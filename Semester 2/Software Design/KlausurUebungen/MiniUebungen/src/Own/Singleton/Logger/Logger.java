package Own.Singleton.Logger;

import java.util.ArrayList;

public class Logger {
    private static Logger loggerInstance;
    private final ArrayList<String> logList = new ArrayList<>();

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
            System.out.println("Logger instance created");
        }
        else System.out.println("Logger already exists, returning the existing logger instance...");
        return loggerInstance;
    }

    public synchronized void log(String message) {
        logList.add(message);
    }

    public synchronized int getCount() {
        return logList.size();
    }

    public synchronized void printAll() {
        for (String s : logList) {
            System.out.println(s);
        }
    }
}
