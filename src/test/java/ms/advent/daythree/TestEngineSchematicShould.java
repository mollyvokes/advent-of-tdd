package ms.advent.daythree;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestEngineSchematicShould {

    @Test
    void validate_symbols_test_passes() {
        EngineSchematic engine = new EngineSchematic();
        assertThat(engine.isSymbol('#'), equalTo(true));
    }

    @Test
    void validate_symbols_test_fails() {
        EngineSchematic engine = new EngineSchematic();
        assertThat(engine.isSymbol('.'), equalTo(false));
    }

}
