package processor;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String MENU = "1. Add matrices\n" +
            "2. Multiply matrix to a constant\n" +
            "3. Multiply matrices\n" +
            "4. Transpose matrix\n" +
            "5. Calculate a determinant\n" +
            "6. Inverse matrix\n" +
            "0. Exit";
    public static void main(String[] args) {
        int action = -1;
        while (action != 0) {
            System.out.println(MENU);
            System.out.print("Your choice: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    multipConstMenu();
                    break;
                case 3:
                    multipMatrixMenu();
                    break;
                case 4:
                    transMenu();
                    break;
                case 5:
                    determinantMenu();
                    break;
                case 6:
                    invertMenu();
                    break;
            }
            System.out.println();
        }
    }

    private static void invertMenu() {
        System.out.print("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter matrix:\n");
        double[][] matrix1 = readMatrixDouble(rows, cols);
        System.out.println("The result is:");
        printMatrix(Matrix.invertMatrix(matrix1));

    }

    private static void determinantMenu() {
        System.out.print("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter matrix:\n");
        double[][] matrix1 = readMatrixDouble(rows, cols);
        System.out.println("The result is:");
        System.out.println(Matrix.determinant(matrix1));
    }

    private static void multipMatrixMenu() {
        System.out.print("Enter size of first matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter first matrix:\n");
        double[][] matrix1 = readMatrixDouble(rows, cols);
        System.out.print("Enter size of second matrix: ");
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter second matrix:\n");
        double[][] matrix2 = readMatrixDouble(rows, cols);
        System.out.print("The multiplication result is:\n");
        printMatrix(Matrix.multiplyMatrixByMatrix(matrix1, matrix2));

    }
    private static void multipConstMenu() {
        System.out.print("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter matrix:\n");
        double[][] matrix1 = readMatrixDouble(rows, cols);
        System.out.print("Enter multiplier: ");
        int multiplier = scanner.nextInt();
        System.out.print("The multiplication result is:\n");
        printMatrix(Matrix.multiplyMatrixByScalar(matrix1, multiplier));

    }
    private static void addMenu() {
        System.out.print("Enter size of first matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter first matrix(rows columns):\n");
        double[][] matrix1 = readMatrixDouble(rows, cols);
        System.out.print("Enter size of second matrix: ");
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter second matrix\n");
        double[][] matrix2 = readMatrixDouble(rows, cols);
        System.out.print("The addition result is:\n");
        printMatrix(Matrix.addMatrix(matrix1, matrix2));
    }
    private static void transMenu() {
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        System.out.print("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter matrix:\n");
        double[][] matrix1 = readMatrixDouble(rows, cols);
        switch (choice) {
            case 1:
                matrix1 = Matrix.transposeMain(matrix1);
                break;
            case 2:
                matrix1 = Matrix.transposeSide(matrix1);
                break;
            case 3:
                matrix1 = Matrix.transposeVert(matrix1);
                break;
            case 4:
                matrix1 = Matrix.transposeHor(matrix1);
                break;
        }
        System.out.println("The result is:");
        printMatrix(matrix1);
    }



    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }



    private static int[][] readMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
    private static double[][] readMatrixDouble(int rows, int cols) throws ArrayIndexOutOfBoundsException{
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Double.parseDouble(line[j]);
            }
        }
        return matrix;
    }
}
