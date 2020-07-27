package org.mentormate.application.devcamp.trainee;

import java.util.Scanner;

/**
 *
 */
public class UserInput {
    private int rowGrid;
    private int colGrid;
    private char[][] matrix;
    private int rowCoordinate;
    private int colCoordinate;
    private int N;
    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int getRowGrid() {
        return rowGrid;
    }

    public int getColGrid() {
        return colGrid;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public int getRowCoordinate() {
        return rowCoordinate;
    }

    public int getColCoordinate() {
        return colCoordinate;
    }

    public int getN() {
        return N;
    }

    public void readGridParams(){
        String [] matrixGridParams = scanner.nextLine().split(", ");
        rowGrid = Integer.parseInt(matrixGridParams[0]);
        colGrid = Integer.parseInt(matrixGridParams[1]);
    }

    public void readMatrixInput(){
        matrix = new char[rowGrid][colGrid];
        for (int i = 0; i < rowGrid; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
    }

    public void readCoordinatesAndNGenerations(){
        String[] inputPlaceCoordinatesAndMatrixGenerations = scanner.nextLine().split(", ");
        rowCoordinate = Integer.parseInt(inputPlaceCoordinatesAndMatrixGenerations[0]);
        colCoordinate = Integer.parseInt(inputPlaceCoordinatesAndMatrixGenerations[1]);
        N = Integer.parseInt(inputPlaceCoordinatesAndMatrixGenerations[2]);
        closeScanner();
    }

    private void closeScanner(){
        scanner.close();
    }
}
