package top.xtijie.rcondavframework.exception;

public class RconIOException extends RconException{

    public RconIOException() {
    }

    public RconIOException(String message) {
        super(message);
    }

    public RconIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public RconIOException(Throwable cause) {
        super(cause);
    }

    public RconIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
