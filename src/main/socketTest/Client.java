package main.socketTest;

import java.io.*;
import java.net.Socket;

/**
 * Created by lrx on 17-5-6.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);

            OutputStream out = socket.getOutputStream();
            PrintWriter print = new PrintWriter(out);
            print.write("你好呀，服务器！！！");
            print.flush();
            socket.shutdownOutput();

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
            bufferedReader.close();
            reader.close();
            stream.close();

            print.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
