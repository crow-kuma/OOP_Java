package third.HW06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Clinic {
  private File patientFile;
  private int day;

  public Clinic(File file) {
    this.patientFile = file;
    this.day = 1;
    // Per the directions, the constructor's main jobs are to assign the
    // patientFile and initialize the day. The logic to read the patient file
    // and create Pet objects from it isn't necessary here, as the `nextDay`
    // method creates new Pet objects for daily appointments and the `addToFile`
    // method handles reading/writing the patient file.
    // The `patients` ArrayList has been removed as it was unused.
  }

  public Clinic(String fileName) {
    // This creates a new File object from the provided filename string
    // and then calls the other constructor (public Clinic(File file))
    // with that File object. This is called constructor chaining.
    this(new File(fileName));
  }

  /**
   * Processes a day's appointments from a file, interacts with the user to get
   * pet status, treats them, and generates a report.
   *
   * @param f The appointments file for the day.
   * @return A String containing a report of all appointments for the day.
   * @throws FileNotFoundException if the appointments file cannot be found.
   * @throws InvalidPetException   if a pet type in the file is not "Dog" or
   *                               "Cat".
   */
  public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
    this.day++;
    ArrayList<String> dailyReportLines = new ArrayList<>();
    // Do not use try-with-resources on System.in, as it will close the stream for
    // the whole app.
    Scanner userInput = new Scanner(System.in);
    try (Scanner appointmentScanner = new Scanner(f)) {
      while (appointmentScanner.hasNextLine()) {
        String line = appointmentScanner.nextLine();
        String[] data = line.split(",");
        if (data.length < 4) {
          continue; // Skip malformed lines
        }

        String name = data[0].trim();
        String type = data[1].trim();
        String attributeStr = data[2].trim();
        String timeIn = data[3].trim();

        if (!type.equals("Dog") && !type.equals("Cat")) {
          throw new InvalidPetException("Pet type '" + type + "' is not valid.");
        }

        System.out.printf("Consultation for %s the %s at %s.%nWhat is the health of %s?%n", name, type, timeIn, name);
        double health;
        while (!userInput.hasNextDouble()) {
          System.out.println("Please enter a valid number for health.");
          userInput.next(); // Consume invalid input
        }
        health = userInput.nextDouble();

        System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?%n", name);
        int painLevel;
        while (!userInput.hasNextInt()) {
          System.out.println("Please enter a valid integer for pain level.");
          userInput.next(); // Consume invalid input
        }
        painLevel = userInput.nextInt();

        Pet pet;
        String attributeValue;
        if (type.equals("Dog")) {
          double droolRate = Double.parseDouble(attributeStr);
          pet = new Dog(name, health, painLevel, droolRate);
          attributeValue = String.valueOf(((Dog) pet).getDroolRate());
        } else { // Must be a Cat
          int miceCaught = Integer.parseInt(attributeStr);
          pet = new Cat(name, health, painLevel, miceCaught);
          attributeValue = String.valueOf(((Cat) pet).getMiceCaught());
        }

        pet.speak();
        int treatmentTime = pet.treat();
        String timeOut = addTime(timeIn, treatmentTime);

        String reportLine = String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d",
            name, type, attributeValue, this.day, timeIn, timeOut, health, painLevel);
        dailyReportLines.add(reportLine);
      }
    }
    return String.join("\n", dailyReportLines);
  }

  public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
    return nextDay(new File(fileName));
  }

  public boolean addToFile(String patientInfo) {
    String[] infoParts = patientInfo.split(",");
    if (infoParts.length < 8) {
      return false; // Malformed input
    }
    String petName = infoParts[0];
    ArrayList<String> fileLines = new ArrayList<>();
    boolean petFound = false;

    try (Scanner fileReader = new Scanner(this.patientFile)) {
      while (fileReader.hasNextLine()) {
        fileLines.add(fileReader.nextLine());
      }
    } catch (FileNotFoundException e) {
      // File doesn't exist, we'll create it. This is not an error.
    }

    for (int i = 0; i < fileLines.size(); i++) {
      if (fileLines.get(i).startsWith(petName + ",")) {
        String appointmentData = String.join(",", Arrays.copyOfRange(infoParts, 3, infoParts.length));
        String updatedLine = fileLines.get(i) + "," + appointmentData;
        fileLines.set(i, updatedLine);
        petFound = true;
        break;
      }
    }

    if (!petFound) {
      fileLines.add(patientInfo);
    }

    try (PrintWriter writer = new PrintWriter(this.patientFile)) {
      for (String line : fileLines) {
        writer.println(line);
      }
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  private String addTime(String timeIn, int treatmentTime) {
    int hours = Integer.parseInt(timeIn.substring(0, 2));
    int minutes = Integer.parseInt(timeIn.substring(2, 4));

    minutes += treatmentTime;
    hours += minutes / 60;
    minutes %= 60;

    return String.format("%02d%02d", hours, minutes);
  }
}
