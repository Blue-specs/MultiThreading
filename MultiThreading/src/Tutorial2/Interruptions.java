package Tutorial2;

import java.util.Random;

public class Interruptions {
	public static void main (String args[]) throws InterruptedException{
	
		System.out.println("Starting");
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				Random r = new Random();
				
				for(int i=0;i<1E6;i++){
					if (Thread.currentThread().isInterrupted()){
						System.out.println("interrupt");
						break;
					}
					Math.sin(r.nextDouble());
				}
				
			}
		
		});
		thread.start();
		thread.sleep(500);
		thread.interrupt();
		
		thread.join();
		System.out.println("finished");
	}

}
