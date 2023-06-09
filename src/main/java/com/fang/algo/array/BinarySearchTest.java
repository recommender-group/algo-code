package com.fang.algo.array;

public class BinarySearchTest {
    public static void main(String[] args) {

        System.out.println(findLossValue());
    }

    // 等差数列 求缺失的值
    private static int findLossValue() {
        // tips 要学会使用二分查找，该方法通常都是最优解
        int[] arr = {1, 3, 5, 9, 11, 13, 15, 17, 19};
        // 1.求公差
        int d = (arr[arr.length - 1] - arr[0]) / arr.length;
        // 2.求出缺失的值
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) { // 小于表示2个值 小于等于表示可以极限到只有一个值
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= (arr[0] + mid * d)) { // 小于等于 表示缺失的值在右侧
                left = mid + 1;
            } else if (arr[mid] > (arr[0] + mid * d)) {
                right = mid - 1;
            }
        }
        return arr[0] + (left) * d;
    }

    // 1, 3, 5, 7, 9, 13, 15, 17, 19
    // 0, 1, 2, 3, 4, 5,  6,   7, 8
    /*
     * 1. 中间为4
     *  9=1+2*4
     *  left=mid+1=5
     * 2. mid= 5+(8-5)/2=6
     *  15 > 1+6*2 说名缺失的值在左侧
     *  right=mid-1=5
     * 3. mid=5+(5-5)/2=5
     *  13 >1+5*2 说名缺失的值在左侧
     *  right=mid-1=4
     *  return 1+5*2=11
     */

}
