package gui_pkg;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.*;

public class Admin_gui {

	String a_id;
	String name;
	String passw;
	
	//from login to admin with password
	public Admin_gui(String a_id,String name,String passw){
		this.name=name;
		this.a_id=a_id;
		this.passw=passw;
		
		JFrame j=new JFrame("Admin: "+name);
		
		JButton searchPro= new JButton("Search Product");
		searchPro.setBounds(30, 30, 150, 50);
		searchPro.setForeground(Color.black);
		searchPro.setBackground(Color.red);
		j.add(searchPro);
		searchPro.addActionListener(e->{
			j.setVisible(false);
			new SearchFunc(this.a_id,this.name,this.passw,"admin");
		});
		
		JButton logout = new JButton("Logout");
		logout.setBounds(1300,40,120,60);
		logout.setForeground(Color.black);
		logout.setBackground(Color.yellow);
		j.add(logout);
		logout.addActionListener(e->{
			j.setVisible(false);
	 		new HomePage();
	 		
	 	});
		
		JButton addPro= new JButton("Add Product");
		addPro.setBounds(30, 90, 150, 50);
		addPro.setForeground(Color.black);
		addPro.setBackground(Color.red);
		j.add(addPro);
		addPro.addActionListener(e->{
			j.setVisible(false);
			new AddProduct(a_id,passw,name);
		});
		
		JButton updatePro= new JButton("Update Product");
		updatePro.setBounds(30, 150, 150, 50);
		updatePro.setForeground(Color.black);
		updatePro.setBackground(Color.red);
		j.add(updatePro);
		updatePro.addActionListener(e->{
			j.setVisible(false);
			new UpdateProduct(a_id,passw,name);
			
		});
		
		JButton delPro= new JButton("Delete Product");
		delPro.setBounds(30, 210, 150, 50);
		delPro.setForeground(Color.black);
		delPro.setBackground(Color.red);
		j.add(delPro);
		delPro.addActionListener(e->{
			j.setVisible(false);
			new DeleteProduct(a_id, passw, name);
		});
		
		
		 JMenuBar menubar=new JMenuBar();
		    j.setJMenuBar(menubar);
			
			JMenu menu =new JMenu("Menu");
			menubar.add(menu);
			
			JMenu hlp =new JMenu("Help");
			menubar.add(hlp);
			
			
			JMenuItem pass = new JMenuItem("Change Password");
			menu.add(pass);
			pass.addActionListener(e -> {
				j.setVisible(false);
				new ChangePassword(this.a_id,this.name,this.passw,"admin");
			} );
			
			JMenuItem sami = new JMenuItem("Change Information");
			menu.add(sami);
			sami.addActionListener(e -> {
				j.setVisible(false);
				new ChangeInfo(this.a_id,this.name,this.passw,"admin");
			} );
			
			JMenuItem sInfo = new JMenuItem("Show Information");
			menu.add(sInfo);
			sInfo.addActionListener(e -> {
				try {
					new ShowInfo(this.a_id,this.name,this.passw,"admin");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*this.j.setVisible(false);
				new ChangeInfo(this.c_id,this.c_name,this.passw);*/
			} );
			
		
		
		
		
		
		
		
			j.setSize(1500, 1000);
			j.setLayout(null);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j.setVisible(true);
		j.revalidate();
		j.repaint();
						
		
	}

}



/*
 



show product
show customer
addproduct''
delete customer''
delete profuct''

 
 
 

























*/