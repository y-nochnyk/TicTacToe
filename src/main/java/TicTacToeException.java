import java.io.IOException;

// Exception created especially for this app. It's being thrown if there's wrong input data typed by player
public class TicTacToeException extends IOException {

    TicTacToeException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "TicTacToeException: " + super.getMessage();
    }
}
