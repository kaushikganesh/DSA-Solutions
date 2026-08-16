LongestConsecutiveSequence128.java

Problem:
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Example:

Input:
nums = [100,4,200,1,3,2]

Output:
4

Explanation:

The longest consecutive sequence is:

1 → 2 → 3 → 4

Length = 4

Approach:
Use a HashSet to store all numbers.
For each number, check if the previous number (num - 1) exists.
If it exists, skip it because it is not the start of a sequence.
If it does not exist, start counting from that number.
Keep checking for the next number (currentNum + 1).
Update the longest sequence found.

Code:

import java.util.HashSet;

class Solution {

public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    HashSet<Integer> numSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        numSet.add(nums[i]);
    }
    int longestSub = 1;
    for (int num : numSet) {
        if (numSet.contains(num - 1)) {
            continue;
        }
        int currentNum = num;
        int currentSub = 1;
        while (numSet.contains(currentNum + 1)) {
            currentNum++;
            currentSub++;
        }
        longestSub = Math.max(longestSub, currentSub);
    }
    return longestSub;
}

}

Algorithm:

1. Create an empty HashSet.
2. Store all numbers from the array in the HashSet.
3. For every number, check if num - 1 exists.
4. If num - 1 exists:
    Skip the number because it is not the start of a sequence.
5. If num - 1 does not exist:
    This is the starting number.
6. Check whether currentNum + 1 exists.
7. Keep increasing currentNum and currentSub while consecutive numbers exist.
8. Update longestSub using Math.max().
9. Return longestSub.

Easy Rule:

Previous number exists?
↓
YES → Skip

  NO
    ↓

Start counting
↓
Check next number
↓
Keep counting


Complexity:

Time Complexity: O(n) – each number is processed using HashSet operations.

Space Complexity: O(n) – HashSet stores all the numbers.