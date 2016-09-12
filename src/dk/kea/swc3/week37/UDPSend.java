package dk.kea.swc3.week37;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by coag on 12-09-2016.
 */
public class UDPSend {

    public static void main(String[] args) {

        try {
            int sendPort = 7777;
            InetAddress ip = InetAddress.getByName("localhost");

            DatagramSocket socket = new DatagramSocket();

            Scanner sc = new Scanner(System.in);


            while (true) {
                System.out.println("MSG TO SEND (type exit to kill this app): ");
                String msg = sc.nextLine();

                if(msg.toLowerCase().equals("exit")){
                    System.exit(123);
                }

                byte[] data = msg.getBytes();

                //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
                DatagramPacket packet = new DatagramPacket(data, data.length, ip, sendPort);

                socket.send(packet);
                System.out.println("data sent");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
