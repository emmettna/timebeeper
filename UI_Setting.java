package com.timebeeper;


import java.awt.*;
import javax.swing.*;

public class UI_Setting {
	private int seconds;
	private int rest;
	
	JFrame frame= new JFrame("Working Out Time Beeper");
	JPanel panel = new JPanel();
	JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	JButton resumeButton = new JButton("Resume");
	JButton resetButton = new JButton("Reset");
	JSpinner setSpinnerSeconds = new JSpinner();
	JSpinner setSpinnerSets = new JSpinner();
	JSpinner setSpinnerRest = new JSpinner();
	JLabel time_label = new JLabel();
	JLabel seconds_label = new JLabel();
	JLabel sets_label = new JLabel();
	JLabel rest_label = new JLabel();
	
	public void basicFrameAndLabel(){
		setLabelTime();
		seconds_label.setText("Seconds");
		sets_label.setText("Sets");
		rest_label.setText("Rests");
		Font basicFont = new Font("Apple Casual",Font.BOLD,120);
		time_label.setFont(basicFont);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		panel.add(time_label);
		panel.add(startButton);
		panel.add(seconds_label);
		panel.add(setSpinnerSeconds);
		panel.add(sets_label);
		panel.add(setSpinnerSets);
		panel.add(rest_label);
		panel.add(setSpinnerRest);
		
		frame.setPreferredSize(new Dimension(350, 400));
		frame.setLocation(150, 200);
		frame.pack();
		frame.setVisible(true);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	public void timerInit(){
				stopButton.setVisible(false);
				startButton.setVisible(true);
				labelandSpinnerOnOff(true);
	}
	public void setLabelTime(){
				String str1 = String.format("%02d",  seconds);
				time_label.setText(str1);
	}
	public void setLabelTimeRest(){
				String str2 = String.format("%02d",  rest);
				time_label.setText(str2);
	}
	public void startButton(){
				panel.add(stopButton);
				stopButton.setVisible(true);
				startButton.setVisible(false);
				panel.add(resumeButton);
				resumeButton.setVisible(false);
				labelandSpinnerOnOff(false);
				panel.add(resetButton);
				resetButton.setVisible(false);
	}
	public void stopButton(){
				stopButton.setVisible(false);
				resumeButton.setVisible(true);
				resetButton.setVisible(true);
	}
	public void resumeButton(){
				stopButton.setVisible(true);
				resumeButton.setVisible(false);
				resetButton.setVisible(false);
	}
	public void resetButton(){
				setLabelTime();
				labelandSpinnerOnOff(true);
				resetButton.setVisible(false);
				resumeButton.setVisible(false);
				startButton.setVisible(true);
	}
	public void labelandSpinnerOnOff(boolean a){
				seconds_label.setVisible(a);
				sets_label.setVisible(a);
				rest_label.setVisible(a);
				setSpinnerSeconds.setVisible(a);
				setSpinnerSets.setVisible(a);
				setSpinnerRest.setVisible(a);
	}

	public void setSeconds(int seconds) {
				this.seconds = seconds;
	}
	public void setRets(int rest) {
				this.rest = rest;
	}
}
