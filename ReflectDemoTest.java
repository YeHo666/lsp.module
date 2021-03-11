package ReflectDemo_25;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemoTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("ReflectDemo_25.Student");
     /* 从结果来看方法一和方法二没有区别，但是他们是通过反射的不同操作完成的
      第一个是通过创建新的构造方法，第二个是通过修改成员变量*/
//        反射访问构造方法,参数赋值给创建的构造方法的对象
        Constructor<?> con1 = c.getConstructor(String.class, int.class, String.class);
        Object obj1 = con1.newInstance("林青霞", 30, "西安");
        System.out.println(obj1);

//        反射访问成员变量,修改成员变量
//        先创建构造方法对象
        Constructor<?> con2 = c.getConstructor();
        Object obj2  = con2.newInstance();
//        修改成员变量，每次只能修改一个
        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj2,"林青霞");

        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj2,30);

        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true);
        addressField.set(obj2,"西安");
        System.out.println(obj2);
    }
}
