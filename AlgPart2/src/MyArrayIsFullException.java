public class MyArrayIsFullException extends RuntimeException {
    public MyArrayIsFullException(String message) {
        super(message);
    }

    public MyArrayIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArrayIsFullException(Throwable cause) {
        super(cause);
    }

    public MyArrayIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyArrayIsFullException() {
    }
}
