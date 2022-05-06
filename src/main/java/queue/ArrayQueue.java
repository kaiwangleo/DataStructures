package queue;

/**
 * @author leo
 * @version 1.0
 * @date 2022/4/21 22:50
 */
public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueue1 arrayQueue = new ArrayQueue1(3);
        char key = ' ';
    }
}


/**
 * 使用数组模拟队列
 */
class ArrayQueue1 {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放数据 模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     */
    public ArrayQueue1(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        /**
         * 指向队列头的前一个位置
         * */
        front = -1;
        /**
         * 指向队列尾的具体数据
         * */
        rear = -1;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 出队列
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];

    }

    /**
     * 显示队列所有数据
     */

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("no data");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("no data");
            throw new RuntimeException("队列为空");

        }
        return arr[front + 1];
    }

}
