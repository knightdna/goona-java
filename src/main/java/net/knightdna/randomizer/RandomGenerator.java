package net.knightdna.randomizer;

import java.util.Random;

public class RandomGenerator {

    /**
     * Generate a sequence of number [0..9] from the specified template
     *
     * @param random   Randomness object
     * @param template Template (e.g. 12xxx)
     * @return A valid sequence of number (all 'x' characters are replaced with 0..9),
     * e.g. 12472, 12399, 12032, etc.
     */
    public static String generateNumberStringFromTemplate(Random random, String template) {
        char characters[] = template.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == 'X' || characters[i] == 'x') {
                // 48 = "0" ... 57 = "9"
                characters[i] = (char) generateRandomInteger(random, 48, 57);
            }
        }
        return new String(characters);
    }

    /**
     * Generate a sequence of alphabetic and numeric characters [A..Z, 0..9] from the specified template
     *
     * @param random   Randomness object
     * @param template Template (e.g. ZZ XXXX ZZ)
     * @return A valid alphanumeric string (e.g. AG 1205 TA)
     * - All 'Z' characters are replaced with alphabetic characters
     * - All 'X' characters are replaced with numeric characters
     */
    public static String generateAlphanumericStringFromTemplate(Random random, String template) {
        char characters[] = template.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == 'X' || characters[i] == 'x') {
                // 48 = "0" ... 57 = "9"
                characters[i] = (char) generateRandomInteger(random, 48, 57);
            } else if (characters[i] == 'Z' || characters[i] == 'z') {
                // 65 = "A" ... 90 = "Z"
                characters[i] = (char) generateRandomInteger(random, 65, 90);
            }
        }
        return new String(characters);
    }

    /**
     * Generate array of doubles with a specified number of element and total sum of the doubles
     *
     * @param random     Randomness object
     * @param arraySize  Number of array's elements (e.g. 5)
     * @param sumOfArray Sum of array (e.g. 2.0)
     * @return Array of doubles having sum equals to the sum of array (e.g. [1.03, 0.2, 0.02, 0.5, 0.25])
     */
    public static double[] generateArrayOfDoublesWithSpecifiedSum(Random random, int arraySize, double sumOfArray) {
        double randomNumbers[] = new double[arraySize];
        double total = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextDouble();
            total += randomNumbers[i];
        }

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = randomNumbers[i] / total * sumOfArray;
        }

        return randomNumbers;
    }

    /**
     * Generate a random integer with specified lower and upper bound
     *
     * @param random     Randomness object
     * @param lowerBound Lower bound
     * @param upperBound Upper bound
     * @return A random integer between lower and upper bound (inclusive)
     */
    public static int generateRandomInteger(Random random, int lowerBound, int upperBound) {
        return (int) (random.nextDouble() * (1 + upperBound - lowerBound) + lowerBound);
    }

    /**
     * Generate a random boolean value with the specified percentage of true
     *
     * @param random           Randomness object
     * @param percentageOfTrue Valid percentage of true from 0-100
     * @return A boolean value where the frequency of the "true" boolean value follows the specified percentage
     */
    public static boolean generateRandomBoolean(Random random, int percentageOfTrue) {
        return generateRandomInteger(random, 0, 100) <= percentageOfTrue;
    }

    /**
     * Generate null value/object
     *
     * @param random           Randomness object
     * @param value            Value/object to be assigned if not null
     * @param percentageOfNull Percentage of null value
     * @param <T>              Type of the value/object
     * @return Null or value/object where the frequency of the "null" follows the specified percentage of null
     */
    public static <T> T generateNullSometimes(Random random, T value, int percentageOfNull) {
        return generateRandomBoolean(random, percentageOfNull) ? null : value;
    }

}
