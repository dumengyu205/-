
public class Example02 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
        MyThread myThread=new MyThread();
        myThread.start();
        while (true) {
        	System.out.println("main()����������");
        }
	}
}
class MyThread extends Thread {
	public void run() {
		while (true) {
			System.out.println("MyThread��run()����������");
		}
	}
}
