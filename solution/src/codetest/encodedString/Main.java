package codetest.encodedString;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] str = "  String   with spaces  ".toCharArray();

        System.out.println("Before: " + Arrays.toString(str));

        char[] result = Strings.encodeWhitespacesV1(str);
        char[] result2 = Strings.encodeWhitespaceV2(str);

        System.out.println("After: " + Arrays.toString(result));
        System.out.println("After: " + Arrays.toString(result2));
    }
}
