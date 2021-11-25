package Product1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import Projectpack.Mobilevar;
public class  Product1 
{
	public String url="jdbc:mysql://localhost:3306/bags";
	public String uname="root";
	public String passwd="msjashu456";
	public String query="select * from places";
	public String query1="select * from resources";
	public int p,e,c;
	public void query(String q)
	{
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(url,uname,passwd);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(q);
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
				}
				st.close();
				con.close();
		   }catch(Exception e)
		    {
			   System.out.println(e.getMessage());
		    }
	}
}

