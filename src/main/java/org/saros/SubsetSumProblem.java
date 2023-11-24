package org.saros;

public class SubsetSumProblem {
    int[] set;
    int targetSum;

    public SubsetSumProblem(int[] set, int targetSum) {
        this.set = set;
        this.targetSum = targetSum;
    }

    public boolean solve(){
        int n = set.length;
        boolean[][] subSet = new boolean[n + 1][targetSum + 1];

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
