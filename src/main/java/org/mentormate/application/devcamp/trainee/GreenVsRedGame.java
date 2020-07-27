package org.mentormate.application.devcamp.trainee;

public class GreenVsRedGame {
    private char[][] matrix;
    private int greenCounterGenerationsOfPlace;
    private final UserInput userInput;
    private final NextMatrixGenerator nextMatrixGenerator;

    public GreenVsRedGame( UserInput userInput) {
        this.userInput = userInput;
        this.nextMatrixGenerator = new NextMatrixGenerator();

        this.matrix = userInput.getMatrix();
        this.greenCounterGenerationsOfPlace = 0;
    }

    public int start(){
        for (int generation = 0; generation < userInput.getN(); generation++) {
            char [][] newMatrix = new char[matrix.length][matrix[0].length];
            nextMatrixGenerator.generate(newMatrix, matrix);
            matrix = newMatrix;
            countGreenGenerationsOfSpecifiedPlace();
        }
        return greenCounterGenerationsOfPlace;
    }

    private void countGreenGenerationsOfSpecifiedPlace() {
        greenCounterGenerationsOfPlace += matrix[userInput.getRowCoordinate()][userInput.getColCoordinate()] == '1' ? 1 : 0;;
    }
}
