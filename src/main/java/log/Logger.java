package log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class Logger {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    public static void writeToLog(Level level, String message) {
        logger.log(level, message);
    }

    public static void writeException(String text, Throwable throwable) {
        logger.error(text, throwable);
    }
}
