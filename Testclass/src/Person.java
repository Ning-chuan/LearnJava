import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class Person {
        public String name;
        public int age;
        public String sex;
        public int height;

        public void drawStar(int line, boolean direction) {
                //true代表靠左，false代表靠右。
                for (int i = 1; i <= line; i++) {
                        if (!direction) {
                                for (int j =1; j<=i-1; j++) {
                                        System.out.print(" ");
                                }
                        }
                        for (int j = 1; j <= line + 1 - i; j++) {
                                System.out.print("*");
                        }
                        System.out.println();
                }

        }
}