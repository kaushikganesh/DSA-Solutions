VerifyingAnAlienDictionary953.java

Problem:
Given a sequence of words and an alien alphabet order, return true if the words are sorted according to the alien language.

Example:

Input:
words = [“hello”, “leetcode”]
order = “hlabcdefgijkmnopqrstuvwxyz”

Output:
true

Explanation:

Alien order starts with:

h → 0
l → 1
a → 2
b → 3
…

Compare:

hello
leetcode
↑
h vs l

h comes before l in the alien order.

h → 0
l → 1

Since:

0 < 1

“hello” comes before “leetcode”.

Therefore, the words are sorted.

Easy Rule:

If current letter position > next letter position
↓
return false

Otherwise
↓
break

Approach:
Use a HashMap to store each character and its position in the alien order.
Compare every two neighboring words character by character.
When the first different character is found, compare their positions.
If the second word’s character comes before the first word’s character, return false.
If all pairs are correctly ordered, return true.

Code:

import java.util.HashMap;
import java.util.Map;

class Solution {

public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> orderMap = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
        orderMap.put(order.charAt(i), i);
    }
    for (int i = 0; i < words.length - 1; i++) {
        for (int j = 0; j < words[i].length(); j++) {
            if (j >= words[i + 1].length()) {
                return false;
            }
            if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                int currLetter =
                    orderMap.get(words[i].charAt(j));
                int nextLetter =
                    orderMap.get(words[i + 1].charAt(j));
                if (nextLetter < currLetter) {
                    return false;
                }
                else {
                    break;
                }
            }
        }
    }
    return true;
}

}

Algorithm:

1. Create an empty HashMap.
2. Store each character of order with its position.
3. Compare every two neighboring words.
4. Compare their characters from left to right.
5. If the second word ends before the first word:
    Return false.
6. If two characters are different:
    Get their positions from the HashMap.
7. If the next word’s character comes before the current word’s character:
    Return false.
8. Otherwise, the pair is correctly sorted.
    Break and check the next pair.
9. If all pairs are correctly ordered:
    Return true.

Complexity:

Time Complexity: O(n × m) – compare characters of neighboring words.(n for iterating over hashmap, m for iterating over words)

Space Complexity: O(1) – HashMap stores only 26 lowercase letters.