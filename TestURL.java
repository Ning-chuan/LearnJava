import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 用url实现从服务器下载图片
 */
public class TestURL {
    public static void main(String[] args){
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1.创建url对象
            URL url  = new URL("https://b-ssl.duitang.com/uploads/item/201508/27/20150827093028_VdBy2.thumb.700_0.jpeg");
            //2.获取HttpURLConnection.连接
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            //3.获取输入流、创建输出流
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("beauty.jpeg");
            //4.读写操作
            byte[] byteCar = new byte[1024];
            int len;
            while((len = is.read(byteCar)) != -1){
                fos.write(byteCar,0,len);
            }

            String requestMethod = urlConnection.getRequestMethod();
            System.out.println("请求方式为："+requestMethod);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            urlConnection.disconnect();
        }


    }
}
