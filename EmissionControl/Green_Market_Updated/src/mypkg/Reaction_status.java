package mypkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reaction_status
 */
@WebServlet("/Reaction_status")
public class Reaction_status extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status="";
		HttpSession session=request.getSession();
		boolean reactst=(boolean)session.getAttribute("flag");
		if(reactst)
		{
			status="Reaction Added Succesfully!";
		}
		else
		{
			status="Reaction Out Of Limit!";
		}
		response.getWriter().write(status);
	}

}
