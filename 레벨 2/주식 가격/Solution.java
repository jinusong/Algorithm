public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i<prices.length; i++) {
            for (int j = i; j<prices.length; j++) {
                if (prices[i] > prices[j] || prices.length - 1 == j) {
                    answer[i] = j-i;
                    break;
                }
            }
        }

        return answer;
    }
}