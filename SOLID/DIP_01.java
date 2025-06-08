package SOLID;

public class DIP_01 {

    /*
     * FIX:
     * I have added an interface called `Switchable` for any device that can be switched on/off.
     * Both the Switch class and LightBulb class now depend on this interface, not on each other directly.
     */
    
    public static class LightBulb {
        public void turnOn() {
            System.out.println("Light is ON!");
        }
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    public static class Switch {
        private LightBulb lightBulb;

        // this is "Dependency Injection"
        public Switch(LightBulb lightBulb) {
            this.lightBulb = lightBulb;
        }

        public void operate() {
            lightBulb.turnOn();
        }
    }

    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate();
    }
}