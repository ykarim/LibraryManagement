package log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class Logger {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static LogStack logStack = new LogStack();

    public static void writeToLog(Level level, String message) {
        LogStack.addToStack(message);
        logger.log(level, message);
    }

    public static void writeException(String text, Throwable throwable) {
        LogStack.addToStack(text);
        LogStack.addToStack(throwable);
        logger.error(text, throwable);
    }
}
