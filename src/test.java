import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class test {
    public static void main(String[] args){
        Properties properties = new Properties();
        try{
            InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\ZJY\\Desktop\\project\\src\\dbhelper.properties"));
            properties.load(inputStream);
            String name = properties.getProperty("driverName");
            System.out.println(name);
        }
         catch (Exception E){
            E.printStackTrace();
         }
    }
}
