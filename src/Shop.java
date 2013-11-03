import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
	public static String title;
	public static String owner;
	public static ArrayList<Product>  assortment;	
	public static Manager manager;
	public static Supplier supplier;
	public static Mounter mounter;
	public static Administrator administrator;
	public static Salesman salesman;
	public static Shop shop; 
	private static double cashdesk;
	//we can transmit Client and Order as instants of class, or as link on Book of instances
	private static ArrayList<Client> clientsBook; 	
	private static ArrayList<Order> ordersBook;
	public static ArrayList<Product> storage;	
	
	
	
	public Shop(String title, String owner, Product[] assortment, Administrator administrator, 
			Manager manager, Salesman salesman,Supplier supplier){
		this.title=title;
		this.assortment=manager.getAssortment();
		this.administrator=administrator;
		this.manager=manager;
		this.salesman=salesman;
		this.supplier=supplier;	
		}
	
	
	public static void main(String[] args) {
		setCashdesk(0);
		manager = new Manager("mngName");
		supplier = new Supplier("sName");		
		administrator = new Administrator("admName");
		mounter = new Mounter("mName");
		Salesman[] allSalesmans=null;
		allSalesmans[0] = new Salesman("slsName1");
		allSalesmans[1] = new Salesman("slsName2");
		allSalesmans[2] = new Salesman("slsName3");
		Client client1 = new Client("clName1",15,5000,8,20, true);
		Client client2 = new Client("clName2",10,10000,10,5, false);
		doSell(client1, allSalesmans[2]);
		doSell(client2, allSalesmans[0]);
		}

	
	public static void doSell(Client client, Salesman sls){
		

		//salesman talk with client and decided what product will be install id=5
		int prId=5;
		Product product=getProductFromAssortmentById(prId);
		if (product==null)
			System.out.println("Sorry we dont have this product in assortment right now");
		else
			{
			double summaryPrice=product.price*client.count;					
			if (client.toBuy(product.quality, summaryPrice, product.getTermOfDelivery(client.count)))
				{
				HashMap<String, Integer> listMaterials=null;
				int count= client.count;				
				//quality depends on the features of order
				//in that case nothing special
				int quality=product.quality;	
				if (client.doMeasure){
					listMaterials=mounter.getMeasuring(client.name,client.getClientPhone(),client.getClientAdress(),prId);
					summaryPrice = administrator.getPriceMeasuring(listMaterials);			
					if (client.toBuy(quality, summaryPrice, product.getTermOfDelivery(listMaterials.get(product.title)))){
							count=listMaterials.get(product.title);
							}
					}	
				//administrator create new order and record client at clients book, order at orders book with the identical number
				int orderId = administrator.createOrder(client, prId, count, summaryPrice, listMaterials, quality);
				administrator.getAdvance(orderId);
				Order order=getOrderFromBook(orderId);
				if (order.getStatus().equals("advancepay"))
					{
					sls.sendOrderToMngr(orderId);
					if (order.getStatus().equals("storage"))
						{
						Shop.administrator.getRemain(orderId);
						if (order.price ==  order.getAdvance()+order.getRemain())
							mounter.install(orderId);
						}
					}
				}
			}
	}	
	
	public static void setAssortment(ArrayList<Product> newAssortment) {
		assortment=newAssortment;		
	}

	public static Product bringProduct(int orderId) {
		//bring product from storage to shop
		Order order=getOrderFromBook(orderId);
		Shop.getOrderFromBook(orderId).setStatus("shop");
		return storage.get(orderId);
		}

	public static double getCashdesk() {
		return cashdesk;
	}

	public static void setCashdesk(double cashdesk) {
		Shop.cashdesk = cashdesk;
	}

	public static int addToClientsBook(Client client) {
		clientsBook.add(client);
		return clientsBook.size();
	}
	
	public static Client getClientFromBook(int id) {		
		return clientsBook.get(id);
	}
	
	public static void addToOrdersBook(int id, Order order) {
		ordersBook.add(id, order);
	}
	
	public static Order getOrderFromBook(int id) {		
		return ordersBook.get(id);
	}
	
	public static Product getProductFromAssortmentById(int id){
			return assortment.get(id);
	}

	public static void sentToStorage(int orderId, Product pr) {		
		//product at the storage. Change order status
		storage.add(orderId, pr);
		getOrderFromBook(orderId).setStatus("storage");
	}
	
}
