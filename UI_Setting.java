package com.timebeeper;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI_Setting {
	int seconds;
	int seconds2;
	int sets;
	int rest;

	public void setTime(int ss, int st, int rt){

		this.seconds = ss;
		this.seconds2 = ss;
		this.sets = st;
		this.rest = rt;
	}
	// labels and sounds needed to be added , take the conrols to time class
	public void ticking(){

		if (seconds <=0){
			if(sets <=0)
				System.out.println("finished");
			else if (sets > 0){
				this.seconds = seconds2;
				this.sets = -1;
			}
		}
		else this.seconds -= 1;
	}
	Timer t;
	UI_Setting(){

	JFrame frame= new JFrame("Working Out Time Beeper");
	JPanel panel = new JPanel();
	JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	JButton resumeButton = new JButton("Resume");
	JButton resetButton = new JButton("Reset");
	JButton timeButton = new JButton("SetTime");
	JSpinner setSeconds = new JSpinner();
	JSpinner setSets = new JSpinner();
	JSpinner setRest = new JSpinner();
	
	
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	Font basicFont = new Font("Apple Casual",Font.BOLD,120);
	label.setFont(basicFont);

	String str = String.format("%02d" , seconds);
	label.setText(str);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setContentPane(panel);

	panel.add(label);
	panel.add(startButton);
	panel.add(label1);
	panel.add(setSeconds);
	panel.add(label2);
	panel.add(setSets);
	panel.add(label3);
	panel.add(setRest);
	
	frame.setPreferredSize(new Dimension(350, 250));
	frame.setLocation(150, 200);
	
	frame.pack();
	frame.setVisible(true);

	t = new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(sets<=0 &&seconds<=0){
				e = null;
				System.out.println("working");
				t.stop();
				stopButton.setVisible(false);
				startButton.setVisible(true);
				label1.setVisible(true);
				setSeconds.setVisible(true);
				label2.setVisible(true);
				setSets.setVisible(true);
				label3.setVisible(true);
				setRest.setVisible(true);
			}
			else{
			ticking();
			System.out.println("tick-tok");
			String str1 = String.format("%02d",  seconds);
			label.setText(str1);
			System.out.println(seconds);}
			
		}


	});
	

	startButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			setTime( (int)setSeconds.getValue(), (int)setSets.getValue(), (int)setRest.getValue());
			String str1 = String.format("%02d", seconds);
			label.setText(str1);
			t.start();
			panel.add(stopButton);
			stopButton.setVisible(true);
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
			setTime( 0, 0, 0);
			String str1 = String.format("%02d", seconds);
			label.setText(str1);
			setSeconds.setVisible(true);
			setSets.setVisible(true);
			setRest.setVisible(true);
		}
	});

	Container contentPane = frame.getContentPane();
	contentPane.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
}
