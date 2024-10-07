package BinarySearch;

import java.util.List;

public class BinarySearch {
    public static int find(List<Integer> numbers, int item) {
        int position = -1;
        int low = 0;
        int high = numbers.size() - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (numbers.get(mid) == item) {
                position = mid;
                break;
            } else if (numbers.get(mid) > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return position;
    }

}
