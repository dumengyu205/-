
public class Example03 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
     MyThread myThread=new MyThread();
     Thread thread=new Thread(myThread);
     thread.start();
     while (true) {
    	 System.out.println("main()����������");
     }
	}

}
class MyThread implements Runnable{
	public void run() {
		while (true) {
			System.out.println("MyThread���run()����������");
		}
	}
}
