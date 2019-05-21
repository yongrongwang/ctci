package ctciLibrary;

public class AsSortedMethods {
    public static int randomIntInRange(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }

    public static int[] randomArray(int N, int min, int max) {
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++)
            array[i] = randomIntInRange(min, max);
        return array;
    }

    public static String arrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int a : array)
            builder.append(a + ", ");
        return builder.toString();
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] mat = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = randomIntInRange(min, max);
            }
        }
        return mat;
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
                if (mat[i][j] >= 0)
                    System.out.print(" ");
                if (mat[i][j] > -10 && mat[i][j] < 10)
                    System.out.print(" ");
                if (mat[i][j] > -100 && mat[i][j] < 100)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static LinkedListNode randomLinkedList(int N, int min, int max) {
        LinkedListNode head = new LinkedListNode(randomIntInRange(min, max), null, null);
        LinkedListNode first = head;
        for (int i = 1; i < N; i++) {
            LinkedListNode second = new LinkedListNode(randomIntInRange(min, max), null, null);
            first.setNext(second);
            first = second;
        }
        return head;
    }
}
