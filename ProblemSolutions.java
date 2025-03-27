/******************************************************************
 *
 *   Edwin Johnson / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        Set<Integer> set = new HashSet<>();
            for (int num : list1) {
                set.add(num); // Store all elements of list1 in a HashSet for fast lookup
             }
            for (int num : list2) {
                if (!set.contains(num)) { // Check if each element in list2 exists in set
                    return false;
                }
            }
            return true; // If all elements of list2 are found, return true
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min heap to store k largest elements
        for (int num : array) {
            minHeap.add(num); // Add element to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest element if heap size exceeds k
            }
        }
        return minHeap.poll(); // The root of the heap is the k-th largest element
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length]; // Create array to store both arrays
        System.arraycopy(array1, 0, mergedArray, 0, array1.length); // Copy array1 into mergedArray
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length); // Copy array2 into mergedArray
        Arrays.sort(mergedArray); // Sort the merged array
        return mergedArray;
    }

}
