package DesignBrowserHistory;
import java.util.*;

class BrowserHistory {
	int currId = 0;
	int maxId = 0;
	Map<Integer, String> history = new HashMap<>();

	public BrowserHistory(String homepage) {
		history.put(currId, homepage);
		maxId = currId;
	}

	public void visit(String url) {
		currId++;
		history.put(currId, url);
		maxId = currId;
	}

	public String back(int steps) {
		currId = Math.max(0, currId - steps);
		String url = history.get(currId);
		return url;
	}

	public String forward(int steps) {
		currId = Math.min(maxId, currId + steps);
		String url = history.get(currId);
		return url;
	}

	public static void main(String[] args) {
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
		browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
		browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
		browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
		browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
		browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
		browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
		browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com
	}
}



/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */