package gui_pkg;

import product_pkg.Mobile_ctgr;
import product_pkg.Shopping_cart;
import user.Customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import javax.swing.*;

import com.mysql.jdbc.ResultSetMetaData;

import product_pkg.Shopping_cart;

public class Customer_gui implements ItemListener{
     String c_id;
	 JFrame j;
	public static boolean clog;
	public String sname;
	public String sbrand;
	public double sunitprice;
	public int squantity;
	ArrayList<Shopping_cart> s_cart=new ArrayList<Shopping_cart>();
	
	 public JComboBox<String> categoryCombo;
		
	    JTable jt; 
		JLabel l7;
		JButton searchByNameM;
		JButton searchByBrandM;
		JButton searchByUnitPriceM;
		JButton searchByRear_camera_ResolutionM;
		JButton searchBySelfie_camera_ResolutionM;
		JLabel l8;
		JButton searchByBrandL;
		
		public String c_name;
		public String p;
		public int Ms;
		public int Ls;
		String passw;
	

		public Customer_gui(String c_id,String name,String passw){  //String customerId parameter hisebe thakbe sobkichute
			
			//this. c_name=name;
			this.c_id=c_id;
			this.c_name=name;
			this.passw=passw;
			clog=true;
			Customer cu =new Customer();
			 
			    this.j=new JFrame();
			    //**********************
			    JMenuBar menubar=new JMenuBar();
			    this.j.setJMenuBar(menubar);
				
				JMenu menu =new JMenu("Menu");
				menubar.add(menu);
				
				JMenu hlp =new JMenu("Help");
				menubar.add(hlp);
				
				JMenuItem contact = new JMenuItem("contact us");
				hlp.add(contact);
				contact.addActionListener(e -> {
					//this.j.setVisible(false);
					new Contact_us();
				} );
				
				
				JMenuItem pass = new JMenuItem("Change Password");
				menu.add(pass);
				pass.addActionListener(e -> {
					this.j.setVisible(false);
					new ChangePassword(this.c_id,this.c_name,this.passw);
				} );
				
				JMenuItem sami = new JMenuItem("Change Information");
				menu.add(sami);
				sami.addActionListener(e -> {
					this.j.setVisible(false);
					new ChangeInfo(this.c_id,this.c_name,this.passw);
				} );
				
				JMenuItem sInfo = new JMenuItem("Show Information");
				menu.add(sInfo);
				sInfo.addActionListener(e -> {
					try {
						new ShowInfo(this.c_id,this.c_name,this.passw);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*this.j.setVisible(false);
					new ChangeInfo(this.c_id,this.c_name,this.passw);*/
				} );
				
				
				//********************************
			
			
			this.j.setTitle("Customer: "+c_name);
			this.j.setSize(1000,800);
			this.j.setLayout(null);
			this.j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JButton logout = new JButton("Logout");
			logout.setBounds(780,40,120,60);
			logout.setForeground(Color.black);
			logout.setBackground(Color.yellow);
			this.j.add(logout);
			logout.addActionListener(e->{
				
				this.j.setVisible(false);
		 		new HomePage();
		 		
		 	});
			JButton addToShoppingCart = new JButton("Add To Cart");
			addToShoppingCart.setBounds(780,180,140,60);
			addToShoppingCart.setForeground(Color.black);
			addToShoppingCart.setBackground(Color.yellow);
			this.j.add(addToShoppingCart);
			addToShoppingCart.addActionListener(e->{
				String Data = null;
				
				jt.setCellSelectionEnabled(true);  
		        ListSelectionModel select= jt.getSelectionModel();  
				select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				
				 int[] row = jt.getSelectedRows();  
		         int[] columns = jt.getSelectedColumns();  
		         for (int i = 0; i < row.length; i++) {  
		             
		             Data = (String) jt.getValueAt(row[i],1);  
		           } 
		         System.out.println("Table element selected is: " + Data);
		         JScrollPane sp=new JScrollPane(jt);    
		         j.add(sp);
		         
			     
			     String p_id = null;
			     String p_name=null;
			     String p_brand=null;
			     int p_price=0;
			     int p_qnty=0;
			     int i=0;
			    	String check=null;
		         
		         try {
		        	 
		        	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
		 			System.out.println("Connection Successfull");
		 			Statement stmt = conn.createStatement();
		 		    String query = "Select * from product where m_id='"+Data+"'";
		 		    
		 		    ResultSet rs = stmt.executeQuery(query);
		 		   while(rs.next()){
		 			   
		 			  p_id=Data;
		 			  p_name=rs.getString("m_name");
		 			  p_brand=rs.getString("brand");
		 			  p_price=rs.getInt("unitPrice");
		 			  p_qnty=1;
		 			  
		 	
		 			   
		 		   }
		 		   
		 		  String query3 = "Select * from cart where p_id='"+Data+"'";
				    
				    ResultSet rs3 = stmt.executeQuery(query3);
				    while(rs3.next()){
				    	
				    	check=rs3.getString("p_id");
				    	String check2=rs3.getString("c_id");
				    	if(check.equals(p_id) && check2.equals(c_id)){i=1;}
				    	
				    }
		 		  if(i!=1){
		 			 
		 		  String query2 = "insert into cart values('"+c_id+"','"+p_id+"','"+p_name+"','"+p_brand+"','"+p_price+"','"+p_qnty+"')";            
				    
				    stmt.executeUpdate(query2);
		 			  
		 		  }
		 		   
		 		  j.revalidate();
		 	     j.repaint();
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
		         
		         
		 		
		 	});
			
			JButton shoppingCart = new JButton("Shopping Cart");
			shoppingCart.setBounds(780,110,140,60);
			shoppingCart.setForeground(Color.black);
			shoppingCart.setBackground(Color.red);
			this.j.add(shoppingCart);
			shoppingCart.addActionListener(e->{
				//this.j.setVisible(false);
				new Shopping_cart_gui(c_id,c_name,passw);
		 		
		 	});
			
			//********************************************************************
			
		
			
				
				
				
				JLabel l9=new JLabel("Select Category :");
				l9.setBounds(20,20,250,20);
				l9.setFont(new Font("Times new Rooman",Font.PLAIN,16));
				l9.setForeground(Color.ORANGE);
				this.j.add(l9);
				
				categoryCombo = new JComboBox<String>();
				categoryCombo.addItemListener(this);
			     //categoryCombo.setEditable(false);
				this.categoryCombo.setEditable(false);
			     this.categoryCombo.addItem("Mobile");
			    
			     this.categoryCombo.setBounds(150, 20, 100, 20);
			     this.j.add(categoryCombo);
			     
			     JButton allProduct=new JButton("Search ALL Product");
			     allProduct.setBounds(550,40,200,50);
			     allProduct.setForeground(Color.black);
			     allProduct.setBackground(Color.yellow);
			     this.j.add(allProduct);
			 	allProduct.addActionListener(e->{
			          
			 		 try{
							
				 			//System.out.println("Successfull.....");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
							//System.out.println("Connection Successfull");
							Statement stmt = conn.createStatement();
						    String query = "Select * from product";
						    
						    ResultSet rs = stmt.executeQuery(query);
						    ResultSetMetaData rstmt = (ResultSetMetaData) rs.getMetaData();
						    int c = rstmt.getColumnCount();
						    Vector column = new Vector(c);
						    for(int i = 1; i <= c; i++){
						    	column.add(rstmt.getColumnName(i));
						    }
						                                        
						    Vector data = new Vector();
						    Vector row = new Vector();
						    while(rs.next()){
						    	row = new Vector(c);
						    	for(int i = 1; i <= c; i++){
						    		row.add(rs.getString(i));
						    	}
						    	data.add(row);
						    }
						    
						    JLabel lb1=new JLabel("Model");
						    lb1.setBounds(20, 270, 100, 25);
						    j.add(lb1);
						    
						    JLabel lb2=new JLabel("id");
						    lb2.setBounds(120, 270, 100, 25);
						    j.add(lb2);
						    
						    JLabel lb3=new JLabel("display");
						    lb3.setBounds(220, 270, 100, 25);
						    j.add(lb3);
						    
						    JLabel lb4=new JLabel("ram");
						    lb4.setBounds(320, 270, 100, 25);
						    j.add(lb4);
						    
						    JLabel lb5=new JLabel("rear_camera");
						    lb5.setBounds(400, 270, 100, 25);
						    j.add(lb5);
						    
						    JLabel lb6=new JLabel("selfie_camera");
						    lb6.setBounds(500, 270, 100, 25);
						    j.add(lb6);
						    
						    JLabel lb7=new JLabel("os");
						    lb7.setBounds(620, 270, 100, 25);
						    j.add(lb7);
						    
						    JLabel lb8=new JLabel("brand");
						    lb8.setBounds(720, 270, 100, 25);
						    j.add(lb8);
						    
						    JLabel lb9=new JLabel("price");
						    lb9.setBounds(820, 270, 100, 25);
						    j.add(lb9);
						    
						    JLabel lb10=new JLabel("quantity");
						    lb10.setBounds(920, 270, 70, 25);
						    j.add(lb10);
						    
						    
						  
						    jt= new JTable(data,column);
						    //jt.setEnabled(false);
						    jt.setBounds(20,300,950,600);
							this.j.add(jt);
							//this.j.add(sp);
							this.j.revalidate();
							this.j.repaint();
							  
						    //System.out.println("successfully End");
						    
						   
						
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
				 		
				           
				
			 		
			 		
			 	});
			 	
			 	
			 	this.j.revalidate();
			 	this.j.repaint();
			
			
			 	this.j.setVisible(true);
			
			
		}
		
		
//****************+++++++++++++++++++++++++++++++*************************************+++++++++++++++++++++++++++++++++++++++
		
		
		
		/*public Customer_gui(String c_id,String name){  //String customerId parameter hisebe thakbe sobkichute
		
			//this. c_name=name;
			this.c_id=c_id;
			this.c_name=name;
			this.passw=passw;
			clog=true;
			Customer cu =new Customer();
			 
			    this.j=new JFrame();
			    //**********************
			    JMenuBar menubar=new JMenuBar();
			    this.j.setJMenuBar(menubar);
				
				JMenu menu =new JMenu("Menu");
				menubar.add(menu);
				
				JMenu hlp =new JMenu("Help");
				menubar.add(hlp);
				
				
				JMenuItem pass = new JMenuItem("Change Password");
				menu.add(pass);
				pass.addActionListener(e -> {
					this.j.setVisible(false);
					new ChangePassword(this.c_id,this.c_name,this.passw);
				} );
				
				JMenuItem sami = new JMenuItem("Change Information");
				menu.add(sami);
				sami.addActionListener(e -> {
					this.j.setVisible(false);
					new ChangeInfo(this.c_id,this.c_name,this.passw);
				} );
				
				JMenuItem sInfo = new JMenuItem("Show Information");
				menu.add(sInfo);
				sInfo.addActionListener(e -> {
					try {
						new ShowInfo(c_id,name,passw);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*this.j.setVisible(false);
					new ChangeInfo(this.c_id,this.c_name,this.passw);
				} );
				
				
				//********************************
			
			
			this.j.setTitle("Customer: "+c_name);
			this.j.setSize(1000,800);
			this.j.setLayout(null);
			this.j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JButton logout = new JButton("Logout");
			logout.setBounds(780,40,120,60);
			logout.setForeground(Color.black);
			logout.setBackground(Color.yellow);
			this.j.add(logout);
			logout.addActionListener(e->{
				this.j.setVisible(false);
				clog=false;
				new Delete_cart(c_id);
		 		new HomePage();
		 		
		 	});
			JButton addToShoppingCart = new JButton("Add To Cart");
			addToShoppingCart.setBounds(780,180,140,60);
			addToShoppingCart.setForeground(Color.black);
			addToShoppingCart.setBackground(Color.yellow);
			this.j.add(addToShoppingCart);
			addToShoppingCart.addActionListener(e->{
String Data = null;
				
				jt.setCellSelectionEnabled(true);  
		        ListSelectionModel select= jt.getSelectionModel();  
				select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				
				 int[] row = jt.getSelectedRows();  
		         int[] columns = jt.getSelectedColumns();  
		         for (int i = 0; i < row.length; i++) {  
		             
		             Data = (String) jt.getValueAt(row[i],1);  
		           } 
		         System.out.println("Table element selected is: " + Data);
		         JScrollPane sp=new JScrollPane(jt);    
		         j.add(sp);
		         
			     
			     String p_id = null;
			     String p_name=null;
			     String p_brand=null;
			     int p_price=0;
			     int p_qnty=0;
			     int i=0;
			    	String check=null;
		         
		         try {
		        	 
		        	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
		 			System.out.println("Connection Successfull");
		 			Statement stmt = conn.createStatement();
		 		    String query = "Select * from product where m_id='"+Data+"'";
		 		    
		 		    ResultSet rs = stmt.executeQuery(query);
		 		   while(rs.next()){
		 			   
		 			  p_id=Data;
		 			  p_name=rs.getString("m_name");
		 			  p_brand=rs.getString("brand");
		 			  p_price=rs.getInt("unitPrice");
		 			  p_qnty=1;
		 			  
		 	
		 			   
		 		   }
		 		   
		 		  String query3 = "Select * from cart where p_id='"+Data+"'";
				    
				    ResultSet rs3 = stmt.executeQuery(query3);
				    while(rs3.next()){
				    	
				    	check=rs3.getString("p_id");
				    	if(check.equals(p_id)){i=1;}
				    	
				    }
		 		  if(i!=1){
		 			 
		 		  String query2 = "insert into cart values('"+c_id+"','"+p_id+"','"+p_name+"','"+p_brand+"','"+p_price+"','"+p_qnty+"')";            
				    
				    stmt.executeUpdate(query2);
		 			  
		 		  }
		 		   
		 		  j.revalidate();
		 	     j.repaint();
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
		         
		   
		 		
		 	});
			
			JButton shoppingCart = new JButton("Shopping Cart");
			shoppingCart.setBounds(780,110,140,60);
			shoppingCart.setForeground(Color.black);
			shoppingCart.setBackground(Color.red);
			this.j.add(shoppingCart);
			shoppingCart.addActionListener(e->{
				//this.j.setVisible(false);
				new Shopping_cart_gui(c_id);
		 		
		 	});
			
			//********************************************************************
			
		
			
				
				
				
				JLabel l9=new JLabel("Select Category :");
				l9.setBounds(20,20,250,20);
				l9.setFont(new Font("Times new Rooman",Font.PLAIN,16));
				l9.setForeground(Color.ORANGE);
				this.j.add(l9);
				
				categoryCombo = new JComboBox<String>();
				categoryCombo.addItemListener(this);
			     //categoryCombo.setEditable(false);
				this.categoryCombo.setEditable(false);
			     this.categoryCombo.addItem("Mobile");
			     
			     this.categoryCombo.setBounds(150, 20, 100, 20);
			     this.j.add(categoryCombo);
			     
			     JButton allProduct=new JButton("Search ALL Product");
			     allProduct.setBounds(550,40,200,50);
			     allProduct.setForeground(Color.black);
			     allProduct.setBackground(Color.yellow);
			     this.j.add(allProduct);
			 	allProduct.addActionListener(e->{
			 		 try{
							
				 			//System.out.println("Successfull.....");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
							//System.out.println("Connection Successfull");
							Statement stmt = conn.createStatement();
						    String query = "Select * from product";
						    
						    ResultSet rs = stmt.executeQuery(query);
						    ResultSetMetaData rstmt = (ResultSetMetaData) rs.getMetaData();
						    int c = rstmt.getColumnCount();
						    Vector column = new Vector(c);
						    for(int i = 1; i <= c; i++){
						    	column.add(rstmt.getColumnName(i));
						    }
						                                        
						    Vector data = new Vector();
						    Vector row = new Vector();
						    while(rs.next()){
						    	row = new Vector(c);
						    	for(int i = 1; i <= c; i++){
						    		row.add(rs.getString(i));
						    	}
						    	data.add(row);
						    }
						    
						    JLabel lb1=new JLabel("Model");
						    lb1.setBounds(20, 270, 100, 25);
						    j.add(lb1);
						    
						    JLabel lb2=new JLabel("id");
						    lb2.setBounds(120, 270, 100, 25);
						    j.add(lb2);
						    
						    JLabel lb3=new JLabel("display");
						    lb3.setBounds(220, 270, 100, 25);
						    j.add(lb3);
						    
						    JLabel lb4=new JLabel("ram");
						    lb4.setBounds(320, 270, 100, 25);
						    j.add(lb4);
						    
						    JLabel lb5=new JLabel("rear_camera");
						    lb5.setBounds(400, 270, 100, 25);
						    j.add(lb5);
						    
						    JLabel lb6=new JLabel("selfie_camera");
						    lb6.setBounds(500, 270, 100, 25);
						    j.add(lb6);
						    
						    JLabel lb7=new JLabel("os");
						    lb7.setBounds(620, 270, 100, 25);
						    j.add(lb7);
						    
						    JLabel lb8=new JLabel("brand");
						    lb8.setBounds(720, 270, 100, 25);
						    j.add(lb8);
						    
						    JLabel lb9=new JLabel("price");
						    lb9.setBounds(820, 270, 100, 25);
						    j.add(lb9);
						    
						    JLabel lb10=new JLabel("quantity");
						    lb10.setBounds(920, 270, 70, 25);
						    j.add(lb10);
						    
						    
						  
						    jt= new JTable(data,column);
						    jt.setBounds(20,300,950,600);
							this.j.add(jt);
							//this.j.add(sp);
							this.j.revalidate();
							this.j.repaint();
							  
						    //System.out.println("successfully End");
						    
						   
						
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
				 		
				           
				
			
			
			 	});
			 	
			 	
			 	this.j.revalidate();
			 	this.j.repaint();
			
			
			 	this.j.setVisible(true);
			
		
	}
	*/

public void addcomponentforMobile(){
	this.Ls=0;
	
	this.l7=new JLabel("YOU CAN SEARCH MOBILE BY : ");
	this.l7.setBounds(40,60,1500,40);
	this.l7.setFont(new Font("Times new Rooman",Font.PLAIN,20));
	this.l7.setForeground(Color.ORANGE);
	this.j.add(this.l7);
	
	
	this.searchByBrandM = new JButton("Brand");
	this.searchByBrandM.setBounds(140,120,115,45);
	this.searchByBrandM.setForeground(Color.black);
	this.searchByBrandM.setBackground(Color.blue);
	this.j.add(this.searchByBrandM);
	this.searchByBrandM.addActionListener(e -> {
		this.j.setVisible(false);
		new SearchByBrand(this.c_id,this.c_name,this.passw);
	});
	

	this.searchByUnitPriceM = new JButton("UnitPrice");
	this.searchByUnitPriceM.setBounds(260,120,115,45);
	this.searchByUnitPriceM.setForeground(Color.black);
	this.searchByUnitPriceM.setBackground(Color.blue);
	this.j.add(this.searchByUnitPriceM);
	//j.remove(searchByBrand);
	this.searchByUnitPriceM.addActionListener(e -> {
		this.j.setVisible(false);
		new SearchByPriceM(this.c_id,this.c_name,this.passw);
	});
	
	this.searchByNameM = new JButton("Model Name");
	this.searchByNameM.setBounds(380,120,115,45);
	this.searchByNameM.setForeground(Color.black);
	this.searchByNameM.setBackground(Color.blue);
	this.j.add(this.searchByNameM);
	this.searchByNameM.addActionListener(e -> {
		this.j.setVisible(false);
		new SearchByNameM(this.c_id,this.c_name,this.passw);
	});
	
	this.searchByRear_camera_ResolutionM = new JButton("Rear Camera");
	this.searchByRear_camera_ResolutionM.setBounds(500,120,115,45);
	this.searchByRear_camera_ResolutionM.setForeground(Color.black);
	this.searchByRear_camera_ResolutionM.setBackground(Color.blue);
	this.j.add(this.searchByRear_camera_ResolutionM);
	this.searchByRear_camera_ResolutionM.addActionListener(e -> {
		this.j.setVisible(false);
		new SearchByRearCameraM(this.c_id,this.c_name,this.passw);
	});
	
	this.searchBySelfie_camera_ResolutionM = new JButton("Selfie Camera");
	this.searchBySelfie_camera_ResolutionM.setBounds(620,120,115,45);
	this.searchBySelfie_camera_ResolutionM.setForeground(Color.black);
	this.searchBySelfie_camera_ResolutionM.setBackground(Color.blue);
	this.j.add(this.searchBySelfie_camera_ResolutionM);
	this.searchBySelfie_camera_ResolutionM.addActionListener(e -> {
		this.j.setVisible(false);
		new SearchBySelfieCamM(this.c_id,this.c_name,this.passw);
	});
	
	
	this.j.revalidate();
	this.j.repaint();
}


@Override
public void itemStateChanged(ItemEvent e) {
	System.out.flush();
	this.p= (String)this.categoryCombo.getSelectedItem();
	
	//this.p=null;
    //System.out.println(p);
	if(this.p.equals("Mobile")){
		this.Ms=1;
		if(this.Ls==1){
			this.j.remove(this.l8);
			this.j.remove(this.searchByBrandL);
			
		}
		System.out.println();
		
		this.addcomponentforMobile();
		
	}
	if(this.p.equals("Laptop")){
		this.Ls=1;
        if(this.Ms==1){
        	
        	this.j.remove(this.l7);
        	this.j.remove(this.searchByBrandM);
        	this.j.remove(this.searchByUnitPriceM);
        	this.j.remove(this.searchByNameM);
        	this.j.remove(this.searchByRear_camera_ResolutionM);
        	this.j.remove(this.searchBySelfie_camera_ResolutionM);
        	
        	
		}
		
		
		//this.addcomponentforlaptop();
		
	}
	
}


	



}
