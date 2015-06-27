package com.ep.helper;

import com.ep.Session;
import com.ep.Talk;

public class EventPlannerEngine {
	public static void main(String s[]) {
		Talk wt[] = { new Talk(1, 10), new Talk(1, 20), new Talk(1, 30) };
		int W = 60;
		EventPlannerEngine k = new EventPlannerEngine();
		Session w = k.knapSack(W, wt, wt.length);

		System.out.println(w.getTotalTalkValue());
		for (Talk t : w.getTalks()) {
			System.out.println(t.getDuration());
		}
	}

	Session knapSack(long W, Talk wt[], int n) {
		if (n == 0 || W == 0)
			return new Session(0l);
		if (wt[n - 1].getDuration() > W) {
			return knapSack(W, wt, n - 1);
		} else {
			Session a = knapSack(W - wt[n - 1].getDuration(), wt, n - 1);
			long a_a = wt[n - 1].getValue() + a.getTotalTalkValue();
			Session b = knapSack(W, wt, n - 1);
			long b_b = b.getTotalTalkValue();
			if (a_a > b_b) {
				a.getTalks().add(wt[n - 1]);
				return a;
			} else if (a_a == b_b) {
				a.getTalks().add(wt[n - 1]);
				if (a.getTotalTaskDuration() > b.getTotalTaskDuration())
					return a;
				else
					return b;
			} else {
				return b;
			}
		}
	}
}