
public class Example10 {
	public static void main(String[] args) throws Exception {
		Thread t=new Thread(new EmergencyThread(),"线程一");
		t.start();
		for (int i=1;i<6;i++){
			System.out.println(Thread.currentThread().getName()+"输入:"+i);
			if(i==2) {
				t.join();
			}
			Thread.sleep(500);
		}
	}

}
class EmergencyThread implements Runnable {
	public void run() {
		for(int i=1;i<6;i++) {
			System.out.println(Thread.currentThread().getName()+"输入:"+i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
