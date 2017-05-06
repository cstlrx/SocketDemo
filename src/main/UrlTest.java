package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lrx on 17-5-5.
 */

/**
 * 打印百度页面源代码
 */
public class UrlTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            try {
                InputStream stream = url.openStream();
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();

                bufferedReader.close();
                reader.close();
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
