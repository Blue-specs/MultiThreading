package syncronised;


public class app {
	//syncronised means accessing flag like os
	public synchronized void increment(){
		count++;
	}
	private int count;
	public static void main(String args[] ){
		app App  = new app();
		App.dowork();
	
	}
	public void dowork(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			for (int i=0;i<100000;i++){
				increment();
			}	
			
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			for (int i=0;i<100000;i++){
				increment();
			}	
			
			}
			
		});
	
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("count ="+count);
	

	}
}


