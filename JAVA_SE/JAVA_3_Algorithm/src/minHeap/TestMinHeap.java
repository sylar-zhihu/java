package minHeap;
/*
 * 作者:
 * 日期:2017年5月4日:上午10:50:47
 * 程序作用: 完成检测
**/
public class TestMinHeap {
    public static void main(String[] args) {
        // 源数据
        int[] data = { 56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45 };

        int topK=3;
        // 获取Top5
        int[] top5 = MinHeap.topK(data, topK);

        for (int i = 0; i < topK; i++) {
            System.out.println(top5[i]);
        }
    }

}
