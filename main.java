package com.timebeeper;

public class main {
	
	public static void main(String[] args)   {
		Time timebeeper = new Time();
		timebeeper.timer_Init();
		timebeeper.start();
		timebeeper.stop();
		timebeeper.resume();
		timebeeper.reset();
	}
}
