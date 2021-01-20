package regex.idcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式，常用方法演示
public class Regex {
	public static void main(String[] args) {
		
//		match匹配
//		String str="123a45664";
//		String idcard="[1-9]\\d{4,14}";
//		boolean boo=str.matches(idcard);
//		System.out.println(boo);
		
		
//		String str="1234567";
//		String idcard="1[2345]\\d{5}";
//		System.out.println(str.matches(idcard));
		
		
//		split分割
//		String str="123   46  2342   545";
//		String idcard=" +";
//		String[] strings=str.split(idcard);
//		System.out.println("长度："+strings.length);
//		for(String s:strings)
//			System.out.println(s);
		
//		String str="ekkkjbbbbk";
//		String idcard="(.)\\1+";
//		String[] strings=str.split(idcard);
//		System.out.println("长度："+strings.length);
//		for(String s:strings)
//			System.out.println(s);
		
		
//		replaceAll替换
//		String str="we12345ty34567";
//		String idcard="\\d{5}";
//		str=str.replaceAll(idcard, "#");
//		System.out.println("替换后："+str);
		
//		String str="eeeeeeklkkkkkjjjjjjjjjbbbbbbbbbb";
//		String idcard="(.)\\1+";
//		str=str.replaceAll(idcard, "$1");
//		System.out.println(str);
		
		
//		Matcher+Pattern提取
		String str="ni shi bu Shi sha bi ya hah";
		String regex="\\b[a-zA-Z]{3}\\b";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(str);
		
		System.out.println(matcher.find());
		System.out.println(matcher.group(0));
		
//		System.out.println("----------------");
//		while(matcher.find()){
//			System.out.println(matcher.group());
//			System.out.println(matcher.start()+"……"+matcher.end());
//			// start()  字符的开始下标（包含）
//            //end()  字符的结束下标（不包含）
//		}
		
//		System.out.println(matcher.find(7));
		
		
		
		
		
		
		
	}

}
