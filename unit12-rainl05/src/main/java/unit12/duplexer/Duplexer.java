package unit12.duplexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer implements AutoCloseable{
    private final Socket socket;
    private final PrintWriter writer;
    private final Scanner scanner;

    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;

        this.writer = new PrintWriter(socket.getOutputStream());
        this.scanner = new Scanner(socket.getInputStream());
    }

    @Override
    public void close() throws Exception {
        writer.close();
        scanner.close();
        socket.close();
    }

    public void send(String message){
        writer.println(message);
        writer.flush();
    }

    public String recieve(){
        return scanner.nextLine();
    }
}
