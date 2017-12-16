package JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Json_Sample {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) {
        Person person = new Person("Vasya", 30, Arrays.asList("Moscow", "Berlin", "Dubai"));
        String json = GSON.toJson(person);
        System.out.println(json);

        Person person1 = GSON.fromJson(json, Person.class);
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.getGeoHistory());
    }
}

class Person {

    private String name;
    private Integer age;
    @SerializedName("geo")
    private List<String> geoHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getGeoHistory() {
        return geoHistory;
    }

    public void setGeoHistory(List<String> geoHistory) {
        this.geoHistory = geoHistory;
    }

    public Person(String name, Integer age, List<String> geohistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geohistory;
    }
}
