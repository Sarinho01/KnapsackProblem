package org.saros;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] itemsProfit = {70, 80, 20, 50, 120, 110, 30, 40, 60, 10};
        int[] itemsWeight = {10, 15, 5, 8, 25, 30, 8, 12, 18, 4};
        int backpackSize =  50;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize,itemsWeight,itemsProfit);

        System.out.println(knapsackProblem.solveOptmization());
        System.out.println(knapsackProblem.getSolutionSet().toString());
        knapsackProblem.printSolutionSet();

    }

    static boolean isSubsetSum(int set[], int n, int targetSum) {

        boolean subSet[][] = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++)
            subSet[i][0] = true;

        for (int i = 1; i <= targetSum; i++)
            subSet[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (j < set[i - 1])
                    subSet[i][j] = subSet[i - 1][j];
                if (j >= set[i - 1])
                    subSet[i][j] = subSet[i - 1][j] || subSet[i - 1][j - set[i - 1]];
            }
        }

        return subSet[n][targetSum];
    }






}
