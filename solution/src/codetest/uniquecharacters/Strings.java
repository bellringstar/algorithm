package codetest.uniquecharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 0 ~ 65,535 사이의 아스키 및 유니코드 문자를 퐇마하는 문자열이 있습니다.
 * 문자열의 고유 문자만 포함할 경우 true를 반환하는 코드를 작성하세요. 공백은 무시합니다.
 * */
public class Strings {

    private static final int MAX_CODE = 65535;

    public static boolean isUnique(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }

        Map<Character, Boolean> chars = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.codePointAt(i) <= MAX_CODE) {
                char ch = str.charAt(i);
                if (!Character.isWhitespace(ch)) {
                    if (chars.put(ch, true) != null) { // put의 경우 기존에 key가 있으면 이전 value를 없으면 null을 반환.
                        return false;
                    }
                }
            } else {
                System.out.println("허용되지 않은 character가 존재합니다");
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique2(String text) {
        String[] strings = text.split(" ");
        Set<String> set = new HashSet<>();
        for (String string : strings) {
            if (set.contains(string)) {
                return false;
            }
            set.add(string);
        }
        return true;
    }
}
