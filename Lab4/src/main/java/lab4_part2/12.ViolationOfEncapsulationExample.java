package lab4_part2;

class EncapsulatedUser {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        // Có thể thêm kiểm tra ở đây (ví dụ: name không được null)
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age > 0 && age < 120) { // Logic kiểm tra tuổi hợp lệ
            this.age = age;
        } else {
            System.err.println("Lỗi: Tuổi không hợp lệ. Giá trị '" + age + "' đã bị từ chối.");
        }
    }
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
