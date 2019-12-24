package bank;
public class User {
   private String cardId;
   private String cardPwd;
   private String userName;
   private String call;
   private int account;
   public String getCardId() {
	   return cardId;
   }
   public void setCardId(String cardId) {
	   this.cardId=cardId;
   }
   public String getCardPwd() {
	   return cardPwd;
   }
   public void  setCardPwd(String cardPwd) {
	  this.cardPwd=cardPwd;
   }
   public String getUserName() {
	   return userName;
   }
   public void  setUserName(String userName) {
	   this.userName= userName;
   }
   public String getCall() {
	   return call;
   }
   public void  setCall(String call) {
	   this.call=call;
   }
   public int getAccount() {
	   return account;
   }
   public void  setAccount(int account) {
	   this.account=account;
   }
}

