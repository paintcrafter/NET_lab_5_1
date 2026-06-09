package org.example;

public class Item {
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
