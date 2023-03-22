package gui_pkg;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class HomePage {
	
	JButton userType;
	JButton login;
	JButton cancel;
	JButton show;
	JLabel labelName;
	//String c_id="15";
	JFrame j;
	static String passRem;
	static String usernameRem;
	Connection conn;
	 Statement stmt ;
	public HomePage() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	   
		try {
			stmt = conn.createStatement();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		String newQuery = "DELETE from cart where c_id='"+null+"'";
		//String newQuery2="insert into cart values('"+null+"','"+null+"','"+null+"','"+null+"','"+null+"','"+null+"')";           
				
		try {
			stmt.executeUpdate(newQuery);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		this.j=new JFrame("AREE ONLINE MOBILE & LAPTOP SHOP");
		this.j.setSize(800,600);
		this.j.getContentPane().setBackground(Color.LIGHT_GRAY);
		//ImageIcon image = new ImageIcon("H:/OBJECT ORIENTED PROGRAMMING 1 (JAVA) [J]/project Super shop aree/src/gui_pkg/super-shop-pos-managemnt-accounting-software-system-898x349.png");
		//JLabel lf=new JLabel(image);
		
		//lf.setBounds(20,20,1300,900);
		//lf.setForeground(Color.red);
		//lf.setFont(new Font("Times new Rooman",Font.PLAIN,30));
		//lf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel l7=new JLabel("WELCOME TO AREE ONLINE MOBILE & LAPTOP SHOP");
		l7.setBounds(40,20,700,80);
		l7.setFont(new Font("Cooper Black",Font.PLAIN,20));
		l7.setForeground(Color.black);
		this.j.add(l7);
		
		
		JLabel l1=new JLabel("UserId :");
		l1.setBounds(20,110,200,20);
		l1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		l1.setForeground(Color.DARK_GRAY);
		this.j.add(l1);
		
		final JTextField text =new JTextField();
		text.setBounds(150,110,200,20);
		this.j.add(text);
		
		
		
		
		JLabel l2=new JLabel("Password :");
		l2.setBounds(20,170,100,20);
		l2.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		l2.setForeground(Color.DARK_GRAY);
		this.j.add(l2);
		
		
		final JPasswordField passwd = new JPasswordField();
		passwd.setBounds(150,170,200,20);
		passwd.setEchoChar('*');
		this.j.add(passwd);
		

		
		JCheckBox jd =new JCheckBox("Show password");
		jd.setBounds(150,225,200,20);
		this.j.add(jd);
		jd.addActionListener(e->{
			boolean selected = jd.isSelected();
			if(selected){
				passwd.setEchoChar((char) 0);
				this.j.revalidate();
				this.j.repaint();
			}
			else{
				passwd.setEchoChar('*');
				this.j.revalidate();
				this.j.repaint();
				
			}			
		});
		
		JCheckBox jc =new JCheckBox("Remember Me");
		jc.setBounds(150,200,200,20);
		this.j.add(jc);
		jc.addActionListener(e->{
			
			
		});
		
		JButton login=new JButton("Log In");
		login.setBounds(150,260,100,50);
		this.j.add(login);
		login.addActionListener(e->{
			//this.j.setVisible(false);
			
			try {
				String username=text.getText();
				 String pass= passwd.getText();
				 
				new Login(username, pass,this);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	           //new Customer_gui(c_id);
			
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(280,260,100,50);
		this.j.add(cancel);
		cancel.addActionListener(e -> System.exit(0));
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(450,100,120,60);
		signup.setForeground(Color.black);
		signup.setBackground(Color.yellow);
		this.j.add(signup);
		signup.addActionListener(e -> {
			this.j.setVisible(false);
			new Signup();
		});
		
		JButton searchProduct = new JButton("SearchProduct");
		searchProduct.setBounds(450,175,120,60);
		this.j.add(searchProduct);
		searchProduct.addActionListener(e -> {
			this.j.setVisible(false);
			new SearchFunc();
		});
		
			
	//	this.j.add(lf);
		
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		this.j.setVisible(true);
	 	
	}
	
	public void adderror(){
		JOptionPane.showMessageDialog(null,"Invalid Username or Password.Please try again");
		//JOptionPane.showInputDialog("ab");
		/*JTextField tCheck;
		tCheck=new JTextField("Invalid Username or Password.Please try again");
		tCheck.setEditable(false);
		tCheck.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		tCheck.setForeground(Color.red);
		tCheck.setBounds(390,160,600,60);
		this.j.add(tCheck);
		this.j.revalidate();
		this.j.repaint();
		this.j.setVisible(true);*/
	}
	
}
