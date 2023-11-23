package org.saros;

import java.util.HashSet;
import java.util.Set;

public class KnapsackProblem {

    private int backPackSize;
    private int[] itemsWeight;
    private int[] itemsProfit;
    private int expectedValue;
    private Set<Integer>[][] backTracking;

    public KnapsackProblem(int backpackSize, int[] itemsWeight, int[] itemsProfit) {
        this.backPackSize = backpackSize;
        this.itemsProfit = itemsProfit;
        this.itemsWeight = itemsWeight;
    }

    public KnapsackProblem(int backpackSize, int[] itemsWeight, int[] itemsProfit, int expectedValue) {
        this.backPackSize = backpackSize;
        this.itemsProfit = itemsProfit;
        this.itemsWeight = itemsWeight;
        this.expectedValue = expectedValue;
    }

    public int solveOptmization() {


        //  Quantidade de itens
        int n = itemsWeight.length;

        //  Matriz quantidade de itens x peso da mochila
        int[][] answer = new int[n + 1][backPackSize + 1];
        int currentItemWeight;

        //  IGNORAR (CRIANDO UM SISTEMA DE BACKTRACKING PARA ANOTAR A RESPOSTA)
        backTracking = new HashSet[n + 1][backPackSize + 1];

        for (int i = 1; i < answer.length; i++) {

            //  J é o peso atual
            for (int j = 1; j < backPackSize + 1; j++) {
                //  Peso do item atual
                currentItemWeight = itemsWeight[i - 1];

                //  Caso o peso do item seja maior do que o peso atual (não cabe na mochila)
                //  Então é colocado o valor da linha (item) anterior com o mesmo peso J (mesma coluna)
                if (currentItemWeight > j) {
                    answer[i][j] = answer[i - 1][j];

                    backTracking[i][j] = backTracking[i - 1][j];
                }
                //  Caso o item caiba na mochila
                //  É colocado como valor atual nessa posição da matriz o maior entre
                //  O valor do item + o valor na linha anterior do peso restante
                //  Ou o valor da linha anterior nesse mesmo peso
                else {
                    answer[i][j] = Math.max(
                            answer[i - 1][j],
                            itemsProfit[i - 1] + answer[i - 1][j - currentItemWeight]
                    );

                    backTracking[i][j] = (answer[i - 1][j] >= itemsProfit[i - 1] + answer[i - 1][j - currentItemWeight]) ?
                            backTracking[i - 1][j] :
                            createNewBackTrackingHashSet(i, j, backTracking, currentItemWeight);


                }
            }
        }

        //  A resposta é a última linha na última coluna
        return answer[n][backPackSize];
    }

    private HashSet<Integer> createNewBackTrackingHashSet(int i, int j, Set<Integer>[][] backTracking, int currentItemWeight) {
        HashSet<Integer> resultHashSet = (backTracking[i - 1][j - currentItemWeight] == null)
                ? new HashSet<>()
                : new HashSet<>(backTracking[i - 1][j - currentItemWeight]);

        resultHashSet.add(i - 1);
        return resultHashSet;
    }

    public boolean solveDecision() {
        int result = solveOptmization();
        return result >= expectedValue;
    }

    public Set<Integer> getSolutionSet() {
        int n = itemsWeight.length;
        return backTracking[n][backPackSize];
    }

    public void printSolutionSet() {
        StringBuilder sbr = new StringBuilder();
        sbr.append("Items escolhidos:\n");

        int totalWeight = 0;
        for (Integer i : getSolutionSet()) {
            sbr.append("Item ").append(i + 1).append(" ")
                    .append("Peso: ").append(itemsWeight[i]).append(", ")
                    .append("Valor: ").append(itemsProfit[i]).append("\n");
            totalWeight += itemsWeight[i];
        }


        sbr.append("Valor total da mochila: ").append(solveOptmization()).append("\n");
        sbr.append("Peso total da mochila: ").append(totalWeight);

        System.out.println(sbr);

    }

    public int getBackPackSize() {
        return backPackSize;
    }

    public void setBackPackSize(int backPackSize) {
        this.backPackSize = backPackSize;
    }

    public int[] getItemsWeight() {
        return itemsWeight;
    }

    public void setItemsWeight(int[] itemsWeight) {
        this.itemsWeight = itemsWeight;
    }

    public int[] getItemsProfit() {
        return itemsProfit;
    }

    public void setItemsProfit(int[] itemsProfit) {
        this.itemsProfit = itemsProfit;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(int expectedValue) {
        this.expectedValue = expectedValue;
    }
}
