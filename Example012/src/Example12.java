class Ticket1 implements Runnable{
	private int tickets=10;
	Object lock=new Object();
	public void run() {
		while (true) {
			synchronized (lock) {
				try {
					Thread.sleep(10);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				if(tickets>0) {
					System.out.println(Thread.currentThread().getName()+"---������Ʊ"+tickets--);
				} else {
					break;
				}
			}
		}
	}
}
public class Example12 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Ticket1 ticket=new Ticket1();
		new Thread(ticket,"�߳�һ").start();
		new Thread(ticket,"�̶߳�").start();
		new Thread(ticket,"�߳���").start();
		new Thread(ticket,"�߳���").start();
	}
}
