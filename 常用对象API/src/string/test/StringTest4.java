package string.test;
/*
 * 2017年7月20日13:05:41
 * 
 * 4，模拟一个trim功能一致的方法。去除字符串两端的空白 
 * 思路：
 * 1，定义两个变量。
 * 一个变量作为从头开始判断字符串空格的角标。不断++。
 * 一个变量作为从尾开始判断字符串空格的角标。不断--。
 * 2,判断到不是空格为止，取头尾之间的字符串即可。
 */
public class StringTest4 {
	public static void main(String[] args) {
		String s = "       ab   c    ";
		s = myTrim(s);
		System.out.println("-"+s+"-");	//运行结果：-ab   c-
	}

	private static String myTrim(String s) {
		int start = 0;
		int end = s.length()-1;
		
		while(start<=end && s.charAt(start)==' ')
			start ++;
		
		while(start<=end && s.charAt(end)==' ')
			end --;
		
		return s.substring(start, end+1);
	}
}
