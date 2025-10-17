package lab4_part2;

class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {

    // Thêm @Override để đảm bảo tính đúng đắn và rõ ràng
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}