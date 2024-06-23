package splitwise.logger;

public class MyLogger {
    private final MyLogger nextLogger;
    MyLogger(MyLogger nextLogger){
        this.nextLogger=nextLogger;
    }
    public void log(MyLogLevel logLevel, String msg) {
        if (nextLogger!=null){
            nextLogger.log(logLevel, msg);
        }
    }
}
