package gui_pkg;

import java.util.*;
import javax.swing.*;

import product_pkg.Mobile_ctgr;
import user.Customer;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;


public class AddProduct {
	
	Connection con;
	Statement stmt;
	ArrayList<Mobile_ctgr>mcList;
	int count=0;
	
	public AddProduct(String id,String pass,String name){
			
			JFrame j=new JFrame("ADD Product");
			j.setSize(900,800);
			j.setLayout(null);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel l1=new JLabel("Name : ");
			l1.setBounds(50,40,150,20);
			l1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l1.setForeground(Color.black);
			j.add(l1);
			
			JLabel l2=new JLabel("Id : ");
			l2.setBounds(50,80,150,20);
			l2.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l2.setForeground(Color.black);
			j.add(l2);
			
			JLabel l3=new JLabel("Display size : ");
			l3.setBounds(50,120,150,20);
			l3.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l3.setForeground(Color.black);
			j.add(l3);
			
			JLabel l4=new JLabel("Ram : ");
			l4.setBounds(50,160,150,20);
			l4.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l4.setForeground(Color.black);
			j.add(l4);
			
			JLabel l5=new JLabel("rear_camera_Resolution : ");
			l5.setBounds(50,200,150,20);
			l5.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l5.setForeground(Color.black);
			j.add(l5);
			
			JLabel l6=new JLabel("selfie_camera_Resolution: ");
			l6.setBounds(50,240,150,20);
			l6.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l6.setForeground(Color.black);
			j.add(l6);
			
			JLabel l7=new JLabel("OS: ");
			l7.setBounds(50,280,150,20);
			l7.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l6.setForeground(Color.black);
			j.add(l7);
			
			JLabel l8=new JLabel("Brand: ");
			l8.setBounds(50,320,150,20);
			l8.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l6.setForeground(Color.black);
			j.add(l8);
			
			JLabel l9=new JLabel("Unit price: ");
			l9.setBounds(50,360,150,20);
			l9.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l6.setForeground(Color.black);
			j.add(l9);
			
			JLabel l10=new JLabel("Quantity: ");
			l10.setBounds(50,400,150,20);
			l10.setFont(new Font("Times new Rooman",Font.PLAIN,20));
			//l6.setForeground(Color.black);
			j.add(l10);
			
			
			JTextField text1 =new JTextField();
			text1.setBounds(200,40,150,20);
			j.add(text1);
			
			JTextField text2 =new JTextField();
			text2.setBounds(200,80,150,20);
			j.add(text2);
			
			JTextField text3 =new JTextField();
			text3.setBounds(200,120,150,20);
			j.add(text3);
			
			JTextField text4 =new JTextField();
			text4.setBounds(200,160,150,20);
			j.add(text4);
			
			JTextField text5 =new JTextField();
			text5.setBounds(200,200,150,20);
			j.add(text5);
			
			JTextField text6 =new JTextField();
			text6.setBounds(200,240,150,20);
			j.add(text6);
			
			JTextField text7 =new JTextField();
			text7.setBounds(200,280,150,20);
			j.add(text7);
			
			JTextField text8 =new JTextField();
			text8.setBounds(200,320,150,20);
			j.add(text8);
			
			JTextField text9 =new JTextField();
			text9.setBounds(200,360,150,20);
			j.add(text9);
			
			JTextField text10 =new JTextField();
			text10.setBounds(200,400,150,20);
			j.add(text10);
			
			
			JTextArea ta1= new JTextArea();
	        String ta=(
	                   "fill all the field with proper data"
	      		  );
			           
	         ta1.setText(ta);
	         ta1.setEditable(false);
	         ta1.setForeground(Color.RED);
	         ta1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
	         ta1.setBounds(450,50,400,250);
	         j.add(ta1);
	         ta1.setVisible(false);
			
			JCheckBox jd =new JCheckBox("Show Adding Rules");
			jd.setFont(new Font("Algerian",Font.PLAIN,15));
			jd.setForeground(Color.BLUE);
			jd.setBounds(200,430,200,20);
			j.add(jd);
			jd.addActionListener(e->{
				boolean selected = jd.isSelected();
				if(selected){
					
					ta1.setVisible(true);
			        //j.add(ta1);
				}
				else{
					//j.remove(ta1);
					ta1.setVisible(false);
					
				}			
			});
			
			
			JButton add=new JButton("ADD");
			add.setBounds(100,460,150,30);
			add.setForeground(Color.black);
			add.setBackground(Color.orange);
		 	j.add(add);
		 	add.addActionListener(e->{
		 		String m_name1=text1.getText();
		 		String m_name=m_name1.toLowerCase();
		 		
		 		String m_id1=text2.getText();
		 		String m_id=m_id1.toLowerCase();
		 		
		 		String display_size1=text3.getText();
		 		String display_size=display_size1.toLowerCase();
		 		
		 		String ram1=text4.getText();
		 		String ram=ram1.toLowerCase();
		 		
		 		String rear_camera_Resolution1=text5.getText();
		 		String rear_camera_Resolution=rear_camera_Resolution1.toLowerCase();
		 		
		 		String selfie_camera_Resolution1 =text6.getText();
		 		String selfie_camera_Resolution=selfie_camera_Resolution1.toLowerCase();
		 		
		 		String os1 =text7.getText();
		 		String os=os1.toLowerCase();
		 		
		 		String brand1 =text8.getText();
		 		String brand=brand1.toLowerCase();
		 		
		 		String unitPrice1 =text9.getText();
		 		String unitPrice=unitPrice1.toLowerCase();
		 		
		 		String quantity1 =text10.getText();
		 		String quantity=quantity1.toLowerCase();
		 		
		 		//System.out.println(phone.substring(0,2));
		 		if(!m_name.isEmpty() && !m_id.isEmpty() && !display_size.isEmpty() && !ram.isEmpty() && !rear_camera_Resolution.isEmpty() && !selfie_camera_Resolution.isEmpty() && !os.isEmpty() && !brand.isEmpty() && !unitPrice.isEmpty() && !quantity.isEmpty()){
		 					
		 					try {
		 						
		 						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
		 						stmt = con.createStatement();
		 						
		 						mcList=new ArrayList<Mobile_ctgr>();
		 						
		 						String query2 = "select * from product";
//		 				      query = "select * from City where CountryCode='"+countryCode+"'";
//		 				      System.out.println(query);
		 				      ResultSet rs2 = stmt.executeQuery(query2);
		 				      
		 				      while(rs2.next()){
		 				          
		 				      	//System.out.println(rs.getString("name"));	 				     	 				    	  
		 				    	 Mobile_ctgr c2=new Mobile_ctgr(rs2.getString("m_name"),
		 				    			         rs2.getString("m_id"),
		 				    			         rs2.getDouble("display_size"),
		 				    			        rs2.getInt("ram"),
		 				    			       rs2.getInt("rear_camera_Resolution"),
		 				    			      rs2.getInt("selfie_camera_Resolution"),
		 				    			     rs2.getString("os"),
		 				    			    rs2.getString("brand"),
		 				    			   rs2.getInt("unitPrice"),
		 				    			  rs2.getInt("availablity")
		 				    			  );
		 				    	  		 				    	  	 				    		 				          	 				          
		 				    	 mcList.add(c2);
		 				      }
		 						
		 						for(Mobile_ctgr cl:mcList){
		 							if(cl.m_id.equals(m_id)){
		 								quantity=cl.availablity+quantity;
		 								String query3 = "UPDATE product SET availablity='"+quantity+"',unitPrice='"+unitPrice+"'where m_id='"+m_id+"' OR m_name='"+m_name+"'";
			 							stmt.executeUpdate(query3);
			 							this.count=1;
			 							j.setVisible(false);
			 				 	 		new Admin_gui(id,name,pass);
			 				 			JOptionPane.showMessageDialog(null,"Added Product successfully!!!");
		 								break;		 										 									 				
		 							}	
		 						}
		 						if(this.count!=1){
		 							
		 							String query = "insert into product values('"+m_name+"','"+m_id+"','"+display_size+"','"+ram+"','"+rear_camera_Resolution+"','"+selfie_camera_Resolution+"','"+os+"','"+brand+"','"+unitPrice+"','"+quantity+"')";
		 							stmt.executeUpdate(query);
		 							
		 							j.setVisible(false);
		 				 	 		new Admin_gui(id,name,pass);
		 				 			JOptionPane.showMessageDialog(null,"Added Product successfully!!!");
		 				 			
		 							
		 							
			 							}
		 							
		 							
		 					} catch (SQLException e2) {
		 						// TODO Auto-generated catch block
		 						e2.printStackTrace();
		 					}
	               //take all cusstomer data from database nd if sign up id !=withother customer->NeXt step
	      
		          //insert to database then & set userType as 'customer'
		 			 
		 				
		 		}
		 		else{
		 			JOptionPane.showMessageDialog(null,"Error;Please Fill the blank field & try again");
		 		}
		 		
		 	});
		 	
		 	JButton cancel=new JButton("Cancel");
		 	cancel.setBounds(300,460,150,30);
		 	cancel.setForeground(Color.black);
		 	cancel.setBackground(Color.orange);
		 	j.add(cancel);
		 	cancel.addActionListener(e->{
		           j.setVisible(false);
		 		new Admin_gui(id,name,pass);
		 		
		 	});
		 	
		 	
			j.setVisible(true);
			j.revalidate();
			j.repaint();
		
	}
	
	

}
