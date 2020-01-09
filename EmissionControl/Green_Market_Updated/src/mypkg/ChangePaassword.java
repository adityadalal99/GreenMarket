package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePaassword
 */
@WebServlet("/ChangePassword")
public class ChangePaassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String pass=request.getParameter("Password");
		String email=(String) session.getAttribute("Email");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market", "root", "");
			String query="UPDATE userinfo SET user_pass=? WHERE email=?;";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1,pass);
			stmt.setString(2, email);
			int i=stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.invalidate();
		/*pw.println("<html>");
		pw.println("<body>");
		pw.println("<p>Password changed succesfully. Click here to go to <a href=\"login.html\">login page</a></p>");
		pw.println("</body");
		pw.println("</html>");*/
		response.sendRedirect("login_register.html");
	}

}
