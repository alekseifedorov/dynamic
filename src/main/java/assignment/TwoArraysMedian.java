package assignment;

class TwoArraysMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        boolean even = (nums1.length + nums2.length) % 2 == 0;

        int medPos = (nums1.length + nums2.length) / 2 - 1;

        if (nums1 == null || nums1.length == 0) {
            nums1 = nums2;
        }

        int bottom1 = 0;
        int bottom2 = 0;

        int top1 = nums1.length - 1;
        int top2 = nums2.length - 1;

        int i = top2;
        int j = top1;

        while ((i + j) != medPos) {

            System.out.println("i: " + i);
            System.out.println("j: " + j);

            j = findLess(nums1, nums2[i], bottom1, top1);

            if (j == -1) {
                i = findNextAbove(nums2, nums1[0], bottom2, top2);
                if (i > medPos) {
                    i = medPos;
                    break;
                }
                if ((i + j) == medPos) {
                    break;
                } else {
                    i = i + (top2 - i) / 4;
                    continue;
                }
            }

            i = findNextAbove(nums2, nums1[j], bottom2, top2);

            if (i + j < medPos) {
                i = (top2 + i) / 2;
                continue;
            }

            if (i + j > medPos) {
                if(i < (bottom2 + i) / 2) {
                    i = (bottom2 + i) / 2;
                } else {
                    j = (bottom1 + j) /2;
                }

                continue;
            }
        }

        if (even) {
            return (nums1[j] + nums2[i]) / 2d;
        } else {
            return Math.max(nums2[i], nums1[j]);
        }
    }

    private int findNextAbove(int[] nums, int value, int bottom, int top) {
        if (nums[top] < value) {
            return -1;
        }

        while (true) {
            int limit = (bottom + top) / 2;
            if (nums[limit] < value) {
                bottom = limit;
            } else {
                top = limit;
            }

            if (Math.abs(top - bottom) <= 1) {
                return bottom > value ? bottom : top;
            }
        }
    }

    int findLess(int[] nums, int value, int bottom, int top) {
        if (value > nums[top]) {
            return top;
        }

        if (value < nums[bottom]) {
            return bottom;
        }

        int min = bottom;
        int max = top;
        int pos = top;

        while (true) {
            pos = (min + max) / 2;

            if (nums[pos] < value) {
                return pos;
            } else {
                max = pos;
            }
        }
    }
}