public class NullElementException extends RuntimeException {
    public NullElementException(String message) {
        super(message);
    }

  public NullElementException(String message, Throwable cause) {
    super(message, cause);
  }

  public NullElementException(Throwable cause) {
    super(cause);
  }

  public NullElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public NullElementException() {
  }
}
