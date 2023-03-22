package user;

import java.util.*;
import product_pkg.Shopping_cart;

public class Customer {

	public String c_id;
	public String u_type;
	public String c_name;
	private String c_phn_no;
	private String c_address;
	private String c_creditNo;
	//protected String u_type;
	public String c_passwordNo;
	ArrayList<Shopping_cart> s_cart;
	//Order o1;
	
	public Customer(){};
	
	public Customer(String c_id,String c_type,String c_name,String c_phn_no,String c_address,String c_creditNo,double c_creditBalance,String c_passwordNo){

	this.c_id=c_id;
	//this.c_type=c_type;
	this.c_name=c_name;
	this.c_phn_no=c_phn_no;
	this.c_address=c_address;
	this.c_creditNo=c_creditNo;
    this.c_passwordNo=c_passwordNo;	
	/////////database connection thakbe and getData method thakbe
	}
	private void register(){
		
		
		
	}
	private void pay(){
		
		
	}
	
	public void setid(String c_id){
		this.c_id=c_id;
	}
	public void setName(String c_name){
		this.c_name=c_name;
	}
	public void setAddress(String c_address){
		this.c_address=c_address;
	}
	public void setPhone(String c_phn_no){
		this.c_phn_no=c_phn_no;
	}
	public void setCard(String c_creditNo){
		this.c_creditNo=c_creditNo;
	}
	public void setpassword(String c_passwordNo){
		this.c_passwordNo=c_passwordNo;
	}
	public void setType(String u_type){
		this.u_type=u_type;
	}
	
	
	
	
	
	
	
	
	
	
	
	
     

	
	
}
