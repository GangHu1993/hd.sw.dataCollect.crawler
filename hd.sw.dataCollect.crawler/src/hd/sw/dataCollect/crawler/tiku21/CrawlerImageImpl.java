package hd.sw.dataCollect.crawler.tiku21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class CrawlerImageImpl implements CrawlerImageInterface{
	String urlString=null;
	String filename=null;
	String savePath=null;
	
	public CrawlerImageImpl(String urlString, String filename, String savePath){
		this.urlString = urlString;
		this.filename = filename;
		this.savePath =savePath;
	}
	
	public void getImage() {
		// ����URL
		URL url;
		try {
			url = new URL(urlString);
			// ������
			URLConnection con = url.openConnection();
			// ���������·��
			con.setConnectTimeout(5 * 1000);
			// ������
			InputStream is = con.getInputStream();
			// 1K�����ݻ���
			byte[] bs = new byte[1024];
			// ��ȡ�������ݳ���
			int len;
			// ������ļ���
			File sf = new File(savePath);
			if (!sf.exists()) {
				sf.mkdirs();
			}
			OutputStream os = new FileOutputStream(sf.getPath() + "\\"
					+ filename);
			// ��ʼ��ȡ
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// ��ϣ��ر���������
			os.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
