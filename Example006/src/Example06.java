class DamonThread implements Runnable {
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName()+"---is running.");
		}
	}
}
public class Example06 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("main�߳��Ǻ�̨�߳���"+Thread.currentThread().isDaemon());
		DamonThread dt=new DamonThread();
		Thread t=new Thread(dt,"��̨�߳�");
		System.out.println("t�߳�Ĭ���Ǻ�̨�߳���"+t.isDaemon());
		t.setDaemon(true);
		t.start();
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}
}
