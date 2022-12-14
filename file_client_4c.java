package cn_lab;

import java.io.*;
import java.net.*;



public class file_client_4c {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
        byte[] contents = new byte[10000];
        FileOutputStream fos = new FileOutputStream("F:\\saran\\saran\\src\\cn_lab\\sk.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();
        int bytesRead = 0;
        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead);
        bos.flush();
        socket.close();
        System.out.println("File saved successfully!");

    }
}
