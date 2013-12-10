package Tutorial1;
import java.util.*;
import java.io.*;
public class MainClass {
	
	public static int threadcount=4;
	public static int stop =80000;
	public static void main(String args[]){
		
		System.out.println("spawning threads......");
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int incrementAmount = stop/threadcount;
		int starting =1;
	for (int i=0;i<threadcount;i++){
		
		if ((i+1)!= threadcount){
			threads.add(new Thread(new PrimeThread(starting ,starting+incrementAmount,i+".txt",false)));
			starting +=incrementAmount;
		}
		else 
			threads.add(new Thread(new PrimeThread(starting ,starting+incrementAmount,i+".txt",true)));
			
		}//end for
	
	for (int i=0;i<threads.size();i++){
		threads.get(i).start();
	}
	for (int i=0;i<threads.size();i++){
		try
		{
			threads.get(i).join();
		}catch(Exception e)
		{
			
		}
	}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i=0;i<threads.size();i++){
			try {
				Scanner scan = new Scanner(new File(i+".txt"));
				while(scan.hasNextInt()){
					primes.add(scan.nextInt());
				}
				scan.close();
				
			} catch (Exception e) {
				
				
			}
		
		
		}
		System.out.println("PRIMES are\n\n\n\n\n");
		for (int i=0;i<primes.size();i++){
			System.out.println(primes.get(i));
		}
		
		
		
		
	}
		
		
		
	}


