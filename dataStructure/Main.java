package com.yulin.bnta.dataStructure;

public class Main {
    public static void main(String[] args){
        String letters = "a,b,b,c,c,c,z";

        System.out.println(CountLetter.letterString(letters));

        String brackets = "({()})";

        System.out.println(CheckBrackets.allPaired(brackets));
    }
}
