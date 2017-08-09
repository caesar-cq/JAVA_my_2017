package common;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;

import domain.MoveConfig;
import domain.MoveData;
import domain.MoveObject;
import view.MotionObjectView;

public class Controller {
	private MotionObjectView view;
	private MoveObject motionObject;
	private Timer timer;  
	private CommonSlider slider1;
	private CommonSlider slider2;
	/*private MoveData data11 = new MoveData("水平",0,20,0,1);
	private MoveData data12 = new MoveData("垂直",0,20,0,1);
	private MoveData data21 = new MoveData("半径",0,500,150,1);
	private MoveData data22 = new MoveData("转速",0,20,0,400);*/
	
	private HashMap <String,MoveConfig> configMap  /*= new HashMap <String,MoveConfig>()*/;
	
	public Controller(MotionObjectView view){
		/*MoveConfig config = new MoveConfig();
		config.setName("小球");
		config.setClassname("domain.Ball");
		config.setMoveData(0, data11);
		config.setMoveData(1, data12);
		
		configMap.put("domain.Ball", config);
		
		config = new MoveConfig();
		config.setName("圆周");
		config.setClassname("domain.CircleMotion");
		config.setMoveData(0, data21);
		config.setMoveData(1, data22);
		
		configMap.put("domain.CircleMotion", config);*/
		
		this.view = view;
		timer = new Timer(50,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(motionObject != null )
					motionObject.move();
			}
		});
		timer.start();
		String filename = "bin//configsource//config.xml";
		initial(filename);
		
	}
	/*public void setMotionObject(MoveObject obj){
		this.motionObject = obj;
	}*/
	/*public HashMap <String,MoveConfig> initial(String filename){
		configMap = new HashMap <String,MoveConfig>();
		
		return configMap;
	}*/
	
	public void initial(String filename){
		ConfigReader reader = new ConfigReader(filename);
		configMap = reader.getMoveConfig();
		reader.cleanup();
	}
	public JPanel getSliderPane(){
		slider1 = new CommonSlider();
		slider2 = new CommonSlider();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.add(slider1);
		panel2.add(slider2);
		JPanel south = new JPanel(new GridLayout(2,1,1,1));
		south.add(panel1);
		south.add(panel2);
		slider1.setValueChangeHandler(new ValueChangeHandler(){
			@Override
			public void valueChanged(double value) {
				// TODO Auto-generated method stub
				motionObject.setAdelta(value);
				view.repaint();
			}
		});
		slider2.setValueChangeHandler(new ValueChangeHandler(){
			@Override
			public void valueChanged(double value) {
				// TODO Auto-generated method stub
				motionObject.setBdelta(value);
				view.repaint();
			}
		});
		slider1.setEnabled(false);
		slider2.setEnabled(false);
		return south;
	}
	
	public JPanel getListPane(){
		JPanel dragPane = new JPanel();
		initial("bin\\configsource\\config.xml");
		int size = configMap.size();
		MoveConfig[] configs = new MoveConfig[size];
		Iterator<MoveConfig> iter = configMap.values().iterator();
		for(int i = 0; iter.hasNext(); i++){
			configs[i] = iter.next();
			//System.out.println(configs[i].getName());
		}
		
	
		JList<MoveConfig> list = new JList<MoveConfig>(configs);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dragPane.add(list);
		return dragPane;
	}
	
	public JMenuBar getMenuBar(){
		JMenu menu = new JMenu("菜单");
		Iterator<MoveConfig> iter = configMap.values().iterator();
		while(iter.hasNext()){
			MoveConfig config = iter.next();
			JMenuItem item = new JMenuItem(config.getName());
			item.setActionCommand(config.getClassname());
			item.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try{
						String classname = item.getActionCommand();  
						motionObject = (MoveObject)Class.forName(classname).newInstance();  //根据类名全称将类的信息装入内存
						view.setMoveObject(motionObject);
						motionObject.setView(view);
						
						MoveConfig config = configMap.get(classname);
						if(config != null){
							MoveData[] datas = config.getMoveDatas();
							slider1.setCommonSlider(datas[0].getTitle(),datas[0].getMin(), datas[0].getMax(),(int)motionObject.getAdelta());
							slider2.setCommonSlider(datas[1].getTitle(),datas[1].getMin(), datas[1].getMax(),(int)motionObject.getBdelta());
							slider2.setRateFactory(datas[1].getRateFactor());
						}
						setSliderEnable(true);
						//view.repaint();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
			menu.add(item);
		}
		//
		//JMenuItem item1 = new JMenuItem("hhhh");
		//menu.add(item1);
		/*while(iter.hasNext()){
			MoveConfig config = iter.next();
			JMenuItem item = new JMenuItem(config.getName());
			item.setActionCommand(config.getClassname());
			menu.add(item);
		}*/
		JMenuItem item3 = new JMenuItem("退出");
		menu.add(new JSeparator());
		menu.add(item3);
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		item3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);			
			}
		});
		return bar;
	}
	private void setSliderEnable(boolean b){
		slider1.setEnabled(b);
		slider2.setEnabled(b);
	}
}