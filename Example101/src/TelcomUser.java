import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new ArrayList();
	}
	void generateCommunicateRecord(){
		int recordNum = new Random().nextInt(10);
		for(int i=0;i<=recordNum; i++){
			long timeStart = System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			long timeStart1 = cal.getTimeInMillis();
			long timeEnd1 = timeStart1 + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart1 + 
					"," + timeEnd1 +
					"," + this.callTo+ 
					";");
		    }
		}
		private String getCallToPhoneNumber() {
			return "1380372" +String.valueOf(new Random().nextInt(10))
			     + String.valueOf(new Random().nextInt(10))
			     + String.valueOf(new Random().nextInt(10))
			     + String.valueOf(new Random().nextInt(10));
		}
			private String accountFee(long timeStart,long timeEnd) {
				double feePerMinute = 0.2;
				int minutes = Math.round(timeEnd - timeStart)/60000;
				double feeTotal = feePerMinute * minutes;
				return(String.format("%.4f", feeTotal));
			}
				void printDetails(){
				  int arrayListSize = this.communicationRecords.size();
					for(int i=0;i<arrayListSize - 1;i++){
						System.out.println("----------通话记录分割线--------");
						String [] recordField = ((String) this.communicationRecords.get(i)).split(",");
						System.out.println("主叫："+recordField[0]);
						System.out.println("被叫："+recordField[3]);
						System.out.println("通话开始时间："+new Date(Long.parseLong(recordField[1])));
						System.out.println("通话结束时间："+new Date(Long.parseLong(recordField[2])));
						System.out.println("计费："
						        + accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
						        + "元。");
					}		
		}
	}
