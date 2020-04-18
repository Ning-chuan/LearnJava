package server;

public class HttpServletResponse {

    private StringBuffer responseContent = new StringBuffer();

    public void write(String str) {
        responseContent.append(str);
    }

    public String getResponseContent(){
        return responseContent.toString();
    }
}
