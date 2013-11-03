public class Client {
	public String name;
	public boolean doMeasure;
	public int count;
	private String adress;
	private String phone;
	private static double money;
	private static int quality;
	private static int waitTime;
	
	public Client(String clName,int clWaitTime,double clMoney,int clQuality, int clCount, boolean measure) {
		name=clName;
		money=clMoney;
		quality=clQuality;
		waitTime=clWaitTime;
		count=clCount;
		doMeasure = measure;
		}
	
	public boolean toBuy(int prQuality, double price, int time) {
		return ((prQuality>=quality)&&(price<=money)&&(time<=waitTime));
		}
	
	public double payAdvance(int orderId) {
		double advance=Shop.getOrderFromBook(orderId).price/100*70;
		money=money-advance;	
		return advance;
		}
	
	public double payRemain(int orderId) {
		double remain=Shop.getOrderFromBook(orderId).price/100*30;
		money=money-remain;
		return remain;
		}
	
	public String getClientAdress(){
		return adress;}
	public String getClientPhone(){
		return phone;}
	
	public void receiveMsg(String msg, int orderId) {
		if (msg.equals("Product in shop")){
			payRemain(orderId);
			}
		}
	public static void happyClient() {
		System.out.print("i'm happy");
		}
}