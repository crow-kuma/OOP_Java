package third.HW06;

import java.io.FileNotFoundException;

/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

  public static void main(String[] args) {
    Clinic clinic = new Clinic("Patients.csv");
    String dayOneReport = "";
    try {
      dayOneReport = clinic.nextDay("Appointments.csv");
      if (dayOneReport != null && !dayOneReport.isEmpty()) {
        String[] dayOneAppointments = dayOneReport.split("\\n");
        for (String appointment : dayOneAppointments) {
          if (!clinic.addToFile(appointment)) {
            System.out.println("Appointment could not be added to file!");
          }
        }
      }
    } catch (FileNotFoundException exception) {
      System.out.println("Error: Could not find appointments file. " + exception.getMessage());
    } catch (InvalidPetException exception) {
      System.out.println("Error processing appointments: " + exception.getMessage());
    }
  }
}
