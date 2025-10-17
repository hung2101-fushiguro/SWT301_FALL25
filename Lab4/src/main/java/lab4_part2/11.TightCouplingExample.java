package lab4_part2;

interface IPrinter {
    void print(String message);
}
class ConsolePrinter implements IPrinter {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
class Report {
    private final IPrinter printer; // Phụ thuộc vào interface

    // Dependency Injection thông qua constructor
    public Report(IPrinter printer) {
        this.printer = printer;
    }

    void generate() {
        printer.print("Generating report...");
    }
}
