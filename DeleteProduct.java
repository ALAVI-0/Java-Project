package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import product_pkg.Mobile_ctgr;

public class DeleteProduct {

	Connection con;
	Statement stmt;
	ArrayList<Mobile_ctgr>mcList;
	String pp;
	
	public DeleteProduct(String id,String pass,String name){
			
			JFrame j=new JFrame("Delete Product");
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
			
			
			JTextField text2 =new JTextField();
			text2.setBounds(200,80,150,20);
			j.add(text2);
			
			JTextField text3 =new JTextField();
			text3.setBounds(200,120,150,20);
			
			
			JTextField text4 =new JTextField();
			text4.setBounds(200,160,150,20);
			
			
			JTextField text5 =new JTextField();
			text5.setBounds(200,200,150,20);
			
			
			JTextField text6 =new JTextField();
			text6.setBounds(200,240,150,20);
			
			
			JTextField text7 =new JTextField();
			text7.setBounds(200,280,150,20);
			
			
			JTextField text8 =new JTextField();
			text8.setBounds(200,320,150,20);
			
			
			JTextField text9 =new JTextField();
			text9.setBounds(200,360,150,20);
			
			
			JTextField text10 =new JTextField();
			text10.setBounds(200,400,150,20);
			
			
			
			JButton search=new JButton("Search");
			search.setBounds(400,30,150,40);
			j.add(search);
			search.addActionListener(e->{
				j.add(text1);
				j.add(text3);
				j.add(text4);
				j.add(text5);
				j.add(text6);
				j.add(text7);
				j.add(text8);
				j.add(text9);
				j.add(text10);
				
				text1.setEditable(false);
				text2.setEditable(false);
				text3.setEditable(false);
				text4.setEditable(false);
				text5.setEditable(false);
				text6.setEditable(false);
				text7.setEditable(false);
				text8.setEditable(false);
				text9.setEditable(false);
				text10.setEditable(false);
				
				String id1=text2.getText();
				
				try {
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
						stmt = con.createStatement();
						
					mcList=new ArrayList<Mobile_ctgr>();
						
						String query2 = "select * from product where m_id='"+id1+"'";
//				      query = "select * from City where CountryCode='"+countryCode+"'";
//				      System.out.println(query);
				      ResultSet rs2 = stmt.executeQuery(query2);
				      
				      while(rs2.next()){
				          
				      	//System.out.println(rs.getString("name"));	 				     	 				    	  
				    	 Mobile_ctgr c2=new Mobile_ctgr(
				    			 rs2.getString("m_name"),
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
				    	this.pp=rs2.getString("m_name");
				    	
				    	 mcList.add(c2);
				      }
						
						for(Mobile_ctgr cl:mcList){
						
							text1.setText(this.pp); 


							String s= String.valueOf(cl.display_Size);
							text3.setText(s);
							
							String s1= String.valueOf(cl.ram);
							text4.setText(s1);
							
							String s2= String.valueOf(cl.rear_camera_Resolution);
							text5.setText(s2);
							
							String s3= String.valueOf(cl.selfie_camera_Resolution);
							text6.setText(s3);
							
							//String s4= String.valueOf();
							text7.setText(cl.os);
							
							//String s5= String.valueOf(cl.rear_camera_Resolution);
							text8.setText(cl.brand);
							
							String s6= String.valueOf(cl.unitPrice);
							text9.setText(s6);
							
							String s7= String.valueOf(cl.availablity);
							text10.setText(s7);
										
						}
					
				}
												
					 catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
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
		 	
		 	JButton update=new JButton("Delete");
		 	update.setBounds(100,460,150,30);
		 	update.setForeground(Color.black);
		 	update.setBackground(Color.orange);
		 	j.add(update);
		 	update.addActionListener(e->{
            String id1=text2.getText();
		 		
		 		
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
		 						
		 						String query2 = "DELETE FROM product where m_id ='"+id1+"'";
//		 				     
		 				      stmt.executeUpdate(query2);
		 				     JOptionPane.showMessageDialog(null,"deleted Product successfully!!!");
	 				 			j.setVisible(false);
	 				 	 		new Admin_gui(id,name,pass);
		 				     
		 					}	
		 					catch (SQLException e2) {
		 						// TODO Auto-generated catch block
		 						e2.printStackTrace();
		 					}		 		
		 				 				          		 		
		 					}
		 			 		else{
		 			 			JOptionPane.showMessageDialog(null,"Error;Please Fill the blank field & try again");
		 			 		}
		 	});
		 	
		 	j.setVisible(true);
		 	
			
			
	}
	
	
}
