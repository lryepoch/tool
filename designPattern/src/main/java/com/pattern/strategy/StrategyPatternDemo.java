package strategy;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Context context = new Context(new OperationAdd());
		System.out.println(context.executeStrategy(10, 5));

		 context = new Context(new OperationSubstract());
		System.out.println(context.executeStrategy(10, 5));
		
		 context = new Context(new OperationMultiply());
		System.out.println(context.executeStrategy(10, 5));
	}

}
