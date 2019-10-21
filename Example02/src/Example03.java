
public class Example03 implements Runnable{
	public  void run(){
		for(int i=0;i<50;i++){
			System.out.println("new");
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Thread(new Example03()).start();
		for (int i=0;i<100;i++) {
			System.out.println("main");
		}
	}
}
