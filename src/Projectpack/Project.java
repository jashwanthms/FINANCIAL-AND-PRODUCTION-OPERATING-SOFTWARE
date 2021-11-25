package Projectpack;
import java.util.Scanner;
import java.awt.*;
import java.net.URI;

import Product3.Table1;
import Product3.Table2;
import Product.Product;
import Product.product01;
import Product1.Product1;
import Product1.ProductBags;
import Product4.toys1;
import Product4.toys2;
//import mypack.Login;

import java.sql.*;
class Login
{
	String uid=null;
	String passd=null;
}
class variables{
	String url="jdbc:mysql://localhost:3306/miniproject";
	 String username="root";
	 String passwd="msjashu456";
	 String query1="insert into login values (?,?)";
	 String query2="select * from login ";
}
class Registercheck extends variables
{
	String query3="select * from login";
	int flag=1;
    public int rch(String s1,String s2)
    {
    	   try {
    	    	 Class.forName("com.mysql.cj.jdbc.Driver");
    			 Connection con=DriverManager.getConnection(url,username,passwd);
    			 Statement at=con.createStatement();
    		     ResultSet rs=at.executeQuery(query3);
    		     while(rs.next())
    		     {
    		    	 String a1=rs.getString(1);
    		    	 if(s1.equals(a1))
    		    	 {
    		    		 flag=0;
    		    	 }
    		     }
    	    	 
    	     }catch(Exception e)
    	     {
    	    	 
    	     }
    	return flag;
    }
}
class Log extends variables
{
	public int register() {
		Login obj1=new Login();
		 Scanner sc2=new Scanner(System.in); 
		 System.out.println("Enter Your User id");
		 obj1.uid=sc2.nextLine();
		 System.out.println("Enter Your password");
		 obj1.passd=sc2.nextLine();
		 Registercheck r1=new Registercheck();
		int c=r1.rch(obj1.uid,obj1.passd);
		if(c==1)
		{
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con=DriverManager.getConnection(url,username,passwd);
				 PreparedStatement pt=con.prepareStatement(query1);
				 pt.setString(1, obj1.uid);
				 pt.setString(2, obj1.passd);
				 int k=pt.executeUpdate();
				 System.out.println(k+" row/s changed");
			 }catch(Exception e)
			 {
				 System.out.println(e);
			 }
		}else {
		System.out.println("User id has taken already try another one ");
		      	
		}
	  return c;	 
	}
	public int login()
	{
		 int flag=0;
		Login obj2=new Login();
		 Scanner sc1=new Scanner(System.in);
		 System.out.println("Enter Your User id");
		 obj2.uid=sc1.nextLine();
		 System.out.println("Enter Your Password");
		 obj2.passd=sc1.nextLine();
		 try
		 {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,username,passwd);
			 Statement at=con.createStatement();
		     ResultSet rs=at.executeQuery(query2);
		     while(rs.next())
		     {
		    	 String s1=rs.getString(1);
		    	 String s2=rs.getString(2);
		    	if(obj2.uid.equals(s1) && obj2.passd.equals(s2))
		    	{
		    		 flag=1;
		    		System.out.println("Login done");
		    		
		    		break;
		    	}
		     }
		    
			if(flag==0)
			{
				System.out.println("Login Unsucess full");
			}
				
		 }catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
		 return flag;
	}
}
class LoginConstructor
{
	public  static int a;
	int q;
	public LoginConstructor()
	{
		 
 System.out.println("#### WELCOME TO FINANTIAL AND PRODUCTION OPERATING SOFTWARE #####");
		 System.out.println("1.NewRegistration");
		 System.out.println("2.To login");
		 Scanner sc=new Scanner(System.in);
		 a=sc.nextInt();
		 if(a!=1 && a!=2)
		 {
			 System.out.println("Invalid input");
			 System.exit(0);
		 }
		 if(a==1)
		 {
			 Log l1=new Log();
			int i=l1.register();
			if(i==0)
			{
				 while(i!=1)
				 {
					 //int a,b;
					 System.out.println("1.Reregister again 2.to exit ");
					 Scanner sc2=new Scanner(System.in);
					 q=sc2.nextInt();
					 if(q==1)
					 {
						 int i1=l1.register();
						 i=i1; 
					 }else if(q==2)
					 {
						 System.exit(0);
					 }
				 }	 
			}
			 
		 }else if(a==2)
		 {
			 Log l2=new Log();
			 int r=l2.login();
			if(r==0)
			{
				 while(r!=1)
				 {
					 int a,b;
					 System.out.println("1.Relogin again 2.to exit ");
					 Scanner sc2=new Scanner(System.in);
					 a=sc2.nextInt();
					 if(a==1)
					 {
						 int r1=l2.login();
						 r=r1; 
					 }else if(a==2)
					 {
						 System.exit(0);
					 }
					 
				 }
			}
		 } else
			{
				System.out.println("Invalid input");
			}		
	}
}
class Enter
{
	public void f1()
	{
	   
	    System.out.println();
	    System.out.println("Press Enter key to continue");
	    try {
	    	System.in.read();
	    }catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
}
class Products{
	String url="jdbc:mysql://localhost:3306/miniproject";
	String uname="root";
	String passwd="msjashu456";
	String query="select * from products";
    public void show()
    {
     System.out.println("Here are the list of Products to which we give Service");
 	    try {
 	    	Class.forName("com.mysql.cj.jdbc.Driver");
 	       
 		    Connection con=DriverManager.getConnection(url,uname,passwd);
 			Statement st=con.createStatement();
 			ResultSet rs=st.executeQuery(query);
 		
 			while(rs.next())
 			{
 				System.out.println( rs.getInt(1)+" "+rs.getString(2));
 			}
 				
 	    }catch(Exception e)
 	    {
 	    	System.out.println(e.getMessage());
 	    }
    }
}
class Select
{
	public Select()
	{
		 System.out.println();
		    System.out.println("Choose Your choice");
		    Scanner sc=new Scanner(System.in);
		    int i=sc.nextInt();
		    if(i==1)
		    {
		    	MobilePhones obj =new MobilePhones();
		    	System.out.println("      Here are the list of places where you can manufacure Mobile phones   ");
		    	obj.fun();
		    	obj.fun1();
		    }else if(i==2)
		    {
		    	Bags obj1=new Bags();
		    	System.out.println("      Here are the list of places where you can manufacure Bags   ");
		    	obj1.fun1();
		    	obj1.fun11();
		    }else if(i==3)
		    {
		    	Tables obj2=new Tables();
		    	System.out.println("      Here are the list of places where you can manufacure Tables   ");	
		        obj2.fun1();
		        obj2.fun11();
		    }else if(i==4)
		    {
		    	Toys obj2=new Toys();
		    	System.out.println("      Here are the list of places where you can manufacure Toys  ");	
		        obj2.fun1();
		        obj2.fun11();
		    }
	}
	
}
class Bags extends Product1
{
	public void fun1()
	{
		 Product1 obj1=new Product1();
		 obj1.query(query);
	}
	public void fun11()
	{
		Enter obj1 = new Enter();
	     obj1.f1();
	     Product1 obj=new Product1();
	     System.out.println("Resourses Required for Manufacturing");
	     System.out.println(); 
		 obj.query(query1);
		 Scanner sc1= new Scanner(System.in);
		 System.out.println(); 
		 System.out.println("Enter Your cost of production");
		 p=sc1.nextInt();
		 ProductBags objw=new ProductBags();
		 System.out.println(objw.employeeSelector(p)+" employees should be hiered");
		 System.out.println(objw.pices()+" pices are manufactured with respect your budget");
		 System.out.println(objw.boxes()+" boxes are produced");
		 Enter obje=new Enter();
		 System.out.println();
		 System.out.println("To continue with Financial management");
		 obje.f1();
		System.out.println("Amout of salary to be paid for all "+objw.x+"employess");
		System.out.println( objw.salary());
	    System.out.println("Gst of 18% is for your product"+objw.gst(p));
	    int c=p+objw.salary()+objw.gst(p);
	    System.out.println("Total cost of your manufacturing unit"+c);
	    System.out.println("cost per unit will be"+objw.cpu(c));
	    objw.comp();
	    System.out.println("Enter the price at which you want to sell");
	    float s1;
	    s1=sc1.nextFloat();
	    objw.prolo(s1,c);
	    System.out.println("Enter 1 to generate bill 2 to exit");
	    int i1=sc1.nextInt();
	    if(i1==1)
	    {
	    	System.out.println("Do you want to include transportation expenses in your bill");
	    	System.out.println("1.Yes 2.No");
	    	Scanner obj22=new Scanner(System.in);
	    	int t=obj22.nextInt();
	         if(t==1)
	         {
	        	 objw.transpo();
	        	 objw.gbill(p);
		    	 System.out.println("***Thank You For Choosing our Software***");
		    	 //System.exit(0);
	         }else {
	        	 objw.gbill(p);
		    	 System.out.println("***Thank You For Choosing our Software***");
		    	// System.exit(0);
		    	 
	         }
	    }
	    else {
	    	 System.out.println("***Than You For Choosing our Software***");
	    	//System.exit(0);
	    }
	 System.out.println("Enter 1 to give your basic information 2 to not to give");
	 Scanner obweb=new Scanner(System.in);
	 int a=obweb.nextInt();
	 if(a==1)
	 {
		 try {
			 Desktop d=Desktop.getDesktop();
	         d.browse(new URI("file:///C:/Users/jashwanth%20M.S/OneDrive/Documents/index.html")); 
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		
	 }else {
		 System.out.println("...END...");
	 }
	}
}

class MobilePhones extends product01 {
 public void fun()
 {
	 product01 obj=new product01();
	 obj.query(query);
 }
 public void fun1()
 {
		 Enter obj1 = new Enter();
	     obj1.f1();
	     product01 obj=new product01();
	     System.out.println("Resourses Required for Manufacturing");
	     System.out.println(); 
		 obj.query(query1);
	 Scanner sc1= new Scanner(System.in);
	 System.out.println(); 
	 System.out.println("Enter Your cost of production");
	 p=sc1.nextInt();
	 Product objw=new Product();
	 System.out.println(objw.employeeSelector(p)+" employees should be hiered");
	 System.out.println(objw.pices()+" pices are manufactured with respect your budget");
	 System.out.println(objw.boxes()+" boxes are produced");
	 Enter obje=new Enter();
	 System.out.println();
	 System.out.println("To continue with Financial management");
	 obje.f1();
	System.out.println("Amout of salary to be paid for all "+objw.x+"employess");
	System.out.println( objw.salary());
    System.out.println("Gst of 18% is for your product"+objw.gst(p));
    int c=p+objw.salary()+objw.gst(p);
    System.out.println("Total cost of your manufacturing unit"+c);
    System.out.println("cost per unit will be"+objw.cpu(c));
    objw.comp();
    System.out.println("Enter the price at which you want to sell");
    float s1;
    s1=sc1.nextFloat();
    objw.prolo(s1,c);
    System.out.println("Enter 1 to generate bill 2 to exit");
    int i1=sc1.nextInt();
    if(i1==1)
    {
    	System.out.println("Do you want to include transportation expenses in your bill");
    	System.out.println("1.Yes 2.No");
    	Scanner obj22=new Scanner(System.in);
    	int t=obj22.nextInt();
         if(t==1)
         {
        	 objw.transpo();
        	 objw.gbill(p);
	    	 System.out.println("***Thank You For Choosing our Software***");
	    	// System.exit(0);
         }else {
        	 objw.gbill(p);
	    	 System.out.println("***Thank You For Choosing our Software***");
	    	 //System.exit(0);
         }
    }else {
    	 System.out.println("***Than You For Choosing our Software***");
    	//System.exit(0);
    }
    
    System.out.println("Enter 1 to give your basic information 2 to not to give");
	 Scanner obweb=new Scanner(System.in);
	 int a=obweb.nextInt();
	 if(a==1)
	 {
		 try {
			 Desktop d=Desktop.getDesktop();
	         d.browse(new URI("file:///C:/Users/jashwanth%20M.S/OneDrive/Documents/index.html")); 
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		
	 }else {
		 System.out.println("...END...");
	 }
	}
   
    
 
}
class Tables extends Table1 {
	public void fun1()
	{
		 Table1 obj1=new Table1();
		 obj1.query(query);
	}
	public void fun11()
	{
		Enter obj1 = new Enter();
	     obj1.f1();
	     Table1 obj=new Table1();
	     System.out.println("Resourses Required for Manufacturing");
	     System.out.println(); 
		 obj.query(query1);
		 Scanner sc1= new Scanner(System.in);
		 System.out.println(); 
		 System.out.println("Enter Your cost of production");
		 p=sc1.nextInt();
		 Table2 objw=new Table2();
		 System.out.println(objw.employeeSelector(p)+" employees should be hiered");
		 System.out.println(objw.pices()+" pices are manufactured with respect your budget");
		 System.out.println(objw.boxes()+" boxes are produced");
		 Enter obje=new Enter();
		 System.out.println();
		 System.out.println("To continue with Financial management");
		 obje.f1();
		System.out.println("Amout of salary to be paid for all "+objw.x+"employess");
		System.out.println( objw.salary());
	    System.out.println("Gst of 18% is for your product"+objw.gst(p));
	    int c=p+objw.salary()+objw.gst(p);
	    System.out.println("Total cost of your manufacturing unit"+c);
	    System.out.println("cost per unit will be"+objw.cpu(c));
	    objw.comp();
	    System.out.println("Enter the price at which you want to sell");
	    float s1;
	    s1=sc1.nextFloat();
	    objw.prolo(s1,c);
	    System.out.println("Enter 1 to generate bill 2 to exit");
	    int i1=sc1.nextInt();
	    if(i1==1)
	    {
	    	System.out.println("Do you want to include transportation expenses in your bill");
	    	System.out.println("1.Yes 2.No");
	    	Scanner obj22=new Scanner(System.in);
	    	int t=obj22.nextInt();
	         if(t==1)
	         {
	        	 objw.transpo();
	        	 objw.gbill(p);
		    	 System.out.println("***Thank You For Choosing our Software***");
		    	// System.exit(0);
	         }else {
	        	 objw.gbill(p);
		    	 System.out.println("***Thank You For Choosing our Software***");
		    	 //System.exit(0);
	         }
	    	
	    }else {
	    	 System.out.println("***Than You For Choosing our Software***");
	    	System.exit(0);
	    }
	    System.out.println("Enter 1 to give your basic information 2 to not to give");
		 Scanner obweb=new Scanner(System.in);
		 int a=obweb.nextInt();
		 if(a==1)
		 {
			 try {
				 Desktop d=Desktop.getDesktop();
		         d.browse(new URI("file:///C:/Users/jashwanth%20M.S/OneDrive/Documents/index.html")); 
			 }catch(Exception e)
			 {
				 System.out.println(e.getMessage());
			 }
			
		 }else {
			 System.out.println("...END...");
		 }
	   
	}
}
class Toys extends toys1
{
	public void fun1()
	{
		 toys1 obj1=new toys1();
		 obj1.query(query);
	}
	public void fun11()
	{
		Enter obj1 = new Enter();
	     obj1.f1();
	     toys1 obj=new toys1();
	     System.out.println("Resourses Required for Manufacturing");
	     System.out.println(); 
		 obj.query(query1);
		 Scanner sc1= new Scanner(System.in);
		 System.out.println(); 
		 System.out.println("Enter Your cost of production");
		 p=sc1.nextInt();
		 toys2 objw=new toys2();
		 System.out.println(objw.employeeSelector(p)+" employees should be hiered");
		 System.out.println(objw.pices()+" pices are manufactured with respect your budget");
		 System.out.println(objw.boxes()+" boxes are produced");
		 Enter obje=new Enter();
		 System.out.println();
		 System.out.println("To continue with Financial management");
		 obje.f1();
		System.out.println("Amout of salary to be paid for all "+objw.x+"employess");
		System.out.println( objw.salary());
	    System.out.println("Gst of 18% is for your product"+objw.gst(p));
	    int c=p+objw.salary()+objw.gst(p);
	    System.out.println("Total cost of your manufacturing unit"+c);
	    System.out.println("cost per unit will be"+objw.cpu(c));
	    objw.comp();
	    System.out.println("Enter the price at which you want to sell");
	    float s1;
	    s1=sc1.nextFloat();
	    objw.prolo(s1,c);
	    System.out.println("Enter 1 to generate bill 2 to exit");
	    int i1=sc1.nextInt();
	    if(i1==1)
	    {
	    	System.out.println("Do you want to include transportation expenses in your bill");
	    	System.out.println("1.Yes 2.No");
	    	Scanner obj22=new Scanner(System.in);
	    	int t=obj22.nextInt();
	         if(t==1)
	         {
	        	 objw.transpo();
	        	 objw.gbill(p);
		    	 System.out.println("***Thank You For Choosing our Software***");
		    	// System.exit(0);
	         }else {
	        	 objw.gbill(p);
		    	 System.out.println("***Thank You For Choosing our Software***");
		    	// System.exit(0);
	         }
	    	
	    }else {
	    	 System.out.println("***Thank You For Choosing our Software***");
	    	System.exit(0);
	    }
	    System.out.println("Enter 1 to give your basic information 2 to not to give");
		 Scanner obweb=new Scanner(System.in);
		 int a=obweb.nextInt();
		 if(a==1)
		 {
			 try {
				 Desktop d=Desktop.getDesktop();
		         d.browse(new URI("file:///C:/Users/jashwanth%20M.S/OneDrive/Documents/index.html")); 
			 }catch(Exception e)
			 {
				 System.out.println(e.getMessage());
			 }
			
		 }else {
			 System.out.println("...END...");
		 }
	   
	}
}
public  class Project extends LoginConstructor  {

	public  static void main(String[] args) {
		
		LoginConstructor obj=new LoginConstructor();
		if(a==1)
		{
			LoginConstructor obj1=new LoginConstructor();
		}
		System.out.println(" Hey There if you want to be an insdustrial expert then "
		    		+ "this software is just for you");
		Enter obj1 = new Enter();
	    obj1.f1();
	    Products obj2=new Products();
	    obj2.show();
	    Select obj3=new Select();
	   
	 }	
}


