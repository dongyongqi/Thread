package com.imooc.concurrent;
//军队线程
//模拟作战双方行为

public class ArmyRunnable implements Runnable {
	//volatile保证了线程可以正确的读取其他线程的值
	 volatile boolean keepRunning=true;
	@Override
	public void run() {
		while (keepRunning) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"进攻对方【"+i+"】");
				//让出处理器时间，下次进攻还不一定是谁呢
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束了战争！");

	}

}
