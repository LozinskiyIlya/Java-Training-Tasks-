package November6;

public interface Interface1 { void printConcatenation(int x, String asd);

}
class InterfaceOneImplementation implements Interface1{


    @Override
    public void printConcatenation(int x, String asd) {
        System.out.println(x+asd);
    }
    static Interface1 lambda = (x, asd) -> System.out.println(x+" "+asd);

    public static void main(String[] args) {
        lambda.printConcatenation(1,"sdas");
    }
    }


