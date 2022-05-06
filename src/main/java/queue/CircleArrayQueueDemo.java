package queue;

import java.util.Scanner;

/**
 * @author leo
 * @version 1.0
 * @date 2022/5/6 23:17
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        /**
         * 这里设置4 其队列有效数据最大为3
         * */
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):推出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列获取数据");
            System.out.println("h(head):查看队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    int data = arrayQueue.getQueue();
                    System.out.println("取出的数据是" + data);
                default:
                    break;
            }
        }

    }


}

class CircleArray {
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

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        /**
         * 直接将数据加入
         * */
        arr[rear] = n;
        /**
         * 将rear后移 这里必须考虑取模
         * */
        rear = (rear + 1) % maxSize;

    }


    /**
     * 出队列
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        /**
         * 这里front指向队列第一个元素
         * 1 先把front对应的值保存到一个临时变量
         * 2 将front后移
         * 3 将临时保存的变量返回
         * */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    /**
     * 显示队列所有数据
     */

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("no data");
        }

        /**
         * 从front开始遍历，遍历多少个元素？
         *
         *
         * */
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("no data");
            throw new RuntimeException("队列为空");

        }
        return arr[front];
    }

}
