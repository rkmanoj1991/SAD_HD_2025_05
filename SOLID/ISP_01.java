package SOLID;

public class ISP_01 {

    /*
     * FIX:
     * Split the large Printer interface into smaller interfaces:
     * Printable, Scannable, and Faxable.
     * SimplePrinter now only implements Printable and does not need to implement methods it doesn’t support.
     */

    public static interface Printable {
        void printDocument();
    }

    public static interface Scannable {
        void scanDocument();
    }

    public static interface Faxable {
        void faxDocument();
    }

    public static class SimplePrinter implements Printable {
        @Override
        public void printDocument() {
            System.out.println("Sending document to the printer ...");
        }
    }

    public static void main(String[] args) {
        SimplePrinter printer = new SimplePrinter();
        printer.printDocument();
    }
}
