import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        buySellStcok(null);
    }

    public static void printArrStr() {
        String[] strArr = { "h", "k", "sded" };
        List<String> myList = new ArrayList<>();
        myList.add("ss");
        myList.add("kkk");
        System.out.println(String.join("", strArr));
    }

    /** Array and Hashing */
    public static int[] twoSum(int[] arrInput) {
        /**
         * 
         * 1
         * Given an array of integers nums and an integer target, return indices of the
         * two numbers such that they add up to target.
         * 
         * You may assume that each input would have exactly one solution, and you may
         * not use the same element twice.
         * 
         * You can return the answer in any order.
         * Example 1:
         * 
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         * Example 2:
         * 
         * Input: nums = [3,2,4], target = 6
         * Output: [1,2]
         * Example 3:
         * 
         * Input: nums = [3,3], target = 6
         * Output: [0,1]
         * 
         */

        // int[] inputs = { 2, 7, 11, 15 };
        int[] inputs = { 3, 3 };

        // int[] inputs = { 3, 2, 4 };

        int target = 6;
        Map<Integer, Integer> myMap = new HashMap<>();

        for (var i = 0; i < inputs.length; i++) {
            if (myMap.containsKey(inputs[i])) {
                // return new int[] { inputs[myMap.get(inputs[i])], inputs[i] }; // returns
                // actual values
                return new int[] { myMap.get(inputs[i]), i }; // returns actual values

            }

            myMap.put(target - inputs[i], i);

        }

        return new int[] {};
    }

    public static boolean containsDuplicate(int[] arrInput) {

        /**
         * 
         * 217
         * Given an integer array nums, return true if any value appears at least twice
         * in the array, and return false if every element is distinct.
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [1,2,3,1]
         * 
         * Output: true
         * 
         * Explanation:
         * 
         * The element 1 occurs at the indices 0 and 3.
         * 
         * Example 2:
         * 
         * Input: nums = [1,2,3,4]
         * 
         * Output: false
         * 
         * Explanation:
         * 
         * All elements are distinct.
         * 
         * Example 3:
         * 
         * Input: nums = [1,1,1,3,3,4,3,2,4,2]
         * 
         * Output: true
         * 
         * 
         */

        // int[] nums = { 1, 2, 3 };
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        Set<Integer> mySet = new HashSet<>();
        for (var i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                return true;
            }
            mySet.add(nums[i]);
        }

        return false;
    }

    public static boolean anagram(String str) {
        /**
         * 242
         * Given two strings s and t, return true if t is an anagram of s, and false
         * otherwise.
         * 
         * Example 1:
         * 
         * Input: s = "anagram", t = "nagaram"
         * Output: true
         * 
         * Example 2:
         * 
         * Input: s = "rat", t = "car"
         * 
         * Output: false
         * 
         */

        String s = "anagram";
        String t = "nagaram";
        Map<String, Integer> myMap = new HashMap<>();
        Map<String, Integer> myMap2 = new HashMap<>();
        if (s.length() != t.length())
            return false;

        for (var i = 0; i < s.length(); i++) {
            String strKey = String.valueOf(s.charAt(i));
            if (!myMap.containsKey(strKey)) {
                myMap.put(strKey, 1);
            } else {
                Integer storedValue = myMap.get(strKey);
                myMap.put(strKey, storedValue + 1);
            }
        }

        for (var i = 0; i < t.length(); i++) {
            String strKey = String.valueOf(t.charAt(i));
            if (!myMap2.containsKey(strKey)) {
                myMap2.put(strKey, 1);
            } else {
                Integer storedValue = myMap2.get(strKey);
                myMap2.put(strKey, storedValue + 1);
            }
        }
        // System.out.println(myMap.toString());
        // System.out.println(myMap2.toString());

        for (var key : myMap.keySet()) {
            Integer val1 = myMap.get(key);
            Integer val2 = myMap2.get(key);
            if (val1 != val2)
                return false;
        }
        return true;
    }

    public static String[][] groupAnagram(String[] input) {
        /**
         * 
         * Given an array of strings strs, group the anagrams together. You can return
         * the answer in any order.
         * 
         * Example 1:
         * 
         * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * 
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         * 
         * Explanation:
         * 
         * There is no string in strs that can be rearranged to form "bat".
         * The strings "nat" and "tan" are anagrams as they can be rearranged to form
         * each other.
         * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
         * form each other.
         * Example 2:
         * 
         * Input: strs = [""]
         * 
         * Output: [[""]]
         * 
         * Example 3:
         * 
         * Input: strs = ["a"]
         * 
         * Output: [["a"]]
         * 
         */

        class LocalHelper {
            public static String sortString(String input) {
                char[] charArray = input.toCharArray();
                Arrays.sort(charArray);
                return String.valueOf(charArray);
            }
        }

        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Map<String, ArrayList<String>> myMap = new HashMap<>();

        for (String str : strs) {
            String sortedStr = LocalHelper.sortString(str);
            if (myMap.containsKey(sortedStr)) {
                myMap.get(sortedStr).add(sortedStr);
            } else {
                ArrayList<String> l = new ArrayList<>();
                l.add(str);
                myMap.put(sortedStr, l);
            }

        }

        ArrayList<ArrayList<String>> listOfResults = new ArrayList<>();
        for (String key : myMap.keySet()) {
            listOfResults.add(myMap.get(key));
        }

        return new String[][] { { "", "" } };
    }

    public static int[] sortBubble() {

        int[] arr = { 0, 4, 5, 2 };

        for (var i = 0; i < arr.length; i++) {
            for (var j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] twoSumII(int[] input, int target) {
        /**
         * 
         * 
         * 
         * 
         */

        return new int[] {1, 2, 3,4};

    }

    // dont understand
    public static int rotatedSortedArray(int[] arr) {
        /**
         * 
         * There is an integer array nums sorted in ascending order (with distinct values).

            Prior to being passed to your function, nums is possibly left rotated at an unknown index k
            (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], 
            nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left 
            rotated by 3 indices and become [4,5,6,7,0,1,2].

            Given the array nums after the possible rotation and an integer target, return the index of 
            target if it is in nums, or -1 if it is not in nums.

            You must write an algorithm with O(log n) runtime complexity.

            Example 1:

            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4
            Example 2:

            Input: nums = [4,5,6,7,0,1,2], target = 3
            Output: -1
            Example 3:

            Input: nums = [4,5,6,7,0,1,2], target = 5
            Output: 1
            Example 4:

            Input: nums = [1], target = 0
            Output: -1

            [4 5 6 7 8 0 1 2]
         * 
         * 
         */

        // class BinarySearch {
        //     public static int search(int[] nums, int target) {
        //         int low = 0;
        //         int high = nums.length -1;
        //         int mid = (high - low) /2;
        //         int indexFound = -1;

        //         while (low <= high) {
        //             if (nums[mid] == target) {
        //                 indexFound = mid;
        //                 return indexFound;
        //             }else if (target < nums[mid]) {
        //                 high = mid - 1;
        //                 mid = (high - low) / 2;

        //             } else if (target > nums[mid]) {
        //                 low = mid + 1;
        //                 mid = (high + low) / 2;
        //             }
        //         }
        //         return indexFound;
        //     }
            
        // }

        // int[] nums = {4,5,6,7,0,1,2};
        // int target = 5;
        // int indexFound = -1;

        // // still dont understand

        return 0;
    }

    public static int[] productOfArrayExcepSelf(int[] input) {
        /**
         * 238
         * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all 
         * the elements of nums except nums[i].

            The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

            You must write an algorithm that runs in O(n) time and without using the division operation.
            Example 1:

            Input: nums = [1,2,3,4]
            Output: [24,12,8,6]
            Example 2:

            Input: nums = [-1,1,0,-3,3]
            Output: [0,0,9,0,0]
         * 
         * 
         */
        int[] nums = {1,2,3,4};
        int pointer;

        List<Integer> results = new ArrayList<>();
        int[] resultArr = new int[nums.length];

        for (var i=0; i< nums.length; i++) {
            pointer = 0;
            int product = 1;
            while (pointer < nums.length) {
                if (i != pointer) {
                    product = product * nums[pointer]; 
                }
            }
            resultArr[i] = product;
            results.add(product);
        }

        System.out.println(results);

        return resultArr;
    }

    public static int[][] threeSum(int[] input) {
        /**
         * 15
         * 
         * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
         * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

            Notice that the solution set must not contain duplicate triplets.
            Example 1:

            Input: nums = [-1,0,1,2,-1,-4]
            Output: [[-1,-1,2],[-1,0,1]]
            Explanation: 
            nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
            nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
            nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
            The distinct triplets are [-1,0,1] and [-1,-1,2].
            Notice that the order of the output and the order of the triplets does not matter.
            Example 2:

            Input: nums = [0,1,1]
            Output: []
            Explanation: The only possible triplet does not sum up to 0.
            Example 3:

            Input: nums = [0,0,0]
            Output: [[0,0,0]]
            Explanation: The only possible triplet sums up to 0.
            
         * 
         */

        int[] nums = {-1,0,1,2,-1,-4};
        // assume the lengh input minimal 3
        int pointer1 =0;
        int pointer2 = pointer1 + 1;
        int pointer3 = pointer2 +1;

        List<int[]> results = new ArrayList<>();
        Map<String, Integer> mappedResult = new HashMap<>();

        while (pointer1 < nums.length) {
            while (pointer2 < nums.length) {
                while (pointer3 < nums.length) {
                    int first = nums[pointer1];
                    int second = nums[pointer2];
                    int third = nums[pointer3];

                    int total = first + second + third;
                    if (total == 0) {
                        int[] triplets = {first, second, third};
                        results.add(triplets);
                        Arrays.sort(triplets);
                        List<Integer> mapKey = Arrays.asList(triplets)

                    }
                }
            }
        }

            
    }

    /** Two Pointers */
    public static boolean validPalindrom(String s) {
        /**
         * 125
         * A phrase is a palindrome if, after converting all uppercase letters into
         * lowercase letters and removing all non-alphanumeric characters, it reads the
         * same forward and backward. Alphanumeric characters include letters and
         * numbers.
         * 
         * Given a string s, return true if it is a palindrome, or false otherwise.
         * 
         * 
         * Example 1:
         * 
         * Input: s = "A man, a plan, a canal: Panama"
         * Output: true
         * Explanation: "amanaplanacanalpanama" is a palindrome.
         * Example 2:
         * 
         * Input: s = "race a car"
         * Output: false
         * Explanation: "raceacar" is not a palindrome.
         * Example 3:
         * 
         * Input: s = " "
         * Output: true
         * Explanation: s is an empty string "" after removing non-alphanumeric
         * characters.
         * Since an empty string reads the same forward and backward, it is a
         * palindrome.
         * 
         */

        // String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String normalizedStr = str2.replaceAll("[^a-zA-Z0-9]", ""); // perlu diingat. not alphanumeric
        System.out.println(normalizedStr);

        for (var i = 0; i < Math.floor((normalizedStr.length() / 2)); i++) {
            String firstEl = String.valueOf(normalizedStr.charAt(i));
            String secondEl = String.valueOf(normalizedStr.charAt(normalizedStr.length() - 1 - i));

            if (!firstEl.toLowerCase().equals(secondEl.toLowerCase())) {
                System.out.printf("%s %s\n", firstEl, secondEl);
                return false;
            }
        }
        return true;
    }

    public static int[] moveZeroes(int[] input) {
        /**
         * 283
         * Given an integer array nums, move all 0's to the end of it while maintaining
         * the relative order of the non-zero elements.
         * 
         * Note that you must do this in-place without making a copy of the array.
         * 
         * Example 1:
         * 
         * Input: nums = [0,1,0,3,12]
         * Output: [1,3,12,0,0]
         * Example 2:
         * 
         * Input: nums = [0]
         * Output: [0]
         * 
         */

        int[] nums = { 0, 1, 0, 3, 12 };
        // int[] nums = { 0 };

        // [1, 0, 3, 12, 0]
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        if (pointer1 == pointer2) {
            System.out.println(Arrays.toString(nums));
        }

        while (pointer1 != pointer2) {
            if (nums[pointer1] == 0) {
                int tempVal = nums[pointer2];
                nums[pointer2] = nums[pointer1];
                for (var i = pointer1; i < pointer2; i++) {
                    nums[i] = nums[i + 1];
                }
                pointer2 -= 1;
                nums[pointer2] = tempVal;
            } else {
                pointer1 += 1;
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    /** Sliding window */
    public static boolean containsDuplicateII(int[] input) {
        /**
         * 219
         * Given an integer array nums and an integer k, return true if there are two
         * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
         * - j) <= k.
         * 
         * Example 1:
         * 
         * Input: nums = [1,2,3,1], k = 3
         * Output: true
         * Example 2:
         * 
         * Input: nums = [1,0,1,1], k = 1
         * Output: true
         * Example 3:
         * 
         * Input: nums = [1,2,3,1,2,3], k = 2
         * Output: false
         * 
         */

        // int[] nums = { 1, 2, 3, 1, 2, 3 };
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        int pointer1 = 0;
        int pointer2 = k; // assume length >= k

        while (pointer2 <= nums.length - 1) {
            Map<Integer, Integer> myMap = new HashMap<>();
            for (var i = pointer1; i <= pointer2; i++) {
                if (myMap.containsKey(nums[i])) {
                    System.out.printf("found in index %d and %d \n", i, myMap.get(nums[i]));
                    return true;
                }

                myMap.put(nums[i], i);
            }
            pointer1 += 1;
            pointer2 += 1;
        }

        return false;
    }

    public static int longestSubstring(String input) {
        /**
         * 3
         * Given a string s, find the length of the longest substring without duplicate
         * characters.
         * 
         * Example 1:
         * 
         * Input: s = "abcabcbb"
         * Output: 3
         * Explanation: The answer is "abc", with the length of 3. Note that "bca" and
         * "cab" are also correct answers.
         * Example 2:
         * 
         * Input: s = "bbbbb"
         * Output: 1
         * Explanation: The answer is "b", with the length of 1.
         * Example 3:
         * 
         * Input: s = "pwwkew"
         * Output: 3
         * Explanation: The answer is "wke", with the length of 3.
         * Notice that the answer must be a substring, "pwke" is a subsequence and not a
         * substring.
         * 
         */
        String str = "pwwkew";
        char[] strArr = str.toCharArray();
        int pointer1 = 0;
        int pointer2 = pointer1;
        int maxSize = 0;
        Map<Integer, String> resultMap = new HashMap<>();

        while (pointer1 < strArr.length) {
            List<String> listStr = new ArrayList<>();
            while (pointer2 < strArr.length) {
                String testValue = String.valueOf(strArr[pointer2]);
                if (!listStr.contains(testValue)) {
                    listStr.add(testValue);
                } else {
                    break;
                }
                pointer2 += 1;
            }
            pointer1 += 1;
            resultMap.put(listStr.size(), String.join("", listStr));
            if (listStr.size() > maxSize) {
                maxSize = listStr.size();
            }
        }

        System.out.printf("maxsize: %d, str: %s  \n", maxSize, resultMap.get(maxSize));
        return maxSize;
    }

    public static int[][] mergeIntervals() {
        /**
         * 
         * Given an array of intervals where intervals[i] = [starti, endi], merge all
         * overlapping intervals, and return an array of the non-overlapping intervals
         * that cover all the intervals in the input.
         * 
         * 
         * Example 1:
         * 
         * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
         * Output: [[1,6],[8,10],[15,18]]
         * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
         * Example 2:
         * 
         * Input: intervals = [[1,4],[4,5]]
         * Output: [[1,5]]
         * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
         * Example 3:
         * 
         * Input: intervals = [[4,7],[1,4]]
         * Output: [[1,7]]
         * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
         * 
         */

        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        List<Integer[]> mergedInterval = new ArrayList<>();
        int pointerNext = 1;
        int current = 0;
        if (intervals.length < 2)
            return intervals;

        while (pointerNext < intervals.length) {
            int[] currArr = intervals[current];
            int[] nextArr = intervals[pointerNext];
            if (nextArr[0] <= currArr[1]) {
                mergedInterval.add(new Integer[] { currArr[0], nextArr[1] });
                current = pointerNext + 1;
                pointerNext += 2;
            } else {
                mergedInterval.add(new Integer[] { currArr[0], currArr[1] });
                mergedInterval.add(new Integer[] { nextArr[0], nextArr[1] });
                current = pointerNext;
                pointerNext += 1;
            }
        }

        for (var i = 0; i < mergedInterval.size(); i++) {
            System.out.printf("[%d, %d], ", mergedInterval.get(i)[0], mergedInterval.get(i)[1]);

        }

        return new int[][] { { 1, 2 } };
    }

    public static int buySellStcok(int[] input) {
        /**
         * 121
         * 
         * You are given an array prices where prices[i] is the price of a given stock on the ith day.

            You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

            Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

            

            Example 1:

            Input: prices = [7,1,5,3,6,4]
            Output: 5
            Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
            Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
            Example 2:

            Input: prices = [7,6,4,3,1]
            Output: 0
            Explanation: In this case, no transactions are done and the max profit = 0.
         * 
         * 
         */
        int[] prices = {7,1,5,3,6,4};
        int sellIndex;
        int buyIndex;
        int pointer1=0;
        int pointer2 = pointer1;

        if (prices.length == 0) return 0;
        if (prices.length == 1) return prices[0];

        sellIndex = pointer1;
        buyIndex = pointer1;

        boolean found = false;

        while (pointer1 < prices.length) {
            while (pointer2 < prices.length) {
                if(prices[pointer2] < prices[buyIndex]) {
                    buyIndex = pointer2;
                    sellIndex = pointer2;
                    break;
                }

                if(prices[pointer2] > prices[sellIndex]) {
                    sellIndex = pointer2;
                }

                if (pointer2 == prices.length -1) {
                    found = true;
                    break;
                }

                pointer2 += 1;
            }
            
            if (found == true) {
                break;
            }
            pointer1 = pointer2;
        }

        int maxProfit = prices[sellIndex] - prices[buyIndex];
        System.out.printf("max profit: %d", maxProfit);

        return maxProfit;

    }

    public static int maximumProductSubArray(int[] input) {
        /**
         * 152
         * Given an integer array nums, find a subarray that has the largest product, and return the product.

            The test cases are generated so that the answer will fit in a 32-bit integer.

            Note that the product of an array with a single element is the value of that element.

            Example 1:

            Input: nums = [2,3,-2,4]
            Output: 6
            Explanation: [2,3] has the largest product 6.
            Example 2:

            Input: nums = [-2,0,-1]
            Output: 0
            Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
            

            Constraints:

            1 <= nums.length <= 2 * 104
            -10 <= nums[i] <= 10
            The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
         * 
         * 
         */
        int[] nums = {2,3,-2,4};
        int pointer1 =0 ;
        int pointer2 = pointer1 + 1;
        if (nums.length == 1) return nums[pointer1];

        int maxProduct = nums[pointer1] * nums[pointer2];

        while(pointer2 < nums.length) {
            int product = nums[pointer1] * nums[pointer2];

            if (maxProduct > product) {
                maxProduct = product;
            }
            
            pointer1 +=1;
            pointer2 +=1;
        }

        return maxProduct;
    }
    /** Binary Search */
    public static int searchInsertPosition(int[] input) {
        /**
         * Given a sorted array of distinct integers and a target value, return the
         * index if the target is found. If not, return the index where it would be if
         * it were inserted in order.
         * 
         * You must write an algorithm with O(log n) runtime complexity.
         * 
         * Example 1:
         * 
         * Input: nums = [1,3,5,6], target = 5
         * Output: 2
         * Example 2:
         * 
         * Input: nums = [1,3,5,6], target = 2
         * Output: 1
         * Example 3:
         * 
         * Input: nums = [1,3,5,6], target = 7
         * Output: 4
         * 
         */

        // int[] nums = { 1, 3, 5, 6 };
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middleIndex = low + (high - low) / 2;
            if (nums[middleIndex] == target) {
                System.out.printf("found in index %d\n", middleIndex);
                return middleIndex;
            } else if (target > nums[middleIndex]) {
                low = middleIndex + 1;
            } else {
                high = middleIndex - 1;
            }
        }

        System.out.printf("Should inserted in index %d\n", low);
        return low;
    }

}
