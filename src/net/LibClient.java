package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import net.packets.Packet;
import net.packets.Packet.PacketTypes;
import net.packets.Packet00Login;
import net.packets.Packet01Disconnect;
import net.packets.Packet02AddBook;
import net.packets.Packet04LoginInfoUser;
import net.packets.Packet05BookInfo;
import net.packets.Packet06ReserveItem;
import net.packets.Packet11AcceptedAdmin;
import net.packets.Packet12Accepted;
import net.packets.Packet33BookChange;

import org.apache.commons.codec.binary.Base64;

import Library.Users;
/**
 * Must be the same with Library Client
 */
@SuppressWarnings("deprecation")
public class LibClient extends Thread {

    private InetAddress ipAddress;
    private DatagramSocket socket;
    public boolean acceptedLogin;
    protected int index=-1;
    protected String username;
    protected String password;
    private static byte[] key = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65,
        0x79 };
    
    public void libClient() {
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName("24.146.238.85");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
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
            handleLogin((Packet00Login) packet, address, port);
            break;
        case DISCONNECT:
            packet = new Packet01Disconnect(dt);
            System.out.println("[" + address.getHostAddress() + ":" + port + "] "
                    + ((Packet01Disconnect) packet).getUsername() + " has left.");
            break;
        case AddBook:
            packet = new Packet02AddBook(dt);
            handleMove((Packet02AddBook) packet);
            break;
        case Accepted:
        	packet=new Packet12Accepted(dt);
        	acceptedLogin=true;
        	index=((Packet12Accepted) packet).getIndex();
        	break;
        case LoginInfo:
        	packet=new Packet04LoginInfoUser(dt);
        	Users.addUser(((Packet04LoginInfoUser) packet).getFirstName(), ((Packet04LoginInfoUser) packet).getLastName(), username, password, ((Packet04LoginInfoUser) packet).getAge(), ((Packet04LoginInfoUser) packet).getID(), ((Packet04LoginInfoUser) packet).getCardNumber());
        	break;
        case BookInfo:
        	packet=new Packet05BookInfo(dt);
        	Library.Book.add(((Packet05BookInfo) packet).getTitle(), ((Packet05BookInfo) packet).getAuthor(), ((Packet05BookInfo) packet).getPublisher(), ((Packet05BookInfo) packet).getPublicationYear()
        			, ((Packet05BookInfo) packet).getID(),((Packet05BookInfo) packet).getGradeLevel(), ((Packet05BookInfo) packet).getGenre(), ((Packet05BookInfo) packet).getNumberAvailable(), ((Packet05BookInfo) packet).getCondition());
        	break;
        case ReserveItem:
        	packet=new Packet06ReserveItem(dt);
        	Users.reserves.get(index).add(((Packet06ReserveItem) packet).getItem());
        	break;
        case AcceptedAdmin:
        	packet=new Packet11AcceptedAdmin(dt);
        	Users.addAdmin(((Packet11AcceptedAdmin) packet).getUsername(), ((Packet11AcceptedAdmin) packet).getPassword());
        	break;
        case BookChange:
        	packet=new Packet33BookChange(dt);
        	int cID=((Packet33BookChange) packet).getCID();
        	int currentIndex=Library.Book.id.indexOf(cID);
        	Library.Book.libraryBooks.set(currentIndex, ((Packet33BookChange) packet).getTitle());
        	Library.Book.authors.set(currentIndex, ((Packet33BookChange) packet).getAuthor());
        	Library.Book.publishers.set(currentIndex, ((Packet33BookChange) packet).getPublisher());
        	Library.Book.publicationYears.set(currentIndex, ((Packet33BookChange) packet).getPublicationYear());
        	Library.Book.id.set(currentIndex, ((Packet33BookChange) packet).getId());
        	Library.Book.gradeLevels.set(currentIndex, ((Packet33BookChange) packet).getGradelevel());
        	Library.Book.genre.set(currentIndex, ((Packet33BookChange) packet).getGenre());
        	Library.Book.numberAvailable.set(currentIndex, ((Packet33BookChange) packet).getNumberavailable());
        	Library.Book.condition.set(currentIndex, ((Packet33BookChange) packet).getCondition());
        	break;
        	/*
        case AdminAlreadyExists:
        	packet=new Packet20AdminAlreadyExists(dt);
        	View.AddAdmin.adminExists=0;
        	break;
        case AdminExists:
        	packet=new Packet21AdminNotExists(dt);
        	View.AddAdmin.adminExists=1;
        	*/
        }
    }

    public void sendData(byte[] data) {
    	String dt=new String(data).trim();
    	
    	try {
			dt=EncryptByteArray(data);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
            DatagramPacket packet = new DatagramPacket(dt.getBytes(), dt.getBytes().length, ipAddress, 5609);
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    private void handleLogin(Packet00Login packet, InetAddress address, int port) {
    	System.out.println("[" + address.getHostAddress() + ":" + port + "] " 
                + " has joined.");
    	username = packet.getUsername();
    	password=packet.getPassword();
    }

    private void handleMove(Packet02AddBook packet) {
       
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
        byte[] decryptedArray=cipher.doFinal(Base64.decodeBase64(strToDecrypt));
		return decryptedArray;
    }
    
}