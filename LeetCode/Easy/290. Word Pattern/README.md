# [Easy] Word Pattern

[문제 링크](https://leetcode.com/problems/word-pattern/)

### 문제 설명
Given a`pattern`and a string`s`, find if`s`follows the same pattern.

Herefollowmeans a full match, such that there is a bijection between a letter in`pattern`and anon-emptyword in`s`. Specifically:

- Each letter in`pattern`maps toexactlyone unique word in`s`.
- Each unique word in`s`maps toexactlyone letter in`pattern`.
- No two letters map to the same word, and no two words map to the same letter.

### 입출력
Example 1:

```
Input:pattern = "abba", s = "dog cat cat dog"
Output:true
```

Explanation:

The bijection can be established as:

- `'a'`maps to`"dog"`.
- `'b'`maps to`"cat"`.

Example 2:

```
Input:pattern = "abba", s = "dog cat cat fish"
Output:false
```

Example 3:

```
Input:pattern = "aaaa", s = "dog cat cat dog"
Output:false
```

### 문제설명
Constraints:

- `1 <= pattern.length <= 300`
- `pattern`contains only lower-case English letters.
- `1 <= s.length <= 3000`
- `s`contains only lowercase English letters and spaces`' '`.
- `s`does not containany leading or trailing spaces.
- All the words in`s`are separated by asingle space.