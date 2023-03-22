package gui_pkg;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;

class ChangeInfo{
	Connection connn;
	Statement stmt;
	String c_id;
	String name;
	String passw;
	
	public ChangeInfo(String c_id,String name,String passww){
		
		this.c_id=c_id;
		this.name=name;
		this.passw=passww;
		
		JFrame frame=new JFrame("Change information");
	
    JLabel l1 = new JLabel("Enter Your Id:");
	l1.setBounds(10,50,150,20);
	frame.add(l1);
	
	JTextField id=new JTextField();
	id.setBounds(200,50,200,20);
	frame.add(id);
	
	
	 JLabel l2 = new JLabel("Enter Password:");
	l2.setBounds(10,120,150,20);
	frame.add(l2);
	
	JPasswordField oldpass=new JPasswordField();
	oldpass.setBounds(200,120,200,20);
	frame.add(oldpass);
	
	
	 JLabel l3 = new JLabel("Enter address:(changeAble)");
	l3.setBounds(10,190,230,20);
	frame.add(l3);
	
	JTextField address=new JTextField();
	address.setBounds(200,190,200,20);
	frame.add(address);
	
	
	 JLabel l4 = new JLabel("Enter contactNO:(changeAble)");
	l4.setBounds(10,260,230,20);
	frame.add(l4);
	
	JTextField contactNO=new JTextField();
	contactNO.setBounds(200,260,200,20);
	frame.add(contactNO);
	
	
	 JLabel l5 = new JLabel("Enter Name:(changeAble)");
		l5.setBounds(10,330,230,20);
		frame.add(l5);
		
		JTextField firstName=new JTextField();
		firstName.setBounds(200,330,200,20);
		frame.add(firstName);
		
		
		 JLabel l6 = new JLabel("Enter CreditCardNo:(changeAble)");
			l6.setBounds(10,400,230,20);
			frame.add(l6);
			
			JTextField cCard=new JTextField();
			cCard.setBounds(200,400,200,20);
			frame.add(cCard);
			
			
			
	
	JButton confirm=new JButton("Confirm");
	confirm.setBounds(100,500,120,70);
	frame.add(confirm);
	confirm.addActionListener(e -> {
		
		String enter_cid=id.getText();
		String enter_contactNO=contactNO.getText();
		String enter_firstName=firstName.getText();
		String enter_cCard=cCard.getText();
		String enter_oldpass=oldpass.getText();
		String enter_address=address.getText();
		
		if(c_id.equals(enter_cid) && passww.equals(enter_oldpass) ){
			
			if((!enter_contactNO.isEmpty()) && (!enter_firstName.isEmpty()) && (!enter_cCard.isEmpty()) && (!enter_address.isEmpty())){
		
				
   if(enter_cCard.length()==16 && (enter_contactNO.length()==11 || enter_contactNO.length()==9)){
	 				
	 				if("016".equals(enter_contactNO.substring(0,3)) || "017".equals(enter_contactNO.substring(0,3)) || "018".equals(enter_contactNO.substring(0,3)) ||
	 			         "019".equals(enter_contactNO.substring(0,3)) || "015".equals(enter_contactNO.substring(0,3)) || "011".equals(enter_contactNO.substring(0,3)) ||
	 			       ( "02".equals(enter_contactNO.substring(0,2)) && enter_contactNO.length()==9) ){
				
				
				frame.setVisible(false);
		System.out.println(enter_contactNO);
		
		
		try {
			
			
			connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
			stmt = (Statement) connn.createStatement();
				String query = "UPDATE customer SET c_phone='"+enter_contactNO+"',c_name='"+enter_firstName+"',c_cardNo='"+enter_cCard+"',c_address='"+enter_address+"'where c_id='"+c_id+"'";				
				stmt.executeUpdate(query);
				
			
			}
				
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		JOptionPane.showMessageDialog(null,"Information changed successFully!!!");
		this.name=enter_firstName;
		//System.out.println(this.name);
		new Customer_gui(c_id,this.name,passww);
	 				}
	 				else{
	 					
	 					JOptionPane.showMessageDialog(null,"Error;Invalid phone number");
	 				}
	 		
	 			}
	 				else{
	 					JOptionPane.showMessageDialog(null,("Error;"+'\n'+
	 							"1.Mobile number 11 Number" + '\n' + 
	 				             "2.Telephone number 09 Number" + '\n' +
	 				             "3.Credit Card No 16 Number" + '\n' +
	 				             "4.Add Contact Number FROM Bangladesh"+ '\n'));
	 				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Error;Please Fill the blank field & try again");
			}
			
		}
		else{
			
			JOptionPane.showMessageDialog(null,"Invalid input.Please try again with right input");
			
		}
	});
	
	JButton cancel=new JButton("Cancel");
	cancel.setBounds(270,500,100,70);
	frame.add(cancel);
	cancel.addActionListener(e -> {
		frame.setVisible(false);
		new Customer_gui(c_id,name,this.passw);
	});
	
	
	frame.setSize(1000,900);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	//**************for admin///
	
public ChangeInfo(String c_id,String name,String passww,String u_type){
		
	this.c_id=c_id;
	this.name=name;
	this.passw=passww;
	
	JFrame frame=new JFrame("Change information");

JLabel l1 = new JLabel("Enter Your Id:");
l1.setBounds(10,50,150,20);
frame.add(l1);

JTextField id=new JTextField();
id.setBounds(200,50,200,20);
frame.add(id);


 JLabel l2 = new JLabel("Enter Password:");
l2.setBounds(10,120,150,20);
frame.add(l2);

JPasswordField oldpass=new JPasswordField();
oldpass.setBounds(200,120,200,20);
frame.add(oldpass);


 JLabel l3 = new JLabel("Enter address:(changeAble)");
l3.setBounds(10,190,230,20);
frame.add(l3);

JTextField address=new JTextField();
address.setBounds(200,190,200,20);
frame.add(address);


 JLabel l4 = new JLabel("Enter contactNO:(changeAble)");
l4.setBounds(10,260,230,20);
frame.add(l4);

JTextField contactNO=new JTextField();
contactNO.setBounds(200,260,200,20);
frame.add(contactNO);


 JLabel l5 = new JLabel("Enter Name:(changeAble)");
	l5.setBounds(10,330,230,20);
	frame.add(l5);
	
	JTextField firstName=new JTextField();
	firstName.setBounds(200,330,200,20);
	frame.add(firstName);
	
			
		

JButton confirm=new JButton("Confirm");
confirm.setBounds(100,500,120,70);
frame.add(confirm);
confirm.addActionListener(e -> {
	
	String enter_cid=id.getText();
	String enter_contactNO=contactNO.getText();
	String enter_firstName=firstName.getText();
	String enter_oldpass=oldpass.getText();
	String enter_address=address.getText();
	
	if(c_id.equals(enter_cid) && passww.equals(enter_oldpass) ){
		
		if((!enter_contactNO.isEmpty()) && (!enter_firstName.isEmpty()) && (!enter_address.isEmpty())){
	
			
if( (enter_contactNO.length()==11 || enter_contactNO.length()==9)){
 				
 				if("016".equals(enter_contactNO.substring(0,3)) || "017".equals(enter_contactNO.substring(0,3)) || "018".equals(enter_contactNO.substring(0,3)) ||
 			         "019".equals(enter_contactNO.substring(0,3)) || "015".equals(enter_contactNO.substring(0,3)) || "011".equals(enter_contactNO.substring(0,3)) ||
 			       ( "02".equals(enter_contactNO.substring(0,2)) && enter_contactNO.length()==9) ){
			
			
			frame.setVisible(false);


	try {
		
		
		connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
		stmt = (Statement) connn.createStatement();
			String query = "UPDATE admin SET a_phone='"+enter_contactNO+"',a_name='"+enter_firstName+"',a_address='"+enter_address+"'where a_id='"+c_id+"'";				
			stmt.executeUpdate(query);
			
		
		}
			
	 catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	
	JOptionPane.showMessageDialog(null,"Information changed successFully!!!");
	this.name=enter_firstName;
	//System.out.println(this.name);
	new Admin_gui(c_id,name,this.passw);
 				}
 				else{
 					
 					JOptionPane.showMessageDialog(null,"Error;Invalid phone number");
 				}
 		
 			}
 				else{
 					JOptionPane.showMessageDialog(null,("Error;"+'\n'+
 							"1.Mobile number 11 Number" + '\n' + 
 				             "2.Telephone number 09 Number" + '\n' +
 				             "3.Add Contact Number FROM Bangladesh"+ '\n'));
 				}
		}
		else{
			JOptionPane.showMessageDialog(null,"Error;Please Fill the blank field & try again");
		}
		
	}
	else{
		
		JOptionPane.showMessageDialog(null,"Invalid input.Please try again with right input");
		
	}
});

JButton cancel=new JButton("Cancel");
cancel.setBounds(270,500,100,70);
frame.add(cancel);
cancel.addActionListener(e -> {
	frame.setVisible(false);
	//new Customer_gui(c_id,name,this.passw);
	new Admin_gui(c_id,name,this.passw);
});


frame.setSize(1000,900);
frame.setLayout(null);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
