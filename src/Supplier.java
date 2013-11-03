public class Supplier {
	private static Product[] assortiment;
	public String name;
    public String account;
	
		
	public Supplier(String sName){
		//get supplier to work
		name=sName;
		//create product in assortiment
		assortiment[0] =  new Product(1,"title1",25.69,8);
		assortiment[1] =  new Product(2,"title2",20.8,6);
		//and so on
		Shop.manager.setAssortiment(assortiment);
	}
	
	public String createAccount(int orderId) {
		//it's may be other class "account" 
		//in that case account create at base of Shop.getOrderFromBook(orderId);		
		return account="new account";	
	}
	
	public static void setPayAccount(int orderId, String status) {
		//supplier may check bank account and than
		//if order.count not exist and status.equal("prepaid")- create 
        //then		
		sendProduct(orderId,"prepaid");
	}

	public static void sendProduct(int orderId, String status) {
		//say manager that product sent at shop
		if (status.equals("prepaid"))
			{
			int id= Shop.getOrderFromBook(orderId).productId;
			String title="";
			int i;
			for (i=0;i<assortiment.length;i++){
				if (assortiment[i].id==id) 
					{title=assortiment[i].title;break;}				
				}
				
			Product pr= new Product(id,title,Shop.getOrderFromBook(orderId).price,Shop.getOrderFromBook(orderId).quality);
			//send product to shop
			Shop.getOrderFromBook(orderId).setStatus("send");
			Shop.manager.sentProduct(orderId,pr);
			}
		}
	


	
	

}