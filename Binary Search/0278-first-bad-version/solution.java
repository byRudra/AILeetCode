/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid is bad, so first bad version is
                // either mid or somewhere to the left
                right = mid;
            } else {
                // mid is good, so first bad version must be after mid
                left = mid + 1;
            }
        }

        return left;
    }
}