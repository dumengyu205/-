
public class TelcomAccountSystem {

	public static void main(String[] args) {
		//ʵ����һ�������û���TelcomUser
		//TelcomUser telcomUser = new TelcomUser("13800138000");
		TelcomUserBasedOnCollection telcomUser = new TelcomUserBasedOnCollection("13800138000");
		//����ͨ����¼
		telcomUser.generateCommunicateRecord();
		//��ӡͨ���굥
		//telcomUser.printDetails();
		telcomUser.printCallToNumber();
	}

}
