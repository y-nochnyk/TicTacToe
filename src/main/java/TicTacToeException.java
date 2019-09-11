import java.io.IOException;

public class TicTacToeException extends IOException {
    public TicTacToeException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "TicTacToeException: " + super.getMessage();
    }
}
