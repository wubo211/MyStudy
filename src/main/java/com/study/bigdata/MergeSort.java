package com.study.bigdata;

import java.io.*;
import java.util.*;

/**
 * Created on 2019/11/28
 * 1.拆分控制30M
 * 2.内排序（30m有序）
 * 3.每个小文件有类似指针的，指向下一个元素
 */
public class MergeSort {
    //多少条拆分一个文件
    private  static final int SPLIT_SIZE=13;
    //拆分后小文件保存目录
    private static final String SPLIT_DIR="/Users/apple/Documents/test/split";
    //小文件编号
    private int fileNum = 0;
    //
    private static final String prefix = "bigdata_";
    //小文件归并大文件后的文件路径
    private String outFile="/Users/apple/Documents/test/result.txt";

    public static void main(String[] args) throws FileNotFoundException,IOException {
        MergeSort ms = new MergeSort();

        //大文件拆分小文件方法
        ms.splitFile("/Users/apple/Documents/test/test.txt");
        //小文件归并为大文件并且排序
        ms.mergeFile();
    }
    private void splitFile(String fname){
        //设置读取每一行数据的临时变量
        String data = null;
        //读取了多少行的计数器，用于判断是否要开始新的拆分小文件
        int count = 0;
        //set存储会自动去重，会把放进来的数据自动排序
        SortedSet<Integer> set = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fname))){
            do{
                data = br.readLine();
                //关键的拆分判断+写小文件
                if(data != null){
                    set.add(Integer.valueOf(data));
                    count ++;
                    //读取的数量和拆分阈值进行判断
                    if(count >= SPLIT_SIZE){
                        System.out.println("==========拆分文件");
                        writeFile(set);
                        count = 0;
                        set.clear();
                    }
                }else if(!set.isEmpty()){
                    writeFile(set);
                    count = 0;
                    set.clear();
                }
            }while (data != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeFile(SortedSet<Integer> set) {
        File dir = new File(SPLIT_DIR);
        if(!dir.exists()) {
            dir.mkdir();
        }
        fileNum ++;
        String fname = SPLIT_DIR + System.getProperty("file.separator") + prefix + fileNum + ".txt";
        Iterator<Integer> iter = set.iterator();
        //语法糖
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fname))){
            while (iter.hasNext()){
                try {
                    bw.write(iter.next() + "\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //归并+排序文件
    private void mergeFile() throws IOException{
        //首先获取所有小文件
        File[] files = new File(SPLIT_DIR).listFiles();
        List<FileInfo> list = new ArrayList<>();
        //用files初始化list
        for(File file: files){
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileInfo  finfo = new FileInfo();
            finfo.setReader(reader);
            finfo.setName(file.getName());
            finfo.readNext();
            list.add(finfo);
        }
        //归并排序
        Collections.sort(list);
        Set<Integer> phoneNumberSet = new HashSet<>(10000);
        //结果：归并到大文件
        try(BufferedWriter br = new BufferedWriter(new FileWriter(outFile))){
            while (!list.isEmpty()){
                //取出排序结果的第一个元素
                FileInfo fileInfo = list.get(0);
                if (!phoneNumberSet.contains(fileInfo.getCurNum())){
                    //把结果写入大文件中
                    br.write(fileInfo.getCurNum() + "\r\n");
                }
                phoneNumberSet.add(fileInfo.getCurNum());
                //移动指针
                fileInfo.readNext();
                //排序
                Collections.sort(list);
                //判断当前文件是否读取完毕
                if(fileInfo.getCurNum() == -1){
                    //=-1 代表文件读取完毕,
                    list.remove(fileInfo);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
//        BufferedWriter br = new BufferedWriter(new FileWriter(outFile));
//        while (!list.isEmpty()){
//            //取出排序结果的第一个元素
//            FileInfo fileInfo = list.get(0);
//            //把结果写入大文件中
//            try {
//                br.write(fileInfo.getCurNum() + "\r\n");
//                //移动指针
//                fileInfo.readNext();
//                //排序
//                Collections.sort(list);
//                //判断当前文件是否读取完毕
//                if(fileInfo.getCurNum() == -1){
//                    //=-1 代表文件读取完毕,
//                    list.remove(fileInfo);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //刚开始没加这行，txt一直没有数据输出
//        br.flush();
//        br.close();

    }
}
