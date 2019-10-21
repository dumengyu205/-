
public class Test03 {
	public static void main(String[] args) {
		Num t = new Num();
		new Thread(t,"线程1").start();
		new Thread(t,"线程2").start();
		new Thread(t,"线程3").start();
		new Thread(t,"线程4").start();
		new Thread(t,"线程5").start();

	}
}
class Num implements Runnable {
	private int sum= 100;
	public void run(){
		while (true) {
			if(sum>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在下载第"+sum--+"段");
			}
		}
	}
}