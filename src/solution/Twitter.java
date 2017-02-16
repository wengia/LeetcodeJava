package solution;

import java.util.*;

/* Twitter - Medium */
public class Twitter {
	private HashMap<Integer, Tweet> users = new HashMap<>();
	private HashMap<Integer, Set<Integer>> followers = new HashMap<>(); // Key followed Values
	private int timeStamp = 0;
	private int capacity = 10;

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(timeStamp++, tweetId);
        if (users.containsKey(userId))
        	newTweet.next = users.get(userId);
        	
        users.put(userId, newTweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	LinkedList<Integer> res = new LinkedList<>();
    	
    	// Merge all tweets
    	Tweet mergeT = mergeTweets(null, users.get(userId));
    	if (followers.containsKey(userId)) {
	    	for(Integer followee: followers.get(userId))
	    		mergeT = mergeTweets(mergeT, users.get(followee));
    	}
    	
    	int count = capacity;
    	while(mergeT != null && count-- > 0) {
    		res.add(mergeT.tweetId);
    		mergeT = mergeT.next;
    	}
    	
    	return res;
    }
    
    // Merge l2 to l1 and return l1 head
    private Tweet mergeTweets(Tweet l1, Tweet l2) {
    	if (l2 == null) return l1;
    	
    	Tweet dummyHead = new Tweet(-1, -1), pos = dummyHead;
    	dummyHead.next = l1;
    	int count = capacity;
    	while(pos.next != null && l2 != null && count-- > 0) {
    		if (pos.next.order < l2.order) {
    			Tweet cp = new Tweet(l2.order, l2.tweetId);
    			cp.next = pos.next;
    			pos.next = cp;
    			l2 = l2.next;
    		}
    		pos = pos.next;
    	}
    	
    	while(l2 != null && count-- > 0) {
			pos.next = new Tweet(l2.order, l2.tweetId);
			pos = pos.next;
			l2 = l2.next;
		}
    		
    	return dummyHead.next;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (followerId == followeeId) return;
    	if (!followers.containsKey(followerId)) {
    		followers.put(followerId, new HashSet<Integer>());
    	}
    	followers.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (!followers.containsKey(followerId)) return;
        followers.get(followerId).remove(followeeId);
    }
    
    private class Tweet {
    	int order;
    	int tweetId;
    	Tweet next;
    	
    	Tweet(int order, int tweetId) {
    		this.order = order;
    		this.tweetId = tweetId;
    	}
    }
}
