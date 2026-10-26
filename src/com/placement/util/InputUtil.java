
package com.placement.util;

import java.util.Scanner;

public class InputUtil {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                return sc.nextInt();
            }

            System.out.println("Invalid input! Please enter a whole number.");
            sc.nextLine();
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }

            System.out.println("Invalid input! Please enter a number.");
            sc.nextLine();
        }
    }
}
