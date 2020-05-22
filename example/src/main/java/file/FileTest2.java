package file;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @create by 260408 on 2019-09-19 14:22
 * @description 递归文件夹（按指定格式输出有哪些）
 */
public class FileTest2 {

    //深度优先(递归)遍历
    private static void test(File file) throws IOException {

        File[] list = file.listFiles();

        for (File file2 : list) {
            if (file2.isDirectory()) {
                test(file2);

                //如果是文件，则切割文件路径，输出相对路径
            }else {
                String str = file2.toString();
                String[] strings = str.split("\\\\");
                int i = strings.length;
                putTxt("/" + strings[i - 2] + "/" + strings[i - 1]);

                System.out.println("/" + strings[i-2] + "/" + strings[i-1]);
            }

        }
    }

    //深度优先(非递归)遍历
    private static void test2(File file) {

        LinkedList<File> list = new LinkedList<>();
        list.push(file);

        //list集合
        while (!list.isEmpty()) {

            File f1 = list.pop();

            //如果是文件，则切割文件路径，输出相对路径
            if(!f1.isDirectory()) {
                String str = f1.toString();
                String[] strings = str.split("\\\\");
                int i = strings.length;

                System.out.println("/" + strings[i - 2] + "/" + strings[i - 1]);

                putTxt("/" + strings[i - 2] + "/" + strings[i - 1]);
            }

            if (f1.isDirectory()) {
                File[] files = f1.listFiles();

                for (File f2 : files) {
                    list.push(f2);
                }
            }

        }
    }

    //广度优先遍历
    private static void test3(File files) {

        ArrayList<File> list = new ArrayList<>();
        list.add(files);

        //先全部add到集合，再集中输出
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).isDirectory()) {
                File[] files1 = list.get(i).listFiles();

                for (File files2 : files1) {

                    list.add(files2);
                }
            }

        }

        for (File f:list) {

            //如果是文件，则切割文件路径，输出相对路径
            if (!f.isDirectory()) {

                String str = f.toString();
                String[] strings = str.split("\\\\");
                int i = strings.length;
                System.out.println("/" + strings[i - 2] + "/" + strings[i - 1]);

                putTxt("/" + strings[i - 2] + "/" + strings[i - 1]);

            }
        }
    }

    private static void putTxt(String str) {

        File file = new File("C:\\Users\\260408\\Desktop\\我的文件夹\\11111\\ff.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream, "utf-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(str + "\r\n");

            bufferedWriter.flush();

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\260408\\Desktop\\我的文件夹");
        test(file);
    }

}