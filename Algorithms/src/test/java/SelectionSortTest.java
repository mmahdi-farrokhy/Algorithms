import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {
    private final int[] numbers = {12, 3, 54, 36, 87, 1};
    private final int[] ascendingNumbers = {1, 3, 12, 36, 54, 87};
    private final int[] descendingNumbers = {87, 54, 36, 12, 3, 1};

    @Test
    void sort_an_array_of_numbers_ascending() {
        int[] sortedNumbers = SelectionSort.sortAscending(numbers);
        Assertions.assertArrayEquals(sortedNumbers, ascendingNumbers);
    }

    @Test
    void sort_an_array_of_numbers_descending() {
        int[] sortedNumbers = SelectionSort.sortDescending(numbers);
        Assertions.assertArrayEquals(sortedNumbers, descendingNumbers);
    }
}
