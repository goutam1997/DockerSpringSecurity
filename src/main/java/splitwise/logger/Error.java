package splitwise.logger;

public class Error extends MyLogger{
    Error(MyLogger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(MyLogLevel logLevel, String msg) {
        if (MyLogLevel.ERROR == logLevel){
            System.out.println(logLevel.name()+": "+msg);
        }else {
            super.log(logLevel, msg);
        }
    }
}
