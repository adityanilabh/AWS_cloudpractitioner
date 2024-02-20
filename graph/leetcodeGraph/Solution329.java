class Solution {
    private int getDFS(int[][] matrix, int[][] resultArray, int rowIndex, int columnIndex, int value) {
        if (rowIndex < 0 || rowIndex >= matrix.length || columnIndex < 0 || columnIndex >= matrix[0].length || matrix[rowIndex][columnIndex] <= value) {
            return 0;
        }
        if (resultArray[rowIndex][columnIndex] != 0) {
            return resultArray[rowIndex][columnIndex];
        }
        int a = getDFS(matrix, resultArray, rowIndex - 1, columnIndex, matrix[rowIndex][columnIndex]);
        a = Math.max(a, getDFS(matrix, resultArray, rowIndex + 1, columnIndex, matrix[rowIndex][columnIndex]));
        a = Math.max(a, getDFS(matrix, resultArray, rowIndex, columnIndex + 1, matrix[rowIndex][columnIndex]));
        a = Math.max(a, getDFS(matrix, resultArray, rowIndex, columnIndex - 1, matrix[rowIndex][columnIndex]));
        resultArray[rowIndex][columnIndex] = a + 1;
        return resultArray[rowIndex][columnIndex];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] resultArray = new int[row][column];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result = Math.max(result, getDFS(matrix, resultArray, i, j, Integer.MIN_VALUE));
            }
        }
        return result;
    }
}
