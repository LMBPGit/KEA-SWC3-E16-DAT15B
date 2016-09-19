package dk.kea.swc3.week38;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by coag on 19-09-2016.
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            int port = 5555;

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("TCP Server stared on port " + port);


            while (true) {
                Socket socket = serverSocket.accept();
                Thread t = new Thread(() -> {
                    try {
                        System.out.println("Client connected");
                        while (true) {
                            DataInputStream in = new DataInputStream(socket.getInputStream());

                            String msg = in.readUTF();
                            System.out.println("MSG --> " + msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
