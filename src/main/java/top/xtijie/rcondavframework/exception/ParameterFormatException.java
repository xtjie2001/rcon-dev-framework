package top.xtijie.rcondavframework.exception;

public class ParameterFormatException extends RconException{
    public ParameterFormatException() {
    }

    public ParameterFormatException(String message) {
        super(message);
    }

    public ParameterFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterFormatException(Throwable cause) {
        super(cause);
    }

    public ParameterFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
