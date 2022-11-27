package top.xtijie.rcondavframework.exception;

public class ConsoleDestroyException extends Exception{

    public ConsoleDestroyException() {
    }

    public ConsoleDestroyException(String message) {
        super(message);
    }

    public ConsoleDestroyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsoleDestroyException(Throwable cause) {
        super(cause);
    }

    public ConsoleDestroyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
