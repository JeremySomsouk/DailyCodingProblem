package Amazon;

/*

Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding.
You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
You can assume the string to be decoded is valid.

*/

class Problem3 {

    static String runLengthEncode(String input) {

        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int counter = 0;

        for (char c : input.toCharArray()) {
            if (c == currentChar) {
                ++counter;
            } else {
                result.append(counter).append(currentChar);
                currentChar = c;
                counter = 1;
            }
        }

        result.append(counter).append(currentChar);
        return result.toString();
    }


    static String runLengthDecode(String input) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i += 2) {
            int count = Character.getNumericValue(input.charAt(i));
            char currentChar = input.charAt(i + 1);
            result.append(repeatCharacter(count, currentChar));
        }

        return result.toString();
    }

    private static String repeatCharacter(int nbTimes, char currentChar) {
        return new String(new char[nbTimes]).replace('\0', currentChar);
    }
}
