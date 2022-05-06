package sparsearray;

/**
 * @author leo
 * @version 1.0  稀疏数组
 * @date 2022/4/13 23:43
 */
/**
 * 当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
 *
 * 稀疏数组的处理方法是:
 * 记录数组一共有几行几列，有多少个不同的值
 * 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 *
 *
 *
 * */
public class SpaseArray {
    public static void main(String[] args) {
        /**
         * 创建一个原始的二维数组 11*11
         * 0 ：没有棋子  1 表示黑子  2 表示蓝子
         * */
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        /**
         * 将二维数组转稀疏数组
         * 1 先遍历二维数组 得到非0数据的个数
         * */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        /**
         * 创建对应的稀疏数组
         * */
        int sparse[][] = new int[sum + 1][3];
        sparse[0][0] = 11;
        sparse[0][1] = 11;
        sparse[0][2] = sum;

        /**
         * 遍历二维数组，将非0的数据放到数组中
         * */
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();
        for (int i = 0; i < sparse.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparse[i][0], sparse[i][1], sparse[i][2]);
        }
        System.out.println();
        /**
         * 将稀疏数组恢复成原始数组
         * */
        int[][] chessArr2 = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            /**
             * i行
             * */
            chessArr2[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        System.out.println();
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
