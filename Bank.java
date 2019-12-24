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
		System.out.println("欢迎进入网上银行系统");
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("登录--1"+"注册--2");
			String c=in.nextLine();
			switch(c) {
			case "1":
			System.out.println("请输入银行卡号：");
			String cardId = in.nextLine();
			System.out.println("请输入银行卡密码：");
			String cardPwd = in.nextLine();
			user= (User)dbutil.getUser(cardId);
			if(user.getCardPwd().equals(cardPwd)) {
				System.out.println("登陆成功！欢迎本行客户："+user.getUserName());
				break;
			}
			else {
				System.out.println("密码错误！");
				continue;
			}
			case "2":
				register();
				save();
				break;
			default:
				System.out.println("请重新输入：");
			}
		}
	}
	public void operate() {
		while(true) {
			System.out.println("请输入将要进行的操作：");
			System.out.println("存款--1"+"\t"+"取款--2"+"\t"+"查询余额--3"+"\t"+"退出--0");
			Scanner in=new Scanner(System.in);
			String s = in.nextLine();
			switch(s) {
			case "1":
				System.out.println("请输入存款金额：");
				 int num=Integer.parseInt(in.nextLine()); //划点
				b.income(num);
				break;
			case "2":
				System.out.println("请输入取款金额：");
				int num1=Integer.parseInt(in.nextLine());
				b.takeout(num1);
				break;
			case "3":
				b.show();
				break;
			case "0":
				System.out.println("退出系统！");
				return;
			default:
				System.out.println("请重新输入：");
			}
		}
	}
     public void income(int num) {
    	 account =user.getAccount()+num;
    	 user.setAccount(account);
    	 System.out.println("存款后余额为"+account);
     }
     public void takeout(int num) {
    	 while(true) {
    	 if(num<=user.getAccount()) {
    		 System.out.println("余额不足");
    		 System.out.println("请再次输入取款金额：");
			 int num1=Integer.parseInt(in.nextLine);
    	 }else 
    	 {
    		 account =user.getAccount()-num;
        	 user.setAccount(account);
    		 System.out.println("取款成功，余额为"+account);
    		 break;
    	 }
    	 }
     }
     public void show() {
    	 System.out.println("账户余额为:"+user.getAccount());
     }
     private void register() {
    	 User u = new User();
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("输入卡号:");
    	 u.setCardId(scanner.nextLine());
    	 System.out.println("请输入用户名:");
    	 u.setUserName(scanner.nextLine());
    	 System.out.println("输入密码:");
    	 u.setCardPwd(scanner.nextLine());
    	 System.out.println("输入手机号:");
    	 u.setCall(scanner.nextLine());
    	 System.out.println("输入余额:");
    	 u.setAccount(scanner.nextInt());
    	 DBUtil dbUtil=DBUtil.getInstance();
    	 dbUtil.addUser(u);
     }
     private void save() {
    	 DBUtil dbUtil = DBUtil.getInstance();
    	 dbUtil.update();
     }
}
