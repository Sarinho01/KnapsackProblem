package org.saros;

public class KnapsackProblem {

    private int backPackSize;
    private int[] itemsWeight;
    private int[] itemsProfit;
    
    public KnapsackProblem(int backpackSize, int[] itemsWeight, int[] itemsProfit) {
        this.backPackSize = backpackSize;
        this.itemsProfit = itemsProfit;
        this.itemsWeight = itemsWeight;
    }

    public int solve() {
        //  Quantidade de itens
        int n = itemsWeight.length;

        //  Matriz quantidade de itens x peso da mochila
        int[][] answer = new int[n + 1][backPackSize + 1];
        int currentItemWeight;

        for (int i = 1; i < answer.length; i++) {

            //  J é o peso atual
            for (int j = 1; j <= backPackSize; j++) {
                //  Peso do item atual
                currentItemWeight = itemsWeight[i - 1];

                //  Caso o peso do item seja maior do que o peso atual (não cabe na mochila)
                //  Então é colocado o valor da linha (item) anterior com o mesmo peso J (mesma coluna)
                if (currentItemWeight > j) {
                    answer[i][j] = answer[i - 1][j];
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

                }
            }
        }

        //  A resposta é a última linha na última coluna
        return answer[n][backPackSize];
    }
}
