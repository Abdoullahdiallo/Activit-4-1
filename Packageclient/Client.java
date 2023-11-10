package Packageclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	private static final int PORT = 1234;
	public static void main(String[] args) {
		byte[] buffer = new byte [1024];

		try 
		{
			Scanner sc = new Scanner(System.in);
		   String username = sc.nextLine();
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket PacketTosend  = new DatagramPacket(username.getBytes(),username.length(),InetAddress.getByName("localhost"),PORT);
		
		socket.send(PacketTosend);
		System.out.println("c'est envoyer à server"+PacketTosend.getAddress());
		DatagramPacket MSGreceive = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(PacketTosend);
		System.out.println("server : "+new String(MSGreceive.getData(),0,MSGreceive.getLength()));
		/*private String getTime()
		      
		 /*
		 private String getTime() {
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			 Date currenTime = new Date();
			 return dateFormat.format(currentTime);
				DatagramPacket packetTo = new DatagramPacket(msgTosend.getBytes(), msgTosend.length(),userNamepacket.getAddress(),userNamepacket.getPort());
				socket.send(packetTo);
			System.out.println("l'heure : "+currenTime);
			*/
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
}
