package dk.kea.swc3.week39;

import java.io.*;
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

            ServerSocket server = new ServerSocket(port);

            while (true) {
                Socket socket = server.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                char[] data = new char[1024];
                in.read(data);

                String msg = new String(data).trim();

                System.out.println("--------REQ Start------------");
                System.out.println(msg);
                System.out.println("--------REQ End------------");

                if (msg.toUpperCase().startsWith("GET")) {
                    Scanner reqScanner = new Scanner(msg);
                    reqScanner.next();
                    String fileName = reqScanner.next();

                    String filePath = serverPath + fileName;
                    System.out.println(filePath);

                    try {
                        File file = new File(filePath);
                        if (!file.isFile() == true) {
                            fileName = serverPath + "/404.html";
                            file = new File(fileName);
                            out.writeBytes("HTTP/1.1 404 Shit not found\r\n");
                        } else {
                            out.writeBytes("HTTP/1.1 200 Here is the shit\r\n");
                        }
                        FileInputStream inFile = new FileInputStream(file);


                        if (fileName.endsWith(".jpg")) {
                            out.writeBytes("Content-Type:image/jpeg\r\n");
                        }

                        if (fileName.endsWith(".gif")) {
                            out.writeBytes("Content-Type:image/gif\r\n");
                        }

                        if (fileName.endsWith(".html")) {
                            out.writeBytes("Content-Type:text/html\r\n");
                        }

                        byte[] fileInBytes = new byte[1024];
                        long fileSize = file.length();
                        out.writeBytes("Content-Length: " + fileSize + "\r\n");
                        out.writeBytes("\r\n");

                        int howMany = 0;
                        int total = 0;
                        boolean allSent = false;
                        if (fileSize <= 0) allSent = true;
                        while (allSent == false) {
                            for (int i = 0; i < 1024; i++) fileInBytes[i] = 'x';
                            howMany = inFile.read(fileInBytes, 0, 1024);
                            out.write(fileInBytes, 0, howMany);
                            total = total + howMany;
                            if ((total % 1048576) == 0)
                                System.out.println("Sent so far: " + (int) (total / 1048576) + " MB");
                            fileSize = fileSize - howMany;
                            //System.out.println("DEBUG:  fileSize = " + fileSize);
                            if (fileSize <= 0) allSent = true;
                        }

                        out.writeBytes("\r\n");


                    } catch (Exception e) {
                        out.writeBytes("HTTP/1.1 404 Shit not found\r\n");
                        e.printStackTrace();
                        return;
                    }

                } else {
                    out.writeBytes("HTTP/1.1 400  I do not understand. I am from Barcelona.\r\n");
                    out.writeBytes("\r\n");
                    socket.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
