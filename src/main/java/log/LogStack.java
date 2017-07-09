package log;

import java.util.ArrayList;

/**
 * Holds all log messages produced throughout program duration
 */
public class LogStack {

    private static ArrayList<String> logMessages = new ArrayList<>();
    private static ArrayList<LogWatcher> watchers = new ArrayList<>();

    public static ArrayList<String> getLogMessages() {
        return logMessages;
    }

    /**
     * Add message to stack
     *
     * @param text
     */
    static void addToStack(String text) {
        logMessages.add(text);
        fireAddedLogMessageEvent(text);
    }

    /**
     * Converts exception/error into readable format and adds message to log
     *
     * @param throwable
     */
    static void addToStack(Throwable throwable) {
        for (StackTraceElement element : throwable.getStackTrace()) {
            logMessages.add(element.toString());
            fireAddedLogMessageEvent(element.toString());
        }
    }

    public static void addWatcher(LogWatcher watcher) {
        watchers.add(watcher);
    }

    /**
     * Sends message to all watchers that a new log entry has been entered
     * Also sends the new entry to each of the watchers
     *
     * @param text representing new log entry
     */
    private static void fireAddedLogMessageEvent(String text) {
        for (LogWatcher watcher : watchers) {
            watcher.fireAddedLogMessage(text);
        }
    }
}
