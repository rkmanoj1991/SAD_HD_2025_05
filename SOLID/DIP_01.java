package SOLID;

public class DIP_01 {

    /*
     * FIX:
     * I have added an interface called `Switchable` for any device that can be switched on/off.
     * Both the Switch class and LightBulb class now depend on this interface, not on each other directly.
     */
    
 // Step 1: Define an interface for devices that can be switched on/off
    public interface Switchable {
        void turnOn();
        void turnOff();
    }

    // Step 2: LightBulb now implements the Switchable interface
    public static class LightBulb implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("Light is ON!");
        }

        @Override
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    // Step 3: Switch depends on the abstraction Switchable, not on a concrete LightBulb
    public static class Switch {
        private Switchable device;

        // Constructor Dependency Injection with interface
        public Switch(Switchable device) {
            this.device = device;
        }

        public void operate() {
            device.turnOn();
        }
    }

    // Step 4: Test the fix in main
    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb();  // LightBulb as a Switchable device
        Switch lightSwitch = new Switch(lightBulb); // Switch depends on abstraction
        lightSwitch.operate();
    }
}