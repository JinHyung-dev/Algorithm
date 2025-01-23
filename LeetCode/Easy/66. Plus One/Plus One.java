class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            // 값이 9라면 올림처리
            digits[i] = 0;
        }

        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }
}