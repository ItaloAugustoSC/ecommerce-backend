package com.general.ecommerce.exception;

/**
 * AbstractException for custom classes
 */
public abstract class AbstractException extends RuntimeException
{
  
  private String friendlyMessage;


  /**
   * @return friendlyMessage
   */
  public String getFriendlyMessage()
  {
    return friendlyMessage;
  }

  /**
   * @param friendlyMessage
   */
  public void setFriendlyMessage(String friendlyMessage)
  {
    this.friendlyMessage = friendlyMessage;
  }

  /**
   * @param msg
   */
  public AbstractException(String msg)
  {
    super(msg);
  }

  /**
   * @param errorMsg
   * @param err
   */
  public AbstractException(String errorMsg, Throwable err)
  {
    super(errorMsg,err);
  }

  public AbstractException(String errorMsg, String friendlyMessage) {
    super(errorMsg);
    this.friendlyMessage = friendlyMessage;
  }
}

