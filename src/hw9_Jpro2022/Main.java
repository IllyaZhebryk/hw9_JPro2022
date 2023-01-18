package hw9_Jpro2022;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration("D:/logFile", LoggingLevel.INFO,
                1, ".txt");
        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);
        try {
            fileLogger.info("test");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
