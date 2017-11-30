

@MyAnnotation("aaa")
public class SomeClass {
String name;
    public SomeClass(String name) {
   this.name=name;
    }

    public void method1() {
        System.out.println("Sliha I have no name");
    }
        private void method2(){
            System.out.println("Private! SHHH! my name is " + name);
        }
    }

