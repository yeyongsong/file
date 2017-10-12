package manager;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlAnalysis2 {

	 public static void main(String[] args) {
	        // 创建SAXReader的对象reader
	        SAXReader reader = new SAXReader();
	        try {
	        	String path = "C:\\Users\\Administrator\\Desktop\\test.txt";
	            // 通过reader对象的read方法获取xml文件,docuemnt对象。
	            Document document = reader.read(new File(path));
	            // 通过document对象获取根节点
	            Element root = document.getRootElement();
	            Element contactElem = root.element("result");
	            // 循环解析
	            readEle(contactElem);
	            } catch (DocumentException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	    public static void readEle(Element e){
	        //判断是否有复合内容
	        if(e.hasMixedContent()){
	            //输出该节点的名字，对他的子节点继续进行判断
	            System.out.println("节点名：" + e.getName());
	            Iterator it = e.elementIterator();
	            while (it.hasNext()) {
	                Element arrrName = (Element) it.next();
	                //递归
	                readEle(arrrName);
	            }
	        }else{
	            //如果没有复合内容，就可以输出了
	            System.out.println("节点名：" + e.getName() + "，节点值：" + e.getTextTrim());
	        }
	    }

}
