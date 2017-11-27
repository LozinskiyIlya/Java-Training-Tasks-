package SelfServer;

import java.util.Map;

public class Request {
    String initialLine;
    String bodyString;
    Map<String,String> headers;

    public Request(String initialLine, Map<String, String> headers, String bodyString) {
        this.initialLine = initialLine;
        this.headers = headers;
        this.bodyString = bodyString;
    }
}
