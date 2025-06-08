package SOLID;

public class SRP_02 {

    /*
     * FIX I DID:
     * The Employee class now only handles designation.
     * The salary update function has been moved to a separate SalaryManager class.
     * The email sending functionality is moved to NotificationService class.
     * This way, each class has a single responsibility, making the code easier to maintain and extend.
     */

    public static class Employee {
        public String getDesignation(int employeeID) {
            // Return the employee designation (dummy example)
            return "Developer";
        }
    }

    public static class SalaryManager {
        public void updateSalary(int employeeID) {
            // Logic to update employee salary goes here
            System.out.println("Salary updated for employee ID: " + employeeID);
        }
    }

    public static class NotificationService {
        public void sendMail() {
            // Logic to send email notification goes here
            System.out.println("Email sent successfully!");
        }
    }
    public static void main(String[] args) {
        Employee employee = new Employee();
        SalaryManager salaryManager = new SalaryManager();
        NotificationService notificationService = new NotificationService();

        System.out.println("Designation: " + employee.getDesignation(101));
        salaryManager.updateSalary(101);
        notificationService.sendMail();
    }
}
