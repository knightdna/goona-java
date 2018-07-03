package net.knightdna.randomizer;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class WeightedRandomizedCollectionUnitTest {

    private WeightedRandomizedCollection<String> validRandomizedCollection;

    @Before
    public void setUp() {
        initValidWeightedRandomizedStringCollection();
    }

    private void initValidWeightedRandomizedStringCollection() {
        long seed = 0L;
        Random random = new Random(seed);
        validRandomizedCollection = WeightedRandomizedCollection.of("names", random);
        validRandomizedCollection.add(90.0, "Alice");
        validRandomizedCollection.add(7.5, "Bob");
        validRandomizedCollection.add(2.5, "Charles");
    }

    @Test
    public void givenValidWeightedRandomizedStringCollection_whenNext_thenShouldGetNextString() {
        // given
        assertThat(validRandomizedCollection, is(notNullValue()));

        // when
        String item = validRandomizedCollection.next();

        // then
        assertThat(item, is(notNullValue()));
        assertThat(item, is(equalTo("Alice")));
    }

}
