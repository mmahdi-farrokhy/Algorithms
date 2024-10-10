import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Recursive {
    public static int arraySum(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        return numbers[0] + arraySum(Arrays.copyOfRange(numbers, 1, numbers.length));
    }

    public static int findMax(int[] numbers) {
        if (numbers.length == 2) {
            return numbers[0] > numbers[1] ?
                    numbers[0] :
                    numbers[1];
        }

        int subMax = findMax(Arrays.copyOfRange(numbers, 1, numbers.length));
        return numbers[0] > subMax ?
                numbers[0] :
                subMax;
    }

    public static int[] quickSort(int[] numbers) {
        if (numbers.length < 2) {
            return numbers;
        }

        int pivot = numbers[0];
        int[] numbersLessThanPivot = findNumbersLessThanPivot(numbers, pivot);
        int[] numbersMoreThanPivot = findNumbersMoreThanPivot(numbers, pivot);

        int[] sortedNumbers = new int[numbers.length];

        System.arraycopy(quickSort(numbersLessThanPivot), 0, sortedNumbers, 0, numbersLessThanPivot.length);
        sortedNumbers[numbersLessThanPivot.length] = pivot;
        System.arraycopy(quickSort(numbersMoreThanPivot), 0, sortedNumbers, numbersLessThanPivot.length + 1, numbersMoreThanPivot.length);
        return sortedNumbers;
    }

    private static int[] findNumbersLessThanPivot(int[] numbers, int pivot) {
        List<Integer> numbersLessThanPivot = new LinkedList<>();

        for (int number : numbers) {
            if (number < pivot) {
                numbersLessThanPivot.add(number);
            }
        }

        return numbersLessThanPivot.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] findNumbersMoreThanPivot(int[] numbers, int pivot) {
        List<Integer> numbersMoreThanPivot = new LinkedList<>();

        for (int number : numbers) {
            if (number > pivot) {
                numbersMoreThanPivot.add(number);
            }
        }

        return numbersMoreThanPivot.stream().mapToInt(Integer::intValue).toArray();
    }
}
