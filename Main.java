package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Object lock = new Object(); //synchronization lock
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Pattern 1 : ");
		String p1 = sc.next();
		
		System.out.println("Enter Pattern 2 : ");
		String p2 = sc.next();

		System.out.println("Enter count : ");
		int count = sc.nextInt();
		
		Thread thread01 = new Pattern1(lock,p1,count);

		Thread thread02 = new Pattern1(lock,p2,count);
		
		thread01.start();
		thread02.start();
		
		try {
			thread01.join();
			thread02.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
