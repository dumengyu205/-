
public class Test02 {
	public static void main(String[] args) {
		Taxi t = new Taxi();
		new Thread(t,"赵师傅").start();
		new Thread(t,"钱师傅").start();
		new Thread(t,"孙师傅").start();
		new Thread(t,"李师傅").start();
		new Thread(t,"周师傅").start();

	}
}
class Taxi implements Runnable {
	private int people = 100;
	public void run(){
		while (true) {
			if(people>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在接送第"+people--+"剩余人数");
			}
		}
	}
}