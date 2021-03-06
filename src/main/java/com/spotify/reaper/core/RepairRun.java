package com.spotify.reaper.core;

import org.joda.time.DateTime;

import java.util.List;

public class RepairRun {

  private final long id;

  // IDEA: maybe we want to have start and stop token for parallel runners on same repair run?
  //private final long startToken;
  //private final long endToken;

  private final String cause;
  private final String owner;
  private final State state;
  private final DateTime creationTime;
  private final DateTime startTime;
  private final DateTime endTime;
  private final double intensity;

  public long getId() {
    return id;
  }

  public String getCause() {
    return cause;
  }

  public String getOwner() {
    return owner;
  }

  public State getState() {
    return state;
  }

  public DateTime getCreationTime() {
    return creationTime;
  }

  public DateTime getStartTime() {
    return startTime;
  }

  public DateTime getEndTime() {
    return endTime;
  }

  public double getIntensity() {
    return intensity;
  }

  public enum State {
    NOT_STARTED,
    RUNNING,
    DONE,
    PAUSED
  }

  private RepairRun(Builder builder) {
    this.id = builder.id;
    this.cause = builder.cause;
    this.owner = builder.owner;
    this.state = builder.state;
    this.creationTime = builder.creationTime;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.intensity = builder.intensity;
  }

  public static class Builder {

    private Long id;
    private String cause;
    private String owner;
    private State state;
    private DateTime creationTime;
    private DateTime startTime;
    private DateTime endTime;
    private double intensity;

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder cause(String cause) {
      this.cause = cause;
      return this;
    }

    public Builder owner(String owner) {
      this.owner = owner;
      return this;
    }

    public Builder state(State state) {
      this.state = state;
      return this;
    }

    public Builder creationTime(DateTime creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    public Builder startTime(DateTime startTime) {
      this.startTime = startTime;
      return this;
    }

    public Builder endTime(DateTime endTime) {
      this.endTime = endTime;
      return this;
    }

    public Builder intensity(double intensity) {
      this.intensity = intensity;
      return this;
    }

    public RepairRun build() {
      return new RepairRun(this);
    }
  }
}
