# [Easy] Valid Parentheses 

[문제 링크](https://leetcode.com/problems/valid-parentheses/)

### 문제 설명
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

### 입출력
Example 1:
```
Input: s = "()"
Output: true
```
Example 2:
```
Input: s = "()[]{}"
Output: true
```
Example 3:
```
Input: s = "(]"
Output: false
```
Example 4:
```
Input: s = "([])"
Output: true
```

### 문제설명
Constraints:
- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.