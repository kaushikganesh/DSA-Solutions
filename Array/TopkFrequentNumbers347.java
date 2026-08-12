Problem:
Given an integer array nums and an integer k, return the k most frequent elements.

You may return the answer in any order.

Example:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Explanation:
1 appears 3 times.
2 appears 2 times.
3 appears 1 time.

The 2 most frequent elements are 1 and 2.


Approach:
Use a HashMap to store each number and its frequency.
Use a Min Heap to keep track of the k most frequent elements.


Code:

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {

            heap.add(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}


Algorithm:

1. Create an empty HashMap.

2. Traverse the array and count the frequency of each number.

3. Create a Min Heap based on frequency.

4. Add each number from the HashMap into the heap.

5. If heap size becomes greater than k:
       Remove the least frequent element.

6. Create an answer array of size k.

7. Remove elements from the heap and store them in the answer array.

8. Return the answer array.


Complexity:

* Time Complexity: O(n log k) — count elements and maintain a heap of size k.

* Space Complexity: O(n) — HashMap and heap store elements.