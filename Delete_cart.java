package gui_pkg;

import javax.swing.*;

public class Delete_cart {
	
	public Delete_cart(String c_id){
		
	  JFrame j=new JFrame("delete_cart");
	  j.setSize(100,100);
	  j.setLayout(null);
	  JOptionPane.showMessageDialog(null,"shopping cart cleared!!!");
	  
	  j.setVisible(true);
		
		//delete all row that match with c_id from table shopping_cart from database
		
	}

}
