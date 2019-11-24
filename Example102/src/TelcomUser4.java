import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUser4 {
	private String phoneNumber;
	private String callTo;
	private Vector communicationRecords;
	private TreeSet callToNumbersSet;
	private ArrayList callToNumbersList;
	public TelcomUser4(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new Vector();
		this.callToNumbersSet = new TreeSet();
		this.callToNumbersList = new ArrayList();
	}
	
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			long timeStart = cal.getTimeInMillis();
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);			
			this.callTo = getCallToPhoneNumber();
			this.callToNumbersList.add(this.callTo);
			this.callToNumbersSet.add(this.callTo);
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo);
		}
	}
	
	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));

	}
	
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	void printCallToNumber() {
		for(Object callTo:this.callToNumbersList) {
			System.out.println((String)callTo);
		}
		System.out.println("--------List/Set�ָ���---------");
		for(Object callTo:this.callToNumbersSet) {
			System.out.println((String)callTo);
		}
	}
	
	void printDetails() {				
        int arrayListSize = this.communicationRecords.size();
		
		for(int i = 0; i < arrayListSize - 1; i++) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String) this.communicationRecords.get(i)).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
	}
}
