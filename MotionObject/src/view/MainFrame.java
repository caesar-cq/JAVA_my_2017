package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import common.Controller;


public class MainFrame extends JFrame {
	private MotionObjectView view;
	private Controller ctrl;
	public MainFrame(){
		 view = new MotionObjectView();
		ctrl = new Controller(view);
		this.setJMenuBar(ctrl.getMenuBar());
		this.getContentPane().add(view);
		this.getContentPane().add(ctrl.getSliderPane(), BorderLayout.SOUTH);
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	   /*	view = new MotionObjectView();
		ctrl = new Controller(view);
		//this.setJMenuBar(ctrl.getMenuBar());
		
		JPanel dataPanel = new JPanel();
		dataPanel.add(view,BorderLayout.CENTER);
		dataPanel.add(ctrl.getSliderPane(),BorderLayout.SOUTH);
		
		//this.getContentPane().add(view);
		//this.getContentPane().add(ctrl.getSliderPane(),BorderLayout.SOUTH);
		
		JSplitPane splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, ctrl.getListPane(), dataPanel);
		this.getContentPane().add(splitPane);
		
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}
}


