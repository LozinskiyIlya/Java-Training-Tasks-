import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<SomeClass2> cl2Desc = SomeClass2.class;
        Class<SomeClass> clDesc = SomeClass.class;
        Constructor<SomeClass2> constructor = cl2Desc.getConstructor(SomeClass.class);
        SomeClass s = null;
        SomeClass2 cl = constructor.newInstance(s);

        /*
        Class<SomeClass> classDescription = SomeClass.class;
       MyAnnotation[] annotation = classDescription.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation a: annotation) {
            System.out.println(a.value());
        }


        SomeClass cl = new SomeClass("Vasya");
        SomeClass cl2 = new SomeClass("Petya");

        Class<SomeClass> classDescription = SomeClass.class;
        Method[] methods = classDescription.getMethods();

        for (Method method : methods) {
            System.out.println("Name: " + method.getName());
            System.out.println("Parameters count: " + method.getParameterCount());
            Class<?>[] parameters = method.getParameterTypes();

            for (Class<?> parameter : parameters) {
                System.out.println("\tParameter:" + parameter);
            }
        }
       Class someClassDescription = cl.getClass();

       Method method = someClassDescription.getDeclaredMethod("method2");
       method.setAccessible(true);
       method.invoke(cl);
       method.invoke(cl2);
*/

    }

}
