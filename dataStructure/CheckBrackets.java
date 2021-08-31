package com.yulin.bnta.dataStructure;

import java.util.Stack;

public class CheckBrackets {
    public static boolean allPaired(String string){
        String[] brackets = string.split("");
        Stack<String> stack = new Stack<String>();

        if (brackets.length < 2 || brackets.length % 2 != 0){ return false;}

        stack.push(brackets[0]);

        for (int i = 1; i < brackets.length; i++){

            if(isMatching(stack.peek(), brackets[i])){
                stack.pop();
            } else{
                stack.push(brackets[i]);
            }
        }

        return stack.isEmpty();

    }

    private static boolean isMatching(String openingBracket, String closingBracket){
        String[] brackets = {"{}", "[]", "<>", "()"};
        String input = openingBracket + closingBracket;
        boolean result = false;
        
        for (String bracket : brackets){

            if (input.equals(bracket)){
                result = true;
                break;
            } else{
                result = false;
            }
        }
        
        return result;

    }

    private static boolean isClosingBracket(String openingBracket){
        String[] closingBrackets = {"}", "]", ">", ")"};
        boolean isClosingBracket = false;
        for (String bracket : closingBrackets){
            isClosingBracket = openingBracket.equals(bracket);
        }

        return isClosingBracket;
    }


}
