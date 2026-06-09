package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<Item> packedItems = new ArrayList<>();
    int totalValue = 0;
    int totalWeight = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wynik plecakowy:\n");
        for (Item item : packedItems) {
            sb.append(item).append("\n");
        }
        sb.append("Łączna wartość: ").append(totalValue).append("\n");
        sb.append("Łączna waga: ").append(totalWeight).append("\n");
        return sb.toString();
    }
}
