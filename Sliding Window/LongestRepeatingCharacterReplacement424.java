LongestRepeatingCharacterReplacement424.java

Problem:

Given a string s and an integer k, you can replace any character in the string with another uppercase English character at most k times.

Return the length of the longest substring that can be made to contain the same character after at most k replacements.


Example:

Input:

s = "ABAB"
k = 2

Output:

4

Explanation:

The substring is:

ABAB

We can replace both B's with A:

ABAB
↓↓↓↓
AAAA

Number of replacements = 2

Since k = 2, the whole string is valid.

Therefore:

Answer = 4


Approach:

Use the Sliding Window technique.

Use:

occurance → stores the frequency of each character.

left → represents the starting point of the window.

right → represents the ending point of the window.

ans → stores the longest valid window.

maxOccurance → stores the highest frequency of a character in the current window.

For every character:

1. Add the current character to the frequency array.
2. Find the maximum character frequency.
3. Calculate how many characters need to be replaced:

Window Size - Maximum Character Frequency

4. If the required replacements are greater than k, move left forward.
5. Update the maximum answer.


Code:

class Solution {
    public int characterReplacement(String s, int k) {

        int[] occurance = new int[26];
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurance = 0;

        for (right = 0; right < s.length(); right++) {

            maxOccurance = Math.max(
                maxOccurance,
                ++occurance[s.charAt(right) - 'A']
            );

            if (right - left + 1 - maxOccurance > k) {
                occurance[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}


Important Line:

if (right - left + 1 - maxOccurance > k)

right - left + 1
        ↓
Current window size

maxOccurance
        ↓
Most frequent character in the window

Window Size - maxOccurance
        ↓
Number of characters we need to replace


Example:

Window = "AABA"

Window Size = 4

A occurs 3 times.

maxOccurance = 3

Required replacements:

4 - 3
= 1

If:

k = 2

1 <= 2

So the window is valid.


If:

Window = "ABC"

Window Size = 3

Maximum frequency = 1

Required replacements:

3 - 1
= 2

If:

k = 1

2 > 1

So the window is invalid.

Therefore:

left++


Important Line:

occurance[s.charAt(right) - 'A']++;

This increases the frequency of the current character.

For example:

s.charAt(right) = 'B'

'B' - 'A'
= 1

So:

occurance[1]++;

This means:

Increase the frequency of B by 1.


Important Line:

occurance[s.charAt(left) - 'A']--;

This removes the character that is leaving the window.

When the window becomes invalid:

Old character → Remove
New character → Add


Important Line:

ans = Math.max(ans, right - left + 1);

This compares:

Previous longest window
        VS
Current window

and keeps the larger value.


Example:

s = "ABAB"
k = 2

Window:

A

Required replacements = 0
Answer = 1


Window:

AB

Maximum frequency = 1

2 - 1 = 1 replacement

Answer = 2


Window:

ABA

Maximum frequency = 2

3 - 2 = 1 replacement

Answer = 3


Window:

ABAB

Maximum frequency = 2

4 - 2 = 2 replacements

k = 2

Valid

Answer = 4


Final Answer:

4


Algorithm:

1. Create a frequency array of size 26.
2. Initialize left = 0.
3. Start right from 0.
4. Add the current character to the frequency array.
5. Update maxOccurance.
6. Calculate the required replacements.
7. If replacements > k, move left forward.
8. Update ans using Math.max().
9. Continue until the string ends.
10. Return ans.


Easy Rule:

Expand window
        ↓
Count characters
        ↓
Find most frequent character
        ↓
Calculate:

Window Size - Maximum Frequency
        ↓
Is it greater than k?
        ↓
YES → Move left
        ↓
NO → Keep window
        ↓
Update maximum answer


Remember:

occurance
↓
Stores character frequencies


left
↓
Starting point of window


right
↓
Ending point of window


maxOccurance
↓
Highest character frequency


right - left + 1
↓
Current window size


Window Size - maxOccurance
↓
Number of replacements needed


ans
↓
Longest valid window


Complexity:

Time Complexity: O(n)

The right pointer moves through the string once.
The left pointer also moves only forward.
Therefore, the overall time complexity is O(n).

Space Complexity: O(1)

The frequency array contains only 26 positions for uppercase English letters.
Since 26 is constant, the space complexity is O(1).