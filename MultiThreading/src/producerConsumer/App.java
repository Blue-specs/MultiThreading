package producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	private static BlockingQueue<Integer> que = new ArrayBlockingQueue<Integer>(10);
	
	public static void main (String args[]){
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				producer();
				
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				consumer();
				
				
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
	}
	
	private static void producer(){
		Random r = new Random();
		while (true){
			try {
				que.put(r.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void consumer(){
		Random r = new Random();
		while (true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (r.nextInt(10) ==0){
				
					Integer value;
					try {
						value = que.take();
						System.out.println("taken value: " +value+"\nQue Size =" +que.size() );
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
				
			}
			
			
		}
	}


