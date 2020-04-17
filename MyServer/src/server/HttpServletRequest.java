package server;

import java.util.HashMap;

public class HttpServletRequest {
    //请求对象
    private String content;
    private HashMap<String,String> paramsMap;

    public HttpServletRequest(String content, HashMap<String, String> paramsMap) {
        this.content = content;
        this.paramsMap = paramsMap;
    }

    public HttpServletRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, String> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(HashMap<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }
}
