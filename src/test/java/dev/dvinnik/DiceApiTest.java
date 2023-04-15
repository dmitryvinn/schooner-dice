package dev.dvinnik;

import dev.dvinnik.core.DiceApi;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base class for Dice API tests
 */
public abstract class DiceApiTest {
    protected DiceApi diceApi;
    @BeforeEach
    void setUp() {
        diceApi = initializeTestService();
    }

    abstract DiceApi initializeTestService();
}
