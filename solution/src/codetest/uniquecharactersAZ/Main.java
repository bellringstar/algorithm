package codetest.uniquecharactersAZ;

public class Main {
    public static void main(String[] args) {
        String text1 = "afghnqrsuz";
        String text2 = "abcdefhzqoc";
        String text3 = "abcdefhzqow";

        boolean resultText1 = Strings.isUnique(text1);
        boolean resultText2 = Strings.isUnique(text2);
        boolean resultText3 = Strings.isUnique(text3);

        System.out.println("Text1 has unique characters? " + resultText1);
        System.out.println("Text2 has unique characters? " + resultText2);
        System.out.println("Text3 has unique characters? " + resultText3);
    }
}
