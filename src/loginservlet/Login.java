package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("Login.jsp").include(request, response);

		HttpSession session = request.getSession();
		if (session != null) {
			String username = (String) session.getAttribute("username");

			out.print("Hello, " + username + " Welcome to Profile");
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("kukac") && password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);

			response.sendRedirect("Profile.jsp");

		} else {
			request.setAttribute("error", "Username or Password is incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
			// response.sendRedirect("Login.html");

		}
	}

}
