package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import net.packets.Packet;
import net.packets.Packet.PacketTypes;
import net.packets.Packet00Login;
import net.packets.Packet01Disconnect;
import net.packets.Packet02AddBook;
import net.packets.Packet03AddUser;
import net.packets.Packet04LoginInfoUser;
import net.packets.Packet05BookInfo;
import net.packets.Packet06ReserveItem;
import net.packets.Packet07AddAdmin;
import net.packets.Packet10LoginAdmin;
import net.packets.Packet11AcceptedAdmin;
import net.packets.Packet12Accepted;
import net.packets.Packet14EditBook;
import net.packets.Packet15CheckinBook;
import net.packets.Packet16CheckoutBook;
import net.packets.Packet17DeleteAdmin;
import net.packets.Packet20AdminAlreadyExists;
import net.packets.Packet21AdminNotExists;
import net.packets.Packet22BookAlreadyExists;
import net.packets.Packet23BookNotExists;
import net.packets.Packet24UserAlreadyExists;
import net.packets.Packet25UserNotExists;
import net.packets.Packet33BookChange;

import org.apache.commons.codec.binary.Base64;

import Library.Book;
import Library.LibAdmin;
import Library.LibUser;
import Library.Users;

/*
 * Have a refresh method which updates all users OR books to people after a change
 * Might have one for users and a diff one for books 
 * 
 * Have LibUser and LibAdmin
 * Both extend User
 * 
 * Send packt once logout button is clicked or force quit. Detect forcequit. 
 * 
 * Broadcast all changes to all ppl. 
 * 
 * When admin is deleted make sure admin isnt logged in
 * 
 * when admin makes new admin. new admin cant be logged into and otehr admins on server cant be accessed
 * password isnt getting decrypted
 */
@SuppressWarnings("deprecation")
public class LibServer extends Thread{
	public int port=5609;
	public boolean debug=false;
	private DatagramSocket serverSocket;
	private ArrayList<LibUser> connectedClients=new ArrayList<LibUser>();
	private ArrayList<LibAdmin> connectedAdmins=new ArrayList<LibAdmin>();
	private static byte[] key = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65,
        0x79 };

	public void libServer(){
		 try {
			this.serverSocket = new DatagramSocket(port);
			if(debug){
				final Thread printBooks = new Thread(){
					@Override
					public void run(){
						for(;;){
							System.out.println("Admin Usernames: " + Users.admins);
						 	System.out.println("Admin Passwords: " + Users.adminPasswords);
						 	System.out.println("Book Names: " + Book.libraryBooks);
						 	System.out.println("Book IDs: " + Book.id);
						 	System.out.println("User Names: " + Users.usernames);
						 	System.out.println("User Passwords: " + Users.passwords);
						}
					}
				};
				printBooks.start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		while (true) {
	            byte[] data = new byte[1024];
	            DatagramPacket packet = new DatagramPacket(data, data.length);
	            try {
					serverSocket.receive(packet);
	            } catch (Exception e) {
	                //e.printStackTrace();
	                break;
	            }
	            this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
	        }
	}
	private void parsePacket(byte[] data, InetAddress address, int port) {
	 String message = new String(data).trim();
		 
		 byte[]dt = null;
		 try {
			dt=decryptByteArray(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 String msg=new String(dt).trim();
	        PacketTypes type = Packet.lookupPacket(msg.substring(0, 2));
	        Packet packet = null;
	        switch (type) {
	        default:
	        case INVALID:
	            break;
	        case LOGINUSER:
	            packet = new Packet00Login(dt);
	            System.out.println("[" + address.getHostAddress() + ":" + port + "] "
	                    + ((Packet00Login) packet).getUsername() + " has connected...");
	           LibUser player = new LibUser(((Packet00Login) packet).getUsername(), ((Packet00Login) packet).getPassword(), address, port);
	           this.addConnection(player, (Packet00Login) packet);
	           int indexForUser = -1;
	           if(Users.usernames.contains(((Packet00Login) packet).getUsername())){
	        	   indexForUser=Users.usernames.indexOf(((Packet00Login) packet).getUsername());
	        	   if(Users.passwords.indexOf(((Packet00Login) packet).getPassword())==indexForUser){
	        		   Packet12Accepted packetAccepted=new Packet12Accepted(indexForUser);
	        		   sendData(packetAccepted.getData(),address,port);
	        		   //also send back user's dt etc. books name and age
	        		   
	        	   }else{
	        		//send not acccepted packet id:101   
	        	   }
	           }else{
	        	   //send not found packet idk
	           }
	           
	           //do this once program starts during splash screen or something
	           if(Library.Book.libraryBooks.size()!=0){
	        	   for(int bookNumber=0;bookNumber<Library.Book.libraryBooks.size();bookNumber++){
	        	   		String title=Library.Book.libraryBooks.get(bookNumber);
	        	   		int index=Library.Book.libraryBooks.indexOf(title);
	        	   		Packet05BookInfo p5=new Packet05BookInfo(title, Library.Book.authors.get(index), Library.Book.publishers.get(index), Library.Book.publicationYears.get(index),
	        			   	Library.Book.id.get(index), Library.Book.gradeLevels.get(index), Library.Book.genre.get(index),Library.Book.numberAvailable.get(index), Library.Book.condition.get(index));
	           			sendData(p5.getData(),address,port);
	           			//p5.writedt(this); Might do this and have to change the others
	           		}
	           }
	           if(!Users.reserves.isEmpty()){
	        	   for(int reserveListNumber=0;reserveListNumber<Users.reserves.get(indexForUser).size();reserveListNumber++){
		        	   Packet06ReserveItem p6=new Packet06ReserveItem(Users.reserves.get(indexForUser).get(reserveListNumber));
		        	   sendData(p6.getData(),address,port);
		           }
	           }
	            break;
	        case DISCONNECT:
	            packet = new Packet01Disconnect(dt);
	            System.out.println("[" + address.getHostAddress() + ":" + port + "] "
	                    + ((Packet01Disconnect) packet).getUsername() + " has left...");
	            this.removeConnection((Packet01Disconnect) packet);
	            break;
	        case AddBook:
	        	packet=new Packet02AddBook(dt);
	        	System.out.println("["+((Packet02AddBook)packet).getName());
	        	break;
	        case AddAdmin:
	        	packet=new Packet07AddAdmin(dt);
	        	if(Users.admins.contains(((Packet07AddAdmin) packet).getUsername().trim())){
	        		Packet20AdminAlreadyExists p20=new Packet20AdminAlreadyExists();
	        		sendData(p20.getData(),address,port);
	        	}else{
	        		Users.addAdmin(((Packet07AddAdmin) packet).getUsername(), ((Packet07AddAdmin) packet).getPassword());
	        		Packet21AdminNotExists p21=new Packet21AdminNotExists();
	        		sendData(p21.getData(),address,port);
	        	}
	        	break;
	        case BookInfo:
	        	packet=new Packet05BookInfo(dt);
	        	if(Book.id.contains(((Packet05BookInfo) packet).getID())){
	        		Packet22BookAlreadyExists p22 = new Packet22BookAlreadyExists();
	        		sendData(p22.getData(),address,port);
	        	}else{
	        		Book.add(((Packet05BookInfo) packet).getTitle(), ((Packet05BookInfo) packet).getAuthor(), ((Packet05BookInfo) packet).getPublisher(), ((Packet05BookInfo) packet).getPublicationYear(),((Packet05BookInfo) packet).getID(), 
	        			((Packet05BookInfo) packet).getGradeLevel(), ((Packet05BookInfo) packet).getGenre(), ((Packet05BookInfo) packet).getNumberAvailable(), ((Packet05BookInfo) packet).getCondition());
	        		Packet23BookNotExists p23 = new Packet23BookNotExists();
	        		sendData(p23.getData(),address,port);
	        	}
	        	break;
	        case LoginAdmin:
	        	packet=new Packet10LoginAdmin(dt);
	        	if(Users.loginAdmin(((Packet10LoginAdmin) packet).getUsername(), ((Packet10LoginAdmin) packet).getPassword())){
	        		Packet11AcceptedAdmin p11=new Packet11AcceptedAdmin(((Packet10LoginAdmin) packet).getUsername(),((Packet10LoginAdmin) packet).getPassword());
	        		sendData(p11.getData(), address, port);
	        		LibAdmin admin=new LibAdmin(((Packet10LoginAdmin) packet).getUsername(), ((Packet10LoginAdmin) packet).getPassword(), address, port);
	        		Packet10LoginAdmin p10=(Packet10LoginAdmin) packet;
	        		addConnection(admin,p10);
	 	           if(Library.Book.libraryBooks.size()!=0){
	 	        	   for(int bookNumber=0;bookNumber<Library.Book.libraryBooks.size();bookNumber++){
	 	        	   		String title=Library.Book.libraryBooks.get(bookNumber);
	 	        	   		int index=Library.Book.libraryBooks.indexOf(title);
	 	        	   		Packet05BookInfo p5=new Packet05BookInfo(title, Library.Book.authors.get(index), Library.Book.publishers.get(index), Library.Book.publicationYears.get(index),
	 	        			   	Library.Book.id.get(index), Library.Book.gradeLevels.get(index), Library.Book.genre.get(index),Library.Book.numberAvailable.get(index), Library.Book.condition.get(index));
	 	           			sendData(p5.getData(),address,port);
	 	           			//p5.writedt(this); Might do this and have to change the others
	 	           		}
	 	           }
	 	           //send reserves and checkouits with user
	 	           if(Library.Users.usernames.size()!=0){
	 	        	   for(int userNumber=0;userNumber<Library.Users.usernames.size();userNumber++){
	 	        		   String uname=Library.Users.usernames.get(userNumber);
	 	        		   int index=Library.Users.usernames.indexOf(uname);
	 	        		   Packet04LoginInfoUser p4=new Packet04LoginInfoUser(Users.firstName.get(index),Users.lastName.get(index),Users.usernames.get(index),Users.passwords.get(index),Users.age.get(index),Users.idList.get(index),Users.cardNumber.get(index));
	 	        		   sendData(p4.getData(),address,port);
	 	        	   }
	 	           }
	        	}
	        	break;
	        case EditBook:
	        	packet=new Packet14EditBook(dt);
	        	int cID=((Packet14EditBook) packet).getCurrentID();
	        	int currentIndex=Library.Book.id.indexOf(cID);
	        	Library.Book.libraryBooks.set(currentIndex, ((Packet14EditBook) packet).getTitle());
	        	Library.Book.authors.set(currentIndex, ((Packet14EditBook) packet).getAuthor());
	        	Library.Book.publishers.set(currentIndex, ((Packet14EditBook) packet).getPublisher());
	        	Library.Book.publicationYears.set(currentIndex, ((Packet14EditBook) packet).getPublicationYear());
	        	Library.Book.id.set(currentIndex, ((Packet14EditBook) packet).getId());
	        	Library.Book.gradeLevels.set(currentIndex, ((Packet14EditBook) packet).getGradelevel());
	        	Library.Book.genre.set(currentIndex, ((Packet14EditBook) packet).getGenre());
	        	Library.Book.numberAvailable.set(currentIndex, ((Packet14EditBook) packet).getNumberavailable());
	        	Library.Book.condition.set(currentIndex, ((Packet14EditBook) packet).getCondition());
	        	
	        	Packet33BookChange p33=new Packet33BookChange(cID,((Packet14EditBook) packet).getTitle(),((Packet14EditBook) packet).getAuthor(), ((Packet14EditBook) packet).getPublisher(), ((Packet14EditBook) packet).getPublicationYear(),((Packet14EditBook) packet).getId(), 
	        			((Packet14EditBook) packet).getGradelevel(), ((Packet14EditBook) packet).getGenre(), ((Packet14EditBook) packet).getNumberavailable(), ((Packet14EditBook) packet).getCondition()); 
	        	sendDataToAllClients(p33.getData());
	        	break;
	        case AddUser:
	        	packet= new Packet03AddUser(dt);
	        	if(Users.usernames.contains(((Packet03AddUser) packet).getUsername())){
	        		Packet24UserAlreadyExists p24 = new Packet24UserAlreadyExists();
	        		sendData(p24.getData(),address,port);
	        	}else{
	        		Library.Users.addUser(((Packet03AddUser) packet).getFirstName(), ((Packet03AddUser) packet).getLastName(), ((Packet03AddUser) packet).getUsername(),
	        			((Packet03AddUser) packet).getPassword(), ((Packet03AddUser) packet).getAge(), ((Packet03AddUser) packet).getId(), ((Packet03AddUser) packet).getCardNumber());
	        		Packet25UserNotExists p25 = new Packet25UserNotExists();
	        		sendData(p25.getData(),address,port);
	        	}
	        	break;
	        case CheckinBook:
	        	packet=new Packet15CheckinBook(dt);
	        	Library.Users.returnBook(((Packet15CheckinBook) packet).getBook(), ((Packet15CheckinBook) packet).getID());
	        	//broadcast change to all
	        	break;
	        case CheckoutBook:
	        	packet=new Packet16CheckoutBook(dt);
	        	Library.Users.takeBook(((Packet16CheckoutBook) packet).getBook(), ((Packet16CheckoutBook) packet).getUser(), ((Packet16CheckoutBook) packet).getDate());
	        	break;
	        case DeleteAdmin:
	        	packet=new Packet17DeleteAdmin(dt);
	        	Library.Users.deleteAdmin(((Packet17DeleteAdmin) packet).getName());
	        }
	}
	
	 public void addConnection(LibUser player, Packet00Login packet) {
	        boolean alreadyConnected = false;
	        for (LibUser p : this.connectedClients) {
	            if (player.getUsername().equalsIgnoreCase(p.getUsername())) {
	                if (p.ipAddress == null) {
	                    p.ipAddress = player.ipAddress;
	                }
	                if (p.port == -1) {
	                    p.port = player.port;
	                }
	                alreadyConnected = true;
	            } else {
	                // relay to the current connected player that there is a new
	                // player
	                sendData(packet.getData(), p.ipAddress, p.port);

	                // relay to the new player that the currently connect player
	                // exists
	                packet = new Packet00Login(p.getUsername(),p.getPassword());
	                sendData(packet.getData(), player.ipAddress, player.port);
	            }
	        }
	        if (!alreadyConnected) {
	            this.connectedClients.add(player); 
	        }
	    }
	 
	 public void addConnection(LibAdmin admin, Packet10LoginAdmin packet){
		 boolean alreadyConnected = false;
	        for (LibAdmin a : this.connectedAdmins) {
	            if (admin.getUsername().equalsIgnoreCase(a.getUsername())) {
	                if (a.ipAddress == null) {
	                    a.ipAddress = admin.ipAddress;
	                }
	                if (a.port == -1) {
	                    a.port = admin.port;
	                }
	                alreadyConnected = true;
	            } else {
	                // relay to the current connected player that there is a new
	                // player
	                sendData(packet.getData(), a.ipAddress, a.port);

	                // relay to the new player that the currently connect player
	                // exists
	                packet = new Packet10LoginAdmin(a.getUsername(),a.getPassword());
	                sendData(packet.getData(), admin.ipAddress, admin.port);
	            }
	        }
	        if (!alreadyConnected) {
	            this.connectedAdmins.add(admin); 
	        }
	 }
	 
	 public int getLibUserIndex(String username) {
	        int index = 0;
	        for (LibUser player : this.connectedClients) {
	            if (player.getUsername().equals(username)) {
	                break;
	            }
	            index++;
	        }
	        return index;
	    }

	    public void removeConnection(Packet01Disconnect packet) {
	        this.connectedClients.remove(getLibUserIndex(packet.getUsername()));
	        packet.writeData(this);
	    }
	    
	    public void sendData(byte[] data, InetAddress ipAddress, int port) {
	    	String dt=new String(data).trim();
	    	
	    	try {
				dt=EncryptByteArray(data);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
	    	//DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
	    	DatagramPacket packet = new DatagramPacket(dt.getBytes(), dt.getBytes().length, ipAddress, port);
	        try {
	        	this.serverSocket.send(packet);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void sendDataToAllClients(byte[] data) {
	        for (LibUser p : connectedClients) {
	            sendData(data, p.ipAddress, p.port);
	        }
	        for (LibAdmin a : connectedAdmins){
	        	sendData(data, a.ipAddress, a.port);
	        }
	    }
	    
	    public static String EncryptByteArray(byte[] array) throws Exception
	    {
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        String encryptedString = Base64.encodeBase64String(cipher.doFinal(array));
	        return encryptedString;
	    }
	    public static byte[] decryptByteArray(String strToDecrypt) throws Exception
	    {
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        return cipher.doFinal(Base64.decodeBase64(strToDecrypt));
	    }
	    @Override
        public void interrupt() {
            try {
                serverSocket.close();
            }catch(Exception e){
            	
            } finally {
                super.interrupt();
            }
        }
	    

}
