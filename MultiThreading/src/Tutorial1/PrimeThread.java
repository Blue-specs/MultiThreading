package Tutorial1;
import java.util.*;
import java.io.*;

public class PrimeThread implements Runnable {
	int start;
	int stop;
	String file;
	boolean lead = false;
	public PrimeThread(int startValue, int stopValue,String fileName,boolean isLead){
		
		start = startValue;
		stop = stopValue;
		file = fileName;
		lead = isLead;
	}
	public void run() {
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i=start;i<=stop;i+=2){
			
			if (isPrime(i))
				primes.add(i);
			
			if (lead)
				System.out.println(i+"/" + stop);
			
			
		}
		try {
			PrintWriter print = new PrintWriter(new File(file));
			for(int i=0;i<primes.size();i++){
				print.println(primes.get(i));
			}
			print.close();
		}catch(Exception e){
		}
	}
	public static boolean isPrime(int totest){
		if (totest ==2)
			return true;
		
		for (int n =3;n<totest;n+=2){
			if (totest%n==0)
				return false;
				
		}
		return true;
		
	}

}
