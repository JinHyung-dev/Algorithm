class Solution {
    public boolean isSubsequence(String s, String t) {
        int targetIdx = 0;
        int searchIdx = 0;
        while(targetIdx < s.length()) {
            while(searchIdx < t.length()) {
                char tChar = t.charAt(searchIdx);

                if(tChar == s.charAt(targetIdx)) {
                    if(targetIdx == s.length() - 1) {
                        return true;
                    }
                    targetIdx++;
                }

                searchIdx++;
            }
            break;
        }
        return targetIdx == s.length() ? true : false;
    }
}