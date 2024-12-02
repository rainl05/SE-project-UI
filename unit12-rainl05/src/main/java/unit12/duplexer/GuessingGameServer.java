package unit12.duplexer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import unit12.guessing.GuessResult;
import unit12.guessing.GuessingGame;
import unit12.guessing.GuessingGameImpl;

public class GuessingGameServer extends Duplexer{
    private final GuessingGame game;
    
    public GuessingGameServer(Socket socket) throws IOException {
        super(socket);
        game = new GuessingGameImpl();
    }

    public void run(){
        boolean sentinel = true;

        while(sentinel){
            String msgs =  recieve();
            String[] arr = msgs.split(" ");

            if(arr[0].equals("QUIT")){
                game.quit();
                send("GAME OVER");
                sentinel = false;
            } else if(arr[0].equals("RESTART")){
                game.restart();
                send("RESTARTED");
            } else if(arr[0].equals("GUESS")){
                int guess = Integer.parseInt(arr[2]);
                GuessResult result = game.guess(guess);
                send(result.name());
            } else{
                send("ERROR");
                sentinel = false;
            }
        }
    
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(3075);
        Socket client = server.accept();
        GuessingGameServer ggs = new GuessingGameServer(client);
        ggs.run();

        ggs.close();
        server.close();
    }
    
}
