package org.mentormate.application.devcamp.trainee;

public class NextMatrixGenerator {
    public void generate(char[][] newMatrix, char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                generateGreenOrRed(i, j, matrix, newMatrix);
            }
        }
    }

    private void generateGreenOrRed(int i, int j, char[][] matrix, char[][] newMatrix) {
        //Rules:
        //1. Each red cell that is surrounded by exactly 3 or 6 green cells will also become green in the next generation.
        //2. A red cell will stay red in the next generation if it has either 0, 1, 2, 4, 5, 7 or 8 green neighbours.

        //3. Each green cell surrounded by 0, 1, 4, 5, 7 or 8 green neighbours will become red in the next generation.
        //4. A green cell will stay green in the next generation if it has either 2, 3 or 6 green neighbours.

        int countGreen = greenCounterSurroundingPlace(i, j, matrix);
        if(matrix[i][j] == '0'){
            if( countGreen == 3 || countGreen == 6){
                newMatrix[i][j] = '1';
            } else {
                newMatrix[i][j] = '0';
            }
        } else {
            if (countGreen == 0 || countGreen == 1 || countGreen == 4 || countGreen == 5 || countGreen == 7 || countGreen == 8){
                newMatrix[i][j] = '0';
            } else if(countGreen == 2 || countGreen == 3 || countGreen == 6) {
                newMatrix[i][j] = '1';
            }
        }
    }

    private int greenCounterSurroundingPlace(int i, int j, char[][] matrix) {
        //i - row
        //j - col
        int counter = 0;

        //upper left, upper central, upper right
        //left and right
        //down left, down central, down right
        if (i == 0){//first row
            if (j == 0){
                counter += getRight(i, j, matrix);

                counter += getDownCenter(i, j, matrix);
                counter += getDownRight(i, j, matrix);
            } else if (j == matrix.length - 1){
                counter += getLeft(i, j, matrix);
                counter += getDownLeft(i, j, matrix);
                counter += getDownCenter(i, j, matrix);
            } else {
                counter += getLeft(i, j, matrix);
                counter += getRight(i, j, matrix);

                counter += getDownLeft(i, j, matrix);
                counter += getDownCenter(i, j, matrix);
                counter += getDownRight(i, j, matrix);
            }
        } else if (i > 0 && i < matrix.length - 1){//middle row
            if (j ==0){
                counter += getUpperCenter(i, j, matrix);
                counter += getUpperRight(i, j, matrix);

                counter += getRight(i, j, matrix);

                counter += getDownCenter(i, j, matrix);
                counter += getDownRight(i, j, matrix);
            } else if ( j == matrix.length - 1){
                counter += getUpperLeft(i, j, matrix);
                counter += getUpperCenter(i, j, matrix);

                counter += getLeft(i, j, matrix);

                counter += getDownLeft(i, j, matrix);
                counter += getDownCenter(i, j, matrix);
            } else {//mid
                counter += getUpperLeft(i, j, matrix);
                counter += getUpperCenter(i, j, matrix);
                counter += getUpperRight(i, j, matrix);

                counter += getLeft(i, j, matrix);
                counter += getRight(i, j, matrix);

                counter += getDownLeft(i, j, matrix);
                counter += getDownCenter(i, j, matrix);
                counter += getDownRight(i, j, matrix);
            }
        } else {//last row
            if (j == 0){
                counter += getUpperCenter(i, j, matrix);
                counter += getUpperRight(i, j, matrix);
                counter += getRight(i, j, matrix);
            } else if (j == matrix.length - 1){
                counter += getUpperLeft(i, j, matrix);
                counter += getUpperCenter(i, j, matrix);
                counter += getLeft(i, j, matrix);
            } else {
                counter += getUpperLeft(i, j, matrix);
                counter += getUpperCenter(i, j, matrix);
                counter += getUpperRight(i, j, matrix);

                counter += getLeft(i, j, matrix);
                counter += getRight(i, j, matrix);
            }
        }
        return counter;
    }

    private int getUpperLeft(int row, int col, char[][] matrix){
        return matrix[row - 1][col - 1] == '1' ? 1 : 0;
    }

    private int getUpperCenter(int row, int col, char[][] matrix){
        return  matrix[row - 1][col] == '1' ? 1 : 0;
    }

    private int getUpperRight(int row, int col, char[][] matrix){
        return  matrix[row - 1][col + 1] == '1' ? 1 : 0;
    }

    private int getLeft(int row, int col, char[][] matrix){
        return  matrix[row][col - 1] == '1' ? 1 : 0;
    }

    private int getRight(int row, int col, char[][] matrix){
        return  matrix[row][col + 1] == '1' ? 1 : 0;
    }

    private int getDownLeft(int row, int col, char[][] matrix){
        return  matrix[row + 1][col - 1] == '1' ? 1 : 0;
    }

    private int getDownCenter(int row, int col, char[][] matrix){
        return  matrix[row + 1][col] == '1' ? 1 : 0;
    }

    private int getDownRight(int row, int col, char[][] matrix){
        return  matrix[row + 1][col + 1] == '1' ? 1 : 0;
    }
}
