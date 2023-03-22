package gui_pkg;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import user.Customer;

public class Login{
	String userType;
	HomePage hrefer;
	String userId;
	String pass;
	String name;
	Connection conn;
	Statement stmt;
	ArrayList<Customer>cList;
	int i=0;
	
	public Login(String userId,String password,HomePage href) throws SQLException{
		this.hrefer=href;
		this.userId=userId;
		this.pass=password;
		//System.out.println(this.userId+"pass: "+this.pass);
		cList=new ArrayList<Customer>();
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
		    stmt = conn.createStatement();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		String query = "select * from customer";
//      query = "select * from City where CountryCode='"+countryCode+"'";
//      System.out.println(query);
      ResultSet rs = stmt.executeQuery(query);
      
      while(rs.next()){
          
      	//System.out.println(rs.getString("name"));
    	  Customer c1 = new Customer();
    	  
    	  c1.setid(rs.getString("c_id"));
    	  c1.setpassword(rs.getString("c_password"));
    	  c1.setName(rs.getString("c_name"));
    	  c1.setType(rs.getString("u_type"));
    	  
          
          
          cList.add(c1);
      }
      
      
      //for ADMIN
      
     String query2 = "select * from admin";
//    query = "select * from City where CountryCode='"+countryCode+"'";
//    System.out.println(query);
    ResultSet rs2 = stmt.executeQuery(query2);
    
    while(rs2.next()){
        
    	//System.out.println(rs.getString("name"));
    	
    	Customer c2 = new Customer();
  	  c2.setid(rs2.getString("a_id"));
  	  c2.setpassword(rs2.getString("a_password"));
  	  c2.setName(rs2.getString("a_name"));
  	  c2.setType(rs2.getString("u_type"));
  	  
        
        
        cList.add(c2);
    }
		
		
		//if check of login verfied then goto customer gui for customer
		//user id diye query kore usertype anbe thn search dbe
		//check gulo ArrayList r moddhe hbe
    
      for(Customer cl:cList){ //advance for loop
    	  
		this.pass=password;
		this.userId=userId;
		String userType=cl.u_type;
		
		String databaseCusID=cl.c_id;
		String databaseCusPassword=cl.c_passwordNo;
		
		
if((this.userId.equals(databaseCusID) && this.pass.equals(databaseCusPassword))){
	             
	hrefer.j.setVisible(false);
	this.gotoUser(userType,cl.c_name);
	this.i=1;
	break;
	
		}
		
		
		
	}
      
      if(this.i!=1){
			
			hrefer.adderror();
			
		}
      
	}
	
	public void gotoUser(String userType, String c_name) throws SQLException{
		String cus="customer";
		String admn="admin";
		
		if(userType.equals(cus)){
			//database theke c_name ber korbe then{{{ this.name=c_name
		    
			String newQuery = "DELETE from cart where c_id='"+this.userId+"'";
			String newQuery2="insert into cart values('"+null+"','"+null+"','"+null+"','"+null+"','"+null+"','"+null+"')";           
					
			stmt.executeUpdate(newQuery);
			
			new Customer_gui(this.userId,c_name,this.pass);
		
		}
		else if(userType.equals(admn)){
			//database theke u_name ber korbe then{{{ this.name=u_name
			new Admin_gui(this.userId,c_name,this.pass);
			
		}
		else{
	
			//hrefer.adderror();
			System.out.println("type error");
		}
		
	}
	

}
