package codetest.oneeditaway;

/*
 * 2개의 문자열 q와 p가 있습니다. q 또는 p 에서 하나의 문자만 수정하여 q와 p가 동일한 문자열이 될 수 있는지 확인하는 코드.
 * 이떄 q, p에서 하나의 문자를 삽입 제거 치환할 수 있으며 한 번의 수정만으로 q가 p와 동일해져야 합니다.

 * */
public class Strings {
    public static boolean isOneEditAway(String q, String p) {

        if (Math.abs(q.length() - p.length()) > 1) {
            return false;
        }

        String shorter = q.length() < p.length() ? q : p;
        String longer = q.length() < p.length() ? p : q;

        int is = 0;
        int il = 0;
        boolean marker = false;
        while (is < shorter.length() && il < longer.length()) {
            if (shorter.charAt(is) != longer.charAt(il)) {
                if (marker) {
                    return false;
                }

                marker = true;

                if (shorter.length() == longer.length()) {
                    is++;
                }
            } else {
                is++;
            }
            il++;
        }
        return true;
    }
}
