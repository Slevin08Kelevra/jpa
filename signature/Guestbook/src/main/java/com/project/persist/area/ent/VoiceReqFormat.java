package com.project.persist.area.ent;

import java.util.List;

public class VoiceReqFormat {
  
  private String message;
  private List<String> otherPossibleMessages;

  public List<String> getOtherPossibleMessages() {
    return otherPossibleMessages;
  }

  public void setOtherPossibleMessages(List<String> otherPossibleMessages) {
    this.otherPossibleMessages = otherPossibleMessages;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
