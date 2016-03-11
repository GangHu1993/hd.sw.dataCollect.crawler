package hd.sw.dataCollect.crawler.tiku21;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:控制爬虫相关参数。
*/ 

public class Controller {
	public void run(){
		  String crawlStorageFolder = "/data/crawl/root";
	        int numberOfCrawlers = 7;

	        CrawlConfig config = new CrawlConfig();
	        config.setCrawlStorageFolder(crawlStorageFolder);
	        config.setResumableCrawling(true);

	        /*
	         * Instantiate the controller for this crawl.
	         */
	        PageFetcher pageFetcher = new PageFetcher(config);
	        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
	        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	        CrawlController controller;
			try {
				controller = new CrawlController(config, pageFetcher, robotstxtServer);
				//controller.addSeed("http://tiku.21cnjy.com/quest/MTM2A__QMTxM.html");
				controller.addSeed("http://tiku.21cnjy.com/quest/MTMyE__AMj4O.html");
				 controller.addSeed("http://tiku.21cnjy.com/quest/AjN3U__wMT5N.html");
//			        controller.addSeed("http://www.ics.uci.edu/~welling/");
//			        controller.addSeed("http://www.ics.uci.edu/");

				/*
				 * Start the crawl. This is a blocking operation, meaning that your code
				 * will reach the line after this only when crawling is finished.
				 */
				controller.start(Crawler.class, numberOfCrawlers);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
}
