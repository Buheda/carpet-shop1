public class Shop {
	public static String title;
	public static String owner;
	public static Product[] assortiment;
	public static Manager manager;
	public static Supplier supplier;	
	public static Administrator administrator;
	//public static Client client;
	public static Salesman salesman;
	//public Salesman[] allSalesmans;
	public static Shop shop; 
	
	public static void main(String[] args) {
		manager = new Manager("mngName");
		supplier = new Supplier("sName");		
		administrator = new Administrator("admName");
		Salesman[] allSalesmans=null;
		allSalesmans[0] = new Salesman("slsName1");
		allSalesmans[1] = new Salesman("slsName2");
		allSalesmans[2] = new Salesman("slsName3");
		Client client1 = new Client("clName1",15,5000,8,20);
		Client client2 = new Client("clName2",10,10000,10,5);
		doSell(client1, allSalesmans[2]);
		doSell(client2, allSalesmans[0]);
	}

	public Shop(String title, String owner, Product[] assortiment, Administrator administrator, 
			Manager manager, Salesman salesman,Supplier supplier)
	{
		this.title=title;
		this.assortiment=manager.getAssortiment();
		this.administrator=administrator;
		this.manager=manager;
		this.salesman=salesman;
		this.supplier=supplier;	
	}
	
	public static void doSell(Client client, Salesman salesman){
		
	}
	
	
	public void setAssortiment(Product[] newAssortiment) {
		assortiment=newAssortiment;
		
	}
	
	
}
