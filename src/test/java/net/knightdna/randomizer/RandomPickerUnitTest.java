package net.knightdna.randomizer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class RandomPickerUnitTest {

    @Test
    public void givenValidListAndValidNumberOfItems_whenPick_thenShouldReturnListOfPickedItemWithSizeEqualsToTheNumber() {
        long seedValue = 0L;
        Random random = new Random(seedValue);
        List<String> names = Arrays.asList("Alice", "Bob", "Charles", "David", "Ethan");
        int numberOfItems = 2;
        RandomPicker<String> picker = new RandomPicker<>();

        List<String> pickedItems = picker.pick(random, names, numberOfItems);

        assertThat(pickedItems, is(notNullValue()));
        assertThat(pickedItems.size(), is(equalTo(numberOfItems)));
        assertThat(pickedItems, contains("Alice", "David"));
    }

}
