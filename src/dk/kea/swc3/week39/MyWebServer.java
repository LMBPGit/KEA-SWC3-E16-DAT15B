package dk.kea.swc3.week39;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by coag on 29-09-2016.
 */
public class MyWebServer {

    public static void main(String[] args) {
        try {
            String serverPath = "C:/Users/coag/Desktop/www";
            int port = 8080;
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                byte[] data = new byte[1024];

                in.read(data);
                String msg = new String(data).trim();
                System.out.println("---------REQ Start-------------");
                System.out.println(msg);
                System.out.println("-----------END-----------");

                if (msg.toUpperCase().startsWith("GET")) {
                    Scanner sc = new Scanner(msg);
                    sc.next();
                    String fileName = sc.next();

                    String filePath = serverPath + fileName;

                } else {
                    out.writeBytes("HTTP/1.1 400 I do not compredere. I am from Barcelona.\r\n");
                    out.flush();
                    socket.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
