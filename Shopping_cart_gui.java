package gui_pkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;

import com.mysql.jdbc.ResultSetMetaData;

public class Shopping_cart_gui {

	JTable jt;
	Statement stmt;
	Connection conn;
	int totalPrice = 0;
	String s;

	public Shopping_cart_gui(int c_id) {

	}

	public Shopping_cart_gui(String c_id,String c_name,String passw) {

		// double price = 0.5;
		//String s = String.valueOf(totalPrice);

		JFrame j = new JFrame("Shopping_cart");
		j.setSize(1300, 800);
		j.setLayout(null);

		JLabel l1 = new JLabel("Total price(TAKA) : ");
		l1.setBounds(20, 20, 160, 30);
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Times new Rooman", Font.PLAIN, 16));
		j.add(l1);

		JButton back = new JButton("Back");
		back.setBounds(1100, 70, 150, 40);
		back.setBackground(Color.red);
		back.setForeground(Color.BLACK);
		j.add(back);
		back.addActionListener(e->{
			j.setVisible(false);
			//new Customer_gui(c_id,c_name,passw);
			
		});
		
		JButton refresh = new JButton("refresh");
		refresh.setBounds(1100, 120, 150, 40);
		refresh.setBackground(Color.green);
		refresh.setForeground(Color.BLACK);
		j.add(refresh);
		refresh.addActionListener(e->{
		
			 this.dlete_cart(c_id);
				j.setVisible(false);
				//new Customer_gui(c_id,c_name,passw);
				new Shopping_cart_gui(c_id,c_name,passw);
				
		});

		JButton buy = new JButton("Confirm & BUY");
		buy.setBounds(1100, 20, 150, 40);
		buy.setBackground(Color.magenta);
		buy.setForeground(Color.BLACK);
		j.add(buy);
		buy.addActionListener(e -> {
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
				stmt = conn.createStatement();
				
				String qry2 = "select * from cart where c_id='" + c_id + "'";
				stmt.executeQuery(qry2);
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No product found in cart");
				 e2.printStackTrace();
			}

			if(c_id=="0"){
				new Signup(c_id);
				j.setVisible(false);
				/*String newQuery = "DELETE from cart where c_id='"+null+"'";
				String newQuery2="insert into cart values('"+null+"','"+null+"','"+null+"','"+null+"','"+null+"','"+null+"')";           
						
				try {
					stmt.executeUpdate(newQuery);    //for delete null id list from db
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		else{
			
			String Data1=null;
			String Data = null;
			String Data2 = null;
			String Data3 = null;
			int price = 0;
			int qnty = 0;
			int count = 0;
			int cashchk=0;
			int avil=0;
			int availchk=0;
			int balancechk=0;

			jt.setCellSelectionEnabled(true);
			ListSelectionModel select = jt.getSelectionModel();
			select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

			System.out.println(jt.getRowCount());

			// int[] row = jt.getValueAt(arg0, arg1);
			// int[] columns = jt.getSelectedColumns();
			for (int i = 0; i < jt.getRowCount(); i++) {
                
				Data1 = (String) jt.getValueAt(i, 0);
				Data = (String) jt.getValueAt(i, 1);
				Data2 = (String) jt.getValueAt(i, 4);
				price = Integer.parseInt(Data2);
				Data3 = (String) jt.getValueAt(i, 5);
				qnty = Integer.parseInt(Data3);
				System.out.println(Data1);

				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
					stmt = conn.createStatement();

					String qry = "select * from product where m_id='" + Data + "'";

					//System.out.println(qry);
					ResultSet rs3 = stmt.executeQuery(qry);
		
					while (rs3.next()) {
						count = rs3.getInt("availablity");
						if (count >= qnty) {
							totalPrice = totalPrice + (qnty * price);
							 avil=count-qnty;
							
							 s = String.valueOf(totalPrice);
							 availchk=1;
							 
						} else {
							JOptionPane.showMessageDialog(null, "product quantity is lower then demand");
							j.setVisible(false);
							break;
						}

					}
					
					String qrycash = "select * from customer where c_id='" + Data1 + "'";
					 System.out.println(qrycash);
					 ResultSet rs10 = stmt.executeQuery(qrycash);
					 while(rs10.next()){
						 cashchk=rs10.getInt("cash");
						 System.out.println(cashchk);
						 if(cashchk>totalPrice && availchk==1){
							 
							 cashchk=cashchk-totalPrice;
							 
							 try {
									conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
									stmt = conn.createStatement();
									
									String qry2 = "UPDATE product SET availablity='" + avil + "' where m_id='"+Data+"'";
									stmt.executeUpdate(qry2);
									
									String qrycash2 = "UPDATE customer SET cash='" + cashchk + "' where c_id='"+Data1+"'";
									stmt.executeUpdate(qrycash2);
									balancechk=1;
									
								} catch (Exception e2) {
									e2.printStackTrace();
								}
													//System.out.println(qry2);
												
							 
						 }
						 else{
							 if(availchk==1){
								JOptionPane.showMessageDialog(null, "Sorry transaction failed due to insufficient balance. please try again with enough cash..!! ");
								j.setVisible(false);
								break;
							 }
						 }		
					 }
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally{
					//conn.close();
				}
				
					
			}
			
			JTextField t1 = new JTextField(s);
			t1.setEditable(false);
			t1.setBounds(180, 20, 200, 33);
			j.add(t1);
			
			if(availchk ==1 && balancechk==1){
			JOptionPane.showMessageDialog(null,"Thank you for buying successfully. "+totalPrice+"taka has been deducted from your account!!!!!");
			
			
			System.out.println("Table element selected is: " + Data + "" + Data2 + "" + Data3);
			JScrollPane sp = new JScrollPane(jt);
			j.add(sp);

			String p_id = null;
			String p_name = null;
			String p_brand = null;
			int p_price = 0;
			int p_qnty = 0;
			int i = 0;
			String check = null;

			try {

				conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
				System.out.println("Connection Successfull");
				stmt = conn.createStatement();
				String query = "Select * from product where m_id='" + Data + "'";

				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {

					p_id = Data;
					p_name = rs.getString("m_name");
					p_brand = rs.getString("brand");
					p_price = rs.getInt("unitPrice");
					p_qnty = 1;

				}

				String query3 = "Select * from cart where p_id='" + Data + "'";

				ResultSet rs3 = stmt.executeQuery(query3);
				while (rs3.next()) {

					check = rs3.getString("p_id");
					if (check.equals(p_id)) {
						i = 1;
					}

				}
				if (i != 1) {
					if (!p_id.isEmpty()) {
						String query2 = "insert into cart values('" + c_id + "','" + p_id + "','" + p_name + "','"
								+ p_brand + "','" + p_price + "','" + p_qnty + "')";

						stmt.executeUpdate(query2);
						System.out.println("dhukseeee");
						//add to cart doneeeee
						
					}
				}

				j.revalidate();
				j.repaint();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			}
        
			else{
				
				String newQuery = "DELETE from cart where c_id='"+c_id+"'";
				try {
					stmt.executeUpdate(newQuery);
				} catch (SQLException e100) {
					// TODO Auto-generated catch block
					e100.printStackTrace();
				}
				
			}
		}
			

		});

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
			// System.out.println("Connection Successfull");
			Statement stmt = conn.createStatement();
			String query = "Select * from cart where c_id='" + c_id + "'";

			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rstmt = (ResultSetMetaData) rs.getMetaData();
			int c = rstmt.getColumnCount();
			Vector column = new Vector(c);
			for (int i = 1; i <= c; i++) {
				column.add(rstmt.getColumnName(i));
			}

			Vector data = new Vector();
			Vector row = new Vector();

			while (rs.next()) {
				row = new Vector(c);
				for (int i = 1; i <= c; i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}
			
			JLabel lb1=new JLabel("UserID");
		    lb1.setBounds(20, 270, 150, 25);
		    j.add(lb1);
		    
		    JLabel lb2=new JLabel("id");
		    lb2.setBounds(200, 270, 150, 25);
		    j.add(lb2);
		    
		    JLabel lb3=new JLabel("Model");
		    lb3.setBounds(350, 270, 100, 25);
		    j.add(lb3);
		    
		    JLabel lb4=new JLabel("Brand");
		    lb4.setBounds(500, 270, 100, 25);
		    j.add(lb4);
		    
		    JLabel lb5=new JLabel("Price");
		    lb5.setBounds(650, 270, 100, 25);
		    j.add(lb5);
		    
		    JLabel lb6=new JLabel("Quantity");
		    lb6.setBounds(820, 270, 100, 25);
		    j.add(lb6);
			

			jt = new JTable(data, column);
			jt.setBounds(20, 300, 950, 600);
			j.add(jt);
			// this.j.add(sp);
			j.revalidate();
			j.repaint();

			// System.out.println("successfully End");

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		/*
		 * JButton back=new JButton("BACK"); back.setBounds(550,40,100,50);
		 * back.setForeground(Color.black); back.setBackground(Color.blue);
		 * j.add(back); back.addActionListener(e->{ j.setVisible(false);
		 * //((Window) Customer_gui.j).setVisible(true);
		 * 
		 * });
		 */

		j.revalidate();
		j.repaint();

		j.setVisible(true);

	}

	
	public Shopping_cart_gui(String c_id,String c_name,String passw, String neww) throws SQLException {
		
		
			Connection conn5 = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
			// System.out.println("Connection Successfull");
			Statement stmt5 = conn5.createStatement();
		String nu=null;
		 String query4 = "UPDATE cart SET c_id='"+c_id+"'where c_id='"+null+"'";
							try {
								stmt5.executeUpdate(query4);
							} catch (SQLException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
		
	
		
		// double price = 0.5;
				//String s = String.valueOf(totalPrice);

				JFrame j = new JFrame("Shopping_cart");
				j.setSize(1300, 800);
				j.setLayout(null);

				JLabel l1 = new JLabel("Total price(TAKA) : ");
				l1.setBounds(20, 20, 160, 30);
				l1.setForeground(Color.blue);
				l1.setFont(new Font("Times new Rooman", Font.PLAIN, 16));
				j.add(l1);

				JButton back = new JButton("Back");
				back.setBounds(1100, 70, 150, 40);
				back.setBackground(Color.red);
				back.setForeground(Color.BLACK);
				j.add(back);
				back.addActionListener(e->{
					j.setVisible(false);
					new Customer_gui(c_id,c_name,passw);
					

				});
				
				JButton refresh = new JButton("refresh");
				refresh.setBounds(1100, 120, 150, 40);
				refresh.setBackground(Color.green);
				refresh.setForeground(Color.BLACK);
				j.add(refresh);
				refresh.addActionListener(e->{
					 this.dlete_cart(c_id);
					j.setVisible(false);
					//new Customer_gui(c_id,c_name,passw);
					new Shopping_cart_gui(c_id,c_name,passw);
					
				});

				JButton buy = new JButton("Confirm & BUY");
				buy.setBounds(1100, 20, 150, 40);
				buy.setBackground(Color.magenta);
				buy.setForeground(Color.BLACK);
				j.add(buy);
				buy.addActionListener(e -> {
					  
					try {
						conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
						stmt = conn.createStatement();
						
						String qry2 = "select * from cart where c_id='" + c_id + "'";
						stmt.executeUpdate(qry2);
						
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "No product found in cart");
						 e2.printStackTrace();
					}
					
					String Data = null;
					String Data2 = null;
					String Data3 = null;
					int price = 0;
					int qnty = 0;
					int count = 0;

					jt.setCellSelectionEnabled(true);
					ListSelectionModel select = jt.getSelectionModel();
					select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

					System.out.println(jt.getRowCount());

					// int[] row = jt.getValueAt(arg0, arg1);
					// int[] columns = jt.getSelectedColumns();
					for (int i = 0; i < jt.getRowCount(); i++) {

						Data = (String) jt.getValueAt(i, 1);
						Data2 = (String) jt.getValueAt(i, 4);
						price = Integer.parseInt(Data2);
						Data3 = (String) jt.getValueAt(i, 5);
						qnty = Integer.parseInt(Data3);
						System.out.println(Data);

						try {
							conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
							stmt = conn.createStatement();

							String qry = "select * from product where m_id='" + Data + "'";
							System.out.println(qry);
							ResultSet rs3 = stmt.executeQuery(qry);
							while (rs3.next()) {
								count = rs3.getInt("availablity");
								if (count >= qnty) {
									totalPrice = totalPrice + (qnty * price);
									int avil=count-qnty;
									
									 s = String.valueOf(totalPrice);
									
									
									
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
					stmt = conn.createStatement();
					
					String qry2 = "UPDATE product SET availablity='" + avil + "' where m_id='"+Data+"'";
					stmt.executeUpdate(qry2);
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
									//System.out.println(qry2);
									
				
								} else {
									JOptionPane.showMessageDialog(null, "product quantity is lower then demand");
								}

							}
							
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally{
							//conn.close();
						}
						
							
					}
					
					JTextField t1 = new JTextField(s);
					t1.setEditable(false);
					t1.setBounds(180, 20, 200, 33);
					j.add(t1);
					JOptionPane.showMessageDialog(null,"Thank you for buying successfully!!!!!");
					
					
					System.out.println("Table element selected is: " + Data + "" + Data2 + "" + Data3);
					JScrollPane sp = new JScrollPane(jt);
					j.add(sp);

					String p_id = null;
					String p_name = null;
					String p_brand = null;
					int p_price = 0;
					int p_qnty = 0;
					int i = 0;
					String check = null;

					try {

						conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
						System.out.println("Connection Successfull");
						stmt = conn.createStatement();
						String query = "Select * from product where m_id='" + Data + "'";

						ResultSet rs = stmt.executeQuery(query);
						while (rs.next()) {

							p_id = Data;
							p_name = rs.getString("m_name");
							p_brand = rs.getString("brand");
							p_price = rs.getInt("unitPrice");
							p_qnty = 1;

						}

						String query3 = "Select * from cart where p_id='" + Data + "'";

						ResultSet rs3 = stmt.executeQuery(query3);
						while (rs3.next()) {

							check = rs3.getString("p_id");
							if (check.equals(p_id)) {
								i = 1;
							}

						}
						if (i != 1) {
							if (!p_id.isEmpty()) {
								String query2 = "insert into cart values('" + c_id + "','" + p_id + "','" + p_name + "','"
										+ p_brand + "','" + p_price + "','" + p_qnty + "')";

								stmt.executeUpdate(query2);
							}
						}

						j.revalidate();
						j.repaint();

					} catch (Exception e2) {
						e2.printStackTrace();
					}
					

				});

				try {

					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
					// System.out.println("Connection Successfull");
					Statement stmt = conn.createStatement();
					String query = "Select * from cart where c_id='" + c_id + "'";

					ResultSet rs = stmt.executeQuery(query);
					ResultSetMetaData rstmt = (ResultSetMetaData) rs.getMetaData();
					int c = rstmt.getColumnCount();
					Vector column = new Vector(c);
					for (int i = 1; i <= c; i++) {
						column.add(rstmt.getColumnName(i));
					}

					Vector data = new Vector();
					Vector row = new Vector();

					while (rs.next()) {
						row = new Vector(c);
						for (int i = 1; i <= c; i++) {
							row.add(rs.getString(i));
						}
						data.add(row);
					}
					
					JLabel lb1=new JLabel("UserID");
				    lb1.setBounds(20, 270, 150, 25);
				    j.add(lb1);
				    
				    JLabel lb2=new JLabel("id");
				    lb2.setBounds(200, 270, 150, 25);
				    j.add(lb2);
				    
				    JLabel lb3=new JLabel("Model");
				    lb3.setBounds(350, 270, 100, 25);
				    j.add(lb3);
				    
				    JLabel lb4=new JLabel("Brand");
				    lb4.setBounds(500, 270, 100, 25);
				    j.add(lb4);
				    
				    JLabel lb5=new JLabel("Price");
				    lb5.setBounds(650, 270, 100, 25);
				    j.add(lb5);
				    
				    JLabel lb6=new JLabel("Quantity");
				    lb6.setBounds(820, 270, 100, 25);
				    j.add(lb6);
					

					jt = new JTable(data, column);
					jt.setBounds(20, 300, 950, 600);
					j.add(jt);
					// this.j.add(sp);
					j.revalidate();
					j.repaint();

					// System.out.println("successfully End");

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				/*
				 * JButton back=new JButton("BACK"); back.setBounds(550,40,100,50);
				 * back.setForeground(Color.black); back.setBackground(Color.blue);
				 * j.add(back); back.addActionListener(e->{ j.setVisible(false);
				 * //((Window) Customer_gui.j).setVisible(true);
				 * 
				 * });
				 */

				j.revalidate();
				j.repaint();

				j.setVisible(true);
		
		
	}

	public void dlete_cart(String c_id) {

		System.out.println("cart refreshed successfully");
		 JOptionPane.showMessageDialog(null,"shopping cart cleared!!!");

		// delete all row that match with c_id from table shopping_cart from
		// database
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javasuperproject", "root", "");
			stmt = conn.createStatement();
			
			String qry2 = "DELETE from cart where c_id='" + c_id + "'";
			stmt.executeUpdate(qry2);
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}

}
