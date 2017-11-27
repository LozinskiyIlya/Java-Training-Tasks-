package SparkSample;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
       get("/hello", (req,res) -> {Map<String, Object> model = new HashMap<>();
           return new FreeMarkerEngine().render(
                   new ModelAndView(model, "C:\\Users\\РС\\Desktop\\MyVariant.ftl")
           );});
    }
}
