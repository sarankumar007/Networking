package cn_lab;

import java.io.*;
import java.net.*;
public class file_server_4c
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ssock = new ServerSocket(5000);
        Socket socket = ssock.accept();
        InetAddress IA = InetAddress.getByName("localhost");
        File file = new File("F:\\saran\\saran\\src\\cn_lab\\sk.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream os = socket.getOutputStream();
        byte[] contents;
        long fileLength = file.length();
        long current = 0;
       long start = System.nanoTime();
        while(current!=fileLength){
            int size = 10000;
            if(fileLength - current >= size)
                current += size;
            else{
                size = (int)(fileLength - current);
                current = fileLength;
            }
            contents = new byte[size];
            bis.read(contents, 0, size);
            os.write(contents);
            System.out.print("Sending file ... "+(current*100)/fileLength+"% complete!");
        }
        os.flush();
        socket.close();
        ssock.close();
        System.out.println("File sent succesfully!");
    } }