package org.saros;


public class Main {
    public static void main(String[] args) {
        int[] itemsProfit = {1,4,7};
        int[] itemsWeight = {1,4,7};
        int backpackSize =  9;
        int resultExpectedValue = 9;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize,itemsWeight,itemsProfit, resultExpectedValue);

        boolean knapsackResult = knapsackProblem.solveDecision();

        int[] set = itemsProfit;
        int targetSum = backpackSize;
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(set, targetSum);


        System.out.println("Knapsack = "+knapsackResult);
        System.out.printf("SubsetSum = "+subsetSumProblem.solve());

    }








}
