package base.annotations.runtime;

// 定义一个类，使用注解
@ToString(value = "User")
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Demo类，测试注解
public class ToStringDemo {
    public static void main(String[] args) {
        User user = new User("John");
        try {
            System.out.println(ToStringTool.toString(user));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
