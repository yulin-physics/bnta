package com.yulin.bnta.numList;

import java.util.Arrays;

public class Calc {
    public double numSum(double[] numList){
        double sum = 0;
        for(double i : numList){
            sum +=i;
        }

        System.out.println("The sum of "+ Arrays.toString(numList)+" is: "+sum);
        return sum;
    }

    public double numLargest(double[] numList){
        double max = numList[0];
        for (int i = 1; i < numList.length; i++){
            if (numList[i] > max){
                max = numList[i];
            }
        }
        System.out.println("The largest number in "+ Arrays.toString(numList)+" is: "+ max);
        return max;
    }

    public double[] mergeList(double[]...arrays){
        int size = 0;

        for(double[] i:arrays){
            size += i.length;
        }

        double[] mergedArray = new double[size];

        int destPos = 0;
        for(int i = 0; i < arrays.length; i++){
            System.arraycopy(arrays[i], 0, mergedArray, destPos, arrays[i].length);
            destPos += arrays[i].length;
        }

        Arrays.sort(mergedArray);
        System.out.println("The sorted list is "+Arrays.toString(mergedArray));
        return mergedArray;
    }
}
