package SOLID;

public class DIP_01 {

    /*
     * TASK:
     * The Switch is violating the DIP (Dependency Inversion Principle).
     * Please fix this!
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

        // this is "Dependency Injection" (composition style)
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
}.