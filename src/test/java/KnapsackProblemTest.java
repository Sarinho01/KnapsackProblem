import org.saros.KnapsackProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.saros.SubsetSumProblem;

class KnapsackProblemTest {

    @Test
    void slideExample(){
        int[] itemsProfit = {3000,2000,1500};
        int[] itemsWeight = {4,3,1};
        int backpackSize = 4;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize, itemsWeight, itemsProfit);

        int actual = knapsackProblem.solveOptmization();
        int expected = 3500;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test01NormalCase() {
        int[] itemsProfit = {1, 2, 3};
        int[] itemsWeight = {4, 5, 1};
        int backpackSize = 3;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize, itemsWeight, itemsProfit);

        int actual = knapsackProblem.solveOptmization();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test02DoesNotFitAnyItem() {
        int[] itemsProfit = {1, 2, 3};
        int[] itemsWeight = {4, 5, 6};
        int backpackSize = 3;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize, itemsWeight, itemsProfit);

        int actual = knapsackProblem.solveOptmization();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void test03NormalCase() {
        int[] itemsProfit = {60, 100, 120};
        int[] itemsWeight = {10, 20, 30};
        int backpackSize = 3;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize, itemsWeight, itemsProfit);

        int actual = knapsackProblem.solveOptmization();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test04NormalCase() {
        int[] itemsProfit = {6, 10, 12, 8, 5};
        int[] itemsWeight = {1, 2, 3, 5, 4};
        int backpackSize = 9;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize, itemsWeight, itemsProfit);

        int actual = knapsackProblem.solveOptmization();
        int expected = 28;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test05SubsetSumAndKnapsackSameResult(){
        int[] itemsProfit = {1,4,7};
        int[] itemsWeight = {1,4,7};
        int backpackSize =  9;
        int resultExpectedValue = 9;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize,itemsWeight,itemsProfit, resultExpectedValue);

        int[] set = itemsProfit;
        int targetSum = backpackSize;
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(set, targetSum);


        boolean knapsackResult = knapsackProblem.solveDecision();
        boolean subsetSumResult = subsetSumProblem.solve();

        System.out.println("Knapsack Result = "+knapsackResult);
        System.out.println("SubsetSum Result = "+subsetSumResult);

        Assertions.assertEquals(knapsackResult, subsetSumResult);
    }

    @Test
    void test06SubsetSumAndKnapsackSameResult(){
        int[] itemsProfit = {1,4,7};
        int[] itemsWeight = {1,4,7};
        int backpackSize = 10;
        int resultExpectedValue = 10;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize,itemsWeight,itemsProfit, resultExpectedValue);

        int[] set = itemsProfit;
        int targetSum = backpackSize;
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(set, targetSum);


        boolean knapsackResult = knapsackProblem.solveDecision();
        boolean subsetSumResult = subsetSumProblem.solve();

        System.out.println("Knapsack Result = "+knapsackResult);
        System.out.println("SubsetSum Result = "+subsetSumResult);

        Assertions.assertEquals(knapsackResult, subsetSumResult);
    }

    @Test
    void test07SubsetSumAndKnapsackSameResult(){
        int[] itemsProfit = {1,2,3,4,5};
        int[] itemsWeight = {1,2,3,4,5};
        int backpackSize =  15;
        int resultExpectedValue = 15;
        KnapsackProblem knapsackProblem = new KnapsackProblem(backpackSize,itemsWeight,itemsProfit, resultExpectedValue);

        int[] set = itemsProfit;
        int targetSum = backpackSize;
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(set, targetSum);


        boolean knapsackResult = knapsackProblem.solveDecision();
        boolean subsetSumResult = subsetSumProblem.solve();

        System.out.println("Knapsack Result = "+knapsackResult);
        System.out.println("SubsetSum Result = "+subsetSumResult);

        Assertions.assertEquals(knapsackResult, subsetSumResult);
    }


}
