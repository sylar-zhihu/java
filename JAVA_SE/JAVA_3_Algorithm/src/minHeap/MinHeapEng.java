package minHeap;

public class MinHeapEng {

    // store data
    private double[] data;

    // buildHeap
    public MinHeapEng(double[] data) {
        this.data = data;
        buildHeap();
    }

    private void buildHeap() {

        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            // heapifying each subheap
            heapify(i);
        }
    }

    private void heapify(int i) {
        // find child
        int leftNodeIndex = getLeftIndex(i);
        int rightNodeIndex = getRightIndex(i);

        // for smallestNodeIndex
        int smallestNodeIndex = i;

        // get smallestNodeIndex
        if (leftNodeIndex < data.length && data[leftNodeIndex] < data[i])
            smallestNodeIndex = leftNodeIndex;

        // get smallestNodeIndex
        if (rightNodeIndex < data.length && data[rightNodeIndex] < data[smallestNodeIndex])
            smallestNodeIndex = rightNodeIndex;

        // is heapifyed
        if (i == smallestNodeIndex)
            return;

        // swap smallestNodeIndex to curindex
        swap(i, smallestNodeIndex);

        // if swap reheapify
        heapify(smallestNodeIndex);
    }

    private int getRightIndex(int i) {
        return (i + 1) * 2;
    }

    private int getLeftIndex(int i) {
        return ((i + 1) * 2) - 1;
    }

    private void swap(int i, int j) {
        double tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public double getRoot() {
        return data[0];
    }

    public void setRoot(double root) {
        data[0] = root;
        heapify(0);
    }

    public static double[] topK(double[] data, int k) {
        // get top k to build minHeap
        double[] topk = new double[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }

        // build minHeap
        MinHeapEng heap = new MinHeapEng(topk);

        // process data remain
        for (int i = k; i < data.length; i++) {
            double root = heap.getRoot();

            // replace root
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }

        return topk;
    }

}
