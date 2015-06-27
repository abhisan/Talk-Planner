package com.em.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ep.EventPlanner;
import com.ep.Session;
import com.ep.Talk;
import com.ep.Track;

public class TestEventPlanner {

	@Test
	public void testPlanEvents() {
		List<Track> tracks = new ArrayList<Track>();
		tracks.add(createTrack(1, createSessions()));
		tracks.add(createTrack(2, createSessions()));
		EventPlanner ev = new EventPlanner(tracks);
		List<Talk> tasks = new ArrayList<Talk>();
		tasks.add(new Talk(2, 10l));
		tasks.add(new Talk(3, 20l));
		tasks.add(new Talk(4, 30l));
		List<Track> plannedTracks = ev.planEvents(tasks);

	}

	private Track createTrack(int trackId, List<Session> session) {
		Track t = new Track(trackId, session);
		return t;
	}

	private List<Session> createSessions() {
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(Session.MORNING_SESSION);
		sessions.add(Session.EVENING_SESSION);
		return sessions;
	}
}
