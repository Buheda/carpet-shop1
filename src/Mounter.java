import java.util.HashMap;

public class Mounter {
	private int workPrice;
	public String name;
	
	public Mounter(String mName)
	{
		name=mName;
	}
	
	public HashMap<String, Integer>  getMeasuring(String clName, String clPhone, String clAdress, int prId){
		String material=null;//using product
		//additional materials may be sell such as basic, so they all at the assortment
		int optimalCountProduct=1; // count of basic material
		HashMap<String, Integer>  listMaterials=new HashMap<String, Integer> (); //array of using material and it's count
		listMaterials.put("workPrice",workPrice);
		listMaterials.put(Shop.getProductFromAssortmentById(prId).title, optimalCountProduct);
		int i=2;
		optimalCountProduct=0; // count of using additional materials
		boolean using=false; 
		while (using) //select needed materials from all list
		{
		listMaterials.put(material, optimalCountProduct);
		i++;
		}
	return listMaterials;
	}
	
	public void install(int orderId){
	//install carpet at client with orderId
	  Shop.getClientFromBook(orderId).installComplete();
	}
	
}
