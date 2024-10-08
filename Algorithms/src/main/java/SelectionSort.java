import java.util.LinkedList;
import java.util.List;

public class SelectionSort {
    public static int[] sortAscending(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int minimumIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (numbers[j] < numbers[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            if (minimumIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minimumIndex];
                numbers[minimumIndex] = temp;
            }
        }

        return numbers;
    }

    public static int[] sortDescending(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int minimumIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (numbers[j] > numbers[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            if (minimumIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minimumIndex];
                numbers[minimumIndex] = temp;
            }
        }

        return numbers;
    }
}
