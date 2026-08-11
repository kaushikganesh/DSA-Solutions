Problem:
Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.
You may assume that each input has exactly one solution.

Example:
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9


Code:

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}


Algorithm:

1. Create an empty HashMap.
2. Traverse the array from left to right.
3. Find complement for each number in array = target - current number.
4. If complement exists in HashMap:
       Return its index and current number index.
5. Otherwise:
       Store current number and its index.
6. Return empty array if no pair is found.


Complexity:

* Time Complexity: O(n) — traverse the array once.
* Space Complexity: O(n) — HashMap may store up to n elements.

