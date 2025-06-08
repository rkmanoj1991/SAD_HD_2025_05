package SOLID;

public class DIP_02 {

    /*
    * FIX:
    * I introduced an interface called `Notification` that defines how notifications should work.
    * Now, the Employee class depends on this interface instead of the low level module EmailNotification class.
    */
    
    public static interface Notification {
        void doNotify();
    }

    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }

    public static class Employee {
        private Notification emailNotification;  // Changed type to interface Notification

        // Dependency Injection with interface (abstraction)
        public Employee(Notification emailNotification) {
            this.emailNotification = emailNotification;
        }
    
        public void notifyEmployee() {
            emailNotification.doNotify();
        }
    }

    public static void main(String[] args) {
        EmailNotification emailNotification = new EmailNotification();
        Employee employee = new Employee(emailNotification); // Passing concrete implementation
        employee.notifyEmployee();
    }
}
