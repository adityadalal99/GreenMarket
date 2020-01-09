package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reaction_backend
 */
@WebServlet("/Reaction_backend")
public class Reaction_backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reaction_backend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String[] strArray1 = new String[100];
		String c_name="";
		String no=request.getParameter("hide");
		double normality[]=new double[Integer.parseInt(no)];
		double moles[]=new double[Integer.parseInt(no)];
		HashMap<String,Double> hm=new HashMap<>();
		hm.clear();
		//int moles[]=new int[Integer.parseInt(no)];
		//String sub=request.getParameter("sub");
		String react=request.getParameter("reaction");
		System.out.println(react);
		String tp="";
		int k=0;
		int i=0;
		double too;
		for(int j=0;j<react.length()&&react.charAt(j)!='-';j++)
		{
			System.out.println("j:"+j);
			if((react.charAt(j)=='+'&&((int)(react.charAt(j+1))>=65&&(int)(react.charAt(j+1))<=90))||(j==0&&((int)(react.charAt(j))>=65&&(int)(react.charAt(j))<=90)))
			{
				String name="quantity"+Integer.toString(i+1);
				i++;
			    too=Double.parseDouble(request.getParameter(name));
			    System.out.println("too= "+ too);
				/*while(react.charAt(j)!='+')
				{
					//map=map+react.charAt(l);
					j++;
				}*/
				tp="1";
				normality[k]=too/1.0;
				System.out.println("IN");
				System.out.println(normality[k]);
				//moles[k]=Character.getNumericValue(react.charAt(i));
				//i++;
				k++;
				//tem=min*Double.parseDouble(tp);
				tp="";
				//hm.put(map,tem);
				//map="";
				System.out.println("j after 1 if"+j);
			}
			//System.out.println("2");
			else if((react.charAt(j)=='+'&&((int)(react.charAt(j+1))>='0'&&(int)(react.charAt(j+1))<='9'))||(j==0&&((int)(react.charAt(j))>='0'&&(int)(react.charAt(j))<='9')))
			{
				String name="quantity"+Integer.toString(i+1);
				i++;
			    too=Double.parseDouble(request.getParameter(name));
			    System.out.println("too= "+ too);
			    if(j!=0)
			    {
			    	j++;
			    }
				//j++;
				/*if((int)(react.charAt(j))>=97&&(int)(react.charAt(j))<=122)
				{
					tp="1";
				}*/
				//else
				//{
				while((int)(react.charAt(j))>='0'&&(int)(react.charAt(j))<='9')
						{
					//System.out.println(tp);
					       tp=tp+react.charAt(j);
					       j++;
						}
			
				//}				System.out.println(j);
				/*while(j<react.length()&&react.charAt(j)!='+')
				{
					//map=map+react.charAt(l);
					j++;
					//System.out.println(l);
				}*/
				normality[k]=too/Double.parseDouble(tp);
				System.out.println("IN2");
				System.out.println(tp);
				//System.out.println(normality[k]);
				System.out.println(normality[k]);
				//moles[k]=Double.parseDouble(tp);
				k++;
				System.out.println(tp);
				//System.out.println(min);
				//tem=min*Double.parseDouble(tp);
				tp="";
				//hm.put(map,tem);
				//map="";
				System.out.println("j "+j);
			}
		}
		/*for(int j=0;j<Integer.parseInt(no);j++)
		{
			String name="quantity"+Integer.toString(j+1);
		    double too=Double.parseDouble(request.getParameter(name));
		    System.out.println(i);
			//String formula="formula"+Integer.toString(i+1);
		if((react.charAt(i)=='+'&&((int)(react.charAt(i+1))>=97&&(int)(react.charAt(i+1))<=122))||(i==0&&((int)(react.charAt(i))>=97&&(int)(react.charAt(i))<=122)))
			{
				normality[k]=too/1.0;
				System.out.println("IN");
				System.out.println(normality[k]);
				//moles[k]=Character.getNumericValue(react.charAt(i));
				i++;
				k++;
			}
			else if((react.charAt(i)=='+'&&((int)(react.charAt(i+1))>='0'&&(int)(react.charAt(i+1))<='9'))||(i==0&&((int)(react.charAt(i))>='0'&&(int)(react.charAt(i))<='9')))
			{
				if(i!=0)
				{
					i++;
				}
				while((int)(react.charAt(i))>='0'&&(int)(react.charAt(i))<='9')
                 {
	                tp=tp+react.charAt(i);
	                i++;
                 }
				normality[k]=too/Double.parseDouble(tp);
				System.out.println("IN2");
				System.out.println(tp);
				//System.out.println(normality[k]);
				System.out.println(normality[k]);
				//moles[k]=Double.parseDouble(tp);
				k++;
				tp="";
			}
			else
			{
				continue;
			}
			//Integer.parseInt(s)
			/*if(Integer.parseInt(Character.toString(react.charAt(i)))>='0'&&Integer.parseInt(Character.toString(react.charAt(i)))<='9')
			{
				tp=tp+react.charAt(i);
			}
			else if(Integer.parseInt(Character.toString(react.charAt(i+1)))>=97&&Integer.parseInt(Character.toString(react.charAt(i)))<=122)
			{
				tp=tp+react.charAt(i);
			}
			else
			{
				if(tp!="")
				{
					strArray1[k]=tp
						    k++;
							tp="";	
				}
				else
				{
					
				}
			}
		}
		int result=Integer.parseInt(no);
		for(int i=0;i<result;i++)
		{
			String name="name"+Integer.toString(i+1);
			String formula="formula"+Integer.toString(i+1);
			for(int j=0;j<formula.length();j++)
			{
				String num="";
				if(formula.charAt(j)>='0'&&formula.charAt(j)<='9')
				{
				  num=num+(formula.charAt(j));	
				}
				if(Integer.parseInt(formula.charAt(j))>=Integer.parseInt("0")&&Integer.parseInt(formula.charAt(j))<=Integer.parseInt("1100"))
				{
					
				}
			}
			//String c_name=request.getParameter(name).toLowerCase();
			//String c_formula=request.getParameter(formula);
		}		//doGet(request, response);

	}*/
		for(i=0;i<k;i++)
		{
			System.out.println("i"+i+""+normality[i]);
		}
		double min=normality[0];
		//int min_index=0;
		for(int j=1;j<Integer.parseInt(no);j++)
		{
			if(normality[j]<min)
			{
				min=normality[j];
				//min_index=j;
			}
		}
		for(int j=0;j<Integer.parseInt(no);j++)
		{
			normality[j]=min*moles[j];
		}
		int l=0;
		System.out.println("SABH KHATTAM");
		for(l=0;l<react.length();l++)
		{
			if(react.charAt(l)=='>')
			{
				break;
			}
		}
		System.out.println("line:248 l:"+l);
		tp="";
		String map="";
		double tem;
		//System.out.println("1");
		while(l<react.length())
		{
			if((react.charAt(l)=='+'&&((int)(react.charAt(l+1))>=65&&(int)(react.charAt(l+1))<=90))||(react.charAt(l)=='>'&&((int)(react.charAt(l+1))>=65&&(int)(react.charAt(l+1))<=90)))
			{
				System.out.println("line:257 l:"+react.charAt(l));
					l++;
				
				while(l<react.length()&&react.charAt(l)!='+')
				{
					map=map+react.charAt(l);
					l++;
					System.out.println("l:::"+l);
				}
				tp="1";
				tem=min*Double.parseDouble(tp);
				tp="";
				hm.put(map,tem);
				map="";
			}
			//System.out.println("2");
			else if((react.charAt(l)=='+'&&((int)(react.charAt(l+1))>='0'&&(int)(react.charAt(l+1))<='9'))||(react.charAt(l)=='>'&&((int)(react.charAt(l+1))>='0'&&(int)(react.charAt(l+1))<='9')))
			{
				l++;
				System.out.println("line:278 l:"+l);
				/*if((int)(react.charAt(l))>=65&&(int)(react.charAt(l))<=90)
				{
					tp="1";
				}*/
				//else
				//{
				while(l<react.length()&&((int)(react.charAt(l))>='0'&&(int)(react.charAt(l))<='9'))
						{
					System.out.println("line:287 l:"+l);
					System.out.println(tp);
					       tp=tp+react.charAt(l);
					       l++;
						}
			
				//}				
				System.out.println("line:294 l:"+l);
				while(l<react.length()&&react.charAt(l)!='+')
				{
					map=map+react.charAt(l);
					l++;
					//System.out.println(l);
					System.out.println("line:300 l:"+l);
				}
				System.out.println(tp);
				System.out.println(min);
				tem=min*Double.parseDouble(tp);
				tp="";
				hm.put(map,tem);
				map="";
			}
			else
			{
				l++;
			}
			System.out.println("line:308 l:"+l);
		}
		System.out.println("yaha aya");
		for (String name : hm.keySet()) 
		{
            System.out.println("key: " + name);
            System.out.println("value:"+hm.get(name));
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
         HttpSession session=request.getSession();
         String email=(String)session.getAttribute("email");
         session.setAttribute("flag",true);
         boolean react_proceed=false;
         System.out.println(email);
         try {
 			Class.forName("com.mysql.jdbc.Driver");
 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market","root","");
 			String query="Select * from poison where gasname=?";
 			String q="select company_name from userinfo where email=?";
 			PreparedStatement e_mail=con.prepareStatement(q);
 			e_mail.setString(1,email);
 			ResultSet em=e_mail.executeQuery();
 			if(em.next())
 			{
 				c_name=em.getString(1);
 				//out.println(c_name);
 			}
 			PreparedStatement stmt=con.prepareStatement(query);
 			String query1="Select * from gas_data where company_name=? and gasname=?";
 			String query2="Update gas_data set quantity=quantity+? where gasname=? and company_name=?";
 			String query3="Insert into gas_data(company_name,gasname,quantity) values(?,?,?)";
 			String query4="SELECT quantity FROM gas_data WHERE gasname=? and company_name=?";
 			String query5="SELECT poison_limit FROM poison WHERE gasname=?";
 			String query6="SELECT * FROM user_formula WHERE company_name=? AND compound=?";
 			String query7="Update user_formula set gas_quant=gas_quant+? where compound=? and company_name=?";
 			
 			PreparedStatement st=con.prepareStatement(query1);
 			PreparedStatement s=con.prepareStatement(query2);
 			PreparedStatement q3=con.prepareStatement(query3);
 			PreparedStatement q4=con.prepareStatement(query4);
 			PreparedStatement q5=con.prepareStatement(query5);
 			PreparedStatement q6=con.prepareStatement(query6);
 			PreparedStatement q7=con.prepareStatement(query7);
 			
 			for (String name : hm.keySet()) 
 			{
 	            stmt.setString(1, name);
 	            double val=hm.get(name);
 	            float val1=(float)val;
 	            float lim_val=0f;
 	            ResultSet rs=stmt.executeQuery();
 	            if(rs.next())
 	            {
 	            	System.out.println(rs.getString(1));
 	            	
 	            	st.setString(1, c_name);
 	            	st.setString(2,name);
 	            	
 	            	q4.setString(1, name);
 	            	q4.setString(2,c_name);
 	            	
 	            	q5.setString(1,name);
 	            	
 	            	ResultSet r5=q5.executeQuery();
 	            	if(r5.next())
 	            	{
 	            		lim_val=r5.getFloat("poison_limit");
 	            		lim_val=(float)lim_val;
 	            	}
 	            	System.out.println("R_b line:374 lim:"+lim_val);
 	            	ResultSet r=st.executeQuery();
 	            	if(r.next())
 	            	{
 	            		System.out.println("R_b line:378 check");
 	            		ResultSet r4=q4.executeQuery();
 	            		if(r4.next())
 	            		{
 	            			double qi=hm.get(name);
 	            			float qu=(float)(r4.getFloat("quantity"))+(float)qi;
 	            			if(lim_val<qu)
 	            			{
 	            				System.out.println("R_b line:387 acc_val"+qu);
 	            				//Http
 	            				session.setAttribute("flag", false);
 	            				//out.println("<script> alert(reaction out of limit);</script>");
 	            			}
 	            			else
 	 	            		{
 	            				react_proceed=true;
 	 	            			System.out.println("R_b line:392 acc_val"+qu);
 	 	            			s.setFloat(1, val1);
 	 	 	            		s.setString(2, name);
 	 	 	            		s.setString(3, c_name);
 	 	 	            		s.execute();
 	 	            		}
 	            		}
 	            		/*else
 	            		{
 	            			double qi=hm.get(name);
 	            			float qu=r4.getFloat("quantity")+(float)qi;
 	            			System.out.println("R_b line:385 acc_val"+qu);
 	            			s.setFloat(1, val1);
 	 	            		s.setString(2, name);
 	 	            		s.setString(3, c_name);
 	 	            		s.execute();
 	            		}*/
 	            		System.out.println("R_b line:409 acc_val");
 	            	}
 	            	else
 	            	{
 	            		if(val1>lim_val)
 	            		{
 	            			//out.println("<script> alert(reaction out of limit);</script>");
 	            			session.setAttribute("flag", false);
 	            		}
 	            		else
 	            		{
 	            			react_proceed=true;
 	            			q3.setString(1, c_name);
 	 	            		q3.setString(2, name);
 	 	            		q3.setFloat(3, val1);
 	 	            		q3.execute();
 	            		}
 	            	}
 	            }
 	            q6.setString(1, c_name);
            	q6.setString(2,name);
            	ResultSet r6=q6.executeQuery();
            	if(r6.next()&&react_proceed)
            	{
            		float val2=(float)((double)hm.get(name));
            		q7.setFloat(1, val2);
	            	q7.setString(2, name);
	            	q7.setString(3, c_name);
	            	q7.execute();
            	}
 			}
 			
 			/*stmt.setString(1, username);
 			stmt.setString(2, email);
 			stmt.setString(3, password);*/
 			stmt.execute();
 			stmt.close();
 			con.close();	
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			out.println("Class not found");
 		} catch (SQLException se) {
 			// TODO Auto-generated catch block
 			out.println(se);
 		}
        // getWeight gw=new getWeight();
         //HashMap<String,Double> hm1=new HashMap<>();
         //hm1.clear();
        // hm1=gw.getWeight_function(hm);
        // using values() for iteration over keys 
         response.sendRedirect("Profile.html");
  }
}
