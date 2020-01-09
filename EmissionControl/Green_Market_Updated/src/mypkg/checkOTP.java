package mypkg;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkOTP
 */
@WebServlet("/checkOTP")
public class checkOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data="";
		//Date time=new Date();
		long submittime=0;
		HttpSession session=request.getSession();
		String otp=(String) session.getAttribute("otp");
		String otp_val=request.getParameter("otp_val");
		/*try {
			time=TimeLookup.time();
			submittime=time.getTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//long sendtime=(long)session.getAttribute("sendtime");
		//long diff=submittime-sendtime;
		long diff=1;
		if(diff>300000)
		{
			data="OTP timeout. Please click on Resend OTP";
		}
		else if(!otp.equals(otp_val))
		{
			data="OTP dosent match";
		}
		
		response.getWriter().write(data);
	}

}
