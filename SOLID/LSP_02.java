package SOLID;

public class LSP_02{

    // Base Bird class - all birds extend this
    public static abstract class Bird {
        // General bird behavior can be here
    }

    // Interface for birds that can fly
    public interface Flyable {
        void fly();
    }

    // Sparrow is a flying bird
    public static class Sparrow extends Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    // Penguin is a bird but cannot fly, so it does NOT implement Flyable
    public static class Penguin extends Bird {
        // No fly method here
    }

    // Move method for flying birds only
    public static void move(Flyable bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        move(sparrow);  
    }
}