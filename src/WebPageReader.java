import java.net.*;
import java.io.*;

public class WebPageReader {

	public static void main(String[] args) {		
		try{
			int n=-1;
			URL url=new URL("https://www.baidu.com/");   
			   
			byte[] b = new byte[112];
			StringBuffer area = new StringBuffer();
			InputStream in = url.openStream();   //inΪ��������ָ��URL��������������Դ��
			while((n=in.read(b))!= -1){
			      String s= new String(b, 0, n);
			      area.append(s+"\r\n");  			      
			}
			System.out.println(area.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
