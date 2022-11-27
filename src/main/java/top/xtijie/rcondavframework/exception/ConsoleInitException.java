package top.xtijie.rcondavframework.exception;

public class ConsoleInitException extends Exception{

    public ConsoleInitException() {
    }

    public ConsoleInitException(String message) {
        super(message);
    }

    public ConsoleInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsoleInitException(Throwable cause) {
        super(cause);
    }

    public ConsoleInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
