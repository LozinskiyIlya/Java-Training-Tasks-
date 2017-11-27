package November5;

public interface IcanSay {
  default void say(String toSay){
      System.out.println(toSay);
    }
}
