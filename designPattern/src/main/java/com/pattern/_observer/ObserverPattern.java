package _observer;

/**
 * @author martylee
 *客户Client
 */
public class ObserverPattern {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		F_observer f_observer = new F_observer();
		S_observer s_observer = new S_observer();
		T_Observer t_Observer = new T_Observer();
		
		Subject subject = new Subject();
		
		//观察者注册到被观察者中。
		subject.addAttach(f_observer);
		subject.addAttach(s_observer);
		subject.addAttach(t_Observer);
		
		//目标修改，通知观察者
		subject.setMsg("msg change");
		subject.setMsg("hahhhhhhhhhh");

	}

}
