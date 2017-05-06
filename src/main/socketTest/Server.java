package main.socketTest;

/**
 * Created by lrx on 17-5-6.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP的服务器端
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3000);
            // 等待客户端连接
            System.out.println("服务器端开始监听：");
            Socket socket = server.accept();

            // 接受客户端信息
            InputStream stream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String in = bufferedReader.readLine();
            while (in != null) {
                System.out.println(in);
                in = bufferedReader.readLine();
            }
            // 关闭输入流
            socket.shutdownInput();

            // 向客户端发送信息
            OutputStream out = socket.getOutputStream();
            PrintWriter print = new PrintWriter(out);
            print.write("来自服务器：我已经接收到信息！！！");

            print.close();
            out.close();
//            关闭其他资源
            bufferedReader.close();
            reader.close();
            stream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
