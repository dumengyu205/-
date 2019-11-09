import java.util.Random;

class Input implements Runnable{
	private Storage st;
	private int num;
	Input(Storage st) {
		this.st=st;
	}
	Random r=new Random();
	public void run(){
		while(true){
			st.put(r.nextInt());
		}
	}
}