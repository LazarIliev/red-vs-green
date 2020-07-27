package org.mentormate.application.devcamp.trainee;


public class App {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.readGridParams();
        userInput.readMatrixInput();
        userInput.readCoordinatesAndNGenerations();

        GreenVsRedGame greenVsRedGame = new GreenVsRedGame(userInput);
        System.out.println("Count of the green generations of the place is: " + greenVsRedGame.start());
    }
}
