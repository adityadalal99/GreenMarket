package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String email=(String)session.getAttribute("email");
		String password=(String)session.getAttribute("password");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market","root","");
			String query="INSERT INTO userinfo(company_name, email, user_pass) VALUES (?, ?, ?)";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, email);
			stmt.setString(3, password);
			stmt.execute();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.println("Class not found");
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			int i=se.getErrorCode();
			out.println(i);
		}
		
		String no=request.getParameter("hide");
		String sub=request.getParameter("sub");
		int result=Integer.parseInt(no);
		//String arr[]=new String[result];
		//out.println(result);
		for(int i=0;i<result;i++)
		{
			String name="name"+Integer.toString(i+1);
			String formula="formula"+Integer.toString(i+1);
			String c_name=request.getParameter(name).toLowerCase();
			String c_formula=request.getParameter(formula);
			char[] chars = c_formula.toCharArray();
			for(int j=0;j<c_formula.length();j++)
			{
				if(c_formula.charAt(j)>=sub.charAt(0)&&c_formula.charAt(j)<=sub.charAt(9))
				{
					chars[j]=(char) (chars[j]-sub.charAt(0)+'0');
				}
			}
			String str=new String(chars);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market","root","");
				Statement stm=conn.createStatement();
				String q="SELECT * FROM formula";
				ResultSet rs=stm.executeQuery(q);
				int flag=0;
				while(rs.next())
				{
					String si=rs.getString(1);
					if(si.equals(str))
					{
						flag=1;
						break;
					}
				}
				stm.close();
				if(flag==0)
				{
					PreparedStatement st=conn.prepareStatement("INSERT INTO formula(compound) VALUES(?)");
					st.setString(1, str);
					st.execute();
					st.close();
				}
				PreparedStatement s=conn.prepareStatement("INSERT INTO user_formula(company_name, compound) VALUES(?,?)");
				s.setString(1, username);
				s.setString(2, str);
				s.execute();
				s.close();
				//conn.close();
				//int temp=0;
				PreparedStatement mystmt=conn.prepareStatement("SELECT * FROM formula_name WHERE compound=? AND name=?");
				mystmt.setString(1, str);
				mystmt.setString(2, c_name);
				ResultSet r=mystmt.executeQuery();
				//out.print(r);
				if(r.next()==false)
				{
					PreparedStatement mys=conn.prepareStatement("INSERT INTO formula_name(compound, name) VALUES(?,?)");
					mys.setString(1, str);
					mys.setString(2, c_name);
					mys.execute();
					mys.close();
				}
				mystmt.close();
				conn.close();
						
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				out.println(e);
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.println(e);
				e.printStackTrace();
			}	
		}
		response.sendRedirect("login_register.html");
			
	}

}
