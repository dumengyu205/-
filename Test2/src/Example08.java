
public class Example08 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("1、添加---------------------");
		add();
		System.out.println("2、添加---------------------");
		remove();
		System.out.println("3、添加---------------------");
		alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();
		sb.append("张小三");
		System.out.println("append添加结果:"+sb);
		sb.insert(2,"一");
		System.out.println("insert添加结果:"+sb);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("张小三");
		sb.delete(1, 1);
		System.out.println("删除指定位置结果："+sb);
		sb.deleteCharAt(2);
		System.out.println("删除指定位置结果："+sb);
		sb.delete(0,sb.length());
		System.out.println("清空缓冲区结果："+sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("张小三");
		sb.setCharAt(1, '李');
		System.out.println("修改指定位置结果："+sb);
		sb.replace(1, 2, "四");
		System.out.println("替换指定位置字符（串）结果："+sb);
		System.out.println("字符串翻转结果："+sb.reverse());
	}

}
