package codetest.encodedString;
/*
* char[]로 주어진 문자열 str이 있을 때 문자열의 모든 공객을 '%20'으로 치환하는 코드. 결과 문자열은 char[]로 반환.
* "  String   with spaces  ". -> [%, 2, 0, %, 2, 0, S, t, r,....
* */
public class Strings {
    public static char[] encodeWhitespacesV1(char[] str) {
        String string = new String(str);
        String replaced = string.replace(" ", "%20");
        return replaced.toCharArray();
    }

    public static char[] encodeWhitespaceV2(char[] str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        int countWhitespace = 0;
        for (char c : str) {
            if (Character.isWhitespace(c)) {
                countWhitespace++;
            }
        }

        if (countWhitespace > 0) {
            char[] encodeStr = new char[str.length + countWhitespace * 2];

            int idx = 0;
            for (int i = 0; i < str.length; i++) {
                if (Character.isWhitespace(str[i])) {
                    encodeStr[idx] = '%';
                    encodeStr[idx + 1] = '2';
                    encodeStr[idx + 2] = '0';
                    idx = idx + 3;
                } else {
                    encodeStr[idx] = str[i];
                    idx++;
                }
            }
            return encodeStr;
        }
        return str;
    }
}
