package Reflection;

public class Student {
    public String name;
    int age;
    private double money;

    public Student() {
        System.out.println("无参构造函数");
    }

    public Student(String subject) {
        System.out.println("有参数构造函数" + subject);
    }

    private Student(int i){}
}
//https://www.cnblogs.com/echola/p/9491950.html