package log;

/**
 * Watches the program's log for new entries and handles each new entry accordingly
 * fireAddedLogMessage is called for every new log entry
 */
public interface LogWatcher {

    /**
     * Processes new log message
     *
     * @param message
     */
    void fireAddedLogMessage(String message);
}
