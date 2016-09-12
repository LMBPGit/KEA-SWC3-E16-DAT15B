package dk.kea.swc3.week37;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by coag on 12-09-2016.
 */
public class UDPReceive {

    public static void main(String[] args) {
        try {
            int receivePort = 7777;
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket(receivePort, ip);

            while (true) {
                byte[] receiveData = new byte[1024];

                DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(packet);
                String msg = new String(receiveData);
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
