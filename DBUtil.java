package bank;
import java.io.*;
import java.util.*;
public class DBUtil {
private static DBUtil instance = null;
private TreeMap users = new TreeMap();
private DBUtil(){
	getUsersFromInputStream("user.txt");	
}
private void getUsersFromInputStream(String isName) {
	try {
		FileInputStream fs=new FileInputStream(isName);
		byte[] content = new byte[1024];
		int i=0;
		int conInteger=0;
		while(true) {
			try {
				conInteger=fs.read();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(conInteger==-1) {
				break;
			}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
				try {
					this.processUserString(new String(content, "GBK").trim());
					i=0;
				}catch(UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				continue;
			} else {
				content[i]=(byte)conInteger;
			i++;
			}
		}
	}catch(Exception e) {
		e.getStackTrace();
	}
}
public void processUserString(String userString) {
	String [] userFilelds = userString.split(",");
	User u = new User();
	u.setCardId(userFilelds[0]);
	u.setCardPwd(userFilelds[1]);
	u.setUserName(userFilelds[2]);
	u.setCall(userFilelds[3]);
	u.setAccount(Integer.parseInt(userFilelds[4]));
	addUser(u);
}
  public static DBUtil getInstance() {
	  if(instance==null) {
		//»®µã
		  synchronized(DBUtil.class) {   
			  if(instance==null) {
			 instance = new DBUtil();
		  }
		 }
	  }
	  return instance;
  }
 public  Object getUser(String cardId){
	 
	  return users.get(cardId);
  }
  public TreeMap<String,User>getUsers(){
	  return users;
  }
  public void addUser(User u) {
	  users.put(u.getCardId(),u);
  }
  public void update() {
	  Set<String> userSet = users.keySet();
	  StringBuffer uStringBuffer = new StringBuffer();
	  for(String cardId:userSet) {
		User u =(User)users.get(cardId);
		  String uString = u.getCardId()+","+u.getCardPwd()+","+u.getUserName()+","+u.getCall()+","+u.getAccount()+"\r\n"
;	  
		  uStringBuffer.append(uString); }
	  putUsersToFile(uStringBuffer.toString(),"user.txt");
  }
  private void putUsersToFile(String uString,String osName) {
	  try {
		  FileOutputStream fos = new FileOutputStream(osName);
		  try {
			 fos.write(uString.getBytes("GBK"));
			 
		  }catch(UnsupportedEncodingException e) {
			  e.printStackTrace();
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
}
