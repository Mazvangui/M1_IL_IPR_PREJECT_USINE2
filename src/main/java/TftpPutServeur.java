import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

public class TftpPutServeur {

	public static void main(String[] args) {
		// Attends sur le port 6969

		// Boucle

		// Reception du packet
		DatagramPacket p = null;

		// Affichage du packet

		// Attention à ne pas afficher plus d'informations que nécessaire.

		// Décodage du packet
		decodeRequest(p);

		// Envoyer acquittement
//		 sendAck(server, /***/);
	}

	public static void sendAck(DatagramSocket server, short seqNumber, SocketAddress dstAddr) throws IOException {
		System.out.println("Send " + seqNumber + " to " + dstAddr);

		// Construire le paquet avec les bonnes informations
		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		//adapter la taille
		byteBuffer.putShort((short) 2); //attention le code n'est pas celui de l'acquittement dans cet exemple
		byteBuffer.putShort(seqNumber);
		byte[] buffer = byteBuffer.array();
		// afficher le tableau de bytes envoyé
		affiche(buffer);

		// Envoyer le paquet à la bonnes addresses
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
