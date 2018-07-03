package net.knightdna.randomizer;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

@RequiredArgsConstructor(staticName = "of")
public class WeightedRandomizedCollection<E> {

    @Getter
    @NonNull
    protected String name;
    @Getter
    @NonNull
    protected Random random;
    protected double total = 0;
    @Getter
    protected NavigableMap<Double, E> map = new TreeMap<>();

    public WeightedRandomizedCollection<E> add(double weight, E entry) {
        if (weight <= 0) {
            return this;
        }
        total += weight;
        map.put(total, entry);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }

}
