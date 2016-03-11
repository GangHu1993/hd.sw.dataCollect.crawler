package hd.sw.dataCollect.crawler.tiku21;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:网页内容过滤。
*/ 

public class ContentFilterImpl implements ContentFilterInterface{
	String html;
	String res=null;
	String title=null;
	String description =null;
	String image=null;
	ArrayList<String> imageUrl =null;
	
	int begin;
	int end;
	public ContentFilterImpl(String html){
		this.html =html;
	}
	
	public String getTitle(){
		begin = html.indexOf("<title>");
		end = html.indexOf("</title>");
		title = html.substring(begin, end);
		title = title.replaceAll("<title>", "");
		return title;
	}
	
	public String getDescription(){
		begin = html.indexOf("<meta name=\"description\" content=\",");
		end = html.indexOf("\" />",begin);
		description = html.substring(begin, end);
		description = description.replaceAll("<meta name=\"description\" content=\",", "");
		return description;
	}
	
	public String getContent(){
		int begin = html.indexOf("<div class=\"answer_detail\">");
		int end = html.indexOf("<div class=\"test_suggest\">");
		res = html.substring(begin, end);//res 是题内容
		return res;	
	}
	
	public ArrayList<String> getImage(String re){
		while(re.contains("<img src=\"")){
			int begin = re.indexOf("<img src=\"");
			int end = re.indexOf("\"",begin);
			image = re.substring(begin, end);
			imageUrl.add(image.substring(begin, end));
			image.replaceFirst("<img src=\"", "");
		}
		
		return imageUrl;	
	}
	
	public String deleteHtml(){
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(res); 
        res=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(res); 
        res=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(res); 
        res=m_html.replaceAll(""); //过滤html标签
        
        res = res.replaceAll("&nbsp","");
        
        return res;
	}
}
