package LoggerRateLimiter;
import java.util.*;
class Logger {
	Map<String, Integer> cache;
	public Logger() {
		cache = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!cache.containsKey(message)) {
			cache.put(message, timestamp + 10);
			return true;
		}

		int timeLimit = cache.get(message);

		if (timeLimit <= timestamp) {
			cache.put(message, timestamp + 10);
			return true;
		} else {
			return false;
		}
	}
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */