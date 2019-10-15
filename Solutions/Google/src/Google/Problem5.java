package Google;

/*

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false

*/

import java.util.Stack;

class Problem5 {

    static boolean areBracketsBalanced(String brackets) {

        Stack<Character> stack = new Stack<>();

        for (Character bracket : brackets.toCharArray()) {
            if (isOpenBracket(bracket)) {
                stack.push(bracket);
            } else if (isClosingBracket(bracket)) {
                if (stack.isEmpty()) {
                    return false;
                }

                Character lastBracket = stack.pop();
                if (isOppositeBracket(lastBracket, bracket)) {
                    continue;
                }

                return false;
            } else {
                throw new IllegalArgumentException("Not a bracket : there is an invalid character.");
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOppositeBracket(Character lastBracket, Character currentBracket) {
        if (lastBracket == '(') {
            return currentBracket == ')';
        }
        if (lastBracket == '{') {
            return currentBracket == '}';
        }
        if (lastBracket == '[') {
            return currentBracket == ']';
        }

        return false;
    }

    private static boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private static boolean isClosingBracket(char bracket) {
        return bracket == ')' || bracket == '}' || bracket == ']';
    }
}
