package Library;

import net.LibClient;
import net.LibServer;

public class LibServStart {
	public static void main(String[]args){
		LibServer serv=new LibServer();
		serv.libServer();
		serv.run();
		//Implement in main when user logs in. 
		while(true){
		LibUser user=new LibUser("hi","hi",null,-1);
		net.packets.Packet00Login loginPacket = new net.packets.Packet00Login("hi","hi");
		if(serv!=null){
			serv.addConnection(user, loginPacket);
			
		}
		LibClient client=new LibClient();
		client.libClient();
		loginPacket.writeData(client);
		}
	}
}
