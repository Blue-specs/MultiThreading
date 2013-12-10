package thread_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class processor implements Runnable {
	int id;
	public processor(int id){
	this.id = id;
	}
	@Override
	public void run() {
		System.out.println("starting id" +id);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finishing id" + id);
		
	}
	public static void main(String args[]){
		ExecutorService executor = Executors.newFixedThreadPool(2);
	
		for (int i=0;i<5;i++){
			executor.submit(new processor(i));
			
		}
		executor.shutdown();
		
		System.out.println("all tasks submitted");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("all tasks completed");
		
	}
	

}
