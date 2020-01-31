package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ImmediateRefreshHandler;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class �׶�֮�� {
	static List<String> lines_zi=new ArrayList<String>();
	static List<String> lines_jian=new ArrayList<String>();
	static List<String> lines_tou=new ArrayList<String>();
	
	static String line;
	public static void Value_start()
	{
		// TODO �Զ����ɵķ������
WebClient webClient=new WebClient(BrowserVersion.CHROME); // ʵ����Web�ͻ��� 
        

        try {
        	webClient.getOptions().setActiveXNative(false);
        	//webClient.getOptions().setCssEnabled(false);
        	//webClient.getOptions().setRedirectEnabled(true);
        	webClient.getOptions().setJavaScriptEnabled(true);
        	webClient.getOptions().setDoNotTrackEnabled(true);
        	webClient.getOptions().setThrowExceptionOnScriptError(false);
        	webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        	webClient.getCache().setMaxSize(100);
        	webClient.getOptions().setJavaScriptEnabled(true);//����js�ű�ִ��
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());//����֧��AJAX
            webClient.getOptions().setCssEnabled(false);//����css
            webClient.getOptions().setUseInsecureSSL(true);//ssl��ȫ����
            webClient.getOptions().setThrowExceptionOnScriptError(false);  //����js����ʱ�����쳣
            //webClient.getOptions().setTimeout(50000);  //��ʱʱ��  ms
            webClient.getCookieManager().setCookiesEnabled(true);
            webClient.getCache().clear();
	        webClient.setRefreshHandler(new ImmediateRefreshHandler());
	        webClient.getOptions().setTimeout(2*1000);	//��ҳ����ms��ʱ��Ӧ
	        webClient.setJavaScriptTimeout(600*1000);   //javaScript����ms��ʱ
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());  
	        //webClient.setJavaScriptTimeout(600*1000);   
	        //webClient.getOptions().setRedirectEnabled(true); 
	        webClient.waitForBackgroundJavaScript(60*1000);
	        
	        HtmlPage page=webClient.getPage("http://www.beijing.gov.cn/hudong/hdjl/com.web.search.mailList.flow"); // ������ȡҳ��
	        HtmlElement a=page.getElementByName("nextPage");
	        int j=1,lastj=0;
	        FileHandle fh=new FileHandle();
	        StringHandle sh=new StringHandle();
	        List<String> lastInfo_zi=new ArrayList<String>();
	        List<String> lastInfo_jian=new ArrayList<String>();
	        List<String> lastInfo_tou=new ArrayList<String>();
	        fh.outFile(""+"\r\n", "E:\\578095023\\FileRecv\\������ҵ\\����������ҵ\\�������������ż�����ʵս\\����.txt", false);
	       
	        while(j!=314)
	        {
	        	
	        	String nowInfo=page.asXml();
	        	//System.out.println(ia);
	        	List<String> infoList_zi=sh.getExpString("letterdetail\\('.*?','.*?'\\)", nowInfo);
	        	int g_size_zi=infoList_zi.size();
	        	if(sh.StringListSameOutStringList(infoList_zi, lastInfo_zi).size()!=g_size_zi&&g_size_zi==7)
	        	{
	        		//System.out.println(g_size);
		        	for(int i=0;i<g_size_zi;i++)
		        	{
		        		String theWeb=infoList_zi.get(i).replaceAll("letterdetail\\('.*?','", "").replace("')", "");
		        		System.out.println(theWeb);
		        		lines_zi.add(theWeb);
		        		fh.outFile(theWeb+"\r\n", "E:\\578095023\\FileRecv\\������ҵ\\����������ҵ\\�������������ż�����ʵս\\����.txt", true);
		        		
		        		if(i==g_size_zi-1)
		        		{
		        			lastInfo_zi=infoList_zi;
		        			System.out.println(j);
		        			j++;
		        			break;
		        		}
		        			 
		        	}
		            page=a.click();
	        	}
	        	//page=a.click();
	        }
	        
	        
        }catch (FailingHttpStatusCodeException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            webClient.close(); // �رտͻ��ˣ��ͷ��ڴ�
        }
    
	}
	public static void main(String[] args) {
		Value_start();
	}

}


