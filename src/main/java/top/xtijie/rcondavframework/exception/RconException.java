package top.xtijie.rcondavframework.exception;

public class RconException extends Exception{

    public RconException() {
    }

    public RconException(String message) {
        super(message);
    }

    public RconException(String message, Throwable cause) {
        super(message, cause);
    }

    public RconException(Throwable cause) {
        super(cause);
    }

    public RconException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
