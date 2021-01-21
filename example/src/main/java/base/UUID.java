package base;

public class UUID {
	public static void main(String[] args) {
		
		String str1 = "gajo123.780rjl";
		String str2 = str1.substring(str1.lastIndexOf("."));
		
		String str3 = UUID.randomUUID();
		String str4 = str3 + str2;
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);


	}

	private static String randomUUID() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
