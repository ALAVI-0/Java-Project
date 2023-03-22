package gui_pkg;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.mysql.jdbc.ResultSetMetaData;

/*import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;*/


public class SearchByBrand {
	JFrame frame;
	
	public JTextField txtFieldNum1;
	JLabel labelName;
	 JTable jt;
	 //public JComboBox<String> searchcombo;
	JButton btnSearch;
	
	//for customer
	
	public SearchByBrand(String c_id, String c_name, String passw){
		    this.frame = new JFrame("SearchByBrand");
		    //this.frame.setSize(1000,800);
		    this.frame.setBounds(20,10,1000,800);
		    //this.frame.setTitle("HOME");  
	        //this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.frame.setLayout(null);
	        
	        this.txtFieldNum1 = new JTextField();
	        //this.txtFieldNum1.setEditable(true);
			this.txtFieldNum1.setBounds(210, 60, 120, 40);
			this.txtFieldNum1.setForeground(Color.BLUE);
			this.txtFieldNum1.setFont(new Font(null, Font.PLAIN,20));
			this.frame.add(this.txtFieldNum1);
			
			
			
			this.btnSearch = new JButton("search");
			this.btnSearch.setBounds(332, 60, 100, 40);
			this.frame.add(btnSearch);
			this.btnSearch.addActionListener(e->{
				
				try{
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
					//System.out.println("Connection Successfull");
					Statement stmt = conn.createStatement();
				    String query = "Select * from product where brand='"+txtFieldNum1.getText()+"'";
				    
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
				    this.frame.add(lb1);
				    
				    JLabel lb2=new JLabel("id");
				    lb2.setBounds(120, 270, 100, 25);
				    this.frame.add(lb2);
				    
				    JLabel lb3=new JLabel("display");
				    lb3.setBounds(220, 270, 100, 25);
				    this.frame.add(lb3);
				    
				    JLabel lb4=new JLabel("ram");
				    lb4.setBounds(320, 270, 100, 25);
				    this.frame.add(lb4);
				    
				    JLabel lb5=new JLabel("rear_camera");
				    lb5.setBounds(400, 270, 100, 25);
				    this.frame.add(lb5);
				    
				    JLabel lb6=new JLabel("selfie_camera");
				    lb6.setBounds(500, 270, 100, 25);
				    this.frame.add(lb6);
				    
				    JLabel lb7=new JLabel("os");
				    lb7.setBounds(620, 270, 100, 25);
				    this.frame.add(lb7);
				    
				    JLabel lb8=new JLabel("brand");
				    lb8.setBounds(720, 270, 100, 25);
				    this.frame.add(lb8);
				    
				    JLabel lb9=new JLabel("price");
				    lb9.setBounds(820, 270, 100, 25);
				    this.frame.add(lb9);
				    
				    JLabel lb10=new JLabel("quantity");
				    lb10.setBounds(920, 270, 70, 25);
				    this.frame.add(lb10);
				    
				    
				    
				    
				  
				    jt= new JTable(data,column);
				    jt.setBounds(20,300,950,600);
					this.frame.add(jt);
					//this.j.add(sp);
					this.frame.revalidate();
					this.frame.repaint();
					  
				  //  System.out.println("successfully End");
				    
				   
				
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
								
			});
			
			
			JButton addToShoppingCart = new JButton("Add To Cart");
			addToShoppingCart.setBounds(700,180,140,60);
			addToShoppingCart.setForeground(Color.black);
			addToShoppingCart.setBackground(Color.yellow);
			this.frame.add(addToShoppingCart);
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
		        this.frame.add(sp);
		         
			     
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
		 		   
		 		  this.frame.revalidate();
		 	     this.frame.repaint();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		         
		         
		 		
		 	});
			
			JButton shoppingCart = new JButton("Shopping Cart");
			shoppingCart.setBounds(700,110,140,60);
			shoppingCart.setForeground(Color.black);
			shoppingCart.setBackground(Color.red);
			this.frame.add(shoppingCart);
			shoppingCart.addActionListener(e->{
				//this.j.setVisible(false);
				new Shopping_cart_gui(c_id,c_name,passw);
		 		
		 	});
			
			JButton back=new JButton("BACK");
			back.setBounds(550,40,100,50);
			back.setForeground(Color.black);
			back.setBackground(Color.blue);
			this.frame.add(back);
			back.addActionListener(e->{
		           
				this.frame.setVisible(false);
		        	   new Customer_gui(c_id, c_name, passw);
		         
						
			});
			
	        
	        //Add the Country Combobox
	       
			/*JLabel lf=new JLabel("Welcome To Our University System");
			lf.setBounds(20,20,500,50);
			lf.setForeground(Color.red);
			lf.setFont(new Font("Times new Rooman",Font.PLAIN,30));*/
	       
	        this.frame.setLayout(null);
			this.labelName = new JLabel("Search by Brand:");
			this.labelName.setFont(new Font(null, Font.PLAIN,20));
			this.labelName.setBounds(47, 60, 170, 40);
			this.labelName.setForeground(Color.red);
	        this.frame.add(this.labelName);
	        
	       
	        this.frame.setVisible(true); //visibility sobar last e dite hbe
	        //countryCombo.setSelectedIndex(0);
	        
	        
	}
	
	
	
	public SearchByBrand(){
	    this.frame = new JFrame("SearchByBrand");
	    //this.frame.setSize(1000,800);
	    this.frame.setBounds(0,0,1000,800);
	    //this.frame.setTitle("HOME");  
        //this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(null);
        
        this.txtFieldNum1 = new JTextField();
        //this.txtFieldNum1.setEditable(true);
		this.txtFieldNum1.setBounds(210, 60, 120, 40);
		this.txtFieldNum1.setForeground(Color.BLUE);
		this.txtFieldNum1.setFont(new Font(null, Font.PLAIN,20));
		this.frame.add(this.txtFieldNum1);
		
		
		
		this.btnSearch = new JButton("search");
		this.btnSearch.setBounds(332, 60, 100, 40);
		this.btnSearch.addActionListener(e->{
			
			try{
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
				System.out.println("Connection Successfull");
				Statement stmt = conn.createStatement();
			    String query = "Select * from product where brand='"+txtFieldNum1.getText()+"'";
			    
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
			    this.frame.add(lb1);
			    
			    JLabel lb2=new JLabel("id");
			    lb2.setBounds(120, 270, 100, 25);
			    this.frame.add(lb2);
			    
			    JLabel lb3=new JLabel("display");
			    lb3.setBounds(220, 270, 100, 25);
			    this.frame.add(lb3);
			    
			    JLabel lb4=new JLabel("ram");
			    lb4.setBounds(320, 270, 100, 25);
			    this.frame.add(lb4);
			    
			    JLabel lb5=new JLabel("rear_camera");
			    lb5.setBounds(400, 270, 100, 25);
			    this.frame.add(lb5);
			    
			    JLabel lb6=new JLabel("selfie_camera");
			    lb6.setBounds(500, 270, 100, 25);
			    this.frame.add(lb6);
			    
			    JLabel lb7=new JLabel("os");
			    lb7.setBounds(620, 270, 100, 25);
			    this.frame.add(lb7);
			    
			    JLabel lb8=new JLabel("brand");
			    lb8.setBounds(720, 270, 100, 25);
			    this.frame.add(lb8);
			    
			    JLabel lb9=new JLabel("price");
			    lb9.setBounds(820, 270, 100, 25);
			    this.frame.add(lb9);
			    
			    JLabel lb10=new JLabel("quantity");
			    lb10.setBounds(920, 270, 70, 25);
			    this.frame.add(lb10);
			    
			    
			    
			    
			    jt= new JTable(data,column);
			    jt.setBounds(20,300,950,600);
				this.frame.add(jt);
				//this.j.add(sp);
				this.frame.revalidate();
				this.frame.repaint();
				  
			    System.out.println("successfully End");
			    
			   
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
			
			
			
		});
		this.frame.add(btnSearch);
		
		JButton back=new JButton("BACK");
		back.setBounds(435,60,100,40);
		back.setForeground(Color.black);
		back.setBackground(Color.blue);
		this.frame.add(back);
		back.addActionListener(e->{
	           this.frame.setVisible(false);
				new SearchFunc();	
		});
        
       
       
        this.frame.setLayout(null);
		this.labelName = new JLabel("Search by Brand:");
		this.labelName.setFont(new Font(null, Font.PLAIN,20));
		this.labelName.setBounds(47, 60, 170, 40);
		this.labelName.setForeground(Color.red);
        this.frame.add(this.labelName);
        
       
        this.frame.setVisible(true); //visibility sobar last e dite hbe
        //countryCombo.setSelectedIndex(0);
        
        
}
	
	

	
	
}
