package command;

public class BuyStock implements Order {
	private Stock abcStock;
	
	public BuyStock(Stock abcStock) {
		// TODO Auto-generated constructor stub
		this.abcStock=abcStock;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		abcStock.buy();
	}

}
