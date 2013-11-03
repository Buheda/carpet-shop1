import java.util.ArrayList;
import java.util.HashMap;

public class Supplier {
	private static ArrayList<Product>  assortment;
	public static String name;
	public String address;
	public String Telephone;
    public static ArrayList<Creator> creatorsList;
	public static ArrayList accountList;
	private static ArrayList<Integer> prToSend;
	
	public Supplier(String sName){
		//get supplier to work
		name=sName;
		//create product in assortment
		//and so on
		Creator cr=getNewCreator();
		assortment=cr.getAssortment();
		Shop.manager.setAssortment(assortment);		
		}
	
	public Creator getNewCreator(){
		//this method can be used not only at supplier initialization
		Creator cr=new Creator("crName","crAddress","crPhone","essential_elements");
		addToCreatorsList(cr);
		return cr;		
		}
	
	/*public HashMap<Integer, String> createAccount(int orderId) {
		Order order= Shop.getOrderFromBook(orderId);
		HashMap<Integer,String> account=Creator.createAccount;
		accountList.add(account);		return account;
		}*/
	public HashMap<Integer, String> createAccount(String shopTitle, String clientName,
			int productId, double price, int quality) {	
		//it's may be other class "account" 
		//in that case account create at base of Shop.getOrderFromBook(orderId);
		int idAccount=5;		
		HashMap<Integer,String> account = null;
		account.put(idAccount,"newNameAccount");
		return account;	
		}
	
	public static void setPayAccount(int orderId) {
		//supplier may check bank account and than
		if (Shop.getOrderFromBook(orderId).getStatus().equals("prepaid"))
			{
			Product prInfo=Shop.getProductFromAssortmentById(Shop.getOrderFromBook(orderId).productId);
			
			int d=Shop.getOrderFromBook(orderId).count-Shop.getProductFromAssortmentById(Shop.getOrderFromBook(orderId).productId).getExistCount();
			if (d<=0)
				{
				//create and bring ordered count
				Product pr= new Product(prInfo.productId,prInfo.title,Shop.getOrderFromBook(orderId).count,
								Shop.getOrderFromBook(orderId).price,Shop.getOrderFromBook(orderId).quality);				
				bringProduct(orderId,pr,Shop.getOrderFromBook(orderId).count);
				}
			else
				{
				Order order=Shop.getOrderFromBook(orderId);
				//else bring existed count
				Product existProduct=new Product(prInfo.productId,prInfo.title,d,
						Shop.getOrderFromBook(orderId).price,Shop.getOrderFromBook(orderId).quality);
				bringProduct(orderId,existProduct,d);
				//and order to creator create other count
				Creator.createProduct(name, orderId, order.productId, Shop.getProductFromAssortmentById(order.productId).title,  
						d, order.price,order.quality);}
			}
		}
	public static void bringProduct(int orderId, Product pr, int count) {
		if (count==Shop.getOrderFromBook(orderId).count)
			{//if count  equals ordered count send them
			prToSend.remove(orderId);
			sendProduct(orderId, pr);
			}
		else 
			//else we accumulate count
			prToSend.set(orderId,prToSend.get(orderId)+count);		
		}
	
	public static void sendProduct(int orderId, Product pr) {
		//send product to shop's storage 
		//and say manager that product sent at shop
		Shop.getOrderFromBook(orderId).setStatus("send");
		Shop.sentToStorage(orderId,pr);
		Shop.manager.sentProduct(orderId);				
		}	

	public static int addToCreatorsList(Creator creator) {
		creatorsList.add(creator);
		return creatorsList.size();
		}
	
	public static Creator getCreatorFromList(int id) {		
		return creatorsList.get(id);
		}
	
	public ArrayList<Product> getAssortment(){
		return assortment;
	}
}