import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
	public static String title;
	public static String owner;
	public static Product[] assortiment;	
	public static Manager manager;
	public static Supplier supplier;
	public static Mounter mounter;
	public static Administrator administrator;
	public static Salesman salesman;
	public static Shop shop; 
	private static double cashdesk;
	//we can transmit Client and Order as instants of class, or as link on Book of instances
	private static ArrayList clientsBook; 	
	private static ArrayList ordersBook; 
	
	
	public Shop(String title, String owner, Product[] assortiment, Administrator administrator, 
			Manager manager, Salesman salesman,Supplier supplier){
		this.title=title;
		this.assortiment=manager.getAssortiment();
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
		double summaryPrice=assortiment[prId].price*client.count;		
		
		
		if (client.toBuy(assortiment[prId].quality, summaryPrice, assortiment[prId].getTermOfDelivery(client.count)))
		{
		
		HashMap<String, Integer> listMaterials=null;
		int count= client.count;
		
		//quality depends on the features of order
		//in that case nothing special
		int quality=assortiment[prId].quality;	
			if (client.doMeasure){
			listMaterials=mounter.getMeasuring(client.name,client.getClientPhone(),client.getClientAdress(),prId);
			summaryPrice = administrator.getPriceMeasuring(listMaterials);			
			if (client.toBuy(quality, summaryPrice, assortiment[prId].getTermOfDelivery(listMaterials.get(assortiment[prId].title)))){
					count=listMaterials.get(assortiment[prId].title);
					}
			}	
		//administrator create new order and record client at clients book, order at order sbook
		int orderId = administrator.createOrder(client, prId, count, summaryPrice, listMaterials, quality);
		administrator.getAdvance(orderId);
		sls.sendOrderToMngr(orderId);
		mounter.install(orderId);
		}		
	}	
	
	public static void setAssortiment(Product[] newAssortiment) {
		assortiment=newAssortiment;		
	}

	public static Product bringProduct(int orderId, Product pr) {
		//bring product from storage to shop
		Shop.getOrderFromBook(orderId).setStatus("shop"); 
		return pr;
	}

	public static double getCashdesk() {
		return cashdesk;
	}

	public static void setCashdesk(double cashdesk) {
		Shop.cashdesk = cashdesk;
	}

	public static int addToClientsBook(Client client) {
		clientsBook.add(clientsBook);
		return clientsBook.size();
	}
	
	public static Client getClientsFromBook(int id) {		
		return (Client) clientsBook.get(id);
	}
	
	public static int addToOrdersBook(Order order) {
		ordersBook.add(ordersBook);
		return ordersBook.size();
	}
	
	public static Order getOrderFromBook(int id) {		
		return (Order) ordersBook.get(id);
	}
	
}
