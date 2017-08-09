package common;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CommonSlider extends JPanel {
	private JLabel label;
	private JSlider slider;
	private JTextField field;
	private double rateFactory = 1.0;
	
	private ValueChangeHandler handler;
	public CommonSlider(){
		this("", 0, 100, 0);
	}
	public CommonSlider(String title, int min, int max, int cur){
		this.setLayout(new GridLayout(1,1));
		Box box = Box.createHorizontalBox();
		label = new JLabel(title);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		slider = new JSlider(min, max, cur);
		field = new JTextField(String.valueOf(cur), 8);
		
		box.add(label);
		box.add(Box.createHorizontalStrut(5));
		box.add(slider);
		box.add(Box.createHorizontalStrut(5));
		box.add(field);
		
		add(box);
		
		slider.addChangeListener(
			new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int value = slider.getValue();
					consistency(value);
				}
				
			});
		field.addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String s = field.getText();
					if(s != null && !s.equals("")){
						int value = Integer.parseInt(s);
						consistency(value);
					}	
				}
			});
	}
	
	public void setCommonSlider(String title, int min, int max, int cur){
		label.setText(title);
		slider.setMinimum(min);
		slider.setMaximum(max);
		slider.setValue(cur);
	}
	private void consistency(int v){
		slider.setValue(v);
		int value = slider.getValue();
		field.setText(value + "");
		
		if(handler != null){
			handler.valueChanged(value / rateFactory);
		}
		
	}
	
	public void setEnabled(boolean b){
		slider.setEnabled(b);
		field.setEnabled(b);
	}
	public double getRateFactory() {
		return rateFactory;
	}

	public void setRateFactory(double rateFactory) {
		this.rateFactory = rateFactory;
	}

	public void setValueChangeHandler(ValueChangeHandler handler){
		this.handler = handler;
	}
	
	public void setCurrentValue(double value){
		int v = (int)(rateFactory * value);
		slider.setValue(v);
		field.setText(slider.getValue() + "");
	}
	public double getCurrentValue(){
		return slider.getValue() / rateFactory;
	}
}
