package game;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameLogger {

    private static final Logger logger = Logger.getLogger(GameLogger.class.getName());

    static {
        logger.setLevel(Level.INFO);
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    static void logWarning(String message) {
        logger.warning(message);
    }
}
