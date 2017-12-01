package SparkSample;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
      Map map = new HashMap();
      map.put("name","Sam");

      get("/hello", (res , req)-> new ModelAndView(map,"hello"));
    }
}
