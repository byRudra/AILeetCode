class Solution {

    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]); // path compression
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py)
                parent[px] = py;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        DSU dsu = new DSU(n);

        // Step 1: Union all allowed swaps
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        // Step 2: Group indices by component
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            map.putIfAbsent(parent, new HashMap<>());
            HashMap<Integer, Integer> freq = map.get(parent);

            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        // Step 3: Match with target
        int mismatch = 0;

        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            HashMap<Integer, Integer> freq = map.get(parent);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                mismatch++;
            }
        }

        return mismatch;
    }
}