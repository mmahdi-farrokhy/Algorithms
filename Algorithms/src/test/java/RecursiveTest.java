import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveTest {
    private final int[] numbers = {12, 3, 54, 36, 87, 1};
    private final int[] sortedNumbers = {1, 3, 12, 36, 54, 87};

    @Test
    void add_numbers_inside_an_array() {
        assertEquals(193, Recursive.arraySum(numbers));
    }

    @Test
    void find_the_maximum_number_in_an_array() {
        assertEquals(87, Recursive.findMax(numbers));
    }

    @Test
    void sort_an_array_of_numbers_using_quick_sort() {
        int[] actual = Recursive.quickSort(numbers);
        Assertions.assertArrayEquals(sortedNumbers, actual);
    }
}
