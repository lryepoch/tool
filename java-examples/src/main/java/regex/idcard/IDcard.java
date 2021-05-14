package regex.idcard;

//检验是否是身份证
public class IDcard {
	public boolean prove(String str){
//		正则表达式
		String regex="\\d{17}[0-9x]";
		boolean b=str.matches(regex);
		return b;
	}
	public static void main(String[] args) {
		IDcard id=new IDcard();
		String string="440981199608266414";
		boolean c=id.prove(string);
		System.out.println(c);
		for(int i=6;i<string.length()-4;i++)
			System.out.print(string.charAt(i));
	}

}
