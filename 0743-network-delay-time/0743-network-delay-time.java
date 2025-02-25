import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0]; // Source node
            int v = times[i][1]; // Destination node
            int w = times[i][2]; // Time taken
            adj.get(u).add(new Pair(v, w));
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Pair(0, k)); // (distance, node)

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int distance = curr.first;
            int node = curr.second;

            if (distance > dist[node]) continue;

            for (Pair it : adj.get(node)) {
                int adjnode = it.first;
                int delay = it.second;

                if (distance + delay < dist[adjnode]) {
                    dist[adjnode] = distance + delay;
                    pq.add(new Pair(dist[adjnode], adjnode));
                }
            }
        }

        // Find max distance
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) return -1; // Unreachable node
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}