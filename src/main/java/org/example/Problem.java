package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    public int n;
    public List<Item> items;

    public Problem(int n, int seed) {
        this.n = n;
        items = new ArrayList<>();

        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(1, 11);
            int weight = random.nextInt(1, 11);
            items.add(new Item(i+1, value, weight));
        }
    }

    public Result solve(int capacity) {
        items.sort((a, b) -> Double.compare(b.ratio(), a.ratio()));
        Result result = new Result();
            for (Item item : items) {
                while (capacity > 0) {
                    if (item.weight > capacity) break;
                    result.packedItems.add(new Item(item.id, item.value, item.weight));
                    result.totalValue += item.value;
                    result.totalWeight += item.weight;
                    capacity -= item.weight;
                }
            }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
