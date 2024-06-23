package splitwise.logger;

public class Main {
    public static void main(String[] args) {
        MyLogger logger=new Error(new Debug(new Info(null)));
        logger.log(MyLogLevel.DEBUG, "Hey");
        logger.log(MyLogLevel.ERROR, "Hi");
        logger.log(MyLogLevel.INFO, "Hello");
    }
}
