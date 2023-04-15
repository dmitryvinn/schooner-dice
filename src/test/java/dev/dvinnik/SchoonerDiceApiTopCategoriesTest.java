package dev.dvinnik;

import dev.dvinnik.core.Category;
import dev.dvinnik.core.DiceApi;
import dev.dvinnik.core.SchoonerDiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test class for Top Category method
 *
 * I kept the test cases to a bare minimum here since I tested scorring method very extensively.
 */
public class SchoonerDiceApiTopCategoriesTest extends DiceApiTest {
    private static final String GENERIC_ERROR_MESSAGE = "Incorrect top categories for the dice rolls";

    @Override
    DiceApi initializeTestService() {
        return new SchoonerDiceApi();
    }

    @Test
    void testTopCategoriesWithOnesThroughFivesCategoriesOccurrencesSequentially() {
        final List<Integer> diceRolls = List.of(1, 2, 3, 4, 5);

        final List<Category> listOfCategories = diceApi.topCategories(diceRolls);

        Assertions.assertEquals(List.of(Category.LARGE_STRAIGHT), listOfCategories, GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testTopCategoriesWithAllSameOccurrences() {
        final List<Integer> diceRolls = List.of(5, 5, 5, 5, 5);
        final List<Category> listOfCategories = diceApi.topCategories(diceRolls);
        Assertions.assertEquals(List.of(Category.SCHOONER), listOfCategories, GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testTopCategoriesWithAllSameOccurrencesButOne() {
        final List<Integer> diceRolls = List.of(5, 4, 5, 5, 5);
        final List<Category> listOfCategories = diceApi.topCategories(diceRolls);
        Assertions.assertEquals(List.of(Category.THREE_OF_A_KIND, Category.FOUR_OF_A_KIND, Category.CHANCE),
                listOfCategories, GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testTopCategoriesWithFullHouseOnly() {
        final List<Integer> diceRolls = List.of(1, 2, 2, 1, 1);
        final List<Category> listOfCategories = diceApi.topCategories(diceRolls);
        Assertions.assertEquals(List.of(Category.FULL_HOUSE),
                listOfCategories, GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testTopCategoriesWithThreeOfAKind() {
        final List<Integer> diceRolls = List.of(3, 3, 3, 6, 7);
        final List<Category> listOfCategories = diceApi.topCategories(diceRolls);
        Assertions.assertEquals(List.of(Category.THREE_OF_A_KIND, Category.CHANCE),
                listOfCategories, GENERIC_ERROR_MESSAGE);
    }
}
