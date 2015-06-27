package com.ep;

import java.util.List;

public class Track {
	private int trackId;
	private List<Session> sessions;

	public Track(int trackId, List<Session> session) {
		this.trackId = trackId;
		this.sessions = session;
	}

	public int getTrackId() {
		return trackId;
	}

	public List<Session> getSessions() {
		return sessions;
	}

}
