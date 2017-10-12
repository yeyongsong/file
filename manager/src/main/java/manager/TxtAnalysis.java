package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TxtAnalysis {

	public void getTxt(){
		String path = "C:\\Users\\Administrator\\Desktop\\test.txt";
		
		File file = new File(path);
		String str  = null;
		try {
			//读取文件
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			while((str=br.readLine())!=null){
				System.out.println("str======"+str);
				String[] split = str.split("、");
				System.out.println("split==="+Arrays.toString(split));
				System.out.println("split[0]==="+split[0].length()+"==="+split[0]);
				System.out.println("split[1]==="+split[1].length()+"==="+split[1]);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		
		TxtAnalysis tt = new TxtAnalysis();
		tt.getTxt();
		
	}

}
