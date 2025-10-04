package org.openjfx.DzMath;

public class SupportingFunctions {
    public static int binarySearch(int[] array, double n) {
        int low = 0;
        int high = array.length - 1;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (array[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (normalFunction.absoluteValue(array[high] - n) < normalFunction.absoluteValue(array[low] - n)) {
            return high;
        } else {
            return low;
        }
    }

    public static double summation(double... n) {
        double sum = 0;
        for (int i = 0; i <= n.length - 1; i++) {
            sum += n[i];
        }
        return sum;
    }
}
