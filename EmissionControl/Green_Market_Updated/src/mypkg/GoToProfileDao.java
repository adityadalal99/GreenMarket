package mypkg;
import java.sql.*;
import java.util.HashMap;

public class GoToProfileDao {
	public float get_db_weight(String element)
	{
		float val=0f;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market", "root", "");
			String q1="SELECT AtomicMass FROM mytable WHERE Symbol=?";
			PreparedStatement p1=con.prepareStatement(q1);
			p1.setString(1,element);
			ResultSet r1=p1.executeQuery();
			if(r1.next())
			{
				val=(float)r1.getFloat("AtomicMass");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return val;
	}
	public String get_comp_data(String emaili)
	{
		String tor="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market", "root", "");
			String q1="SELECT company_name FROM userinfo WHERE email =?";
			PreparedStatement p1=con.prepareStatement(q1);
			p1.setString(1,emaili);
			ResultSet r1=p1.executeQuery();
			String c_name="";
			if(r1.next())
			{
				c_name=r1.getString(1);
			}
			String selectSQL = "SELECT compound,gas_quant FROM user_formula WHERE company_name =? ";
			PreparedStatement pd= con.prepareStatement(selectSQL);
			pd.setString(1,c_name);
			ResultSet rs=pd.executeQuery();
			while(rs.next())
			{
				tor=tor+rs.getString("compound")+",";
			}
			tor = tor.substring(0, tor.length() - 1);
			tor=tor+"+";
			String selectSQL1 = "SELECT compound,gas_quant FROM user_formula WHERE company_name =? ";
			PreparedStatement pd1= con.prepareStatement(selectSQL1);
			pd1.setString(1,c_name);
			ResultSet rs1=pd1.executeQuery();
			while(rs1.next())
			{
				tor=tor+rs1.getFloat("gas_quant")+",";
			}
			tor = tor.substring(0, tor.length() - 1);
			con.close();
			return tor;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return tor;	
		}
	}
	public String get_data(String emaili)
	{
		HashMap<String,Float> hm1=new HashMap<>();
		hm1.clear();
		hm1.put("CO", 0f);
		hm1.put("CO2",0f);
		hm1.put("H2S",0f);
		hm1.put("NH3",0f);
		hm1.put("PH3",0f);
		hm1.put("SO2",0f);
		for (String name : hm1.keySet()) 
		{
            System.out.println("key: " + name);
            System.out.println("value:"+hm1.get(name));
		}
		String tor="";
		System.out.println("idhaar aaya line:17 GTPD");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_market", "root", "");
			//Statement st=con.createStatement();		
			String q1="SELECT company_name FROM userinfo WHERE email =?";
			PreparedStatement p1=con.prepareStatement(q1);
			p1.setString(1,emaili);
			ResultSet r1=p1.executeQuery();
			String c_name="";
			if(r1.next())
			{
				c_name=r1.getString(1);
			}
			String selectSQL = "SELECT * FROM gas_data WHERE company_name =? ";
			PreparedStatement pd= con.prepareStatement(selectSQL);
			pd.setString(1,c_name);
			ResultSet rs=pd.executeQuery();
			System.out.println("yee chal raha hai!");
			System.out.println("idhaar aaya line:32 GTPD");
			while(rs.next())
			{
				//hm.put(rs.getString(2),rs.getFloat(3));
				System.out.println("idhaar aaya line:38 GTPD name:  value"+rs.getString(2)+""+rs.getString(3));
				hm1.replace(rs.getString(2),rs.getFloat(3));
				System.out.println("saabh theek hai bro");
			}
			for(String name : hm1.keySet())
			{
				System.out.println("idhaar aaya line:45 GTPD name:"+name);
				tor=tor+hm1.get(name)+",";
				System.out.println("idhaar aaya line:47 GTPD");
			}
			tor="CO"+"CO2"+"H2S"+"PH3"+"NH3"+"SO2";
			tor=hm1.get("CO")+","+hm1.get("CO2")+","+hm1.get("H2S")+","+hm1.get("PH3")+","+hm1.get("NH3")+","+hm1.get("SO2")+",";
			tor = tor.substring(0, tor.length() - 1);
			System.out.println(tor);
			con.close();
			return tor;
			//return hm;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return tor;	
		}
	}
	public boolean check_user(String emaili,String p)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/greenmarket", "root", "");
			//Statement st=con.createStatement();		
			String selectSQL = "SELECT email,password FROM USER WHERE email =? ";
			PreparedStatement pd= con.prepareStatement(selectSQL);
			pd.setString(1,emaili);
			ResultSet rs=pd.executeQuery();
			if(rs.next())
			{
				//System.out.println("INIT_DB_CONNECTED_BRO");
			   String pa;
			   pa=rs.getString("password");
			   int var=p.compareTo(pa);
			  if(var!=0)
			  {
				con.close();
				return false;
			  }
			  else
			  {
				con.close();
				return true;
			  }
			}
			else
			{
				con.close();
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return false;
		}
	}
}
