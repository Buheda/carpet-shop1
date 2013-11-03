public class Salesman {
	public String name;	

	public Salesman(String slsName) {
	name=slsName;
	}

	/*public static void main(String[] args) {
		int productType=0 ;
		for (int i=0;i<products.length;i++)
			{
			if (Client.toBuy(products[i].quality, products[i].price, products[i].getTermOfDelivery(Client.count)))
				productType=i;
				}
			if (productType==0)
				//если ничего не подошло из ассортимента - уходит
				System.out.print("goodby");
			else
			{//Если клиент согласен с выбранным товаром 
			//выезд и получение информации на месте установки коврового покрытия:
			String[][] measurings=getMeasurings(productType);
			//расходные материалы:
			String[] Materials=measurings[0];
			//на основе Materials имеем стоимость расходных материалов materialPrice, к примеру, 10,56:
			double materialPrice=10.56;
			//оптимальное кол-во покрытия:
			int optimalCountProduct=Integer.parseInt(measurings[1][0]);
			//вычисляем новую цену с учетом доставки по оп	тимальному кол-ву материалов:
			double newPrice=materialPrice+products[productType].getTermOfDelivery(optimalCountProduct);
			newPrice = newPrice-(newPrice/100*discount);
			//quality может быть изменён в соответствии с особенностями заказа.
			//в данном варианте никаких особенностей нет:
			int quality=products[productType].quality;
			if (Client.toBuy(quality, newPrice, optimalCountProduct))
					{									
					Order order =  new Order(Client.name,
							products[productType],
							optimalCountProduct,quality,
							products[productType].getTermOfDelivery(optimalCountProduct));
					//клиент уплатил аванс
					double advance=newPrice/100*20;
					Client.payAdvance(order,advance);
					//отправляем заказ поставщику					
					sendOrder(order);				
					}			
			}
	}
	
	private static String[][] getMeasurings(int type)
	{
		//выезд и просчёт затрат материалов на месте
		//от type зависит какие материалы нужны(клей, например).
		String[] materials=null; 
		materials[0]="клей";		
		//оптимально необходимое кол-во товара		
		String optimalCountProduct="кол-во";
		String[][] a = null;
		a[0] = materials;
		a[1][0]=optimalCountProduct;
		return a;
	}

	//пришел товар по указанному заказу
	private static void getProduct(Order order)
	{//этот метод инициализируется поставщиком
		//привозит водитель товар в магазин
		Product orderedProduct = bringProduct(order);
		//осмотр товара на брак
		//сравниваем кач-во пришедшего товара с указанным в заказе
 		if (orderedProduct.getQuality()<order.getQuality())
 			//если есть брак - делаем обмен 
 			changeProduct(order);			
 		else
 			sendMessageToClient(order);
	}
	
	private static void sendOrder(Order order) {
		//отправление заказа поставщику
		}
	private static Product bringProduct(Order order) {
		//привезли товар в магазин в соответствии с заказом
		return null;
		}
	private static void changeProduct(Order order) {
		//общаемся с поставщиком и производим обмен		
		}
	private static void sendMessageToClient(Order order) {		
		//отправляем сообщение/звоним покупателю	
		//и обсуждается дата/время укладки
		//и сообщаем, что клиент должен оплатить оставшуюся часть заказа:
		Client.payRemain(order);
		}

	public static void installProduct(Order order) {
		//едем устанавливать в оговоренную дату покрытие в соответствие с заказом
		Client.happyClient();
	}
	
	public static void sentProduct(String place){
		//If (Product.getPlace()=="sklad")
			//Salesman.sentProduct(“sklad”));
	}
	*/
	
}
