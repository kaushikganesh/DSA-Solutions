Problem:
Given an integer array nums, return true if any value appears at least twice in the array. Return false if every element is distinct.

Example:
Input: nums = [1, 2, 3, 1]
Output: true

Explanation:
1 appears more than once.


Approach:

Use a HashSet to store numbers that we have already seen.
Number already in HashSet → Duplicate found → return true
Number not in HashSet → Add it to HashSet

Code:

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {

            if (seenNumbers.contains(num)) {
                return true;
            }

            seenNumbers.add(num);
        }

        return false;
    }
}



Algorithm:

1. Create an empty HashSet.
2. Traverse each number in the array.
3. Check if the number is already in the HashSet.
4. If yes → return true.
5. If no → add the number to the HashSet.
6. If the loop ends → return false.


Complexity:

* Time Complexity: O(n) — traverse the array once.
* Space Complexity: O(n) — HashSet may store up to n elements.





