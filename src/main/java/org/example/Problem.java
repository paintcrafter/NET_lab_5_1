package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    public int n;
    public int seed;
    public List<Item> items;

    public static class Item {
        int id;
        int value;
        int weight;

        Item(int id, int value, int weight) {
            this.id = id;
            this.value = value;
            this.weight = weight;
        }

        double ratio() {
            return (double) value / weight;
        }

        @Override
        public String toString() {
            return String.format("%d. wartość=%d, waga=%d", id, value, weight);
        }
    }

    public Problem(int n, int seed) {
        this.n = n;
        this.seed = seed;
        this.items = new ArrayList<>();

        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(1, 11);
            int weight = random.nextInt(1, 11);
            items.add(new Item(i+1, value, weight));
        }
    }

    public static class PackedItem {
        int index;
        int value;
        int weight;


        public PackedItem(int index, int value, int weight) {
            this.index = index;
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("Przedmiot %d: wartość=%d, waga=%d", index, value, weight);
        }
    }

    public static class Result {
        List<PackedItem> packedItems = new ArrayList<>();
        int totalValue = 0;
        int totalWeight = 0;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Wynik plecakowy:\n");
            for (PackedItem item : packedItems) {
                sb.append(item).append("\n");
            }
            sb.append("Łączna wartość: ").append(totalValue).append("\n");
            sb.append("Łączna waga: ").append(totalWeight).append("\n");
            return sb.toString();
        }
    }

    public Result solve(int capacity) {
        items.sort((a, b) -> Double.compare(b.ratio(), a.ratio()));
        Result result = new Result();
        int remainingCapacity = capacity;
            for (Item item : items) {
                while (remainingCapacity > 0) {
                    if (item.weight > remainingCapacity) break;
                    result.packedItems.add(new PackedItem(item.id, item.value, item.weight));
                    result.totalValue += item.value;
                    result.totalWeight += item.weight;
                    remainingCapacity -= item.weight;
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
