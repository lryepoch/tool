package _flyweight;

////������Ԫ��ɫ��
public class ConcreteFlyweight implements Flyweight {
	private String string;//����״̬
	  /**
     * ���캯��������״̬��Ϊ��������
     * 
     * @param intrinsicState
     */
	public ConcreteFlyweight(String string){
		this.string=string;
	}
	
	 /**
     * ����״̬��Ϊ�������뷽���У��ı䷽������Ϊ�� ���ǲ����ı���������״̬��
     */
	public void operation(String state) {
		// TODO Auto-generated method stub
		System.out.println("����״̬:"+this.string);
		System.out.println("����״̬��"+state);

	}

}
