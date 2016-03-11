package hd.sw.dataCollect.crawler.tiku21;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
	String content=null;
	String title=null;
	String description =null;
	String image=null;
	String deleteHtml=null;
	ArrayList<String> imageUrl =null;
	
	int begin;
	int end;
	
	public String getTitle(String html){
		begin = html.indexOf("<title>");
		end = html.indexOf("</title>");
		title = html.substring(begin, end);
		title = title.replaceAll("<title>", "");
		return title;
	}
	
	public String getDescription(String html){
		begin = html.indexOf("<meta name=\"description\" content=\",");
		end = html.indexOf("\" />",begin);
		description = html.substring(begin, end);
		description = description.replaceAll("<meta name=\"description\" content=\",", "");
		return description;
	}
	
	public String getContent(String html){
		int begin = html.indexOf("<div class=\"answer_detail\">");
		int end = html.indexOf("<div class=\"test_suggest\">");
		content = html.substring(begin, end);//res ��������
		return content;	
	}
	
	public ArrayList<String> getImage(String imContent){
		while(imContent.contains("<img src=\"")){
			begin = imContent.indexOf("<img src=\"");
			end = imContent.indexOf("\"",begin);
			image = imContent.substring(begin, end);
			imageUrl.add(image.substring(begin, end));
			image.replaceFirst("<img src=\"", "");
		}
		
		return imageUrl;	
	}
	
	public String deleteHtml(String res){
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //����script��������ʽ 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //����style��������ʽ 
        String regEx_html="<[^>]+>"; //����HTML��ǩ��������ʽ 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(res); 
        res=m_script.replaceAll(""); //����script��ǩ 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(res); 
        res=m_style.replaceAll(""); //����style��ǩ 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(res); 
        deleteHtml=m_html.replaceAll(""); //����html��ǩ
        
        deleteHtml = deleteHtml.replaceAll("&nbsp","");
        
        return deleteHtml;
	}
}
