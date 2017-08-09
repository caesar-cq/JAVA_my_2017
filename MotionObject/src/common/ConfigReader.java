package common;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.MoveConfig;
import domain.MoveData;

public class ConfigReader {
	private Element root;
	public ConfigReader(String filename){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(filename);
			root = doc.getDocumentElement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected String getValue(Element parent,String tagName){
		NodeList list = parent.getElementsByTagName(tagName);
		Element element = (Element)list.item(0);
		//NodeList list1 = element.getChildNodes();    //获取全部子节点
		Node node = element.getChildNodes().item(0);
		if(node.getNodeType() == Node.TEXT_NODE)
			return node.getNodeValue();
		return null; 
	}
	
	public HashMap<String,MoveConfig> getMoveConfig(){
		
		HashMap<String,MoveConfig> configs = new HashMap<String,MoveConfig>();
		
		NodeList list = root.getElementsByTagName("Config");
		for(int i = 0 ; i < list.getLength() ; i++){
			Element element = (Element)list.item(i);
			String name = getValue(element, "Name");
			String classname = getValue(element,"ClassName");
			MoveConfig config = new MoveConfig();
			config.setName(name);
			config.setClassname(classname);
			NodeList sliders = element.getElementsByTagName("Sliders");
			Element sliderEle = (Element) sliders.item(0);
			
			NodeList sliderList = sliderEle.getElementsByTagName("Slider");
			for(int k = 0 ; k < sliderList.getLength() ; k++){
				Element parent = (Element)sliderList.item(k);
				String title = getValue(parent,"Title");
				String min = getValue(parent,"Min");
				String max = getValue(parent,"Max");
				String cur = getValue(parent,"Cur");
				String rateFactor = getValue(parent,"RateFactor");
				
				MoveData data = new MoveData(title,Integer.parseInt(min),Integer.parseInt(max),Integer.parseInt(cur),Double.parseDouble(rateFactor));
				config.setMoveData(k, data);
			}
			configs.put(classname, config);
		}
		return configs;
	}
	
	public void cleanup(){
		root = null;
	}
}
