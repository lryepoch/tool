package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\260408\\Desktop\\www\\1.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\260408\\Desktop\\www\\2.txt");

        /**read()   一个字节一个字节地读
         * write(len)
         * 碰到-1，说明没有值了
         */
        int len;
        while ((len = fis.read())!=-1){
            fos.write(len);
        }

        /**read(byte[] bytes)   一个数组地读【推荐】
         * write(bytes)
         */
        byte[] bytes = new byte[1024*5];
        while (fis.read(bytes)!=-1){
            fos.write(bytes);
        }

        /**read(byte[] bytes,int off,int len)  用指定长度读取一个数组
         * write(bytes,0,len)【推荐】
         */
        byte[] bytes1 = new byte[1024*5];
        int len1;
        while ((len1 = fis.read(bytes1,0,1024))!=-1){
            fos.write(bytes,0,len);
        }

        fis.close();
        fos.close();

    }
}
