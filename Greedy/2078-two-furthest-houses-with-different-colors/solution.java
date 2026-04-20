class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        // going forward with fixed end
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[colors.length - 1]) {
                max = Math.max(max, colors.length - 1 - i);
            }
        }

        // going backward with fixed start
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[0] != colors[i]) {
                max = Math.max(max, i - 0);
            }
        }

        return max;
    }
}