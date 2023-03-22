package gui_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import javax.swing.JTextArea;

public class Contact_us {
	
	 public Contact_us() {

		 JFrame j=new JFrame("Contact us");
			j.setSize(500,400);
			j.setLayout(null);
			//j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JTextArea ta1= new JTextArea();
		    String ta=(
		               "CUSTOMER SERVICE & FEEDBACK" +'\n'+'\n'+'\n'+
		               "Toll free: +13062033669"+ '\n'+
		               "Online support: "+ '\n' +
		               "support@areesupershop.com" +'\n'+'\n'+
		               "Mon - Fri: 9:00 am - 10:00 pm"+ '\n'+
		               "Sat & Sun: 9:00 am - 6:00 pm"
		               
		  		  );
			           
		     ta1.setText(ta);
		     ta1.setEditable(false);
		     ta1.setForeground(Color.RED);
		     ta1.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		     //ta1.setBounds(450,50,400,250);
		     ta1.setBounds(50, 50, 400, 250);
		     j.add(ta1);
		     ta1.setVisible(true);
		 
		     j.setVisible(true);
				j.revalidate();
				j.repaint();
		 
	}
	
	

}
