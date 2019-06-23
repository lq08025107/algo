package Reflect;

public class ReflectTest {
    public static void main(String[] args){
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
        fruit.show();
    }
}
