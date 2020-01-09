package mypkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register_session
 */
@WebServlet("/register_session")
public class register_session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("Email");
		String password=request.getParameter("password");
		String username=request.getParameter("Username");
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		//response.sendRedirect("addrxn.html");
		response.getWriter().write(username+email+password);
	}

}
