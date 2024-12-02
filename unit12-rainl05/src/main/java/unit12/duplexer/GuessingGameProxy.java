package unit12.duplexer;

import java.io.IOException;
import java.net.Socket;

import unit12.guessing.GuessResult;
import unit12.guessing.GuessingGame;

public class GuessingGameProxy extends Duplexer implements GuessingGame{
    
    public GuessingGameProxy(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'restart'");
    }

    @Override
    public GuessResult guess(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guess'");
    }

    @Override
    public void quit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quit'");
    }
    
}
