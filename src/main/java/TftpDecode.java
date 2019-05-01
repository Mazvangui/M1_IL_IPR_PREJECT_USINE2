// package pr.tp2.udp.tftp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class TftpDecode {

	public static void main(String[] args) throws IOException {
		// Attends sur le port 6969
		int port = 9090;
		String URL = "224.3.2.1";
		byte buffer[] = new byte[100];
		// Boucle
		while(true){

			System.out.println("======== Date : =============");
			MulticastSocket socket = new MulticastSocket(port);
			InetAddress group = InetAddress.getByName(URL);
			socket.joinGroup(group);

			DatagramPacket packet;
			for (int i = 0; i < 5; i++) {
				byte[] buf = new byte[1000];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				String received = new String(packet.getData(), 0,packet.getLength(), "UTF-8");

				System.out.println("Quote of the Moment: " + received);
			}

			socket.leaveGroup(group);
			socket.close();


//			InetAddress group = InetAddress.getByName("203.0.113.0");
//			DatagramPacket packet;
//			packet = new DatagramPacket(buffer, buffer.length, group, port);
////			System.out.println("Quote of the Moment: " + packet);
////
//			DatagramSocket socket = new DatagramSocket(port);
////			socket.send(packet);
////			System.out.println("Quote of the Moment socket : " + socket);
////
//
////			for (int i = 0; i < buffer.length; i++) {
////				byte[] buf = new byte[256];
////				packet = new DatagramPacket(buffer, buffer.length, group, port);
//////				packet = new DatagramPacket(buf, buf.length);
////				socket.receive(packet);
////
////				String received = new String(packet.getData());
////				System.out.println("Quote of the Moment: " + received);
////			}
//
//			// Reception du packet
//			System.out.println("socket : " + socket.getPort() );
//			System.out.println("socket : " + socket.getBroadcast());
//			System.out.println("socket -: " + socket.getChannel() );
//			System.out.println("socket-- : " + socket.getInetAddress() );
//			System.out.println("socket -: " + socket);
//			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
////			byte[] buf = new byte[256];
//			packet = new DatagramPacket(buffer, buffer.length, group, port);
//			System.out.println("datagram --: " + p.getPort());
//			System.out.println("datagram- p: " + packet);
//			socket.receive(p);
//			System.out.println("socket receive : " + p);
//			String data = new String();
//			data = p.toString();
//			System.out.println("Date : " );
//			System.out.println("Date : " + data);
//			// Attention à ne pas afficher plus d'informations que nécessaire.
//
//			// Décodage du packet
//			decodeRequest(p);
//
//			socket.close();

		}
	}


	public static void affiche(byte[] bytes) {
		for (int i = 0; i < bytes.length; i++) {
			if (i % 16 == 0) {
				System.out.println("\n");
			}
			System.out.printf("%02x ", bytes[i]);
		}
	}

	public static void decodeRequest(DatagramPacket p) {
		System.out.printf("Type : %s, fichier : %s, mode %s", "RRQ", "test.txt", "ascii");
	}

}
