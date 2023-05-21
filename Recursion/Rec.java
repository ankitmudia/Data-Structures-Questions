package Recursion;

import java.util.ArrayList;

public class Rec {
    static void subSet(int[] number, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> output, int index) {
        // base case
        if (index >= number.length) {
            System.out.println(output);
            result.add(output);
            return;
        }

        // include
        output.add(number[index]);
        subSet(number, result, output, index + 1);

        // exclude
        output.remove(output.size() - 1);
        subSet(number, result, output, index + 1);
    }

    public static void main(String[] args) {
        int[] number = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        subSet(number, result, output, 0);
    }
}
