package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet04LoginInfoUser extends Packet {
	int age;
	int balance;
	int cardnumber;
	String firstName, lastName, userName, password;
	int id;
	//ArrayList<String> reserves, checkouts;
	
	//change cn to string
	public Packet04LoginInfoUser(String firstName, String lastName, String userName, String password, int age, int id, int cardnumber) {
		super(04);
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.age=age;
		this.id=id;
		this.cardnumber=cardnumber;
	}
	
	public Packet04LoginInfoUser(byte[]data){
		super(04);
		Object[] dataArray = readData(data).split("/<>/");
		String ag=dataArray[0].toString();
		this.age=Integer.valueOf(ag);
		this.balance=Integer.valueOf(dataArray[1].toString());
		this.cardnumber=Integer.valueOf(dataArray[2].toString());
		this.firstName=(String) dataArray[3];
		this.lastName=(String) dataArray[4];
		this.id=Integer.valueOf(dataArray[5].toString());
		this.userName = (String) dataArray[6];
		this.password = (String) dataArray[7];
	}

	@Override
	public void writeData(LibClient client) {
		client.sendData(getData());
	}

	@Override
	public void writeData(LibServer server) {
		server.sendDataToAllClients(getData());
	}

	@Override
	public byte[] getData() {
		// Find a way to send arraylists:checkouts and reserves
		return ("04" + this.age + "/<>/" + this.balance + "/<>/" + this.cardnumber + "/<>/" +this.firstName + "/<>/" +this.lastName + "/<>/" +this.id + "/<>/" + this.userName + "/<>/" + this.password).getBytes();
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getAge(){
		return age;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public int getCardNumber(){
		return cardnumber;
	}
	
	public int getID(){
		return id;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}

