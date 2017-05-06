package main;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lrx on 17-5-5.
 */
public class Test1 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("主机IP地址" + address.getHostAddress());
        System.out.println("主机名：" + address.getHostName());
    }

}
