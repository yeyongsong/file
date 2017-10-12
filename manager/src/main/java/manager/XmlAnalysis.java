package manager;
import java.io.File;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class XmlAnalysis {
	public static void main(String[] args) {	
		String path = "C:\\Users\\Administrator\\Desktop\\test.txt";
		File file = new File(path);
		SAXReader saxReader = new SAXReader();
		try {
			//读取文件，获得dom对象
			Document document = saxReader.read(file);
			//获取文档的根节点
			Element root = document.getRootElement();
			System.out.println("root===="+root.getName());
			//获取根节点下面的指定子节点result
			Element contactElem = root.element("result");
			System.out.println("contactElem===="+contactElem.getName());		
			//获得子节点下面的节点集合
			List<Element> elements = contactElem.elements("book");
			System.out.println(elements.size());
			for(Element e : elements){
				System.out.println("name======"+e.elementText("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
}
