class YieldThread extends Thread {
	public YieldThread(String name){
		super(name);
	}
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+"---"+i);
			if(i==3) {
				System.out.print("�߳��ò�:");
				Thread.yield();
			}
		}
	}
}
public class Example09 {
	public static void main(String[] args) {
		Thread t1=new YieldThread("�߳�A");
		Thread t2=new YieldThread("�߳�B");
		t1.start();
		t2.start();

	}

}
