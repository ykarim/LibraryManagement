package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet03AddUser extends Packet {
	private String username;
	private String firstName;
	private String lastName;
	private int id;
	private int cardNumber;
	private String password;//encrypt
	private int age;
	//might have to add checkouts and reserves or let serv handle tht. Might use separate packets for tht. Nvm use another packet to sync users. This packet is to add users to system.
	//packet too big
	
	public Packet03AddUser(String firstname, String lastname, String username, String password, int age, int id, int cardNumber) {
		super(03);
		this.firstName=firstname;
		this.lastName=lastname;
		this.username=username;
		this.password=password;
		this.age=age;
		this.id=id;
		this.cardNumber=cardNumber;
	}
	
	public Packet03AddUser(byte[]data){
		super(03);
		String[]dataArray=readData(data).split("/<>/");
		this.firstName=dataArray[0];
		this.lastName=dataArray[1];
		this.username=dataArray[2];
		this.password=dataArray[3];
		this.age=Integer.parseInt(dataArray[4]);
		this.id=Integer.parseInt(dataArray[5]);
		this.cardNumber=Integer.parseInt(dataArray[6]);
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
		return ("03"+ this.firstName + "/<>/" + this.lastName + "/<>/" + this.username + "/<>/" + this.password + "/<>/" + this.age +"/<>/"
				+this.id+"/<>/"+this.cardNumber).getBytes();
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

}
