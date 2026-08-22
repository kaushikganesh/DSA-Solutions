FirstMissingPositive41.java


Problem:

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) extra space.


Example:

Input:
nums = [3, 4, -1, 1]

Output:
2


Explanation:

The positive numbers are:

1 → exists
2 → missing
3 → exists
4 → exists

Therefore, the smallest missing positive integer is 2.


Approach:

Use the array itself to mark which positive numbers exist.

First, check whether 1 exists.
If 1 does not exist, return 1.

Replace all invalid numbers (<= 0 or > n) with 1.

Use negative values to mark numbers as present.

For a number x, make nums[x] negative.

Since index n does not exist, use index 0 to represent number n.

Finally, find the first positive position.
That position represents the missing number.


Code:

class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        boolean containsOne = false;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 1) {
                containsOne = true;
                break;
            }
        }

        if (!containsOne) {
            return 1;
        }


        for (int i = 0; i < n; i++) {

            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }


        for (int i = 0; i < n; i++) {

            int a = Math.abs(nums[i]);

            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            }
            else {
                nums[a] = -Math.abs(nums[a]);
            }
        }


        for (int i = 1; i < n; i++) {

            if (nums[i] > 0) {
                return i;
            }
        }


        if (nums[0] > 0) {
            return n;
        }


        return n + 1;
    }
}


Algorithm:

1. Find the length of the array and store it in n.

2. Check whether 1 exists in the array.

3. If 1 does not exist:
   Return 1.

4. Replace all invalid numbers with 1:
   - Negative numbers
   - Zero
   - Numbers greater than n

5. Traverse the array and take the absolute value of every number.

6. Use the number as an index and make that position negative.

7. If the number is n:
   Use index 0 to represent n.

8. Traverse from index 1 to n - 1.

9. If nums[i] is positive:
   i is missing.
   Return i.

10. If nums[0] is positive:
    n is missing.
    Return n.

11. If all numbers from 1 to n exist:
    Return n + 1.


Example:

Input:

nums = [3, 4, -1, 1]


Step 1:

1 exists.

Continue.


Step 2:

Replace invalid numbers.

[3, 4, -1, 1]

-1 is invalid.

So:

[3, 4, 1, 1]


Step 3:

Mark the numbers.


Number 3 exists:

Mark index 3 as negative.

[3, 4, 1, -1]


Number 4 exists:

4 == n

So use index 0.

[-3, 4, 1, -1]


Number 1 exists:

Mark index 1 as negative.

[-3, -4, 1, -1]


Number 1 exists again:

Index 1 is already negative.

[-3, -4, 1, -1]


Step 4:

Check from index 1.


Index 1:

nums[1] = -4

Negative → 1 exists.


Index 2:

nums[2] = 1

Positive → 2 is missing.


Therefore:

Output: 2


Easy Rule:

Number exists?
        ↓
Mark its index as negative
        ↓
Check the array
        ↓
First positive index
        ↓
That index is the missing number


Important:

Positive value → Number is missing

Negative value → Number exists

Index 0 → Represents number n


Complexity:

Time Complexity: O(n)

Space Complexity: O(1)

Time Complexity:
The array is traversed a few times.
Each traversal takes O(n).
Therefore, total time is O(n).

Space Complexity:
No extra array, HashMap or HashSet is used.
The original array is used for marking.
Therefore, extra space is O(1).