package first;

import java.util.Scanner;

public class FahrenheitCelsiusConverter {
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter a Fahrenheit value and the day of the week: ");
      int fahrenheit = input.nextInt();
      String day = input.nextLine();
      double celsius = (5.0 / 9) * (fahrenheit - 32);
      System.out.println(day + " Fahrenheit: " + fahrenheit);
      System.out.println(day + " Celsius: " + celsius);
    }
  }
}