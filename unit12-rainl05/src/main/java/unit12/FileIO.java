package unit12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("src/main/java/unit12/practicum/practicum.txt");

        byte[] buffer = new byte[1024]; //will only read enough data to fill 1024 bytes or whaever number byte you put.
        int num = in.read(buffer);

        while(num > 0) {
            String s = new String(buffer, 0, num);
            System.out.println(s);
            num = in.read(buffer);
        }

        //produces same thing as above except above is more efficient
        // int data = in.read();
        // while(data != -1){ //checks if there is data -1 means no data
        //     System.out.print((char)data); //(char) turns the data into actual things
        //     data = in.read();
        // }

        in.close();


        OutputStream out = new FileOutputStream("foo.txt"); //creates a new txt file called foo.txt then asks user to print stuff and store it.
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("print some text");
            String line = scanner.nextLine() + "\n";
            if(line.equals("\n")){
                break;
            }
            byte[] data = line.getBytes();
            out.write(data);

        } 
        out.flush();
        out.close();
    }
}
