package dev.dvinnik.core;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Schooner Dice API implementation
 *
 * Note: I would generally not leave so many comments since comments are often end up being legacy code, but I am
 * adding extra for the reviewers
 */
public class SchoonerDiceApi implements DiceApi {

    /**
     * Produce a score for a particular category for a list of dice throws
     *
     * @param category Expected category of the dice throw
     * @param diceRoll Collection of dice throws
     * @return Either score for the specified category if it matches the list of dice throws, or {@code Category#DEFAULT_VALUE}
     */
    @Override
    public int score(final Category category,
                     final List<Integer> diceRoll) {
        try {

            switch (category) {
                case ONES, TWOS, THREES, FOURS, FIVES, SIXES, SEVENS, EIGHTS -> {
                    return scoreForSingleCategories(diceRoll, category.getMatchingDiceScore());
                }
                case THREE_OF_A_KIND, FOUR_OF_A_KIND -> {
                    // Creating a map where a key is a score of each dice throw,
                    // and a value is a number of occurrences of each score
                    final Map<Integer, Long> mapOfDuplicates =
                            diceRoll.stream().collect(Collectors.groupingBy(value -> value, Collectors.counting()));

                    // Check if any of the scores occurred a minimum number of expected occurrences
                    final int numberOfOccurrencesExpected = Category.THREE_OF_A_KIND == category
                            ? Category.THREE_OF_A_KIND_NUMBER_OF_OCCURRENCES_REQUIRED
                            : Category.FOUR_OF_A_KIND_NUMBER_OF_OCCURRENCES_REQUIRED;
                    if (mapOfDuplicates.values().stream()
                            .anyMatch(value -> value >= numberOfOccurrencesExpected)) {
                        return calculateSum(diceRoll);
                    }
                }
                case FULL_HOUSE -> {
                    final Map<Integer, Long> mapOfDuplicatesForFullHouse = diceRoll.stream()
                            .collect(Collectors.groupingBy(value -> value, Collectors.counting()));

                    // Since we only have 5 dice throws, the map of duplicates can only contain two entries for Full House
                    // And one of the entry has to have 3 duplicates and another 2
                    if (mapOfDuplicatesForFullHouse.size() == Category.NUMBER_OF_COMBINATIONS_FOR_FULL_HOUSE
                            && mapOfDuplicatesForFullHouse.values().stream().allMatch(value ->
                            value.longValue() == Category.FULL_HOUSE_OCCURRENCES_REQUIRED.getKey()
                                    || value.longValue() == Category.FULL_HOUSE_OCCURRENCES_REQUIRED.getValue())) {
                        return category.getConstantDiceScore();
                    }
                }
                case SMALL_STRAIGHT, LARGE_STRAIGHT -> {
                    // Note: for four sequential dice, assuming they don't have to come sequentially
                    // (meaning [1, 3, 2, 5, 4] would be considered sequential) because we sort them
                    final List<Integer> sortedDiceRolls = diceRoll.stream().sorted().distinct().toList();

                    // Fail-fast: if after removing duplicates, you have fewer elements than expected, no reason to proceed
                    final int numberOfSequentialOccurrencesExpected = category.getMatchingDiceScore();
                    if (numberOfSequentialOccurrencesExpected > sortedDiceRolls.size()) {
                        break;
                    }
                    // Iterate through the sorted collection where we make sure that the next value is an increment
                    // of one, or we start from the beginning
                    int counterForSequential = 1;
                    for (int i = 0; i < sortedDiceRolls.size() - 1; i++) {
                        if (sortedDiceRolls.get(i) + 1 == sortedDiceRolls.get(i + 1)) {
                            counterForSequential++;
                        }
                        if (counterForSequential == category.getMatchingDiceScore()) {
                            return category.getConstantDiceScore();
                        }
                    }
                }
                case ALL_DIFFERENT -> {
                    // If after removing duplicates, we have fewer items, then not all dice throws are unique
                    if (diceRoll.stream().distinct().count() == diceRoll.size()) {
                        return category.getConstantDiceScore();
                    }
                }
                case SCHOONER -> {
                    // After removing all duplicates, we should have one value in the list of dice scores
                    if (diceRoll.stream().distinct().count() == Category.NUMBER_OF_UNIQUE_SCORES_FOR_SCHOONER) {
                        return category.getConstantDiceScore();
                    }
                }
                case CHANCE -> {
                    return calculateSum(diceRoll);
                }
                default -> {
                    return Category.DEFAULT_SCORE;
                }
            }
            return Category.DEFAULT_SCORE;
        } catch (final Exception e) {
            /**
             * Generally speaking, I would have bubbled up the exception right in the signature.
             * I.e. I would have had {#score(..., ...) throws Exception} but because this exercise had a particular
             * signature for the method, I am just wrapping it up and throwing a Runtime exception (not a very good solution)
             *
             * You could also gracefully handle the exception by returning a default value of zero and logging the exception,
             * but I don't like to hide major exceptions like that.
             */

            throw new RuntimeException(e);
        }
    }

    /**
     * Produces a list of categories that produce the top score for a list of dice throws
     *
     * @param diceRoll List of dice throws
     * @return Collection of categories that would produce the highest score for the given dice throws
     */
    @Override
    public List<Category> topCategories(final List<Integer> diceRoll) {
        final List<Category> result = new ArrayList<>();
        /**
         * Check each of the categories and collect the ones that would produce the highest score
         */
        int topScore = 0;
        for (Category category : Category.values()) {
            int currentScore = score(category, diceRoll);
            if (currentScore > topScore) {
                result.clear();
                result.add(category);
                topScore = currentScore;
            } else if (currentScore == topScore) {
                result.add(category);
            }
        }
        return result;
    }

    /**
     * Utility method to sum all dice throw scores
     */
    int calculateSum(final List<Integer> diceRoll) {
       return diceRoll.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Calculates a sum of dice throws that match the expected value for single-type categories like Ones, Twos, etc.
     * @param diceRoll List of dice throws
     * @param expectedValue Expected value of dice rolls that should be calculated
     */
    private int scoreForSingleCategories(final List<Integer> diceRoll,
                                         final int expectedValue) {
        return diceRoll.stream().mapToInt(Integer::intValue)
                .filter(diceValue -> expectedValue == diceValue)
                .sum();
    }
}
