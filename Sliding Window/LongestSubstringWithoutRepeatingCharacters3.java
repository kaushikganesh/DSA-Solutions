LongestSubstringWithoutRepeatingCharacters3.java

Sliding Window

Problem:

Given a string s, find the length of the longest substring without repeating characters.

If no characters are present, return 0.

Example:

Input:
s = "abcabcbb"

Output:
3

Explanation:

The longest substring without repeating characters is:

"abc"

Length = 3

Approach:

Use three variables:

left → stores the starting position of the current window.

right → stores the ending position of the current window.

ans → stores the maximum length found so far.

Use a HashSet to store the characters currently present in the window.

For every character:

If the current character is already present in the HashSet,

move left forward and remove characters from the left until the duplicate character is removed.

Otherwise, add the current character to the HashSet.

Then calculate the current window length and compare it with the previous maximum.

Code:

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {

            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            ans = Math.max(ans, right - left + 1);

            right++;
        }

        return ans;
    }
}

Important Lines:

while(set.contains(c)){
    set.remove(s.charAt(left));
    left++;
}

set.contains(c)

↓

Checks whether the current character already exists in the window.

If it exists, we have a duplicate.

↓

set.remove(s.charAt(left))

↓

Remove the character from the left side.

↓

left++

↓

Move the left pointer forward.

↓

Continue until the duplicate character is removed.

Another Important Line:

ans = Math.max(ans, right - left + 1);

right - left + 1

↓

Current window length

↓

Math.max()

↓

Compare:

Previous maximum length

VS

Current window length

↓

Keep the bigger value.

Example:

s = "abcabcbb"

a:

set = {a}

ans = 1


b:

set = {a,b}

ans = 2


c:

set = {a,b,c}

ans = 3


a:

'a' already exists.

Remove characters from the left:

a b c a
↑
remove a

Move left:

b c a

Now there are no duplicates.

Current length = 3

ans = 3


b:

Duplicate b is found.

Remove characters from the left until b is removed.

Current window becomes:

c a b

Current length = 3

ans = 3


c:

Duplicate c is found.

Window becomes:

a b c

Current length = 3

ans = 3

Continue the same process until the string ends.

Final Answer:

3

Algorithm:

1. Create a HashSet to store unique characters.
2. Initialize left = 0.
3. Initialize right = 0.
4. Initialize ans = 0.
5. Traverse through the string using right.
6. Check whether the current character already exists in the HashSet.
7. If it exists, remove characters from the left and move left forward.
8. Add the current character to the HashSet.
9. Calculate the current window length.
10. Compare it with the previous maximum length.
11. Keep the maximum length.
12. Return ans.

Easy Rule:

Take a character
        ↓
Check HashSet
        ↓
Already exists?
        ↓
      YES
        ↓
Remove from left
        ↓
Move left forward
        ↓
Until duplicate is removed
        ↓
Add current character
        ↓
Calculate window length
        ↓
Keep maximum
        ↓
Continue

Complexity:

Time Complexity: O(n)
Each character is added to and removed from the HashSet at most once.
Therefore, the string is traversed efficiently.

Space Complexity: O(n)
The HashSet stores characters from the current window.


Easy Memory Trick:

right → Expands the window
left → Removes duplicates
HashSet → Detects duplicates
ans → Stores the longest length


Main Formula:

Current Window Length
        ↓
right - left + 1

Maximum Length
        ↓
Math.max(ans, right - left + 1)