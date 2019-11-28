import java.net.*;
import java.io.*;

public class WebPageReader {

	public static void main(String[] args) {		
		try{
			int n=-1;
			URL url=new URL("https://www.pintia.cn/");   
			   
			byte[] b = new byte[112];
			StringBuffer area = new StringBuffer();
			InputStream doinb = url.openStream();   //in为输入流，指向URL对象所包含的资源。
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
