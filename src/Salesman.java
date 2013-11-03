public class Salesman {
	public String name;
	public Salesman(String slsName) {
		name=slsName;
		}
	
	public void sendOrderToMngr(int orderId) {
		//sendOrderto manager
		Shop.manager.getOrder(orderId);
		}
	
	public void sentProduct(int orderId, Product pr) {
		Order order=Shop.getOrderFromBook(orderId);
		if (order.getStatus().equals("storage")){		
			Product bringPr=Shop.bringProduct(orderId, pr);
			if (pr.quality>=order.quality)
				Shop.getClientsFromBook(order.clientId).receiveMsg("Product in shop by", orderId);
			}
		}	
}
