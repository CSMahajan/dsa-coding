package binary.search;

public class KokoBanana {

    public static void main(String[] args) {
        int[] piles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int hours = 15;
        int minEatingSpeed = minHours(piles, hours);
        System.out.println(minEatingSpeed);
    }

    public static boolean isPossible(int[] piles, int k, int maxHours) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return maxHours >= hours;
    }

    public static int minHours(int[] piles, int maxHours) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int minHours = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(piles, mid, maxHours)) {
                minHours = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minHours;
    }
}
