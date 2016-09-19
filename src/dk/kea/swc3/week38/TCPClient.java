package dk.kea.swc3.week38;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by coag on 19-09-2016.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            if(args.length < 2){
                args = new String[2];
                Scanner scInfo = new Scanner(System.in);
                System.out.println("IP:");
                args[0] = scInfo.next();
                System.out.println("PORT:");
                args[1] = scInfo.next();
            }
            InetAddress ip = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);

            Socket socket = new Socket(ip, port);

            DataInputStream in = new DataInputStream(socket.getInputStream());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Type your msg: ");
                String msg = sc.nextLine();
                if (msg.toLowerCase().equals("quit")){
                    break;
                }
                out.writeUTF(msg);
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
