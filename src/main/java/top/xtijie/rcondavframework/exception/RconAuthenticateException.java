package top.xtijie.rcondavframework.exception;

public class RconAuthenticateException extends RconException {

    public RconAuthenticateException() {
    }

    public RconAuthenticateException(String message) {
        super(message);
    }

    public RconAuthenticateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RconAuthenticateException(Throwable cause) {
        super(cause);
    }

    public RconAuthenticateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
