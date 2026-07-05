package binary.search;

public class FlowerBouquet {

    public static void main(String[] args) {
        int[] bloomDays = {1, 10, 3, 10, 2};
        int bouquets = 3;
        int consecutive = 1;
        int capacity = findMinimumBloomDaysForBouquets(bloomDays, bouquets, consecutive);
        System.out.println(capacity);
    }

    public static int findMinimumBloomDaysForBouquets(int[] bloomDays, int bouquets, int consecutives) {
        int left = 0;
        int right = 0;
        for (int weight : bloomDays) {
            right += Math.max(right, weight);
            left = Math.min(left, weight);
        }
        int minCapacity = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(bloomDays, mid, bouquets, consecutives)) {
                minCapacity = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minCapacity;
    }

    public static boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int consecutiveFlowers = 0;
        int bouquetsMade = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (day >= bloomDay[i]) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquetsMade++;
                    consecutiveFlowers = 0;
                }
                if (bouquetsMade >= m) {
                    return true;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }
        return false;
    }
}
