
public class Example02 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        MyThread myThread=new MyThread();
        myThread.start();
        while (true) {
        	System.out.println("main()方法在运行");
        }
	}
}
class MyThread extends Thread {
	public void run() {
		while (true) {
			System.out.println("MyThread类run()方法在运行");
		}
	}
}
