package main.MutiThreadSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lrx on 17-5-6.
 */
public class Server {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket server = null;
        try {
            server = new ServerSocket(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务器端开始监听：");
        try {
            while (true) {
                socket = server.accept();
                new Thread(new SocketThread(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
