package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    public static String getNextLine() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static int getNextInt() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Необходимо целое. Попробуй снова: ");
            }
        }
    }
}
