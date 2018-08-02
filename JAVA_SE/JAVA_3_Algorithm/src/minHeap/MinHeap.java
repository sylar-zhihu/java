package minHeap;

public class MinHeap {

    // 堆的存储结构 - 数组
    private int[] data;

    // 传入的也是一个数组 但是没有排序
    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    // 将数组转换成最小堆
    private void buildHeap() {
        // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
        // *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            // 对有孩子结点的元素heapify
            heapify(i);
        }
    }

    // 当元素i的左右子树都是小根堆时，通过Heapify让i元素下降到适当的位置，以符合堆的性质。
    private void heapify(int i) {
        // 获取左右结点的数组下标
        int leftNodeIndex = getLeftIndex(i);
        int rightNodeIndex = getRightIndex(i);

        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int smallestNodeIndex = i;

        // 存在左结点，且左结点的值小于根结点的值
        if (leftNodeIndex < data.length && data[leftNodeIndex] < data[i])
            smallestNodeIndex = leftNodeIndex;

        // 存在右结点，且右结点的值小于以上比较的较小值
        if (rightNodeIndex < data.length && data[rightNodeIndex] < data[smallestNodeIndex])
            smallestNodeIndex = rightNodeIndex;

        // 左右结点的值都大于根节点，直接return，不做任何操作
        if (i == smallestNodeIndex)
            return;

        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        swap(i, smallestNodeIndex);

        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallestNodeIndex);
    }

    // 获取右结点的数组下标
    private int getRightIndex(int i) {
        return (i + 1) * 2;
    }

    // 获取左结点的数组下标
    private int getLeftIndex(int i) {
        return ((i + 1) * 2) - 1;
    }

    // 交换元素位置
    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // 获取对中的最小的元素，根元素
    public int getRoot() {
        return data[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root) {
        data[0] = root;
        heapify(0);
    }

    // 从data数组中获取最大的k个数
    public static int[] topK(int[] data, int k) {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        // 从k开始，遍历data
        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }

        return topk;
    }

}
