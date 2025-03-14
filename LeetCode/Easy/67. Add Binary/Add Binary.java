class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while(i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if(i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);  // 현재 자리값 계산
            carry = sum / 2;  // 올림값 계산
        }
    }
}