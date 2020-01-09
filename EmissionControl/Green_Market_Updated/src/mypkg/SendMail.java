package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Calendar;
//import java.util.TimeZone;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String to=request.getParameter("Email");
		String verify=request.getParameter("payment");
		HttpSession session=request.getSession();
		String s=Mailer.send(to);
		/*try {
			Date time=TimeLookup.time();
			long sendtime=time.getTime();
			session.setAttribute("sendtime",sendtime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println("ghgfgh");
		session.setAttribute("otp",s);
		session.setAttribute("Email",to);
		//out.print("message has been sent successfully");
		if(verify.equals("1"))
		{
			response.sendRedirect("otpforpayment.jsp");
		}
		else
		{
			response.sendRedirect("Otp.jsp");
		}
		out.close();
	}

}
