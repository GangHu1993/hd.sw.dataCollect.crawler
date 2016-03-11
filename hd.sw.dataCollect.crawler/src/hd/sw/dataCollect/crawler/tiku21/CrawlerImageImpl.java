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
		// 构造URL
		URL url;
		try {
			url = new URL(urlString);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求的路径
			con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			File sf = new File(savePath);
			if (!sf.exists()) {
				sf.mkdirs();
			}
			OutputStream os = new FileOutputStream(sf.getPath() + "\\"
					+ filename);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
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
