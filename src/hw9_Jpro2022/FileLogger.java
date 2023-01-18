package hw9_Jpro2022;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private final FileLoggerConfiguration fileLoggerConfiguration;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
    }

    public void debug(String log) throws IOException {
        if (fileLoggerConfiguration.getLoggingLevel() == LoggingLevel.INFO) {
            return;
        }
        String logMessage = getLogMessage(log, LoggingLevel.DEBUG);
        logMessage(logMessage);
    }

    public void info(String log) throws IOException {
        String logMessage = getLogMessage(log, LoggingLevel.INFO);
        logMessage(logMessage);
    }

    private void logMessage(String logMessage) throws IOException {
        String filePath = fileLoggerConfiguration.getFilePath();
        String extension = fileLoggerConfiguration.getExtension();
        File file = new File(filePath + extension);
        checkFileSize(file);
        if (file.isDirectory()) {
            throw new RuntimeException("Path is not a file, its a directory");
        } else if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() != 0) {
                bufferedWriter.newLine();
            }
            bufferedWriter.write(logMessage);
            checkFileSize(file);
        }
    }

    private void checkFileSize(File file) {
        if (file.length() >= fileLoggerConfiguration.getFileSize()) {
            throw new FileMaxSizeReachedException(String.format("Current file size is %s, max size is %s, "
                            + "file path: %s", file.length(), fileLoggerConfiguration.getFileSize(),
                    file.getAbsolutePath()));
        }
    }

    private String getLogMessage(String log, LoggingLevel loggingLevel) {
        return String.format("[%s][%s] Message: [%s]", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                loggingLevel, log);
    }

}
