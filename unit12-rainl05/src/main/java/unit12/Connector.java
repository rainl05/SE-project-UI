package unit12;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Connector {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("time.nist.gov", 13); //errors will occur for wrong links and wrong port numbers 
        System.out.println("Connected!\n\n\n");


        InputStream in = sock.getInputStream();
        Scanner scanner = new Scanner(in);
        while(scanner.hasNext()){ //do not spam unless u wanna get ip banned.
            System.out.println(scanner.next());
        }
        System.out.println("");
        scanner.close();

        sock.close();
    }
}
