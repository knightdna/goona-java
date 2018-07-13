package net.knightdna.randomizer;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class RandomGeneratorUnitTest {

    private Random random;

    @Before
    public void setUp() {
        random = new Random(0L);
    }

    @After
    public void tearDown() {
        random = null;
    }

    @Test
    public void givenValidTemplate_whenGenerateNumberStringFromTemplate_thenShouldGenerateNumberString() {
        String template = "135XXXXX";
        String expectedNumberString = "13572655";

        String numberAsString = RandomGenerator.generateNumberStringFromTemplate(random, template);

        assertThat(numberAsString, is(notNullValue()));
        assertThat(numberAsString, is(equalTo(expectedNumberString)));
    }

    @Test
    public void givenValidTemplate_whenGenerateAlphanumericStringFromTemplate_thenShouldGenerateAlphanumericString() {
        String template = "ZZXXZZXXZZXXXZZZ";
        String expectedAlphanumericString = "TG65PI39WY211AOZ";

        String alphanumericString = RandomGenerator.generateAlphanumericStringFromTemplate(random, template);

        assertThat(alphanumericString, is(notNullValue()));
        assertThat(alphanumericString, is(equalTo(expectedAlphanumericString)));
    }

    @Test
    public void givenValidArraySizeAndSum_whenGenerateArrayOfDoublesWithSpecifiedSum_thenShouldGenerateArrayOfDoubles() {
        int arraySize = 10;
        double sumOfArray = 100.0;
        Double[] expectedItems = {
                11.63853078083742,
                3.8298411038766558,
                10.149014024001959,
                8.764104434704024,
                9.514166326734728,
                5.3055314694079705,
                6.133014697049134,
                15.680730092086195,
                13.998418224359321,
                14.986648846942591
        };

        Double[] generatedItems = toWrappedDoubles(
                RandomGenerator.generateArrayOfDoublesWithSpecifiedSum(random, arraySize, sumOfArray));

        assertThat(generatedItems, is(notNullValue()));
        assertThat(generatedItems.length, is(equalTo(arraySize)));

        double sumOfGeneratedItems = Stream.of(generatedItems)
                .mapToDouble(Double::doubleValue)
                .sum();
        assertThat(sumOfGeneratedItems, is(equalTo(sumOfArray)));
        assertThat(generatedItems, isEqualTo(expectedItems));
    }

    @Test
    public void givenVeryHighPercentageOfNull_whenGenerateNullSometimes_thenShouldGenerateNull() {
        int percentageOfNull = 99;
        Double validDouble = 99.99999;

        Double generatedDouble = RandomGenerator.generateNullSometimes(random, validDouble, percentageOfNull);

        assertThat(generatedDouble, is(nullValue()));
    }

    @Test
    public void givenVeryLowPercentageOfNull_whenGenerateNullSometimes_thenShouldNotGenerateNull() {
        int percentageOfNull = 1;
        Double validDouble = 99.99999;

        Double generatedDouble = RandomGenerator.generateNullSometimes(random, validDouble, percentageOfNull);

        assertThat(generatedDouble, is(notNullValue()));
        assertThat(generatedDouble, is(equalTo(validDouble)));
    }

    private static Double[] toWrappedDoubles(double[] primitiveDoubles) {
        return Arrays.stream(primitiveDoubles)
                .boxed()
                .toArray(Double[]::new);
    }

    private static Matcher<Double[]> isEqualTo(Double[] items) {
        List<Matcher<? super Double>> matchers = new ArrayList<>();
        for (Double item : items) {
            matchers.add(is(equalTo(item)));
        }
        return arrayContaining(matchers);
    }

}
