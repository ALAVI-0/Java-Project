package gui_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;


class ChangePassword{
	
	String c_id;
	String name;
	String newpass;
	String passww;
	Connection connn;
	Statement stmt;
	
	public ChangePassword(String c_id,String name,String passww){
		
		
		this.name=name;
		
		
		JFrame frame=new JFrame("Change password");
	
    JLabel l1 = new JLabel("Enter Your Id:");
	l1.setBounds(10,50,150,20);
	frame.add(l1);
	
	JTextField id=new JTextField();
	id.setBounds(200,50,200,20);
	frame.add(id);
	
	//this.c_id=enter_c_id;
	
	 JLabel l2 = new JLabel("Enter Old Password:");
	l2.setBounds(10,120,150,20);
	frame.add(l2);
	
	JPasswordField oldpass=new JPasswordField();
	oldpass.setBounds(200,120,200,20);
	frame.add(oldpass);
	
	//this.passww=enter_oldpass;
	
	 JLabel l3 = new JLabel("Enter New Password:");
	l3.setBounds(10,190,150,20);
	frame.add(l3);
	
	JPasswordField passwd1=new JPasswordField();
	passwd1.setBounds(200,190,200,20);
	frame.add(passwd1);
	
	
	 JLabel l4 = new JLabel("Confirm New Password:");
	l4.setBounds(10,260,150,20);
	frame.add(l4);
	
	JPasswordField passwd2=new JPasswordField();
	passwd2.setBounds(200,260,200,20);
	frame.add(passwd2);
	
	
	JButton confirm=new JButton("Confirm");
	confirm.setBounds(100,350,120,70);
	frame.add(confirm);
	confirm.addActionListener(e -> {
		
		String enter_oldpass=oldpass.getText();
		String enter_c_id=id.getText();
		String enter_passwd1=passwd1.getText();
		String enter_passwd2=passwd2.getText();
		this.newpass=enter_passwd2;
		
		//System.out.println(this.passww);
		if(passww.equals(enter_oldpass) && this.newpass.equals(enter_passwd1) && enter_c_id.equals(c_id)){
			if(!enter_oldpass.equals(this.newpass)){
			frame.setVisible(false);

			try {
				
				
				connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
				stmt = (Statement) connn.createStatement();
				if(!enter_oldpass.isEmpty()&&!enter_passwd1.isEmpty()&&!enter_c_id.isEmpty()&&!this.newpass.isEmpty()){
					String query = "UPDATE customer SET c_password='"+this.newpass+"'where c_id='"+c_id+"'";				
					stmt.executeUpdate(query);
					
				}
				else{
					JOptionPane.showMessageDialog(null,"fill blank field");
				}
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			JOptionPane.showMessageDialog(null,"Password changed Successfully!!!");
			new Customer_gui(c_id,name,this.newpass);
			}
			else{
				JOptionPane.showMessageDialog(null,"Error;Old password & New password can't be same.PLease try again");
			}
		}
		else{
			//show error textfield
			//System.out.println("error");
			JOptionPane.showMessageDialog(null,"Invalid input.Please try again with right input");
			
		}
		
	});
	
	JButton cancel=new JButton("Cancel");
	cancel.setBounds(270,350,100,70);
	frame.add(cancel);
	cancel.addActionListener(e -> {
		frame.setVisible(false);
		new Customer_gui(c_id,name,passww);
	});
	
	
	frame.setSize(500,500);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	//**************for admin///
	
public ChangePassword(String c_id,String name,String passww,String u_type){
		
	
		
		JFrame frame=new JFrame("Change password");
	
    JLabel l1 = new JLabel("Enter Your Id:");
	l1.setBounds(10,50,150,20);
	frame.add(l1);
	
	JTextField id=new JTextField();
	id.setBounds(200,50,200,20);
	frame.add(id);
	
	//this.c_id=enter_c_id;
	
	 JLabel l2 = new JLabel("Enter Old Password:");
	l2.setBounds(10,120,150,20);
	frame.add(l2);
	
	JPasswordField oldpass=new JPasswordField();
	oldpass.setBounds(200,120,200,20);
	frame.add(oldpass);
	
	//this.passww=enter_oldpass;
	
	 JLabel l3 = new JLabel("Enter New Password:");
	l3.setBounds(10,190,150,20);
	frame.add(l3);
	
	JPasswordField passwd1=new JPasswordField();
	passwd1.setBounds(200,190,200,20);
	frame.add(passwd1);
	
	
	 JLabel l4 = new JLabel("Confirm New Password:");
	l4.setBounds(10,260,150,20);
	frame.add(l4);
	
	JPasswordField passwd2=new JPasswordField();
	passwd2.setBounds(200,260,200,20);
	frame.add(passwd2);
	
	
	JButton confirm=new JButton("Confirm");
	confirm.setBounds(100,350,120,70);
	frame.add(confirm);
	confirm.addActionListener(e -> {
		
		String enter_oldpass=oldpass.getText();
		String enter_c_id=id.getText();
		String enter_passwd1=passwd1.getText();
		String enter_passwd2=passwd2.getText();
		this.newpass=enter_passwd2;
		
		//System.out.println(this.passww);
		if(passww.equals(enter_oldpass) && this.newpass.equals(enter_passwd1) && enter_c_id.equals(c_id)){
			if(!enter_oldpass.equals(this.newpass)){
			frame.setVisible(false);


            try {
				
				
				connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasuperproject", "root", "");
				stmt = (Statement) connn.createStatement();
				if(!enter_oldpass.isEmpty()&&!enter_passwd1.isEmpty()&&!enter_c_id.isEmpty()&&!this.newpass.isEmpty()){
					String query = "UPDATE admin SET a_password='"+this.newpass+"'where a_id='"+c_id+"'";				
					stmt.executeUpdate(query);
					
				}
				else{
					JOptionPane.showMessageDialog(null,"fill blank field");
				}
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			JOptionPane.showMessageDialog(null,"Password changed Successfully!!!");
			new Admin_gui(c_id,name,this.passww);
			}
			else{
				JOptionPane.showMessageDialog(null,"Error;Old password & New password can't be same.PLease try again");
			}
		}
		else{
			//show error textfield
			//System.out.println("error");
			JOptionPane.showMessageDialog(null,"Invalid input.Please try again with right input");
			
		}
		
	});
	
	JButton cancel=new JButton("Cancel");
	cancel.setBounds(270,350,100,70);
	frame.add(cancel);
	cancel.addActionListener(e -> {
		frame.setVisible(false);
		new Customer_gui(c_id,name,passww);
	});
	
	
	frame.setSize(500,500);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
