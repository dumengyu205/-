
public class Example01 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
        MyThread myThread=new MyThread();
        myThread.run();
        while (true) {
        	System.out.println("Main����������");
        }
	}
}
class MyThread{
	public void run() {
		while (true) {
			System.out.println("MyThread���run()����������");
		}
	}
}
