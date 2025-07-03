package first;

import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    System.out.println("List of operations: add subtract multiply divide alphabetize");

    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Enter an operation:");
      String operation = input.next();
      String operationUpper = operation.toUpperCase();

      switch (operationUpper) {
        case ("ADD"):
          System.out.println("Enter two integers:");
          int add1 = input.nextInt();
          int add2 = input.nextInt();
          System.out.println("Answer: " + (add1 + add2));
          break;
        case ("SUBTRACT"):
          System.out.println("Enter two integers:");
          int sub1 = input.nextInt();
          int sub2 = input.nextInt();
          System.out.println("Answer: " + (sub1 - sub2));
          break;
        case ("MULTIPLY"):
          System.out.println("Enter two doubles:");
          double mult1 = input.nextDouble();
          double mult2 = input.nextDouble();
          System.out.println("Answer: " + (mult1 * mult2));
          break;
        case ("DIVIDE"):
          System.out.println("Enter two doubles:");
          double div1 = input.nextDouble();
          double div2 = input.nextDouble();
          if (div2 == 0) {
            System.out.println("Cannot divide by zero");
          } else {
            System.out.println("Answer: " + (div1 / div2));
          }
          break;
        case ("ALPHABETIZE"):
          System.out.println("Enter two strings:");
          String str1 = input.next();
          String str2 = input.next();
          if (str1.compareTo(str2) < 0) {
            System.out.println("Answer: " + str1 + " comes before " + str2 + " alphabetically.");
          } else if (str1.compareTo(str2) == 0) {
            System.out.println("Answer: Chicken or Egg.");
          } else {
            System.out.println("Answer: " + str2 + " comes before " + str1 + " alphabetically.");
          }
          break;
        default:
          System.out.println("Invalid input entered. Terminating...");
          break;
      }
    }
  }
}
