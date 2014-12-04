package com.spotify.reaper.core;

import com.google.common.collect.Range;

import org.joda.time.DateTime;

import java.math.BigInteger;

public class RepairSegment {
  private Long id;
  private final ColumnFamily columnFamily;
  private final long runID;
  private final Range<BigInteger> tokenRange;
  private final State state;
  private final Range<DateTime> timeRange;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ColumnFamily getColumnFamily() {
    return columnFamily;
  }

  public long getRunID() {
    return runID;
  }

  public BigInteger getStartToken() {
    return tokenRange.lowerEndpoint();
  }

  public BigInteger getEndToken() {
    return tokenRange.upperEndpoint();
  }

  public State getState() {
    return state;
  }

  public DateTime getStartTime() {
    return timeRange.lowerEndpoint();
  }

  public DateTime getEndTime() {
    return timeRange.upperEndpoint();
  }

  public enum State {
    NOT_STARTED,
    RUNNING,
    DONE
  }

  private RepairSegment(Builder builder) {
    this.id = builder.id;
    this.columnFamily = builder.columnFamily;
    this.runID = builder.runID;
    this.tokenRange = Range.openClosed(builder.startToken, builder.endToken);
    this.state = builder.state;
    this.timeRange = Range.closed(builder.startTime, builder.endTime);
  }


  public static class Builder {
    private Long id;
    private ColumnFamily columnFamily;
    private long runID;
    private BigInteger startToken;
    private BigInteger endToken;
    private RepairSegment.State state;
    private DateTime startTime;
    private DateTime endTime;

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder columnFamily(ColumnFamily columnFamily) {
      this.columnFamily = columnFamily;
      return this;
    }

    public Builder runID(long runID) {
      this.runID = runID;
      return this;
    }

    public Builder startToken(BigInteger startToken) {
      this.startToken = startToken;
      return this;
    }

    public Builder endToken(BigInteger endToken) {
      this.endToken = endToken;
      return this;
    }

    public Builder state(RepairSegment.State state) {
      this.state = state;
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


    public RepairSegment build() {
      return new RepairSegment(this);
    }
  }


  @Override
  public String toString() {
    return String.format("(%s,%s]", tokenRange.lowerEndpoint().toString(), tokenRange.upperEndpoint().toString());
  }
}
