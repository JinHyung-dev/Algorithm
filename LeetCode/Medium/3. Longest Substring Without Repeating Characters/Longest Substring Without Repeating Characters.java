class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int length = 0; int start = 0;

        for(int end = 0; end < s.length(); end++){
            // 중복 문자 확인
            while(seen.contains(s.charAt(end)) {
                seen.remove(s.charAt(start));
                start++;
            }

            seen.add(s.charAt(end));  // 새로운 문자 추가
            length = Math.max(length, end - start + 1);  // 길이 수정
        }

        return length;
    }
}