class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.trim().isEmpty()) return true;

        s = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]+", "");
        int left = 0; int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            right--;
            left++;
        }

        return true;
    }
}