
public class Supplier {
	private Product[] assortiment;
	public String name;
    public String account;
	
		
	public Supplier(String sName){
		//get supplier to work
		name=sName;
		//assortiment = set assortiment;
		Shop.manager.setAssortiment(assortiment);
	}
	
	public String createAccount() {
		//it's may be other class "account"
		return account="new account";	
	}
	
	public static void setPayAccount(Order order) {
		//supplier may check bank account and than
		sendProduct(order);
	}

	public static void sendProduct(Order order) {
		//say manager that product sent at shop
		if (order.getStatus().equals("advancepay"))
			{
			//send product to shop
			order.setStatus("send");
			Shop.manager.sentProduct(order);
			}
		}

}