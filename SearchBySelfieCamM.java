package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;

import com.mysql.jdbc.ResultSetMetaData;

import product_pkg.Mobile_ctgr;



public class SearchBySelfieCamM {
	 
	JTable jt;
	
	public SearchBySelfieCamM(String c_id, String c_name, String passw){
		
		
        JFrame j=new JFrame("Search By Selfie Camera(MEGAPIXEL)");
		
		JLabel l2=new JLabel("FROM : ");
		l2.setBounds(20,40,100,20);
		l2.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		l2.setForeground(Color.red);
		j.add(l2);
		
		JLabel l3=new JLabel("TO :");
		l3.setBounds(240,40,100,20);
		l3.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		l3.setForeground(Color.red);
		j.add(l3);
		
		JTextField from =new JTextField();
		from.setBounds(140,40,100,20);
		j.add(from);
		
		JTextField to =new JTextField();
		to.setBounds(340,40,100,20);
		j.add(to);
		
		JButton addToShoppingCart = new JButton("Add To Cart");
		addToShoppingCart.setBounds(1300,180,140,60);
		addToShoppingCart.setForeground(Color.black);
		addToShoppingCart.setBackground(Color.yellow);
		j.add(addToShoppingCart);
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
	 			 if(!p_id.isEmpty()){
	 		  String query2 = "insert into cart values('"+c_id+"','"+p_id+"','"+p_name+"','"+p_brand+"','"+p_price+"','"+p_qnty+"')";            
			    
			    stmt.executeUpdate(query2);
	 			 }
	 		  }
	 		   
	 		  j.revalidate();
	 	     j.repaint();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	         
	         
	 	});
		
		JButton shoppingCart = new JButton("Shopping Cart");
		shoppingCart.setBounds(1300,110,140,60);
		shoppingCart.setForeground(Color.black);
		shoppingCart.setBackground(Color.red);
		j.add(shoppingCart);
		shoppingCart.addActionListener(e->{
			//this.j.setVisible(false);
			new Shopping_cart_gui(c_id,c_name,passw);
	 		
	 	});
		
		JButton back=new JButton("BACK");
		back.setBounds(550,40,100,50);
		back.setForeground(Color.black);
		back.setBackground(Color.blue);
		j.add(back);
		back.addActionListener(e->{
	           
	        	   j.setVisible(false);
	        	   new Customer_gui(c_id, c_name, passw);
	         
					
		});
		
		
		JButton search=new JButton("SEARCH");
		search.setBounds(445,40,100,30);
		j.add(search);
		search.addActionListener(e->{


try{
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
				System.out.println("Connection Successfull");
				Statement stmt = conn.createStatement();
			    String query = "Select * from product where selfie_camera_Resolution > "+from.getText()+" and selfie_camera_Resolution < " + to.getText();
			    
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
				j.add(jt);
				//this.j.add(sp);
				j.revalidate();
				j.repaint();
				  
			    System.out.println("successfully End");
			    
			   
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			} 
			
		});
		
		j.setSize(1500,1000);
		j.setLayout(null);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
public SearchBySelfieCamM(){
		
		
        JFrame j=new JFrame("Search By Selfie Camera(MEGAPIXEL)");
		
		JLabel l2=new JLabel("FROM : ");
		l2.setBounds(20,40,100,20);
		l2.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		l2.setForeground(Color.red);
		j.add(l2);
		
		JLabel l3=new JLabel("TO :");
		l3.setBounds(240,40,100,20);
		l3.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		l3.setForeground(Color.red);
		j.add(l3);
		
		JTextField from =new JTextField();
		from.setBounds(140,40,100,20);
		j.add(from);
		
		JTextField to =new JTextField();
		to.setBounds(340,40,100,20);
		j.add(to);
		
		JButton back=new JButton("BACK");
		back.setBounds(550,40,100,50);
		back.setForeground(Color.black);
		back.setBackground(Color.blue);
		j.add(back);
		back.addActionListener(e->{
	           j.setVisible(false);
				new SearchFunc();	
		});
		
		JButton search=new JButton("SEARCH");
		search.setBounds(445,40,100,30);
		j.add(search);
		search.addActionListener(e->{


try{
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
				System.out.println("Connection Successfull");
				Statement stmt = conn.createStatement();
			    String query = "Select * from product where selfie_camera_Resolution > "+from.getText()+" and selfie_camera_Resolution < " + to.getText();
			    
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
				j.add(jt);
				//this.j.add(sp);
				j.revalidate();
				j.repaint();
				  
			    System.out.println("successfully End");
			    
			   
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			} 
		
		
		});
		
		j.setSize(1500,1000);
		j.setLayout(null);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	
	
}
