class Pair {
    long dist;
    int node;
    Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        long[] dist = new long[n];
        int[] ways = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }

        for (int[] x : roads) {
            int u = x[0];
            int v = x[1];
            int z = x[2];
            adj.get(u).add(new Pair(z, v));
            adj.get(v).add(new Pair(z, u)); 
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            long d = p.dist;
            int u = p.node;

            if (d > dist[u]) continue; 
            for (Pair nbr : adj.get(u)) {
                int v = nbr.node;
                long time = nbr.dist;

                if (d + time < dist[v]) {
                    dist[v] = d + time;
                    ways[v] = ways[u];
                    pq.add(new Pair(dist[v], v));
                } else if (d + time == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
