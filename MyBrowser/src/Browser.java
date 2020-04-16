import java.util.Scanner;

public class Browser {

    private Scanner input = new Scanner(System.in);

    public void handle(){
        System.out.println("请输入URL");
        String url = input.nextLine();
    }

    //解析URL的方法
    private void parseURL(String url){
        int colonIndex = url.indexOf(":");
        int slashIndex = url.indexOf("/");
        String ip = url.substring(0,colonIndex);
        String port = url.substring(colonIndex + 1, slashIndex);
        String contextAndParams = url.substring(slashIndex+1);
    }

    //发送给服务器
    private void send(){

    }



}
