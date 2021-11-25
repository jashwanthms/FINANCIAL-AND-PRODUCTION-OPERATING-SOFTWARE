package Product3;

import java.sql.*;
import java.util.Scanner;
public class Table2 {
public int x,y,z,q,pro;
float fa,transport=0;	
public int employeeSelector(int p)
{
	
	pro=p;
	x=(int) ((p/4500));
	return (x);
	
}
public int pices() {
	y=(pro/1500);
	return y;
}
public int boxes()
{
	z=(y*1)/10;
	return z;
}
public int salary()
{
	q=x*3000;
	return q;
}
public int gst(int p)
{
	int x;
	x=(18*p)/100;
	return(x);
}
public float cpu(float c)
{
	float x=(c)/y;
	return x;
}
public void comp()
{
	System.out.println("List of other brands and their selling price");
	try {
		String url="jdbc:mysql://localhost:3306/tables";
		String uname="root";
		String passwd="msjashu456";
		String query="select * from tbrands";
    	Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection(url,uname,passwd);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}

		st.close();
		con.close();
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
public void prolo(float f,int c)
{
	float M,N;
	fa=f;
	M=y*f;
	N=M-c;
	if(M>c)
	{
		System.out.println("Profit has been generate which is"+N);
	}else {
		System.out.println("You have to change your price you are in loss");
		
	}
}
public void transpo()
{
	System.out.println("Enter the place distance in Kilometers");
	Scanner obj1=new Scanner(System.in);
	float distance=obj1.nextFloat();
	System.out.println("Enter the Price per Kilometer ");
	float price=obj1.nextFloat();
    float totalprice=distance*price;
    transport=totalprice;
    
}
public void gbill(int p)
{
	String d="MobilePhones";
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Number of pieces you want to sale");
	int n=sc.nextInt();
	if(n<=y)
	{
		float t=n*fa;
		System.out.println("      ***** BILL FROM THE COMPANY *****  ");
        System.out.println("Description         |"+" GST |"+"Number of pieces|"+" price per unit   |"+" Amount|");
		System.out.println(d+"        | "+" 18%|"+n+"             |"+fa+"            |"+t+"|");
		System.out.println("Tranportation Fee   |"+"                                           |"+transport);
		System.out.println("Total Roundoff      |"+"                                          "+(t+transport)+ "|");
	}else {
		System.out.println("No stock available");
	}
}
}



