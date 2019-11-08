package UDP通讯器;

public class ShanghaiHost {

	public static void main(String[] args) {
		UDPHost shanghai = new UDPHost("上海", 2019, 2016);
		System.out.println(shanghai.toString());
		
		while(true) {			
			shanghai.sendPacket();			
		}
	
	}
}
