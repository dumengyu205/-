
public class Test03 {
	public static void main(String[] args) {
		Num t = new Num();
		new Thread(t,"�߳�1").start();
		new Thread(t,"�߳�2").start();
		new Thread(t,"�߳�3").start();
		new Thread(t,"�߳�4").start();
		new Thread(t,"�߳�5").start();

	}
}
class Num implements Runnable {
	private int sum= 100;
	public void run(){
		while (true) {
			if(sum>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"�������ص�"+sum--+"��");
			}
		}
	}
}