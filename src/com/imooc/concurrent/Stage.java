package com.imooc.concurrent;

public class Stage extends Thread {
	public void run(){
		System.out.println("***************");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArmyRunnable armyDynasty=new ArmyRunnable();
		ArmyRunnable armyRevolt=new ArmyRunnable();
		
		Thread armyOfDynasty=new Thread(armyDynasty,"随军");
		Thread armyOfRevolt=new Thread(armyRevolt,"起义军");
		//启动线程，开始
		armyOfDynasty.start();
		armyOfRevolt.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {  
			e.printStackTrace();
		}
		armyDynasty.keepRunning=false;
		armyRevolt.keepRunning=false;
		try {
			armyOfRevolt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------");
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("========================");
		armyRevolt.keepRunning=false;
		armyDynasty.keepRunning=false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mrCheng.start();
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*************************************");
		System.out.println("再见");
	}

	public static void main(String[] args) {
		new Stage().start();

	}

}
