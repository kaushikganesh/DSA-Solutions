RomanToInteger13.java

Problem:
Given a Roman numeral string s, convert it into an integer.

Example:

Input: s = “MCMIV”
Output: 1904

Explanation:

M = 1000
C comes before M → C is smaller than M → subtract C
M = 1000
I comes before V → I is smaller than V → subtract I
V = 5

So:

MCMIV
= M + (M - C) + (V - I)
= 1000 + (1000 - 100) + (5 - 1)
= 1000 + 900 + 4
= 1904

Easy Rule:

If current value < next value
↓
SUBTRACT

Otherwise
↓
ADD

Example:

IV → I < V → 1 < 5 → -1 + 5 = 4

VI → V > I → +5 + 1 = 6

Approach:
Use a HashMap to store Roman symbols and their values.
Check two characters together for special cases like IV, IX, XL, XC, CD, CM.
If no special combination exists, process one character.

Code:

import java.util.HashMap;
import java.util.Map;

class Solution {

static Map<String, Integer> values = new HashMap<>();
static {
    values.put("I", 1);
    values.put("V", 5);
    values.put("X", 10);
    values.put("L", 50);
    values.put("C", 100);
    values.put("D", 500);
    values.put("M", 1000);
    values.put("IV", 4);
    values.put("IX", 9);
    values.put("XL", 40);
    values.put("XC", 90);
    values.put("CD", 400);
    values.put("CM", 900);
}
public int romanToInt(String s) {
    int sum = 0;
    int i = 0;
    while (i < s.length()) {
        if (i < s.length() - 1) {
            String twoSymbols = s.substring(i, i + 2);
            if (values.containsKey(twoSymbols)) {
                sum += values.get(twoSymbols);
                i += 2;
                continue;
            }
        }
        String oneSymbol = s.substring(i, i + 1);
        sum += values.get(oneSymbol);
        i += 1;
    }
    return sum;
}

}

Algorithm:

1. Create an empty HashMap and store Roman symbols with their values.
2. Start from the first character using i = 0.
3. Check two characters together.
4. If the two characters form a special combination:
    Add its value to sum.
    Move i by 2.
5. Otherwise:
    Take one character.
    Add its value to sum.
    Move i by 1.
6. Repeat until the string ends.
7. Return the answer.

Complexity:

Time Complexity: O(n) – each character is processed once.

Space Complexity: O(1) – HashMap contains only a fixed number of values.