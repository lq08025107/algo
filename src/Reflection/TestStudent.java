package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestStudent {
    public static void getConstruction() throws Exception {
        //获取构造方法
        Class cl=Class.forName("Reflection.Student");
        System.out.println("==========公开的构造方法==========");
        //获得公开的构造方法
        Constructor[] cons=cl.getConstructors();
        for(Constructor con:cons) {
            System.out.println(con);
        }
        System.out.println("==========所有的构造方法==========");
        //获得所有的构造方法
        Constructor[] constructors=cl.getDeclaredConstructors();
        for (Constructor con:constructors
        ) {
            System.out.println(con);
        }
        System.out.println("==========调用构造方法==========");
        //调用无参构造方法
        Constructor constructors1=cl.getConstructor();
        Student student=(Student)constructors1.newInstance();
        //调用有参构造方法
        Constructor constructors2=cl.getConstructor(String.class);
        Student student1=(Student) constructors2.newInstance("英语");
        //调用私有构造方法
        Constructor constructors3=cl.getDeclaredConstructor(int.class);
        constructors3.setAccessible(true);//因为是私有化的方法，所以要设置访问权限
        Student student2=(Student) constructors3.newInstance(2);
    }

    private static void getMethod1() throws Exception {
        Class cl=Class.forName("Reflection.Student");
        //获取所有公开的方法，包括Object中的类
        Method[] method=cl.getMethods();
        for (Method m:method
        ) {
            System.out.println(m.getName());
        }
        //获取本类中所有的方法，不包括父类和eObject
        System.out.println("==========私有方法==========");
        Method[] methods=cl.getDeclaredMethods();
        for (Method ms:methods
        ) {
            System.out.println(ms.getName());
        }
        //调取方法
        System.out.println("==========调取特有方法==========");
        //获取非静态的无参方法
        Method method1=cl.getMethod("eat");
        //获取Student类的成员
        Constructor constructor=cl.getConstructor();
        Student student=(Student)constructor.newInstance();
        method1.invoke(student);
        //获取非静态含参方法
        Method method2=cl.getMethod("study", String.class);
        method2.invoke(student,"物理");
        //获取静态无参方法
        Method method3=cl.getMethod("sleep");
        method3.invoke(null);
        //获取静态含参方法
        try {
            Method method4=cl.getMethod("saveMoney", double.class);
            method4.setAccessible(true);
            method4.invoke(null,100.0);
        }catch (NoSuchMethodException e){
            e.getMessage();
        }catch(Exception e){
            e.getMessage();
        }

    }
    public static void main(String[] args) throws Exception {
        //getConstruction();
        getMethod1();
    }
}
