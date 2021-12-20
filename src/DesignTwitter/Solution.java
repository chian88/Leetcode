package DesignTwitter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class Twitter {
	Map<Integer, List<Integer>> following;
	Map<Integer, List<int[]>> tweetsStore;
	int id = 0;
	PriorityQueue<int[]> heap;
	public Twitter() {
		following = new HashMap<>();
		tweetsStore = new HashMap<>();

	}

	public void postTweet(int userId, int tweetId) {
		tweetsStore.putIfAbsent(userId, new ArrayList<>());
		tweetsStore.get(userId).add(new int[] {tweetId, id++});
	}

	public List<Integer> getNewsFeed(int userId) {
		heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		if (tweetsStore.containsKey(userId)) {
			heap.addAll(tweetsStore.get(userId));
		}

		List<Integer> follows = following.get(userId);

		if (follows != null) {
			for (int followId : follows) {
				if (tweetsStore.containsKey(followId)) {
					heap.addAll(tweetsStore.get(followId));
				}

			}
		}


		int counter = 0;
		Set<Integer> res = new LinkedHashSet<>();
		while (!heap.isEmpty() && counter < 10) {
			res.add(heap.poll()[0]);
			counter++;
		}

		return res.stream().collect(Collectors.toList());
	}

	public void follow(int followerId, int followeeId) {
		following.putIfAbsent(followerId, new ArrayList<>());
		following.get(followerId).add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		if (following.containsKey(followerId)) {
			following.get(followerId).remove(Integer.valueOf(followeeId));
		}

	}

	public static void main(String[] args) {
		Twitter test = new Twitter();
		test.postTweet(1,5);
		test.getNewsFeed(1);
		test.follow(1,2);
		test.postTweet(2,6);
		test.getNewsFeed(1);
		test.unfollow(1,2);
		test.getNewsFeed(1);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */