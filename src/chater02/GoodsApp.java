package chater02;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods=new Goods();
		goods.setName("nikon");
		goods.setPrice(4000);
		goods.setCountSold(100);
		goods.setCountStock(50);
		System.out.println(goods.getName()+":"+goods.getPrice()+":"+goods.getCountStock()+":"+goods.getCountSold());
	}

}
