package unit12;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class example {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.se.rit.edu/"); //must need everything here otherwise will throw error 
        //also works with https://www.se.rit.edu:443 (port number)
        URLConnection connection = url.openConnection(); //connects to url

        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);  //gets the source code of google
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();

        // InetAddress address = InetAddress.getLocalHost();
        // System.out.println(address.getHostAddress());
        // System.out.println(address.getHostName());

        // InetAddress google = InetAddress.getByName("www.google.com");
        // System.out.println(google.getHostAddress());
        // System.out.println(google.getHostName());

        // InetAddress local = InetAddress.getByName("localhost");
        // System.out.println(local.getHostAddress());
        // System.out.println(local.getHostName());
    }
}
