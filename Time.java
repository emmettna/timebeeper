package com.timebeeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Time {
	UI_Setting ui = new UI_Setting();
	Timer t;
	private int seconds;
	private int sets;
	private int rest;

	private void setUI_Time(){
		ui.setSeconds(seconds);
		ui.setRets(rest);
	}
	private void setTime(int ss, int st, int rt){
		this.seconds = ss;
		this.sets = st;
		this.rest = rt;
		setUI_Time();
	}
	private void ticking(){
			this.seconds -= 1;
			setUI_Time();
			ui.setLabelTime();
			System.out.println("doing the job");
	}
	public void timer_Init(){
		ui.basicFrameAndLabel();
		t = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seconds<=0 && sets<=0){
					System.out.println("Finished Well Done buddy!");
					t.stop();
					ui.timerInit();
					ui.setLabelTime();
				}
				else if(seconds <= 0){
						if(rest <= 0){
							sets -= 1;
							seconds = (int) ui.setSpinnerSeconds.getValue();
							rest = (int)ui.setSpinnerRest.getValue();
							ticking();
							}
						else{
							rest -= 1;
							ui.setLabelTimeRest();
							setUI_Time();
							}
						}
					else {
						ticking();
						}
				}
			});
		}
	public void start(){
		ui.startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTime( (int)ui.setSpinnerSeconds.getValue(), (int)ui.setSpinnerSets.getValue(), (int)ui.setSpinnerRest.getValue());
				t.start();
				ui.setLabelTime();
				ui.startButton();
				}	
			});
		}
	public void stop(){
		ui.stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stop();
				ui.stopButton();
			}
		});
		}
	public void resume(){
		ui.resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.start();
				ui.resumeButton();
			}
		});
	}
	public void reset(){
		ui.resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTime(0, 0, 0);
				ui.resetButton();
				ui.setLabelTime();
			}
		});
	}
}
