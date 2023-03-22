package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import user.Customer;

import javax.swing.*;


public class Signup {
	
	Connection con;
	Statement stmt;
	ArrayList<Customer>cList;
	int count=0;
	public Signup(){
		
		JFrame j=new JFrame("SIGN UP");
		j.setSize(900,800);
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1=new JLabel("Name : ");
		l1.setBounds(50,40,150,20);
		l1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l1.setForeground(Color.black);
		j.add(l1);
		
		JLabel l2=new JLabel("Address : ");
		l2.setBounds(50,80,150,20);
		l2.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l2.setForeground(Color.black);
		j.add(l2);
		
		JLabel l3=new JLabel("User Id : ");
		l3.setBounds(50,120,150,20);
		l3.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l3.setForeground(Color.black);
		j.add(l3);
		
		JLabel l4=new JLabel("Password : ");
		l4.setBounds(50,160,150,20);
		l4.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l4.setForeground(Color.black);
		j.add(l4);
		
		JLabel l5=new JLabel("Phone No : ");
		l5.setBounds(50,200,150,20);
		l5.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l5.setForeground(Color.black);
		j.add(l5);
		
		JLabel l6=new JLabel("Credit Card No: ");
		l6.setBounds(50,240,150,20);
		l6.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l6.setForeground(Color.black);
		j.add(l6);
		
		
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
		
		
		JTextArea ta1= new JTextArea();
        String ta=(
                   "1.Mobile number 11 Number" + '\n' + 
		             "2.Telephone number 09 Number" + '\n' +
		             "3.Credit Card No 16 Number" + '\n' +
		             "4.ID (at least) 04 Character" + '\n' +
		             "5.password(at least) 06 Character" + '\n' +
		             "6.Add Contact Number FROM Bangladesh"+ '\n' 
      		  );
		           
         ta1.setText(ta);
         ta1.setEditable(false);
         ta1.setForeground(Color.RED);
         ta1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
         ta1.setBounds(450,50,400,250);
         j.add(ta1);
         ta1.setVisible(false);
		
		JCheckBox jd =new JCheckBox("Show SignUp Rules");
		jd.setFont(new Font("Algerian",Font.PLAIN,15));
		jd.setForeground(Color.BLUE);
		jd.setBounds(200,270,200,20);
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
		
		
		JButton signup=new JButton("Sign up");
		signup.setBounds(100,300,150,30);
		signup.setForeground(Color.black);
		signup.setBackground(Color.orange);
	 	j.add(signup);
	 	signup.addActionListener(e->{
	 		String name=text1.getText();
	 		String address=text2.getText();
	 		String id=text3.getText();
	 		String pass=text4.getText();
	 		String phone=text5.getText();
	 		String cardNo=text6.getText();
	 		String u_type="customer";
	 		String cash1= "0";
	 		//System.out.println(phone.substring(0,2));
	 		if(!name.isEmpty() && !address.isEmpty() && !id.isEmpty() && !pass.isEmpty() && !phone.isEmpty() && !cardNo.isEmpty()){
	 			
	 			if(id.length()>=4 && pass.length()>=6 && cardNo.length()==16 && (phone.length()==11 || phone.length()==9)){
	 				
	 				if("016".equals(phone.substring(0,3)) || "017".equals(phone.substring(0,3)) || "018".equals(phone.substring(0,3)) ||
	 			         "019".equals(phone.substring(0,3)) || "015".equals(phone.substring(0,3)) || "011".equals(phone.substring(0,3)) ||
	 			       ( "02".equals(phone.substring(0,2)) && phone.length()==9) ){
	 					
	 					try {
	 						
	 						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
	 						stmt = con.createStatement();
	 						Customer c1 = new Customer();
	 						cList=new ArrayList<Customer>();
	 						
	 						String query2 = "select * from customer";
//	 				      query = "select * from City where CountryCode='"+countryCode+"'";
//	 				      System.out.println(query);
	 				      ResultSet rs2 = stmt.executeQuery(query2);
	 				      
	 				      while(rs2.next()){
	 				          
	 				      	//System.out.println(rs.getString("name"));	 				     	 				    	  
	 				    	  c1.setid(rs2.getString("c_id"));
	 				    	  c1.setpassword(rs2.getString("c_password"));
	 				    	  	 				    		 				          	 				          
	 				          cList.add(c1);
	 				      }
	 						
	 						for(Customer cl:cList){
	 							if(!cl.c_id.equals(id)){
	 						 String query = "insert into customer values('"+id+"','"+pass+"','"+name+"','"+address+"','"+phone+"','"+cardNo+"','"+u_type+"','"+cash1+"')";               
	 							stmt.executeUpdate(query);
	 							this.count=1;
	 							j.setVisible(false);
	 				 	 		new HomePage();
	 				 			JOptionPane.showMessageDialog(null,"Signed Up Successfully!!!!! .Now LogIN with user Id nd Password");
	 				 			break;
	 							}	
	 						}
	 						if(this.count!=1){
	 							JOptionPane.showMessageDialog(null,"ID already exist.please try again with new one");
 							}
	 							
	 							
	 					} catch (SQLException e2) {
	 						// TODO Auto-generated catch block
	 						e2.printStackTrace();
	 					}
               //take all cusstomer data from database nd if sign up id !=withother customer->NeXt step
      
	          //insert to database then & set userType as 'customer'
	 			 
	 				}
	 				else{
	 					JOptionPane.showMessageDialog(null,"Error;Invalid phone number");
	 				}
	 			
	 			}
	 			else{
		 			JOptionPane.showMessageDialog(null,"Error;You should follow the SignUp Rules:");
	 			}
	 		}
	 		else{
	 			JOptionPane.showMessageDialog(null,"Error;Please Fill the blank field & try again");
	 		}
	 		
	 	});
	 	
	 	JButton cancel=new JButton("Cancel");
	 	cancel.setBounds(300,300,150,30);
	 	cancel.setForeground(Color.black);
	 	cancel.setBackground(Color.orange);
	 	j.add(cancel);
	 	cancel.addActionListener(e->{
	           j.setVisible(false);
	 		new HomePage();
	 		
	 	});
	 	
	 	
		j.setVisible(true);
		j.revalidate();
		j.repaint();
	}
	
	//for new signup in shoppingcart
	public Signup(String c_id) {
		
		JFrame j=new JFrame("SIGN UP");
		j.setSize(900,800);
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1=new JLabel("Name : ");
		l1.setBounds(50,40,150,20);
		l1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l1.setForeground(Color.black);
		j.add(l1);
		
		JLabel l2=new JLabel("Address : ");
		l2.setBounds(50,80,150,20);
		l2.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l2.setForeground(Color.black);
		j.add(l2);
		
		JLabel l3=new JLabel("User Id : ");
		l3.setBounds(50,120,150,20);
		l3.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l3.setForeground(Color.black);
		j.add(l3);
		
		JLabel l4=new JLabel("Password : ");
		l4.setBounds(50,160,150,20);
		l4.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l4.setForeground(Color.black);
		j.add(l4);
		
		JLabel l5=new JLabel("Phone No : ");
		l5.setBounds(50,200,150,20);
		l5.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l5.setForeground(Color.black);
		j.add(l5);
		
		JLabel l6=new JLabel("Credit Card No: ");
		l6.setBounds(50,240,150,20);
		l6.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		//l6.setForeground(Color.black);
		j.add(l6);
		
		
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
		
		
		JTextArea ta1= new JTextArea();
        String ta=(
                   "1.Mobile number 11 Number" + '\n' + 
		             "2.Telephone number 09 Number" + '\n' +
		             "3.Credit Card No 16 Number" + '\n' +
		             "4.ID (at least) 04 Character" + '\n' +
		             "5.password(at least) 06 Character" + '\n' +
		             "6.Add Contact Number FROM Bangladesh"+ '\n' 
      		  );
		           
         ta1.setText(ta);
         ta1.setEditable(false);
         ta1.setForeground(Color.RED);
         ta1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
         ta1.setBounds(450,50,400,250);
         j.add(ta1);
         ta1.setVisible(false);
		
		JCheckBox jd =new JCheckBox("Show SignUp Rules");
		jd.setFont(new Font("Algerian",Font.PLAIN,15));
		jd.setForeground(Color.BLUE);
		jd.setBounds(200,270,200,20);
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
		
		
		JButton signup=new JButton("Sign up");
		signup.setBounds(100,300,150,30);
		signup.setForeground(Color.black);
		signup.setBackground(Color.orange);
	 	j.add(signup);
	 	signup.addActionListener(e->{
	 		String name=text1.getText();
	 		String address=text2.getText();
	 		String id=text3.getText();
	 		String pass=text4.getText();
	 		String phone=text5.getText();
	 		String cardNo=text6.getText();
	 		String u_type="customer";
	 		String cash1 = "0";
	 		//System.out.println(phone.substring(0,2));
	 		if(!name.isEmpty() && !address.isEmpty() && !id.isEmpty() && !pass.isEmpty() && !phone.isEmpty() && !cardNo.isEmpty()){
	 			
	 			if(id.length()>=4 && pass.length()>=6 && cardNo.length()==16 && (phone.length()==11 || phone.length()==9)){
	 				
	 				if("016".equals(phone.substring(0,3)) || "017".equals(phone.substring(0,3)) || "018".equals(phone.substring(0,3)) ||
	 			         "019".equals(phone.substring(0,3)) || "015".equals(phone.substring(0,3)) || "011".equals(phone.substring(0,3)) ||
	 			       ( "02".equals(phone.substring(0,2)) && phone.length()==9) ){
	 					
	 					try {
	 						
	 						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
	 						stmt = con.createStatement();
	 						Customer c1 = new Customer();
	 						cList=new ArrayList<Customer>();
	 						
	 						String query2 = "select * from customer";
//	 				      query = "select * from City where CountryCode='"+countryCode+"'";
//	 				      System.out.println(query);
	 				      ResultSet rs2 = stmt.executeQuery(query2);
	 				      
	 				      while(rs2.next()){
	 				          
	 				      	//System.out.println(rs.getString("name"));	 				     	 				    	  
	 				    	  c1.setid(rs2.getString("c_id"));
	 				    	  c1.setpassword(rs2.getString("c_password"));
	 				    	  	 				    		 				          	 				          
	 				          cList.add(c1);
	 				      }
	 						
	 						for(Customer cl:cList){
	 							if(!cl.c_id.equals(id)){
	 						 String query = "insert into customer values('"+id+"','"+pass+"','"+name+"','"+address+"','"+phone+"','"+cardNo+"','"+u_type+"','"+cash1+"')";
	 							stmt.executeUpdate(query);
	 							this.count=1;
	 							j.setVisible(false);
	 							new Shopping_cart_gui(id,name,pass,"new");
	 				 			JOptionPane.showMessageDialog(null,"Signed Up Successfully!!!!! .Now you can always LogIN with your user Id nd Password");
	 				 			break;
	 							}	
	 						}
	 						if(this.count!=1){
	 							JOptionPane.showMessageDialog(null,"ID already exist.please try again with new one");
 							}
	 							
	 							
	 					} catch (SQLException e2) {
	 						// TODO Auto-generated catch block
	 						e2.printStackTrace();
	 					}
               //take all cusstomer data from database nd if sign up id !=withother customer->NeXt step
      
	          //insert to database then & set userType as 'customer'
	 			 
	 				}
	 				else{
	 					JOptionPane.showMessageDialog(null,"Error;Invalid phone number");
	 				}
	 			
	 			}
	 			else{
		 			JOptionPane.showMessageDialog(null,"Error;You should follow the SignUp Rules:");
	 			}
	 		}
	 		else{
	 			JOptionPane.showMessageDialog(null,"Error;Please Fill the blank field & try again");
	 		}
	 		
	 	});
	 	
	 	JButton cancel=new JButton("Cancel");
	 	cancel.setBounds(300,300,150,30);
	 	cancel.setForeground(Color.black);
	 	cancel.setBackground(Color.orange);
	 	j.add(cancel);
	 	cancel.addActionListener(e->{
	           j.setVisible(false);
	 		new HomePage();
	 		
	 	});
	 	
	 	
		j.setVisible(true);
		j.revalidate();
		j.repaint();
		
	}
}
