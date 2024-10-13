import java.util.Random;

public class Main {
	public static void main(String[] args) {
		CicloThread t1 = new CicloThread("Proceso 1 ", 15);
		CicloThread t2 = new CicloThread("Proceso 2 ", 10);
		CicloRunnable tr3 = new CicloRunnable("Proceso 3 ", 20);
		CicloRunnable tr4 = new CicloRunnable("Proceso 4 ", 5);
		Thread t3 = new Thread(tr3); Thread t4 = new Thread(tr4);
		
		t1.start(); t2.start(); t3.start(); t4.start();
	}//main
}//class Main

class CicloRunnable implements Runnable{
	private int max;
	private Random random;
	private String name;
	public CicloRunnable(String name, int max) {
		this.max = max;
		this.name = name;
		random = new Random();
	}//constructor
	@Override
	public void run() {
	int cont = 0;
	while(cont < this.max) {
		System.out.println(this.name + cont++);
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//sleep:es como el setTimeOut de JS
	}//while
	}//run	
}//class CicloRunnable

class CicloThread extends Thread{
	private int max;
	private Random random;
	public CicloThread(String name, int max) {
		super(name);
			this.max = max;
			random = new Random();
		}//constructor
		
		@Override
		public void run() {
			int cont = 0;
			while(cont < this.max) {
				System.out.println(this.getName() + cont++);
				try {
					Thread.sleep(random.nextInt(3000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//sleep:es como el setTimeOut de JS
			}//while
		}//run
		
	}//class cicloThread
