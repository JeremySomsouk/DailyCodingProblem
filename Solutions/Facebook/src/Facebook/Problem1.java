package Facebook;

/*

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.

*/

class Problem1 {

    static int countDecodableWays(String encodedMessage) {

        if (encodedMessage.isEmpty()) {
            return 0;
        }

        int decodableWays = 1;

        for (int i = 0; i < encodedMessage.length() - 1; ++i) {
            if (isCurrentAndNextCharacterCombination(encodedMessage, i)) {
                ++decodableWays;
            }
        }

        return decodableWays;
    }

    private static boolean isCurrentAndNextCharacterCombination(String encodedMessage, int index) {
        return encodedMessage.charAt(index) <= '2' &&
                encodedMessage.charAt(index + 1) <= '9';
    }
}
