class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        Set<String> usedWords = new HashSet<>();

        if (pattern.length() != words.length) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char target = pattern.charAt(i);

            String word = words[i];
            if(map.containsKey(target)) {
                if(!map.get(target).equals(word)) return false;
            } else {
                if(usedWords.contains(word)) return false;
                map.put(target, word);
                usedWords.add(word);
            }
        }

        return true;
    }
}