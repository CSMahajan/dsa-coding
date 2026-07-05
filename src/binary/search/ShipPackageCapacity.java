package binary.search;

public class ShipPackageCapacity {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int capacity = findMinimumShipCapacity(weights, days);
        System.out.println(capacity);
    }

    public static int findMinimumShipCapacity(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        int minCapacity = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(weights, days, mid)) {
                minCapacity = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minCapacity;
    }

    public static boolean isPossible(int[] weights, int days, int capacity) {
        int currentCapacityLoaded = 0;
        int currentDays = 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + currentCapacityLoaded <= capacity) {
                currentCapacityLoaded += weights[i];
            } else {
                currentDays++;
                currentCapacityLoaded = weights[i];
            }
        }
        return currentDays <= days;
    }
}