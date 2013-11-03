import java.util.ArrayList;
import java.util.HashMap;

public class Creator {
	public static ArrayList<Supplier> suppliersList;
	public String name;
	public String address;
	public String phone;
	public String essentialElements;
	private static ArrayList<Product> assortment;
	public static HashMap<Integer,String> account;
		
	public Creator(String crName, String crAddress, String crPhone,
			String essential_elements) {
		name=crName;
		address=crAddress;
		phone=crPhone;
		essentialElements=essential_elements;
		//create product in assortment
		Product pr=createProduct(1,"title1",10,25.69,8);
		addProductToAssortment(1,pr);
		pr=createProduct(2,"title2",20,20.8,6);
		addProductToAssortment(2,pr);		
		//and so on
		}

	private Product createProduct(int prId,String prTitle,int existCount,double prPrice, int prQuality){
		return new Product(prId, prTitle, existCount, prPrice, prQuality);			
		}
	
	public static void addProductToAssortment(int id, Product product) {
		assortment.add(id, product);		
		}

	public static Supplier getSupplierFromBook(String name) {		
		for (int i=0;i<suppliersList.size();i++)
			if (suppliersList.get(i).name.equals(name))
				{return suppliersList.get(i);
				}
		return null;
	}
	
	public void setWorkWithSupplier(Supplier sp){
		suppliersList.add(sp);
		}
			
	public ArrayList<Product>  getAssortment() {
		return assortment;
		}
	
	public static void createProduct(String spName, int orderId, int productId, String title,
			int count, double price, int quality) {
		Product pr= new Product(productId,title,count,price,quality);
	    //using suppliersList and input spName supplier know address to send product
		getSupplierFromBook(spName).bringProduct(orderId, pr, count);
		}

	
}

	
