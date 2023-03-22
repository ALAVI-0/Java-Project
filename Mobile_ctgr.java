package product_pkg;
import java.text.DateFormat;
import java.util.*;

//import java.lang.Object;
import org.apache.commons.lang3.text.WordUtils;  //for making just 1st letter uppercase;external library add


public class Mobile_ctgr{
   public static Mobile_ctgr mm;
   
   public String m_name;
   public String m_id;
   public double display_Size;
   public double ram;
   public double rear_camera_Resolution;
   public double selfie_camera_Resolution;
   public String os;
   public String brand;
   public double unitPrice;
   public int availablity;
   protected Date date;
   //LocalDate localDate = LocalDate.of( 2011 , Month.JULY , 3 );
   //protected String description; file input
   static ArrayList<Mobile_ctgr>mobile_ctgrList;
   
    public Mobile_ctgr(){
    	mobile_ctgrList=new ArrayList<Mobile_ctgr>();
    }
    
    public void addMobile(Mobile_ctgr mc){
    	int flag=0;
    	for(Mobile_ctgr mc1:mobile_ctgrList){
    		if(mc1.m_name.equals(mc.m_name)){
    			mc1.availablity+=mc.availablity;
    			flag++;
    			break;
    		}
    	}
    	if(flag==0){
    	mobile_ctgrList.add(mc);
    	}
    }
    
  public Mobile_ctgr(String m_id,String m_name,double display_Size,double ram,double rear_camera_Resolution,double selfie_camera_Resolution,String os,String brand,double unitPrice,int availablity){
    	this.m_id=m_id;
    	this.m_name=m_name;
    	this.display_Size=display_Size;
    	this.ram=ram;
    	this.rear_camera_Resolution=rear_camera_Resolution;
    	this.selfie_camera_Resolution=selfie_camera_Resolution;
    	this.os=os;
    	this.brand=brand;
    	this.unitPrice=unitPrice;
	    this.availablity=availablity;
	   
   }
   
 /* public static String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder();
	    boolean nextTitleCase = true;

	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;          //for making just 1st letter uppercase;
	        }

	        titleCase.append(c);
	    }

	    return titleCase.toString();
	}*/
  protected static String toDisplayCase(String s) {
	  ////for making 1st letter uppercase & next all letter lower case of a single word of a string;//for search subidha

	    final String ACTIONABLE_DELIMITERS = " '-/"; // these cause the character following
	                                                 // to be capitalized

	    StringBuilder sb = new StringBuilder();
	    boolean capNext = true;

	    for (char c : s.toCharArray()) {
	        c = (capNext)
	                ? Character.toUpperCase(c)
	                : Character.toLowerCase(c);
	        sb.append(c);
	        capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
	    }
	    return sb.toString();
	}
  
  public static void setobject(Mobile_ctgr m_c100){
	  
	  mm=m_c100;
  }
  public static ArrayList<Mobile_ctgr> getmobile_ctgrList(){
		  
		  return mobile_ctgrList;
	  }
	   
  public String getName(){
	  return m_name;
  }

  public static void showMobile_ctgrList(){
	   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");
	   for(Mobile_ctgr mc3:mobile_ctgrList){
		   System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs ");   
		   
	   }  
   }
   
   public static void searchByMobileName(String m_name){
	   m_name=toDisplayCase(m_name);
	   //m_name=WordUtils.capitalize(m_name);
	   System.out.println("********************************");
		   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");
	for(Mobile_ctgr mc3:mobile_ctgrList){
		if(mc3.m_name.equals(m_name)){
			 System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs "); 		}
	}
	
  }
   public static void searchByRear_camera_Resolution(double rear_camera_Resolution,double to_rear_camera_Resolution){
	    System.out.println("********************************");
		   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");
	for(Mobile_ctgr mc3:mobile_ctgrList){
		if(mc3.rear_camera_Resolution>=rear_camera_Resolution && mc3.rear_camera_Resolution<=to_rear_camera_Resolution){
			 System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs "); 		}
	}
	
}
   public static void searchBySelfie_camera_Resolution(double selfie_camera_Resolution,double to_selfie_camera_Resolution){
	    System.out.println("********************************");
		   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");
	for(Mobile_ctgr mc3:mobile_ctgrList){
		if(mc3.selfie_camera_Resolution>=selfie_camera_Resolution && mc3.selfie_camera_Resolution<=to_selfie_camera_Resolution){
			 System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs "); 		}
	}
	
}
   
   public static void searchByMobileUnitPrice(double unitPrice,double tounitPrice){
	    System.out.println("********************************");
		   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");
	for(Mobile_ctgr mc3:mobile_ctgrList){
		if(mc3.unitPrice>=unitPrice && mc3.unitPrice<=tounitPrice){
			 System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs "); 		}
	}
	
 }   
   /*public void searchByBrand(String brand){
	   
	   brand=toDisplayCase(brand);
	   System.out.println("********************************");
	   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");
    for(Mobile_ctgr mc3:mobile_ctgrList){
	    if(mc3.brand.equals(brand)){
		    System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs "); 		}
    }  

   }*/
   
   public static ArrayList<Mobile_ctgr> searchByBrand(String brand){
	   ArrayList<Mobile_ctgr> searchByBrand=new ArrayList<Mobile_ctgr>();
	   brand=toDisplayCase(brand);
	   /*System.out.println("********************************");
	   System.out.println("id-----brand---------model------display------ram-------rear camera-------selfie camera------os------price-----availablity");*/
    for(Mobile_ctgr mc3:mobile_ctgrList){
	    if(mc3.brand.equals(brand)){
	    	searchByBrand.add(mc3);
	    	//System.out.println(mc3.m_id+"    "+mc3.brand+"    "+mc3.m_name+"    "+mc3.display_Size+" inch   "+mc3.ram+" GB   "+mc3.rear_camera_Resolution+" mp   "+mc3.selfie_camera_Resolution+" mp   "+mc3.os+"   "+mc3.unitPrice+" "+" taka   "+mc3.availablity+" Pcs "); 		
		    }
    }
    return searchByBrand;

   } 
   
   public static void searchByRam(double ram,double toRam){
	   
	   
   }
   
   
   protected void searchbyRealeaseDate(){
	  /* int t=month-3
	   if t<0 then newmonth=12-t and year-1 then search by new month*/
   }
  
  
   
   
   }
