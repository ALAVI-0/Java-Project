package product_pkg;

import java.util.*;

public class Product{
	protected String product_department;
	protected String product_category;
	protected String product_brand;
	
	protected String product_id;
	protected String product_name;
	protected double product_unitPrice;	
	protected String description;
	
	protected double display_Size;
	
	protected int product_quantity;
	protected int product_tmp_quantity;    //for real quantity
	//protected int p_order_quantity;
	static ArrayList<Product> productList;
	
	public Product(){
		productList = new ArrayList<Product>();
	}
	public Product(String product_id,String product_name,double product_unitPrice,int product_quantity){
		this.product_id=product_id;
		this.product_name=product_name;
		this.product_unitPrice=product_unitPrice;
		this.product_quantity=product_quantity;
		
	}
	protected void addNewProduct(Product p){
		productList.add(p);
		System.out.println("add new product successfully");

	}
	protected void addExistingProduct(String p_id,int addQuantity){
		for(Product prL:productList){
			if(prL.product_id.equals(p_id)){
				prL.product_quantity+=addQuantity;
			}
		}
		System.out.println("add existing product successfully");
	}
	protected void showProductList(){
				    System.out.println("********************************");
		    System.out.println("product id____"+"product name_____"+"unit price__"+"quantity");
		for(Product prL2:productList){
			System.out.println(prL2.product_id+"::"+prL2.product_name+"::"+prL2.product_unitPrice+"::"+prL2.product_quantity);
			
		}
	}
	
	protected void showExactProductList(String p_id){
		    System.out.println("********************************");
		    System.out.println("product id____"+"product name_____"+"unit price__"+"quantity");
		for(Product prL3:productList){
			if(prL3.product_id.equals(p_id)){
			System.out.println(prL3.product_id+"::"+prL3.product_name+"::"+prL3.product_unitPrice+"::"+prL3.product_quantity);
			}
		}
		
	}
	
	/*protected void p_remaining(int p_order_quantity){
		this.p_order_quantity=p_order_quantity;
		this.p_quantity=this.p_quantity-p_order_quantity;
		
	}*/
	protected void setP_id(String p_id){
		this.product_id=p_id;
	}
	protected void setP_name(String p_name){
		this.product_name=p_name;
	}
	protected void setP_unitPrice(double p_unitPrice){
		this.product_unitPrice=p_unitPrice;
	}
	protected void setP_quantity(int p_quantity){
		this.product_quantity=p_quantity;
	}
	
	protected String getP_id(){
		return this.product_id;
	}
	protected String getP_name(){
		return this.product_name;
	}
	protected double getP_unitPrice(){
		return this.product_unitPrice;
	}
	protected int getP_quantity(){
		return this.product_quantity;
	}
	

	/*public static void main( String arg[]){
		Product p=new Product();
		Product p1=new Product("001","Apple",50,10);
		Product p2=new Product("002","Mango",60,10);
	    Product p3=new Product("003","Grape",70,10);
		Product p4=new Product("004","Strawberry",80,10);
	    Product p5=new Product("005","Pineapple",90,10);
		p.addNewProduct(p1);
		p.addNewProduct(p2);
		p.addNewProduct(p3);
		p.addNewProduct(p4);
		p.addNewProduct(p5);
		
		p.showProductList();
		p.showExactProductList("002");
		p.addExistingProduct("001",5);
		p.showProductList();

	}*/
	
}

