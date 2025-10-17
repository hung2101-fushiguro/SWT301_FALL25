package lab4_part2;

interface Shape {
    void draw();
    void resize();
}

// Lớp Square bây giờ triển khai đầy đủ TẤT CẢ các phương thức từ Shape
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing square");
    }

    @Override
    public void resize() {
        System.out.println("Resizing square");
    }
}

class CompleteInterfaceImplementationExample {
    public static void main(String[] args) {
        Shape myShape = new Square();
        myShape.draw();
        myShape.resize();
    }
}