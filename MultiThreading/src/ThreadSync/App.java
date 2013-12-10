package ThreadSync;

import java.util.Scanner;

class processor extends Thread{
	//all threads can see a volitile variable
	private volatile boolean running=true;
	public void run(){
		while (running){
			System.out.println("hello");
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				
				
			}
		}
	}
	public void shutdown(){
		running = false;
	}
}


public class App {

	public static void main (String args[]){
		processor p = new processor();
		
		p.start();
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		p.shutdown();
		
	}
}
