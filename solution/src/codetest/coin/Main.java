package codetest.coin;

public class Main {

    public static void main(String[] args) {
        System.out.println("oount (recursion) : " + Coins.calculateChange(50));
        System.out.println("count (Mem) : " + Coins.calculateChangeMem(50));
    }

}
