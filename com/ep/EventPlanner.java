package com.ep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPlanner {
	private List<Track> tracks;

	public EventPlanner(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Track> planEvents(List<Talk> talks) {
		for (Track track : tracks) {
			for (Session session : track.getSessions()) {
				session = knapSack(session.getDuration(), talks, talks.size());
				removePlannedTalk(talks, session.getTalks());
			}
		}
		return tracks;
	}

	private void removePlannedTalk(List<Talk> talks, List<Talk> plannedTalks) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < talks.size(); i++) {
			map.put(talks.get(i).getTalkId(), i);
		}
		for (int i = 0; i < plannedTalks.size(); i++) {
			if (map.containsKey(plannedTalks.get(i))) {
				talks.remove(map.get(plannedTalks.get(i)));
			}
		}
	}

	public Session knapSack(long w, List<Talk> wt, int n) {
		if (n == 0 || w == 0)
			return new Session(0l);
		if (wt.get(n - 1).getDuration() > w) {
			return knapSack(w, wt, n - 1);
		} else {
			Session a = knapSack(w - wt.get(n - 1).getDuration(), wt, n - 1);
			long a_a = wt.get(n - 1).getValue() + a.getTotalTalkValue();
			Session b = knapSack(w, wt, n - 1);
			long b_b = b.getTotalTalkValue();
			if (a_a > b_b) {
				a.getTalks().add(wt.get(n - 1));
				return a;
			} else if (a_a == b_b) {
				a.getTalks().add(wt.get(n - 1));
				if (a.getTotalTaskDuration() < b.getTotalTaskDuration())
					return a;
				else
					return b;
			} else {
				return b;
			}
		}
	}
}
