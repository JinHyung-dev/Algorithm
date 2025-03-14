class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int result = s.lastIndexOf(' ');

        if(result == -1) {
            return s.length();
        }

        return s.length() - 1 - result;
    }
}