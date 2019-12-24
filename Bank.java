package bank;
import java.util.*;
public class Bank {
  int account;
  private static User user;
  static Bank b =new Bank();
	public static void main(String[] args) {
      b.login();
      b.operate();
	}
	public  void  login() {
		DBUtil dbutil = DBUtil.getInstance();
		System.out.println("��ӭ������������ϵͳ");
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("��¼--1"+"ע��--2");
			String c=in.nextLine();
			switch(c) {
			case "1":
			System.out.println("���������п��ţ�");
			String cardId = in.nextLine();
			System.out.println("���������п����룺");
			String cardPwd = in.nextLine();
			user= (User)dbutil.getUser(cardId);
			if(user.getCardPwd().equals(cardPwd)) {
				System.out.println("��½�ɹ�����ӭ���пͻ���"+user.getUserName());
				break;
			}
			else {
				System.out.println("�������");
				continue;
			}
			case "2":
				register();
				save();
				break;
			default:
				System.out.println("���������룺");
			}
		}
	}
	public void operate() {
		while(true) {
			System.out.println("�����뽫Ҫ���еĲ�����");
			System.out.println("���--1"+"\t"+"ȡ��--2"+"\t"+"��ѯ���--3"+"\t"+"�˳�--0");
			Scanner in=new Scanner(System.in);
			String s = in.nextLine();
			switch(s) {
			case "1":
				System.out.println("���������");
				 int num=Integer.parseInt(in.nextLine()); //����
				b.income(num);
				break;
			case "2":
				System.out.println("������ȡ���");
				int num1=Integer.parseInt(in.nextLine());
				b.takeout(num1);
				break;
			case "3":
				b.show();
				break;
			case "0":
				System.out.println("�˳�ϵͳ��");
				return;
			default:
				System.out.println("���������룺");
			}
		}
	}
     public void income(int num) {
    	 account =user.getAccount()+num;
    	 user.setAccount(account);
    	 System.out.println("�������Ϊ"+account);
     }
     public void takeout(int num) {
    	 while(true) {
    	 if(num<=user.getAccount()) {
    		 System.out.println("����");
    		 System.out.println("���ٴ�����ȡ���");
			 int num1=Integer.parseInt(in.nextLine);
    	 }else 
    	 {
    		 account =user.getAccount()-num;
        	 user.setAccount(account);
    		 System.out.println("ȡ��ɹ������Ϊ"+account);
    		 break;
    	 }
    	 }
     }
     public void show() {
    	 System.out.println("�˻����Ϊ:"+user.getAccount());
     }
     private void register() {
    	 User u = new User();
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("���뿨��:");
    	 u.setCardId(scanner.nextLine());
    	 System.out.println("�������û���:");
    	 u.setUserName(scanner.nextLine());
    	 System.out.println("��������:");
    	 u.setCardPwd(scanner.nextLine());
    	 System.out.println("�����ֻ���:");
    	 u.setCall(scanner.nextLine());
    	 System.out.println("�������:");
    	 u.setAccount(scanner.nextInt());
    	 DBUtil dbUtil=DBUtil.getInstance();
    	 dbUtil.addUser(u);
     }
     private void save() {
    	 DBUtil dbUtil = DBUtil.getInstance();
    	 dbUtil.update();
     }
}
