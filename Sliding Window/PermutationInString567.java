PermutationInString567.java

Problem:

Given two strings s1 and s2, return true if s2 contains a permutation of s1.
In other words, return true if one of s1's permutations is a substring of s2.

Example:

Input:

s1 = "ab"
s2 = "eidbaooo"

Output:

true

Explanation:

The permutations of s1 are:

ab
ba

The string s2 contains:

"ba"

Therefore:

true


Approach:

Use two integer arrays of size 26:

s1Map → stores the frequency of characters in s1.

s2Map → stores the frequency of characters in the current window of s2.

Use the Sliding Window technique.

The window size is always equal to s1.length().

For every window:

1. Compare the frequency arrays.
2. If they match, return true.
3. Add the new character entering the window.
4. Remove the old character leaving the window.
5. Continue sliding the window.

If no window matches, return false.


Code:

public class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Create frequency maps for s1 and first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // Slide the window through s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            if (matches(s1Map, s2Map)) {
                return true;
            }

            // Add new character to the window
            s2Map[s2.charAt(i + s1.length()) - 'a']++;

            // Remove old character from the window
            s2Map[s2.charAt(i) - 'a']--;
        }

        // Check the last window
        return matches(s1Map, s2Map);
    }

    // Compare the two frequency maps
    private boolean matches(int[] s1Map, int[] s2Map) {

        for (int i = 0; i < 26; i++) {

            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }

        return true;
    }
}


Important Line:

s2Map[s2.charAt(i + s1.length()) - 'a']++;

s2.charAt(i + s1.length())
        ↓
Find the new character entering the window

- 'a'
        ↓
Convert character into array index

s2Map[index]
        ↓
Find that character's frequency

++
        ↓
Increase its frequency by 1


Example:

s1 = "ab"
s2 = "eidbaooo"

s1.length() = 2

Initial window:

"ei"

When the window moves:

"ei" → "id"

The new character is:

d

Its index is:

'd' - 'a'
= 3

So:

s2Map[3]++;


This means:

Increase the frequency of 'd' by 1.


Important Line:

s2Map[s2.charAt(i) - 'a']--;

This removes the old character from the window.

So when the window moves:

Old character → Remove
New character → Add


Sliding Window:

"ei"
 ↓
Remove e
Add d
 ↓
"id"
 ↓
Remove i
Add b
 ↓
"db"
 ↓
Remove d
Add a
 ↓
"ba"


When we reach:

"ba"

The frequency is the same as:

"ab"

Therefore:

return true;


Algorithm:

1. Check if s1 is longer than s2.
2. Create two frequency arrays of size 26.
3. Store the frequency of characters in s1.
4. Store the frequency of the first window of s2.
5. Compare both frequency arrays.
6. If they match, return true.
7. Add the new character entering the window.
8. Remove the old character leaving the window.
9. Continue sliding the window.
10. Check the final window.
11. Return the result.


Easy Rule:

Create frequency map for s1
        ↓
Create first window in s2
        ↓
Compare frequencies
        ↓
Match?
   ↓          ↓
 YES          NO
  ↓            ↓
true       Slide window
              ↓
       Add new character
              ↓
       Remove old character
              ↓
            Compare
              ↓
           Continue


Remember:

s1Map
↓
Frequency of characters in s1


s2Map
↓
Frequency of characters in current window


s2.charAt()
↓
Gets a character from s2


- 'a'
↓
Converts character into array index


++
↓
Add character frequency


--
↓
Remove character frequency


matches()
↓
Checks whether both frequency arrays are equal


Complexity:

Time Complexity: O(n)

The sliding window moves through s2 once.
The matches() method checks only 26 characters each time.
Since 26 is constant, the overall complexity is O(n).


Space Complexity: O(1)

Only two arrays of fixed size 26 are used.

s1Map → 26
s2Map → 26

Since the size is fixed, the space complexity is O(1).