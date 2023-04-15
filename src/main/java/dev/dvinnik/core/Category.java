package dev.dvinnik.core;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Enum to encapsulate different categories used in the Dice game
 *
 *
 *
 * Decisions explained:
 *  1) While I could technically use and {Enum#ordinal()} for single-type enums (i.e. 1, 2, 3),
 *  I don't believe it's safe and maintainable since someone who could be adding new categories, could potentially
 *  change the order of enums, and break the code making debugging a nightmare.
 *
 *  2) Although both {#matchingDiceScore} and {#constantScore} are integers and one enum could only have one of these values,
 *  for readability, I decided to put them into two separate arguments.
 */
public enum Category {
    ONES(1, null),
    TWOS(2, null),
    THREES(3, null),
    FOURS(4, null),
    FIVES(5, null),
    SIXES(6, null),
    SEVENS(7, null),
    EIGHTS(8, null),
    THREE_OF_A_KIND(null, null),
    FOUR_OF_A_KIND(null, null),
    FULL_HOUSE(null, 25),
    // Slightly different interpretation of {#matchingDiceScore} where it's actually a number of sequential values
    SMALL_STRAIGHT(4, 30),
    ALL_DIFFERENT(null, 35),
    // Slightly different interpretation of {#matchingDiceScore} where it's actually a number of sequential values
    LARGE_STRAIGHT(5, 40),
    SCHOONER(null, 50),
    CHANCE(null, null);

    private static final String CONSTANT_VALUE_EXCEPTION =
            "Calling for a constant dice score value on an invalid category";
    private static final String MATCHING_VALUE_EXCEPTION =
            "Calling for matching dice score value on an invalid category";
    /**
     *  Not a huge fan of making enum such an overly complex class,
     *  and generally would have a utility that will handle this logic, but for purposes of this exercise,
     *  I will put it all together, so I can have an easier way of testing the logic
     */
    public static final int THREE_OF_A_KIND_NUMBER_OF_OCCURRENCES_REQUIRED = 3;
    public static final int FOUR_OF_A_KIND_NUMBER_OF_OCCURRENCES_REQUIRED = 4;
    // i.e. need 3 occurrences of one score and 2 of another
    public static final Map.Entry<Integer, Integer> FULL_HOUSE_OCCURRENCES_REQUIRED =
            new AbstractMap.SimpleEntry<>(3,2);
    public static final int NUMBER_OF_COMBINATIONS_FOR_FULL_HOUSE = 2;

    public static final int NUMBER_OF_UNIQUE_SCORES_FOR_SCHOONER = 1;

    // I would prefer to put it under {SchoonerDiceApi} class instead, but for simplicity and testing reasons, I put in here
    public static final int DEFAULT_SCORE = 0;

    private final Integer matchingDiceScore;
    private final Integer constantDiceScore;

    /**
     * Default constructor
     *
     * @param matchingDiceScore Value of Dice that can be counted for a particular category
     *                          or a number of sequential dice.
     *                          {null} if the value is missing and should not be called
     * @param constantDiceScore Value of a total score that a category should use
     *                          {null} if the value is missing and should not be called
     */
    Category(final Integer matchingDiceScore, final Integer constantDiceScore) {
        this.matchingDiceScore = matchingDiceScore;
        this.constantDiceScore = constantDiceScore;
    }

    /**
     * @return Value of dice that can be counted for a particular category or a number of sequential dice.
     * @throws Exception If the value is null and should not be called on the category
     */
    public int getMatchingDiceScore() throws Exception {
        if (matchingDiceScore == null) {
            throw new Exception(MATCHING_VALUE_EXCEPTION);
        }
        return matchingDiceScore;
    }

    /**
     * @return Value of a total score that a category should use
     * @throws Exception If the value is null and should not be called on the category
     */
    public int getConstantDiceScore() throws Exception {
        if (constantDiceScore == null) {
            throw new Exception(CONSTANT_VALUE_EXCEPTION);
        }
        return constantDiceScore;
    }
}
