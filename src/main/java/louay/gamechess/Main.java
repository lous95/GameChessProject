package louay.gamechess;

import java.util.logging.LogManager;
/**
 * This is the main class which provides the main methods.
 * 
 * @author Louay
 */
public class Main {
    
    public static void main(String[] args) {
        /*LogManager.getLogManager().reset();*/
        
        
        Game game = new Game();
        game.startGame();
    }

}
