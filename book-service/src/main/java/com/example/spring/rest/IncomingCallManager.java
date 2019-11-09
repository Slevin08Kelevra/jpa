package com.example.spring.rest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class IncomingCallManager {

  private Integer lineCount;
  private BlockingQueue<Call> calls;

  @Autowired
  public IncomingCallManager(@Value("${app.available.lines}") final Integer lCount) {
    this.lineCount = lCount;
    this.calls = new ArrayBlockingQueue<Call>(lCount);
  }

  public void storeIncomingCall(Call call) {

    if (calls.offer(call)) {
      System.out.println("call added to queue, automatic response asking to wait");
    } else {
      System.out.println("No line available, please call later.");
    }

  }

  public Call retriveCall() {
    Call call = calls.poll();
    return call;
  }

  public Integer getLineCount() {
    return lineCount;
  }

  public void setLineCount(Integer lineCount) {
    this.lineCount = lineCount;
  }

  public BlockingQueue<?> getCalls() {
    return calls;
  }

  public void setCalls(BlockingQueue<Call> calls) {
    this.calls = calls;
  }

}
