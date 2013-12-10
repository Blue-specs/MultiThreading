package Locks;

import java.util.ArrayList;
import java.util.Random;

public class worker {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	Random r = new Random();
	private ArrayList<Integer> list1 = new ArrayList<>();
	private ArrayList<Integer> list2 = new ArrayList<>();
	public void  stage1(){
		synchronized (lock1) {
			
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(r.nextInt(100));
	}
	}
	public  void stage2(){
		synchronized (lock2) {
			
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(r.nextInt(100));
		}
	}
	public void process(){
		for (int i=0;i<1005;i++);{
			stage1();
			stage2();
		}
	}
	public void main(){
		System.out.println("Starting....");
		long start = System.currentTimeMillis();
		Thread t1 =new Thread(new Runnable(){

			@Override
			public void run() {
				process();
				
			}
			
		});
		Thread t2 =new Thread(new Runnable(){

			@Override
			public void run() {
				process();
				
			}
			
		});

		t1.start();
		t2.start();
		
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println("Timetaken " + (end-start) );
		
		
	}

}
