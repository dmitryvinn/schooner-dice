package dev.dvinnik.core;

import java.util.List;

/**
 * Dice API abstraction so to leave room for different implementations of the Dice API game (not only a Schooner Dice)
 */
public interface DiceApi {
    int score(final Category category,
              final List<Integer> diceRoll);

    List<Category> topCategories(final List<Integer> diceRoll);
}
