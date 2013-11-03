public class Salesman {
	public String name;
	public Salesman(String slsName) {
		name=slsName;
		}
	
	public void sendOrderToMngr(int orderId) {
		//sendOrderto manager
		Shop.manager.getOrder(orderId);
		}
	
	public void sentProduct(int orderId) {
		Order order=Shop.getOrderFromBook(orderId);
		//if product at the storage - bring him at the shop and send message to client
		if (order.getStatus().equals("storage")){		
			Product bringPr=Shop.bringProduct(orderId);
			if (bringPr.quality>=order.quality)
				{
				Shop.getClientFromBook(order.clientId).receiveMsg("Product in shop", orderId);
				Shop.administrator.getRemain(orderId);
				}
			}
		}	
}
