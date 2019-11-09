class Storage {
	private String[] cells=new String[10];
	private int inPos,outPos;
	private int count;
	public synchronized void put (int num){
		try{
			while(count==cells.length)
			{
				this.wait();
			}
		cells[inPos]=String.valueOf(num);
		System.out.println(cells[inPos]+"ÓÃ»§µÇÂ¼");
		inPos++;
		if(inPos==cells.length)
			inPos=0;
		count++;
		this.notify();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	public synchronized void get() {
		try{
			while(count==0){
				this.wait();
			}
		String data=cells[outPos];
		System.out.println(data+"×¢Ïú");
		outPos++;
		if(outPos==cells.length)
			outPos=0;
		count--;
		this.notify();
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
}