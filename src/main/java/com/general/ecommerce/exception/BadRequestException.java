package com.general.ecommerce.exception;

/** BadRequestException a checked exception. */
public class BadRequestException extends AbstractException {

  private static final String MSG = "BAD_REQUEST";

  public enum BadRequestErrorsCodes {

  }

  /** Default constructor */
  public BadRequestException() {
    super(MSG);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   */
  public BadRequestException(String errorMsg, Throwable err) {
    super(MSG, err);
    setFriendlyMessage(errorMsg);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   */
  public BadRequestException(String errorMsg) {
    super(MSG);
    setFriendlyMessage(errorMsg);
  }

  public BadRequestException(String errorCode, String friendlyMessage) {
    super(errorCode);
    setFriendlyMessage(friendlyMessage);
  }

  /**
   * Throws an exception with a custom error code and a custom error message
   *
   * @param errorCode the error code, which is an enum value
   * @param friendlyMessage a custom human-readable error message
   */
  public BadRequestException(BadRequestErrorsCodes errorCode, String friendlyMessage) {
    super(errorCode.name());
    setFriendlyMessage(friendlyMessage);
  }
}
