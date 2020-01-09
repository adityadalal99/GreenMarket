package mypkg;

import java.io.IOException;
//import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.logtopro.web.modeldao.GoToProfileDao;

/**
 * Servlet implementation class Profile_fetch
 */
@WebServlet("/Profile_fetch")
public class Profile_fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("idhaar aaya line:27");
		HttpSession session = request.getSession();
		String emaili = (String) session.getAttribute("email");
		String sp;
		GoToProfileDao obj=new GoToProfileDao();
		sp=obj.get_data(emaili);
		System.out.println(sp);
		response.getWriter().write(sp);
		System.out.println("WADDDDUPPP PEPS");
		
	}

}
