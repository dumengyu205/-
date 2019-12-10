package cn.itcast.application;
import java.util.HashMap;

public class DBUtil {
	private static DBUtil instance =null;
	private HashMap<String,User>users = new HashMap<String,User>();
	
	private DBUtil(){
		User u1 =new User();
		u1.setCardId("1001");
		u1.setCardPwd("123456");
		u1.setUserName("¡ı±∏");
		u1.setCall("13281525712");
		u1.setAccount(1000);
		users.put(u1.getCardId(), u1);
		
		User u2 = new User();
		u2.setCardId("1002");
		u2.setCardPwd("234567");
		u2.setUserName("πÿ”");
		u2.setCall("13181527253");
		u2.setAccount(1000);
		users.put(u1.getCardId(), u2);
		
		User u3 = new User();
		u3.setCardId("1003");
		u3.setCardPwd("345678");
		u3.setUserName("’≈∑…");
		u3.setCall("13041018869");
		u3.setAccount(1000);
		users.put(u1.getCardId(), u3);
	}
	public static DBUtil getInstance(){
		if(instance==null){
			synchronized(DBUtil.class){
				if(instance==null){
					instance= new DBUtil();
				}
			}
		}
		return instance;
	}
	
	public User getUser(String cardId){
		User user = (User) users.get(cardId);
		return user;
	}
	public HashMap<String,User> getUsers(){
		return users;
	}
}
