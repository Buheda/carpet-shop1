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
				//���� ������ �� ������� �� ������������ - ������
				System.out.print("goodby");
			else
			{//���� ������ �������� � ��������� ������� 
			//����� � ��������� ���������� �� ����� ��������� ��������� ��������:
			String[][] measurings=getMeasurings(productType);
			//��������� ���������:
			String[] Materials=measurings[0];
			//�� ������ Materials ����� ��������� ��������� ���������� materialPrice, � �������, 10,56:
			double materialPrice=10.56;
			//����������� ���-�� ��������:
			int optimalCountProduct=Integer.parseInt(measurings[1][0]);
			//��������� ����� ���� � ������ �������� �� ��	���������� ���-�� ����������:
			double newPrice=materialPrice+products[productType].getTermOfDelivery(optimalCountProduct);
			newPrice = newPrice-(newPrice/100*discount);
			//quality ����� ���� ������ � ������������ � ������������� ������.
			//� ������ �������� ������� ������������ ���:
			int quality=products[productType].quality;
			if (Client.toBuy(quality, newPrice, optimalCountProduct))
					{									
					Order order =  new Order(Client.name,
							products[productType],
							optimalCountProduct,quality,
							products[productType].getTermOfDelivery(optimalCountProduct));
					//������ ������� �����
					double advance=newPrice/100*20;
					Client.payAdvance(order,advance);
					//���������� ����� ����������					
					sendOrder(order);				
					}			
			}
	}
	
	private static String[][] getMeasurings(int type)
	{
		//����� � ������� ������ ���������� �� �����
		//�� type ������� ����� ��������� �����(����, ��������).
		String[] materials=null; 
		materials[0]="����";		
		//���������� ����������� ���-�� ������		
		String optimalCountProduct="���-��";
		String[][] a = null;
		a[0] = materials;
		a[1][0]=optimalCountProduct;
		return a;
	}

	//������ ����� �� ���������� ������
	private static void getProduct(Order order)
	{//���� ����� ���������������� �����������
		//�������� �������� ����� � �������
		Product orderedProduct = bringProduct(order);
		//������ ������ �� ����
		//���������� ���-�� ���������� ������ � ��������� � ������
 		if (orderedProduct.getQuality()<order.getQuality())
 			//���� ���� ���� - ������ ����� 
 			changeProduct(order);			
 		else
 			sendMessageToClient(order);
	}
	
	private static void sendOrder(Order order) {
		//����������� ������ ����������
		}
	private static Product bringProduct(Order order) {
		//�������� ����� � ������� � ������������ � �������
		return null;
		}
	private static void changeProduct(Order order) {
		//�������� � ����������� � ���������� �����		
		}
	private static void sendMessageToClient(Order order) {		
		//���������� ���������/������ ����������	
		//� ����������� ����/����� �������
		//� ��������, ��� ������ ������ �������� ���������� ����� ������:
		Client.payRemain(order);
		}

	public static void installProduct(Order order) {
		//���� ������������� � ����������� ���� �������� � ������������ � �������
		Client.happyClient();
	}
	
	public static void sentProduct(String place){
		//If (Product.getPlace()=="sklad")
			//Salesman.sentProduct(�sklad�));
	}
	*/
	
}
