package base.annotations;

public class Demo {
    @Override
    public String toString() {
        return "Demo";
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.toString());
    }
}
