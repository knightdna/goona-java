package net.knightdna.randomizer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPicker<T> {

    /**
     * Pick items randomly from a List
     *
     * @param random              Random object
     * @param items               List containing the items to be picked
     * @param numberOfPickedItems Number of items to be picked
     * @return List of randomly picked items
     */
    public List<T> pick(Random random, List<T> items, int numberOfPickedItems) {
        return IntStream
                .generate(() -> random.nextInt(items.size()))
                .distinct()
                .limit(numberOfPickedItems)
                .mapToObj(items::get)
                .collect(Collectors.toList());
    }

}
