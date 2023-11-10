package Packageserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Server {
    public static void main(String[] args) {
    	int  PORT=1234;
    	byte[] buffer = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(PORT);
			
			System.out.println("Demarrage du server");
			while(true) {
				DatagramPacket userNamepacket = new DatagramPacket(buffer, buffer.length);
				socket.receive(userNamepacket);
				/*
				DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
				String time = getTime();
				DatagramPacket packetTosend = new DatagramPacket(time , getBytes,time.length(),packet.getAddress(),packet.getPort());

				socket.send(packetTosend);
				*/
						
				String username = new String(userNamepacket.getData(),0,userNamepacket.getLength());
				System.out.println("client "+userNamepacket.getAddress()+"username = "+username);
				
				String msgTosend = "Bienvenue "+username;
				DatagramPacket packetTosend = new DatagramPacket(msgTosend.getBytes(), msgTosend.length(),userNamepacket.getAddress(),userNamepacket.getPort());
				socket.send(packetTosend);
					System.out.println("client "+packetTosend.getAddress());
				}
			 
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

  
