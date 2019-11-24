
public class TelcomAccountSystem {

	public static void main(String[] args) {
		//实例化一个电信用户类TelcomUser
		//TelcomUser telcomUser = new TelcomUser("13800138000");
		TelcomUserBasedOnCollection telcomUser = new TelcomUserBasedOnCollection("13800138000");
		//生成通话记录
		telcomUser.generateCommunicateRecord();
		//打印通话详单
		//telcomUser.printDetails();
		telcomUser.printCallToNumber();
	}

}
