package gui_pkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import product_pkg.Mobile_ctgr;


public class SearchFunc /*implements ItemListener*/{
	public JComboBox<String> categoryCombo;
	public JFrame j;
	
	
	JTable jt;
	Connection conn;
	JLabel l7;
	JButton searchByNameM;
	JButton searchByBrandM;
	JButton searchByUnitPriceM;
	JButton searchByRear_camera_ResolutionM;
	JButton searchBySelfie_camera_ResolutionM;
	
	JLabel l8;
	JButton searchByBrandL;
	
	
	
	public String p;
	public int Ms;
	public int Ls;
	
	//for admin
	//for customer in customer_gui
	
	
	
	
public SearchFunc(String c_id,String name,String passww,String u_type){
		
		this.j=new JFrame("Search Product");
		
	     JButton allProduct=new JButton("Search ALL Product");
	     allProduct.setBounds(550,40,200,50);
	     allProduct.setForeground(Color.black);
	     allProduct.setBackground(Color.yellow);
	 	this.j.add(allProduct);
	 	allProduct.addActionListener(e->{
	 		try{
				conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
			    Statement stmt = conn.createStatement();
			    String query = "select * from product";
			    
			    ResultSet rs = stmt.executeQuery(query);
			    ResultSetMetaData rstmt = (ResultSetMetaData) rs.getMetaData();
			    int c = rstmt.getColumnCount();
			    Vector column = new Vector(c);
			    for(int i = 1; i <= c; i++){
			    	column.add(rstmt.getColumnName(i));
			    }
			                                        //  --->> https://www.youtube.com/watch?v=G4JeKZ6nDUI
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
			    
			    
			    
			   // JPanel panel = new JPanel();
			    jt= new JTable(data,column);
			    jt.setBounds(20,300,950,600);
			   
				//JScrollPane sp = new JScrollPane(jt);
				//panel.setLayout(new BorderLayout());
				//panel.add(sp, BorderLayout.CENTER);
				
				this.j.add(jt);
				//this.j.add(sp);
				this.j.revalidate();
				this.j.repaint();
				  
			    System.out.println("successfull");
			    
			   
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
	 		
	 
	 	});
	 	
	 	JButton back=new JButton("BACK");
	 	back.setBounds(755,40,200,50);
	 	back.setForeground(Color.black);
	 	back.setBackground(Color.orange);
	 	this.j.add(back);
	 	back.addActionListener(e->{
	           this.j.setVisible(false);
	           new Admin_gui(c_id,name,passww);
	 		
	 	});
	 	
		
	 	
		this.j.setSize(1000,900);
		this.j.setLayout(null);
		this.j.setVisible(true);
		this.j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	//for general


	public SearchFunc(){
		
		this.j=new JFrame("Search Product");
		
		JLabel l9=new JLabel("Select Category :");
		l9.setBounds(20,20,250,20);
		l9.setFont(new Font("Times new Rooman",Font.PLAIN,16));
		l9.setForeground(Color.ORANGE);
		this.j.add(l9);
		
		categoryCombo = new JComboBox<String>();
		categoryCombo.addItemListener(e->{
		
	
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
		/*if(this.p.equals("Laptop")){
			this.Ls=1;
            if(this.Ms==1){
            	
            	this.j.remove(this.l7);
            	this.j.remove(this.searchByBrandM);
            	this.j.remove(this.searchByUnitPriceM);
            	this.j.remove(this.searchByNameM);
            	this.j.remove(this.searchByRear_camera_ResolutionM);
            	this.j.remove(this.searchBySelfie_camera_ResolutionM);
            	
            	
			}
			
			
			this.addcomponentforlaptop();
			
		}*/
	
	
	
	
	});
		
		
		
		
		
		
		
		
		
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
				conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
			    Statement stmt = conn.createStatement();
			    String query = "select * from product";
			    
			    ResultSet rs = stmt.executeQuery(query);
			    ResultSetMetaData rstmt = (ResultSetMetaData) rs.getMetaData();
			    int c = rstmt.getColumnCount();
			    Vector column = new Vector(c);
			    for(int i = 1; i <= c; i++){
			    	column.add(rstmt.getColumnName(i));
			    }
			                                        //  --->> https://www.youtube.com/watch?v=G4JeKZ6nDUI
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
			    
			    
			   
			   // JPanel panel = new JPanel();
			    jt= new JTable(data,column);
			    jt.setBounds(20,300,950,600);
			   
				//JScrollPane sp = new JScrollPane(jt);
				//panel.setLayout(new BorderLayout());
				//panel.add(sp, BorderLayout.CENTER);
				
				this.j.add(jt);
				//this.j.add(sp);
				this.j.revalidate();
				this.j.repaint();
				  
			    System.out.println("successfull");
			    
			   
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
	 		
	 
	 		
	 	});
	 	
	 	JButton back=new JButton("BACK");
	 	back.setBounds(755,40,200,50);
	 	back.setForeground(Color.black);
	 	back.setBackground(Color.orange);
	 	this.j.add(back);
	 	back.addActionListener(e->{
	           this.j.setVisible(false);
	 		new HomePage();
	 		
	 	});
	 	

	 	JButton addToShoppingCart = new JButton("Add To Cart");
		addToShoppingCart.setBounds(780,180,140,60);
		addToShoppingCart.setForeground(Color.black);
		addToShoppingCart.setBackground(Color.yellow);
		this.j.add(addToShoppingCart);
		
		String c_id = "0";
		
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
			    	if(check.equals(p_id)&&check2.equals("0")){i=1;}
			    	
			    }
	 		  if(i!=1){
	 			 System.out.println("worked");
	 		  String query2 = "insert into cart values('"+"0"+"','"+p_id+"','"+p_name+"','"+p_brand+"','"+p_price+"','"+p_qnty+"')";            
			    
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
			String passw = null;
			String c_name = null;
			//this.j.setVisible(false);
			new Shopping_cart_gui(c_id,c_name,passw);
	 		
	 	});
	 	
	 	
		this.j.setSize(1000,900);
		this.j.setLayout(null);
		this.j.setVisible(true);
		this.j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/*@Override
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
			
			
			this.addcomponentforlaptop();
			
		}
		
	}*/
	
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
			new SearchByBrand();
		});
		

		this.searchByUnitPriceM = new JButton("UnitPrice");
		this.searchByUnitPriceM.setBounds(260,120,115,45);
		this.searchByUnitPriceM.setForeground(Color.black);
		this.searchByUnitPriceM.setBackground(Color.blue);
		this.j.add(this.searchByUnitPriceM);
		//this.j.remove(searchByBrand);
		this.searchByUnitPriceM.addActionListener(e -> {
			this.j.setVisible(false);
			new SearchByPriceM();
		});
		
		this.searchByNameM = new JButton("Model Name");
		this.searchByNameM.setBounds(380,120,115,45);
		this.searchByNameM.setForeground(Color.black);
		this.searchByNameM.setBackground(Color.blue);
		this.j.add(this.searchByNameM);
		this.searchByNameM.addActionListener(e -> {
			this.j.setVisible(false);
			new SearchByNameM();
		});
		
		this.searchByRear_camera_ResolutionM = new JButton("Rear Camera");
		this.searchByRear_camera_ResolutionM.setBounds(500,120,115,45);
		this.searchByRear_camera_ResolutionM.setForeground(Color.black);
		this.searchByRear_camera_ResolutionM.setBackground(Color.blue);
		this.j.add(this.searchByRear_camera_ResolutionM);
		this.searchByRear_camera_ResolutionM.addActionListener(e -> {
			this.j.setVisible(false);
			new SearchByRearCameraM();
		});
		
		this.searchBySelfie_camera_ResolutionM = new JButton("Selfie Camera");
		this.searchBySelfie_camera_ResolutionM.setBounds(620,120,115,45);
		this.searchBySelfie_camera_ResolutionM.setForeground(Color.black);
		this.searchBySelfie_camera_ResolutionM.setBackground(Color.blue);
		this.j.add(this.searchBySelfie_camera_ResolutionM);
		this.searchBySelfie_camera_ResolutionM.addActionListener(e -> {
			this.j.setVisible(false);
			new SearchBySelfieCamM();
		});
		
		
		this.j.revalidate();
		this.j.repaint();
	}
    
    public void addcomponentforlaptop(){
    	
    	this.Ms=0;
    	this.l8=new JLabel("YOU CAN SEARCH LAPTOP BY : ");
		this.l8.setBounds(40,170,1500,40);
		this.l8.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		this.l8.setForeground(Color.ORANGE);
		this.j.add(this.l8);
		
		
		this.searchByBrandL = new JButton("BrandL");
		this.searchByBrandL.setBounds(140,210,115,45);
		this.searchByBrandL.setForeground(Color.black);
		this.searchByBrandL.setBackground(Color.blue);
		this.j.add(this.searchByBrandL);
		this.searchByBrandL.addActionListener(e -> {
			this.j.setVisible(false);
			//new SearchByBrand();
		});
		
		
		this.j.revalidate();
		this.j.repaint();
		
		
    	}
    	
    	
    }	
	




