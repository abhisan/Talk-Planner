package com.ep;

import java.util.ArrayList;
import java.util.List;

public class Session {
	public static Session MORNING_SESSION = new Session(3 * 60);
	public static Session EVENING_SESSION = new Session(4 * 60);
	private List<Talk> talks = new ArrayList<Talk>();
	private long duration;

	public Session(long duration) {
		this.duration = duration;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public long getDuration() {
		return duration;
	}

	public long getTotalTaskDuration() {
		long duration = 0;
		for (Talk t : talks) {
			duration += t.getDuration();
		}
		return duration;
	}

	public long getTotalTalkValue() {
		long value = 0;
		for (Talk t : talks) {
			value += t.getValue();
		}
		return value;
	}
}
