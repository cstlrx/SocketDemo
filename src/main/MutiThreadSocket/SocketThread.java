package main.MutiThreadSocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by lrx on 17-5-6.
 */
public class SocketThread implements Runnable{

    private Socket socket;
    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 接受客户端信息
        try {
            System.out.println(Thread.currentThread().getName());

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

