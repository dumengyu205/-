
public class Example01 {
	public static void main(String[] args) throws Exception {
		String str1=new String();
		String str2=new String("��Сһ");
		char[] charArray=new char[]{'��','С','��'};
		String str3=new String(charArray);
		System.out.println("��"+str1+"С");
		System.out.println(str2);
		System.out.println(str3);
	}

}
