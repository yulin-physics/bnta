package com.yulin.bnta.numList;

public class Main {
    public static void main(String[] args) {
        double[] numList1 = {0.1, 7.9, 1032.8};
        double[] numList2 = {82749, 89, 8.3};
        Calc calc = new Calc();
        double[] result = calc.mergeList(numList1, numList2);
    }
}
