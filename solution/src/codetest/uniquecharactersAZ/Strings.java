package codetest.uniquecharactersAZ;

/*
 * a~z의 문자만 포함할 수 있는 문자열이 있습니다. 이 문자열이 고유 문자로만 구성된 경우 true를 반환하세요
 * 공백은 무시합니다.
 * */
public class Strings {

    private static final char A_CHAR = 'a';

    public static boolean isUnique(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }

        int marker = 0;
        for (int i = 0; i < str.length(); i++) {
            int s = str.charAt(i) - A_CHAR;
            int mask = 1 << s;

            if((marker & mask) > 0) {
                return false;
            }

            marker = marker | mask;
        }

        return true;
    }
}
