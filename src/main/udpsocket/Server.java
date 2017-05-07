package main.udpsocket;

/**
 * Created by lrx on 17-5-7.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 基于UDP通信的服务端
 */
public class Server {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(3000);
            byte[] buffer = new byte[1024];
            // 用于接受客户端消息的数据报
            DatagramPacket packet = new DatagramPacket(buffer,1024);
            // 在接收之前，会处于阻塞状态
            socket.receive(packet);
            // 读取数据
            String string = new String(buffer,0,packet.getLength());

            System.out.println("客户端说：" + string);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
