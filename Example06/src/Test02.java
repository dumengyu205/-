
public class Test02 {
	public static void main(String[] args) {
		Taxi t = new Taxi();
		new Thread(t,"��ʦ��").start();
		new Thread(t,"Ǯʦ��").start();
		new Thread(t,"��ʦ��").start();
		new Thread(t,"��ʦ��").start();
		new Thread(t,"��ʦ��").start();

	}
}
class Taxi implements Runnable {
	private int people = 100;
	public void run(){
		while (true) {
			if(people>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"���ڽ��͵�"+people--+"ʣ������");
			}
		}
	}
}