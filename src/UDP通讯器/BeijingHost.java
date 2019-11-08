package UDP通讯器;

public class BeijingHost {

	public static void main(String[] args) {
		UDPHost beijing = new UDPHost("北京", 2016, 2019);
		System.out.println(beijing.toString());
		
		while(true) {
			beijing.sendPacket();		
		}		
	}
}
