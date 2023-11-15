package Q1;

public class Pattern2 extends Thread {
		
		private Object lock;
		private String pattern;
		private int count;
		
		public Pattern2(Object lock, String pattern, int count) {
			super();
			this.lock = lock;
			this.pattern = pattern;
			this.count = count;
		}
		
		public void run() {
			
			synchronized (lock) {
				for(int i = 0; i < count; i++) {
					System.out.println("Pattern 2 Thread : ");
					
					for(int j = 0; j < count; j++) { //prints the spaces
						System.out.println(" ");
					}
					
					for(int j = 0; j < i+1; j++) { //prints the pattern 
					System.out.println(pattern + " ");
					}
					System.out.println();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}


