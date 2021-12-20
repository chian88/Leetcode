package DesignLoggerSystem;
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
		} else if (cache.get(message) <= timestamp) {
			cache.put(message, timestamp + 10);
			return true;
		} else {
			return false;
		}
	}
}
