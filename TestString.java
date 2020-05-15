import java.io.UnsupportedEncodingException;

public class TestMain {
    public static void main(String[] args) {
        String test = "qwrewt我爱你中国ewr";
        byte[] values = new byte[0];
        try {
            values = test.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (byte value : values) {
            System.out.println(value);
        }
        System.out.println(test.intern());
    }
}
