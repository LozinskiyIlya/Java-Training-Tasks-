package November27;

import java.io.*;
import java.util.Map;

public class Tamplator {
    public String template(Map<String, String> values, String templateFile) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(templateFile), "UTF-8"));
        String template = "";
        String line = reader.readLine();
        while (line != null) {
            template += (line + "\n");
        }

        for (Map.Entry<String, String> entry : values.entrySet()) {
            template = template.replaceAll("@", entry.getKey());
        }
        return template;
    }
}

