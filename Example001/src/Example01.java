
public class Example01 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        MyThread myThread=new MyThread();
        myThread.run();
        while (true) {
        	System.out.println("Main方法在运行");
        }
	}
}
class MyThread{
	public void run() {
		while (true) {
			System.out.println("MyThread类的run()方法在运行");
		}
	}
}
