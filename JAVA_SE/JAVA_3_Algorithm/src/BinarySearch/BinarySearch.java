package BinarySearch;
/*
 * 作者:
 * 日期:2017年6月14日:上午9:52:34
 * 程序作用:
**/
public class BinarySearch {

    /**
     * 用途说明：返回对应key的下标，不存在返回-1,非递归版本
     * 
     * @param array
     * @param key
     * @return
     */
    public static int binarySearchNoRecursive(int[] array, int key) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (array[mid] > key) {
                end = mid - 1;
            } else if (array[mid] < key) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 用途说明：递归版本 返回对应key的下标，不存在返回-1,非递归版本
     * 
     * @param array
     * @param begin
     * @param end
     * @param key
     * @return
     */
    public static  int binaraySearchRecursive(int[] array, int begin, int end, int key) {
        if (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (array[mid] > key) {
                return binaraySearchRecursive(array, begin, mid - 1, key);
            } else if (array[mid] < key) {
                return binaraySearchRecursive(array, mid + 1, end, key);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        int[] array={1,5,9,12,55,56};
        int num=1;
        int binarySearchNoRecursive = binarySearchNoRecursive(array,num);
        System.out.println(binarySearchNoRecursive);
        int binaraySearchRecursive = binaraySearchRecursive(array, 0, array.length-1, num);
        System.out.println(binaraySearchRecursive);
    }

}
