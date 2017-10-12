package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class DownFile {
	/**
	 * ���Ǿ�ֱ���������������ļ�����ֻ��Ҫ�Ĳ���

1.�����ļ�ContentType����

2.�����ļ�ͷ

3.ͨ��response��ȡServletOutputStream����(out)

4.д�������(out)��
	 * @param path
	 * @param response
	 * @return
	 */
	public HttpServletResponse download(String path, HttpServletResponse response) {
		try {
			// path��ָ�����ص��ļ���·����
			File file = new File(path);
			// ȡ���ļ�����
			String filename = file.getName();
			// ȡ���ļ��ĺ�׺����
			String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

			// ��������ʽ�����ļ���
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// ���response
			response.reset();
			// ����response��Header
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public void downloadLocal(HttpServletResponse response) throws FileNotFoundException {
		// ���ر����ļ�
		String fileName = "Operator.doc".toString(); // �ļ���Ĭ�ϱ�����
		// ��������
		InputStream inStream = new FileInputStream("c:/Operator.doc");// �ļ��Ĵ��·��
		// ��������ĸ�ʽ
		response.reset();
		response.setContentType("bin");
		response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		// ѭ��ȡ�����е�����
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void downloadNet(HttpServletResponse response) throws MalformedURLException {
		// ���������ļ�
		int bytesum = 0;
		int byteread = 0;

		URL url = new URL("windine.blogdriver.com/logo.gif");

		try {
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream("c:/abc.gif");

			byte[] buffer = new byte[1204];
			int length;
			while ((byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread;
				System.out.println(bytesum);
				fs.write(buffer, 0, byteread);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

	}
}
