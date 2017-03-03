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
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	public void basicFrameAndLabel(){
	setLabelTime();
	label1.setText("Seconds");
	label2.setText("Sets");
	label3.setText("Rests");
	Font basicFont = new Font("Apple Casual",Font.BOLD,120);
	label.setFont(basicFont);

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setContentPane(panel);
	panel.add(label);
	panel.add(startButton);
	panel.add(label1);
	panel.add(setSpinnerSeconds);
	panel.add(label2);
	panel.add(setSpinnerSets);
	panel.add(label3);
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
				spinnerOnOff(true);
				labelOnOff(true);
			}
	public void setLabelTime(){
			String str1 = String.format("%02d",  seconds);
			label.setText(str1);
	}
	public void setLabelTimeRest(){
			String str2 = String.format("%02d",  rest);
			label.setText(str2);
			System.out.println("renewing rest time");
			
	}
	
	public void startButton(){
				panel.add(stopButton);
				stopButton.setVisible(true);
				startButton.setVisible(false);
				panel.add(resumeButton);
				resumeButton.setVisible(false);
				spinnerOnOff(false);
				labelOnOff(false);
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
				spinnerOnOff(true);
				labelOnOff(true);
				resetButton.setVisible(false);
				resumeButton.setVisible(false);
				startButton.setVisible(true);
	}
	public void labelOnOff(boolean a){
		label1.setVisible(a);
		label2.setVisible(a);
		label3.setVisible(a);
	}
	public void spinnerOnOff(boolean a){
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
