package Facebook;/*

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false

*/

import org.junit.jupiter.api.Test;

import static Facebook.Problem5.areBracketsBalanced;
import static org.assertj.core.api.Assertions.assertThat;

class Test5 {

    @Test
    void areBracketsBalanced_shouldReturnTrue_whenValidBracketValues() {

        String input = "([])[]({})";
        assertThat(areBracketsBalanced(input)).isTrue();
    }

    @Test
    void areBracketsBalanced_shouldReturnFalse_whenInvalidClosingBracket() {

        String input = "([)]";
        assertThat(areBracketsBalanced(input)).isFalse();
    }

    @Test
    void areBracketsBalanced_shouldReturnFalse_whenNotClosingAllBrackets() {

        String input = "((()";
        assertThat(areBracketsBalanced(input)).isFalse();
    }

    @Test
    void areBracketsBalanced_shouldReturnFalse_whenClosingUnopenedBracket() {

        String input = ")))";
        assertThat(areBracketsBalanced(input)).isFalse();
    }

    @Test
    void areBracketsBalanced_shouldReturnTrue_whenEmptyInput() {

        String input = "";
        assertThat(areBracketsBalanced(input)).isTrue();
    }
}
