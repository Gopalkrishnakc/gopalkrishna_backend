package com.excel.mt;

public class ThreadSleepMethod2 implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(3000);
				System.out.println(i);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
public static void main(String[] args) {
	ThreadSleepMethod2 t1=new ThreadSleepMethod2();
	ThreadSleepMethod2 t2=new ThreadSleepMethod2();
	Thread t=new Thread(t1);
	Thread t3=new Thread(t2);
	try {
		t.start();
		System.out.println(t.getName()+"-->>"+t.getPriority()+"====>"+t.getId());
	System.out.println(Thread.currentThread().getName());
	t.join(6000);
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	
	try {
		t3.setDaemon(true);
		t3.start();
		t3.setPriority(1);
		System.out.println(t3.getName()+"-->>"+t3.getPriority()+"====>"+t3.getId());
		t3.setName("java7");
		System.out.println(Thread.currentThread().getName());
		System.out.println(t3.getName()+"-->>"+t3.getPriority()+"====>"+t3.getId());
		t3.join();
	} catch (Exception e) {
	
		e.printStackTrace();
	}
}
}
