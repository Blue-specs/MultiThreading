package Tutorial2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class interruption2 {
	public static void main (String args[]) throws InterruptedException{
	
		System.out.println("Starting");
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<?> fu = exec.submit(new Callable<Void>(){

			@Override
			public Void call() throws Exception {
				Random r = new Random();
				
				for(int i=0;i<1E6;i++){
					if (Thread.currentThread().isInterrupted()){
						System.out.println("interrupted");
						break;
					}
					Math.sin(r.nextDouble());
				}
				
			
				return null;
			} 
			
		});
		exec.shutdown();
		
		Thread.sleep(500);
		exec.shutdownNow();
		//fu.cancel(false);
		
		exec.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("finished");
	}

}
