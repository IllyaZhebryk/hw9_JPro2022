package hw9_Jpro2022;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private int fileSize;
    private String extension;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, int fileSize, String extension) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.fileSize = fileSize;
        this.extension = extension;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
