package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class ProblemTest {
    @Test
    void OneItemFits() {
        Problem problem = new Problem(5, 42);
        int capacity = 10;
        Problem.Result result = problem.solve(capacity);
        assertFalse(result.packedItems.isEmpty(), "Rozwiązanie powinno zawierać co najmniej jeden przedmiot");
        assertTrue(result.totalWeight > 0, "Sumaryczna waga powinna być większa od 0");
        assertTrue(result.totalValue > 0, "Sumaryczna wartość powinna być większa od 0");
    }

    @Test
    void NoItemFits() {
        Problem problem = new Problem(5, 42);
        int capacity = 0;
        Problem.Result result = problem.solve(capacity);
        assertTrue(result.packedItems.isEmpty(), "Rozwiązanie powinno być puste");
        assertEquals(0, result.totalValue, "Sumaryczna wartość ma być 0");
        assertEquals(0, result.totalWeight, "Sumaryczna wartość ma być 0");
    }

    @Test
    void ValueWeightFit(){
        int n = 100;
        int seed = 123;
        Problem problem = new Problem(n, seed);
        for (Problem.Item item : problem.items) {
            assertAll(
                    () -> assertTrue(item.value >= 1 && item.value <= 10,
                            "Wartość przedmiotu powinna być w zakresie 1-10"),
                    () -> assertTrue(item.weight >= 1 && item.weight <= 10,
                            "Waga przedmiotu powinna być w zakresie 1-10")
            );
        }
    }

    @Test
    void RightInstance(){
        int n = 0;
        int seed = 0;
        int capacity = 14;

        Problem problem = new Problem(n, seed);
        problem.items = new ArrayList<>(List.of(
                new Problem.Item(1,1, 4),
                new Problem.Item(2,9, 5),
                new Problem.Item(3,1, 6)
        ));

        Problem.Result result = problem.solve(capacity);
        assertAll(
                () -> assertEquals(3, result.packedItems.size(), "Powinny być zapakowane 3 przedmioty"),
                () -> assertEquals(19, result.totalValue, "Sumaryczna wartość powinna wynosić 19"),
                () -> assertEquals(14, result.totalWeight, "Sumaryczna waga powinna wynosić 14")
        );
    }
}