package dev.dvinnik;

import dev.dvinnik.core.Category;
import dev.dvinnik.core.DiceApi;
import dev.dvinnik.core.SchoonerDiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Schooner Dice API test class for validating scoring method.
 *
 * I generally like to do TDD in my work, so I went a bit extensive.
 * I would generally attempt to spend more time on comments above each test case to document Expected and Actual results,
 * but for keeping my work to the bare minimum, I emphasized naming my test cases and writing the cases in a readable manner
 */
public class SchoonerDiceApiScoreTest extends DiceApiTest {

    private static final String GENERIC_ERROR_MESSAGE = "Incorrect score for the category";

    @Override
    DiceApi initializeTestService() {
        return new SchoonerDiceApi();
    }

    /**
     * Tests for Category: Ones
     */
    @Test
    void testScoreForOnesCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.ONES, 1, List.of(1, 1, 2, 3, 4));
    }

    @Test
    void testScoreForOnesCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.ONES, List.of(2, 2, 2, 2, 4));
    }

    @Test
    void testScoreForOnesCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.ONES, 1, List.of(2, 2, 2, 3, 1));
    }

    /**
     * Tests for Category: Twos
     */
    @Test
    void testScoreForTwosCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.TWOS, 2, List.of(1, 2, 2, 3, 4));
    }

    @Test
    void testScoreForTwosCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.TWOS, List.of(1, 4, 3, 4, 4));
    }

    @Test
    void testScoreForTwosCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.TWOS, 2, List.of(3, 2, 1, 3, 1));
    }

    /**
     * Tests for Category: Threes
     */
    @Test
    void testScoreForThreesCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.THREES, 3, List.of(3, 2, 2, 3, 4));
    }

    @Test
    void testScoreForThreesCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.THREES, List.of(1, 4, 2, 4, 4));
    }

    @Test
    void testScoreForThreesCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.THREES, 3, List.of(3, 2, 1, 1, 1));
    }

    /**
     * Tests for Category: Fours
     */
    @Test
    void testScoreForFoursCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.FOURS, 4, List.of(3, 2, 4, 3, 4));
    }

    @Test
    void testScoreForFoursCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.FOURS, List.of(3, 2, 2, 3, 1));
    }

    @Test
    void testScoreForFoursCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.FOURS, 4, List.of(3, 2, 1, 1, 4));
    }

    /**
     * Tests for Category: Fives
     */
    @Test
    void testScoreForFivesCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.FIVES, 5, List.of(5, 2, 5, 3, 4));
    }

    @Test
    void testScoreForFivesCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.FIVES, List.of(3, 2, 2, 3, 1));
    }

    @Test
    void testScoreForFivesCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.FIVES, 5, List.of(5, 2, 1, 1, 4));
    }

    /**
     * Tests for Category: Sixes
     */
    @Test
    void testScoreForSixesCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.SIXES, 6, List.of(5, 6, 5, 3, 6));
    }

    @Test
    void testScoreForSixesCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.SIXES, List.of(3, 2, 2, 3, 1));
    }

    @Test
    void testScoreForSixesCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.SIXES, 6, List.of(5, 6, 1, 1, 4));
    }

    /**
     * Tests for Category: Sevens
     */
    @Test
    void testScoreForSevensCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.SEVENS, 7, List.of(7, 6, 7, 3, 6));
    }

    @Test
    void testScoreForSevensCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.SEVENS, List.of(3, 2, 2, 3, 1));
    }

    @Test
    void testScoreForSevensCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.SEVENS, 7, List.of(5, 7, 1, 1, 4));
    }

    /**
     * Tests for Category: Eights
     */
    @Test
    void testScoreForEightsCategoryWithSeveralOccurrences() {
        testScoreForSingleCategoryWithSeveralOccurrences(Category.EIGHTS, 8, List.of(7, 6, 8, 3, 8));
    }

    @Test
    void testScoreForEightsCategoryWithNoOccurrences() {
        testScoreForSingleCategoryWithNoOccurrences(Category.EIGHTS, List.of(3, 2, 2, 3, 1));
    }

    @Test
    void testScoreForEightsCategoryWithOneOccurrence() {
        testScoreForSingleCategoryWithOneOccurrence(Category.EIGHTS, 8, List.of(5, 7, 1, 8, 4));
    }

    /**
     * Tests for Category: Three of Kind
     */

    @Test
    void testScoreForThreeOfKindCategoryWithSingleOccurrence() {

        final List<Integer> testDiceRolls = List.of(1, 2, 4, 2, 2);
        // Should be a sum of all dice
        final int expectedScore = testDiceRolls.stream().mapToInt(Integer::intValue).sum();
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.THREE_OF_A_KIND, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForThreeOfKindCategoryWithNoOccurrence() {

        final List<Integer> testDiceRolls = List.of(1, 2, 4, 2, 1);
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.THREE_OF_A_KIND, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: Four of Kind
     */
    @Test
    void testScoreForFourOfKindCategoryWithSingleOccurrence() {

        final List<Integer> testDiceRolls = List.of(4, 4, 4, 4, 2);
        // Should be a sum of all dice
        final int expectedScore = testDiceRolls.stream().mapToInt(Integer::intValue).sum();
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.FOUR_OF_A_KIND, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForFourOfKindCategoryWithNoOccurrence() {
        final List<Integer> testDiceRolls = List.of(1, 1, 4, 2, 1);
        // Should be default value
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.FOUR_OF_A_KIND, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: Full House
     */
    @Test
    void testScoreForFullHouseCategoryWithSingleOccurrence() throws Exception {

        final List<Integer> testDiceRolls = List.of(4, 4, 4, 2, 2);
        final Category testCategory = Category.FULL_HOUSE;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForFullHouseCategoryWithNoOccurrence() {

        final List<Integer> testDiceRolls = List.of(4, 1, 4, 2, 2);
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.FULL_HOUSE, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForFullHouseCategoryWithFourDuplicateOccurrences() {

        final List<Integer> testDiceRolls = List.of(4, 4, 4, 4, 1);
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.FULL_HOUSE, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: Small Straight
     */
    @Test
    void testScoreForSmallStraightCategoryWithSingleOrderedOccurrence() throws Exception {
        final List<Integer> testDiceRolls = List.of(1, 2, 3, 4, 3);
        final Category testCategory = Category.SMALL_STRAIGHT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForSmallStraightCategoryWithSingleUnorderedOccurrence() throws Exception {
        final List<Integer> testDiceRolls = List.of(2, 3, 1, 4, 3);
        final Category testCategory = Category.SMALL_STRAIGHT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForSmallStraightCategoryWithSingleOccurrenceAndDuplicates() throws Exception {
        final List<Integer> testDiceRolls = List.of(2, 3, 1, 4, 2);
        final Category testCategory = Category.SMALL_STRAIGHT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForSmallStraightCategoryWithSingleOccurrenceAfterNonSequentialNumber() throws Exception {
        final List<Integer> testDiceRolls = List.of(1, 3, 4, 5, 6);
        final Category testCategory = Category.SMALL_STRAIGHT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForSmallStraightCategoryWithNoOccurrence() {
        final List<Integer> testDiceRolls = List.of(7, 4, 1, 4, 3);
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.SMALL_STRAIGHT, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: Large Straight
     */
    @Test
    void testScoreForLargeStraightCategoryWithSingleOrderedOccurrence() throws Exception {
        final List<Integer> testDiceRolls = List.of(1, 2, 3, 4, 5);
        final Category testCategory = Category.LARGE_STRAIGHT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForLargeStraightCategoryWithSingleUnorderedOccurrence() throws Exception {
        final List<Integer> testDiceRolls = List.of(2, 3, 1, 4, 5);
        final Category testCategory = Category.LARGE_STRAIGHT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForLargeStraightCategoryWithNoOccurrence() {
        final List<Integer> testDiceRolls = List.of(7, 4, 1, 4, 3);
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.LARGE_STRAIGHT, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: All Different
     */
    @Test
    void testScoreForAllDifferentCategoryWithNoDuplicates() throws Exception {
        final List<Integer> testDiceRolls = List.of(1, 2, 3, 4, 5);
        final Category testCategory = Category.ALL_DIFFERENT;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForAllDifferentCategoryWithSingleDuplicate() {
        final List<Integer> testDiceRolls = List.of(1, 2, 3, 3, 5);
        final Category testCategory = Category.ALL_DIFFERENT;
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForAllDifferentCategoryWithAllDuplicates() {
        final List<Integer> testDiceRolls = List.of(3, 3, 3, 3, 3);
        final Category testCategory = Category.ALL_DIFFERENT;
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: Schooner
     */
    @Test
    void testScoreForSchoonerCategoryWithAllDuplicates() throws Exception {
        final List<Integer> testDiceRolls = List.of(4, 4, 4, 4, 4);
        final Category testCategory = Category.SCHOONER;
        final int expectedScore = testCategory.getConstantDiceScore();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForSchoonerCategoryWithAllDifferentValues() {
        final List<Integer> testDiceRolls = List.of(1, 2, 3, 4, 5);
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(Category.SCHOONER, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForSchoonerCategoryWithAllDuplicatesButOne() {
        final List<Integer> testDiceRolls = List.of(5, 5, 5, 5, 2);
        final Category testCategory = Category.SCHOONER;
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    /**
     * Tests for Category: Chance
     */
    @Test
    void testScoreForChanceCategoryWithNoDuplicates() {
        final List<Integer> testDiceRolls = List.of(1, 2, 3, 5, 6);
        final Category testCategory = Category.CHANCE;
        final int expectedScore = testDiceRolls.stream().mapToInt(Integer::intValue).sum();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    @Test
    void testScoreForChanceCategoryWithDuplicates() {
        final List<Integer> testDiceRolls = List.of(1, 1, 1, 1, 1);
        final Category testCategory = Category.CHANCE;
        final int expectedScore = testDiceRolls.stream().mapToInt(Integer::intValue).sum();
        Assertions.assertEquals(expectedScore,
                diceApi.score(testCategory, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }


    /**
     * Utilities
     */

    void testScoreForSingleCategoryWithSeveralOccurrences(final Category category,
                                                          int categoryMultiplier,
                                                          final List<Integer> testDiceRolls) {
        // Number of category occurrences in the test array  multiplied by a category value
        final int expectedScore = 2 * categoryMultiplier;
        Assertions.assertEquals(expectedScore,
                diceApi.score(category, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }

    void testScoreForSingleCategoryWithOneOccurrence(final Category category,
                                                     int categoryMultiplier,
                                                     final List<Integer> testDiceRolls) {
        // Number of category occurrences in the test array  multiplied by a category value
        final int expectedScore = categoryMultiplier;
        Assertions.assertEquals(expectedScore,
                diceApi.score(category, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }


    void testScoreForSingleCategoryWithNoOccurrences(final Category category,
                                                     final List<Integer> testDiceRolls) {
        // Number of category occurrences in the test array multiplied by a category value
        final int expectedScore = Category.DEFAULT_SCORE;
        Assertions.assertEquals(expectedScore,
                diceApi.score(category, testDiceRolls), GENERIC_ERROR_MESSAGE);
    }
}
