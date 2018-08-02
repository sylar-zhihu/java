package BinarySearch;

/*
 * 作者:
 * 日期:2017年6月14日:上午11:06:37
 * 程序作用:
**/
public class A {
    
    public static void main(String[] args) {
        int[] array={1,5,9,12,55,56};
        int binarySearch = binarySearch(array,56);
        System.out.println(binarySearch);
    }
    public static int binarySearch(int[] a, int target) {
        return binarySearch(a, 0, a.length - 1, target);
    }

    public static int binarySearch(int[] a, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }

        if (target == a[middle]) {
            return middle;
        } else if (target < a[middle]) {
            return binarySearch(a, start, middle - 1, target);
        } else {
            return binarySearch(a, middle + 1, end, target);
        }
    }

}
