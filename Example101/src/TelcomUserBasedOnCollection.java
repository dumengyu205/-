import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUserBasedOnCollection {
	private String phoneNumber;
	private String callTo;
	private Vector communicationRecords;
	private TreeSet callToNumbersSet;
	private ArrayList callToNumbersList;
	public TelcomUserBasedOnCollection(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new Vector();
		this.callToNumbersSet = new TreeSet();
		this.callToNumbersList = new ArrayList();
	}
	
	//ģ��ͨ����¼������
	void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//������ɵ�i��ͨ����¼			
			//��Calendar��ȡ��ǰʱ��
			Calendar cal = Calendar.getInstance();
			//�����ȥ����Сʱ��10Сʱ���ڣ�
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//��ö�Ӧ����
			long timeStart = cal.getTimeInMillis();
			//����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);			
			//���к���
			this.callTo = getCallToPhoneNumber();
			this.callToNumbersList.add(this.callTo);
			this.callToNumbersSet.add(this.callTo);
			//����ͨ����¼
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo);
		}
	}
	
	//������ɱ��к��루����λ�����������
	private String getCallToPhoneNumber() {
		//���һλ�������Ϊ����һЩ�ظ���
		return "1380372000" + String.valueOf(new Random().nextInt(10));
		/*
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
			 */
	}
	
	//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute = 0.2;
		//ͨ���������������������
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
	
	//��ӡͨ����¼
	void printDetails() {				
		/*
		 * ʹ��Enumeration�ӿڱ�����ע��Ӧ��communicationRecords����ΪVector
		 */
		Enumeration enumeration = this.communicationRecords.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String)enumeration.nextElement()).split(",");
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
		
		/*ʹ��for eachѭ������
		* 
		for(Object aRecord:this.communicationRecords) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String)aRecord).split(",");
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
		*/
		
		
		/*
		 * ʹ��ListIterator�������������
		 * 
		ListIterator it = this.communicationRecords.listIterator(
				this.communicationRecords.size());
		while(it.hasPrevious()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String) it.previous()).split(",");
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
		*/
		
		/*
		 * ʹ�õ�����
		 * 
		Iterator it = this.communicationRecords.iterator();
		while(it.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String) it.next()).split(",");
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
		*/
		
		
		/*ʹ������
		//��ȡ��¼��Ŀ����communicationRecords�����е�Ԫ�ظ���
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
		*/
	}
}
