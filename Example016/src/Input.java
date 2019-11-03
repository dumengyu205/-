class Storage{
	private int[] cells=new int[10];
	private int inPos,outPos;
	public void put (int num) {
		cells[inPos]=num;
		System.out.println("��cells["+inPos+"]�з�������---"+cells[inPos]);
		inPos++;
		if(inPos==cells.length)
			inPos=0;
	}
public void get() {
	int data=cells[outPos];
	System.out.println("��cells["+outPos+"]��ȡ������"+data);
	outPos++;
	if(outPos==cells.length)
		outPos=0;
    }
}
class Input implements Runnable{
	private Storage st;
	private int num;
	Input(Storage st){
		this.st=st;
	}
	public void run(){
		while(true){
			st.put(num++);
		}
	}
}
