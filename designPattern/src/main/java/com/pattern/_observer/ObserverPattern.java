package _observer;

/**
 * @author martylee
 *�ͻ�Client
 */
public class ObserverPattern {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		F_observer f_observer = new F_observer();
		S_observer s_observer = new S_observer();
		T_Observer t_Observer = new T_Observer();
		
		Subject subject = new Subject();
		
		//�۲���ע�ᵽ���۲����С�
		subject.addAttach(f_observer);
		subject.addAttach(s_observer);
		subject.addAttach(t_Observer);
		
		//Ŀ���޸ģ�֪ͨ�۲���
		subject.setMsg("msg change");
		subject.setMsg("hahhhhhhhhhh");

	}

}
