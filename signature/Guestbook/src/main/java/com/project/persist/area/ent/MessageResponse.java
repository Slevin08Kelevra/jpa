package com.project.persist.area.ent;

public class MessageResponse {
  
  private String status;
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getOperationDescription() {
    return operationDescription;
  }
  public void setOperationDescription(String operationDescription) {
    this.operationDescription = operationDescription;
  }
  private String operationDescription;

}
