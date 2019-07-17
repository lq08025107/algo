package Reflection;


public class Student extends Human{
    public String name;
    int age;
    private double money;

    public Student() {
        System.out.println("无参构造方法");
    }
    public Student(String subject) {
        System.out.println("有参构造方法"+subject);
    }

    private Student(int i) {
        System.out.println("私有构造方法"+i);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void study(String subject){
        System.out.println("学习"+subject);
    }

    public static void sleep(){
        System.out.println("睡觉");
    }

    private static void saveMoney(double money){
        System.out.println("存款"+money);
    }
}
