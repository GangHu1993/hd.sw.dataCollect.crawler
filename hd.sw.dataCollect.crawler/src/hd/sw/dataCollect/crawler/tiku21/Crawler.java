package hd.sw.dataCollect.crawler.tiku21;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

import com.google.common.io.Files;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<����-��Ŀ > 21�������
* Module:����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-11>                                         
* Version:0.1
* Comments:ʵ����ȡ��
*/ 

public class Crawler extends WebCrawler{
		private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");
		
		public boolean shouldVisit(Page referringPage, WebURL url) {
			String href = url.getURL().toLowerCase();
			return !FILTERS.matcher(href).matches()&&href.startsWith("http://tiku.21cnjy.com/");
		}

		/**
		 * This function is called when a page is fetched and ready to be processed
		 * by your program.
		 */
		public void visit(Page page) {
			synchronized(this){
			String url = page.getWebURL().getURL();
			//System.out.println(url);
			if(url.endsWith(".html")&&url.startsWith("http://tiku.21cnjy.com/quest/")){
System.out.println(url);
				if (page.getParseData() instanceof HtmlParseData) {
					HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
					String html = htmlParseData.getHtml();
					//ContentFilter cf = new ContentFilter(html);//��ҳ���ݹ���
					Filter ft = new Filter();
					//Metadata md = new Metadata(cf.getTitle(),cf.getDescription(),url);//���ݿ����Ԫ��
					Metadata md = new Metadata(ft.getTitle(html),ft.getDescription(html),url);//���ݿ����Ԫ��
				
					FileOperateImpl fp =new FileOperateImpl("G:\\1");
					fp.htmlFileWrite(page);//��html�ļ�
					
					//cf.getContent();
					CrawlerImageImpl cIma;
System.out.println("getContent()");	
//					if(cf.getImage(re).size()>0){//��ȡ��ӦͼƬ
//System.out.println("image");						
//						for(int i=0;i<cf.getImage(re).size();i++){
//							 cIma= new CrawlerImage(cf.getImage(re).get(i),"image"+i+".jpg",fp.getFilePath()+"/image");
//							 cIma.getImage();
//						}
//					}
//if(ft.getImage(ft.getContent(html)).size()==10){//��ȡ��ӦͼƬ
//System.out.println("image");
//ArrayList<String> iUtl =ft.getImage(ft.getContent(html));
//	for(int i=0;i<iUtl.size();i++){
//		 cIma= new CrawlerImage(iUtl.get(i),"image"+i+".jpg",fp.getFilePath()+"/image");
//		 cIma.getImage();
//	}
//}
					//fp.contentWrite(cf.deleteHtml());//��txt�ļ�
					fp.contentWrite(ft.deleteHtml(ft.getContent(html)));//��txt�ļ�
System.out.println("contentwrite");
					DatabaseOperateImpl daop = new DatabaseOperateImpl();
					daop.insert(md);
					}
			}
//			
//			
//			
			
//			if(url.endsWith(".html")){
//			String html=null;
//			System.out.println("URL: " + url);
//
//			if (page.getParseData() instanceof HtmlParseData) {
//				HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
//			//	String text = htmlParseData.getText();
//			//	html = htmlParseData.getHtml();
//				//Set<WebURL> links = htmlParseData.getOutgoingUrls();
//
//				//System.out.println("Text length: " + text.length());
//				//System.out.println("Html length: " + html.length());
//				//System.out.println("Number of outgoing links: " + links.size());
//				System.out.println("Html:" + html);
//				File storageFolder=new File("G:\\1");
//				String filename = storageFolder.getAbsolutePath() + "/" + "url.txt";
//				try {
//					Files.write(page.getContentData(), new File(filename));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		}}
	}

