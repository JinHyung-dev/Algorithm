class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max = 0;

        for(int price : prices) {
            if(price < buy) {  // 현재가가 더 작으면 구매가 갱신
                buy = price;
            } else {  // 그렇지 않으면 최대값 계산
                max = Math.max(max, price - buy);
            }
        }
        return max;
    }
}