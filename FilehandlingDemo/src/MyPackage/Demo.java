package MyPackage;

import java.io.*;

/**
 * Created by cerebro on 09/07/16.
 */
public class Demo {
    public static void main(String[] args) {
        try {
            FileInputStream reader = new FileInputStream("/Users/cerebro/IdeaProjects/abes_13thjune/FilehandlingDemo/src/MyPackage/demo.txt");

            int int1 = reader.read();

            while(int1 > 0) {
                System.out.println((char)int1);

                int1 = reader.read();
            }

            reader.close();

            FileWriter writer = new FileWriter("/Users/cerebro/IdeaProjects/abes_13thjune/FilehandlingDemo/src/MyPackage/demo.txt");

            writer.write("I love Java!");
            writer.close();

            File file1 = new File("/Users/cerebro/IdeaProjects/abes_13thjune/FilehandlingDemo/src/MyPackage/");

            System.out.println(file1.isDirectory());

            File[] insideFiles = file1.listFiles();

            for (int i = 0; i < insideFiles.length; i++) {
                System.out.println(insideFiles[i].getName());
            }

        } catch (Exception e) {


//            prashant@codekamp.in
//            8285601665
//            prashant.konnection  (skype id)

        }
    }
}