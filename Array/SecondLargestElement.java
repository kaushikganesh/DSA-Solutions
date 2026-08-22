SecondLargestElement.java


Problem:

Given an integer array, find the second largest distinct element in the array.

If the array has 0 or 1 element, return -1.

If all elements are the same, return the largest element.


Example:

Input:
arr = [4, 6, 5, 1, 2]

Output:
5

Explanation:

The largest element is 6.

The second largest element is 5.

Therefore:

Second Largest = 5


Approach:

Use two variables:

max → stores the largest element.

secondMax → stores the second largest distinct element.

Initially, both max and secondMax are set to Integer.MIN_VALUE.

Integer.MIN_VALUE means the smallest possible value that an int can store in Java.

Integer.MIN_VALUE = -2147483648

Example:

int max = Integer.MIN_VALUE;

Initially:

max = -2147483648

If the current number is 4:

4 > -2147483648

Therefore:

max = 4


Code:

import java.util.*;

class SecondLargestElement {

    public static void main(String[] args) {

        int[] arr1 = {4,6,5,1,2};
        int[] arr2 = {};
        int[] arr3 = {5,5,5};
        int[] arr4 = {5,5,4};

        System.out.println(findSecondLargestElement(arr1));
        System.out.println(findSecondLargestElement(arr2));
        System.out.println(findSecondLargestElement(arr3));
        System.out.println(findSecondLargestElement(arr4));
    }

    private static int findSecondLargestElement(int[] arr) {

        if(arr.length == 0 || arr.length == 1)
            return -1;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int num : arr) {

            if(max < num) {

                secondMax = max;
                max = num;

            } else if(secondMax < num && num != max) {

                secondMax = num;
            }
        }

        if(secondMax == Integer.MIN_VALUE) {
            return max;
        }

        return secondMax;
    }
}


Algorithm:

1. Create two variables:

   max = Integer.MIN_VALUE

   secondMax = Integer.MIN_VALUE


2. Check whether the array length is 0 or 1.


3. If the length is 0 or 1:

   Return -1.


4. Traverse every number in the array.


5. Check whether num is greater than max.


6. If num is greater than max:

   Move max into secondMax.

   Update max with num.


7. Otherwise, check:

   secondMax < num

   AND

   num != max


8. If both conditions are true:

   Update secondMax with num.


9. After the loop, check whether secondMax is still Integer.MIN_VALUE.


10. If it is:

    Return max.


11. Otherwise:

    Return secondMax.


Easy Rule:

Current number > max?

        YES
          ↓
secondMax = max
          ↓
    max = num


        NO
          ↓
Is num > secondMax
AND num != max?

        YES
          ↓
secondMax = num


Finally:

secondMax found?
      ↓
     YES
      ↓
return secondMax


If no distinct secondMax:
      ↓
return max


Important:

max → Largest element
secondMax → Second largest distinct element
num → Current element
Integer.MIN_VALUE → Smallest possible int value


Complexity:

Time Complexity: O(n)
The array is traversed only once.

Space Complexity: O(1)
Only two variables are used: max & secondMax