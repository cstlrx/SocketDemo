package main.udpsocket;

import java.io.IOException;
import java.net.*;

/**
 * Created by lrx on 17-5-7.
 */
public class Client {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        byte[] data = "Hello server, i'm client~".getBytes();
        // 定义一个数据报，UDP是以数据报的形式发送数据，故在数据报中指定目的地址和端口号
        DatagramPacket packet = new DatagramPacket(data,data.length,address,3000);
//        发送数据报
        try {
            DatagramSocket socket = new DatagramSocket();
            // 发送时方法会处于阻塞状态
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
