class Twitter {
    class Tweet{
        int id;
        int time;
        Tweet next;
        Tweet(int i , int t){
            id = i;
            time = t;
            next = null;
        }
    }
    HashMap<Integer,Tweet> tweetMap;
    HashMap<Integer,Set<Integer>> followMap;
    int time = 0;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId,time++);
        t.next = tweetMap.get(userId);
        tweetMap.put(userId,t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);
        follow(userId,userId);
        for(int followee: followMap.get(userId)){
            if(tweetMap.containsKey(followee)){
                pq.add(tweetMap.get(followee));
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size()<10){
            Tweet curr = pq.poll();
            res.add(curr.id);
            if(curr.next!=null){
                pq.add(curr.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
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