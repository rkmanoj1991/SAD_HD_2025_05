package SOLID;

public class ISP_02 {
    
    /*
     * FIX:
     * Split the Worker interface into two interfaces: Workable and Restable.
     * Developer implements both (works and rests).
     * Robot implements only Workable (works, but does not rest).
     * This respects ISP by not forcing classes to implement unused methods.
     */

    public static interface Workable {
        void work();
    }

    public static interface Restable {
        void rest();
    }

    public static class Developer implements Workable, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding ...");
        }

        @Override
        public void rest() {
            System.out.println("Developer is making a break!");
        }
    }

    public static class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working hard ...");
        }
        // No rest() method needed here
    }

    // Overloaded workingCycle methods based on capabilities
    public static void workingCycle(Workable worker) {
        worker.work();
    }

    public static void workingCycle(Workable worker, Restable restWorker) {
        worker.work();
        restWorker.rest();
    }

    public static void main(String[] args) {
        Developer developer = new Developer();
        Robot robot = new Robot();

        // Developer can work and rest
        workingCycle(developer, developer);

        // Robot only works
        workingCycle(robot);
    }
}