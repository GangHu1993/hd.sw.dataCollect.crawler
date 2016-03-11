package hd.sw.dataCollect.crawler.tiku21;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.common.io.Files;

import edu.uci.ics.crawler4j.crawler.Page;
/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:文件操作。
*/ 
public class FileOperateImpl implements FileOperateInterface{
	private String filePath = null;

	static int counter;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public FileOperateImpl(String filePath) {
		this.filePath = filePath;
	}

	public void htmlFileWrite(Page page) {
		File storageFolder = new File(filePath);

		if (!storageFolder.exists()) {
			storageFolder.mkdirs();
		}
		storageFolder = new File(filePath + "/" + counter);
		filePath = filePath + "/" + counter;
		if (!storageFolder.exists()) {
			storageFolder.mkdirs();
		}

		String filename = storageFolder.getAbsolutePath() + "/"
				+ storageFolder.listFiles().length + ".html";
		try {
			Files.write(page.getContentData(), new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		storageFolder = null;
		filename = null;
		counter++;
	}

	public void contentWrite(String content) {

		File storageFolder = new File(filePath);

		if (!storageFolder.exists()) {
			storageFolder.mkdirs();
		}
		
		storageFolder = new File(filePath);
		if (!storageFolder.exists()) {
			storageFolder.mkdirs();
		}
		String filename = storageFolder.getAbsolutePath() + "/"
				+ storageFolder.listFiles().length + ".txt";
		File saveFile = new File(filename);

		if (!saveFile.exists()) {
			try {
				saveFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			BufferedWriter TxtWriter = new BufferedWriter(new FileWriter(
					filename));
			TxtWriter.write(content);
			TxtWriter.flush();
			TxtWriter.close();
			TxtWriter = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("IO Exception");
		}
		saveFile = null;
		storageFolder = null;
	}
}
