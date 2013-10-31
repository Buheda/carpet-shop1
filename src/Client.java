public class Client {
//сроки ожидания заказа в днях
private static int waitTime;
//сколько денег у клиента 
private static double money;
private static int quality;
public static int count;
public static String name;

public static boolean toBuy(int prQuality, double price, int time) {
	return ((prQuality>=quality)&&(price<=money)&&(time<=waitTime));
		}

public static void payAdvance(Order order,double advance) {
	order.setAdvance(advance);
	money=money-advance;	
	}

public static void payRemain(Order order) {
	//клиент пришел
	//клиент оплачивает остаток по заказу
	order.setRemain(money);
	Salesman.installProduct(order);
	}

public static void happyClient() {
	//клиенту установили покрытие и он счастлив
	System.out.print("i'm happy");
}
}