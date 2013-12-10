package countdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class processor implements Runnable{

	private CountDownLatch latch;
	public processor (CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println ("started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
	
}
public class App {
	public static void main(String args[]){
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService ex = Executors.newFixedThreadPool(3);
		
		for (int i =0; i<3;i++){
			ex.submit(new processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed");
	}

}
