public class Hello {
    public static void main(String[] args) {
        var a = "Hello";
        var b = "Hello";
        IO.println(a.equals(b));

        if (a.equals(b)) {
            System.out.println("a equals b");
        } else {
            System.out.println("a does not equal b");
        }
    }
}