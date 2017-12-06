package main;

import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;

public class Container {

    public Object getInstance(Class cl) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        List<Object> values = new LinkedList<>();
        Constructor[] constructors = cl.getConstructors();
        Constructor cons = constructors[0];
        Class[] parameterTypes = cons.getParameterTypes();
        for (Class parameter : parameterTypes) {
            values.add(getInstance(parameter));
        }
        Object o = cons.newInstance(values.toArray());
        setInstancesForFields(o);
        setInstanceForSetters(o);

        return o;

    }

    public void setInstancesForFields(Object o) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class cl = o.getClass();
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            field.set(o, getInstance(fieldType));
        }
    }

    public void setInstanceForSetters(Object o) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class cl = o.getClass();
        Method[] methods = cl.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().contains("set")) {
                Class[] methodParameterTypes = methods[i].getParameterTypes();
                List<Object> values = new LinkedList<>();
                for (Class argumentClass : methodParameterTypes) {
                    values.add(getInstance(argumentClass));
                }
                try {
                    methods[i].invoke(o, values.toArray());
                }catch (IllegalArgumentException e){
                    System.out.println(methods[i].getName());

                }
            }
        }
    }
}
