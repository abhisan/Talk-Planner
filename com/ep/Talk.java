package com.ep;

public class Talk {
	public static Talk small = new Talk(1, 5);
	private Integer value = 1;
	private long duration;
	private Integer talkId;
	private long startTime;
	
	public Talk(int talkId, long duration) {
		this.duration = duration;
		this.talkId = talkId;
	}

	public long getDuration() {
		return duration;
	}

	public Integer getTalkId() {
		return talkId;
	}

	public int getValue() {
		return value;
	}
	
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@Override
	public boolean equals(Object talk) {
		return this.talkId == ((Talk)talk).getTalkId();
	}
}
