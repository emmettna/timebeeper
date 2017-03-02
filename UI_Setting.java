package com.timebeeper;


import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.TimerTask;

import javax.swing.*;

public class UI_Setting {
	int minutes;
	int seconds;
	int seconds2;
	int sets;
	int rest;
	public class fefew{
		
	}
	
	public void setTime(int mm, int ss, int st, int rt){
		this.minutes = mm;
		this.seconds = ss;
		this.seconds2 = ss;
		this.sets = st;
		this.rest = rt;
	}
	
	public void ticking(){

		if (seconds <=0){
			if(sets <=0 && minutes <=0)
				System.out.println("finished");
			else if (sets > 0){
				this.seconds = seconds2;
				this.sets = -1;
			}
		}
		else this.seconds -= 1;
	}
	
	UI_Setting(){
		
	JFrame frame= new JFrame("Working Out Time Beeper");
	JPanel panel = new JPanel(new FlowLayout());
	JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	JButton resumeButton = new JButton("Resume");
	JButton resetButton = new JButton("Reset");
	JButton timeButton = new JButton("SetTime");
	JSpinner setSeconds = new JSpinner();
	JSpinner setSets = new JSpinner();
	JSpinner setRest = new JSpinner();
	
	
	JLabel label = new JLabel();
//	SimpleDateFormat adf = new SimpleDateFormat("HH:mm:ss");
//	label.setText(adf.format(new java.util.Date()));
	String str = String.format("%02d : %02d", minutes, seconds);
	label.setText(str);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setContentPane(panel);

	panel.add(label);
	panel.add(startButton);
//	panel.add(timeButton);
	panel.add(setSeconds);
	panel.add(setSets);
	panel.add(setRest);
	
	frame.setPreferredSize(new Dimension(350, 250));
	frame.setLocation(150, 200);
	
	frame.pack();
	frame.setVisible(true);

	Timer t = new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(sets<=0 &&seconds<=0){
				e = null;
				System.out.println("working");
			}
			else{
			ticking();
			System.out.println("tick-tok");
			String str1 = String.format("%02d : %02d", minutes, seconds);
			label.setText(str1);
			System.out.println(seconds);}
			
		}
	});

	
			
			
//	Timer t = new Timer(1000,new ActionListener() {
//		public void actionPerformed(ActionEvent e){
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		label.setText(sdf.format(new java.util.Date()));
//}	
//});	
	
	
	
	
	//spinner time setting button disabled for now :)
//	timeButton.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			setTime(0, (int)spinner.getValue());
//			String str1 = String.format("%02d : %02d",minutes, seconds);
//			label.setText(str1);
//			
//		}
//	});
	startButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			setTime(0, (int)setSeconds.getValue(), (int)setSets.getValue(), (int)setRest.getValue());
			String str1 = String.format("%02d : %02d",minutes, seconds);
			label.setText(str1);
			t.start();
			panel.add(stopButton);
			startButton.setVisible(false);
			panel.add(resumeButton);
			resumeButton.setVisible(false);
			setSeconds.setVisible(false);
			setSets.setVisible(false);
			setRest.setVisible(false);
			panel.add(resetButton);
			resetButton.setVisible(false);
		}
	} );
			
	stopButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			t.stop();
			stopButton.setVisible(false);
			resumeButton.setVisible(true);
			resetButton.setVisible(true);
		}
	});

	resumeButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			t.start();
			stopButton.setVisible(true);
			resumeButton.setVisible(false);
			resetButton.setVisible(false);
		}
	});
	resetButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setTime(0, 0, 0, 0);
			String str1 = String.format("%02d : %02d",minutes, seconds);
			label.setText(str1);
			setSeconds.setVisible(true);
			setSets.setVisible(true);
			setRest.setVisible(true);
		}
	});

	

	Container contentPane = frame.getContentPane();
	contentPane.setLayout(new FlowLayout());
	}

}
