class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> revadj = new ArrayList<>();
        int[] inDegree = new int[V];

        // Initialize revadj list
        for (int i = 0; i < V; i++) {
            revadj.add(new ArrayList<>());
        }

        // Reverse the graph: Create an adjacency list for the reverse graph
        for (int i = 0; i < V; i++) {
            for (int neighbor : graph[i]) {
                revadj.get(neighbor).add(i);
                inDegree[i]++; // Count in-degree
            }
        }

        // Topological sorting using Kahn’s algorithm (BFS approach)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int neighbor : revadj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        Collections.sort(safeNodes); // Ensure the output is sorted
        return safeNodes;
    }
}
