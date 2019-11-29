package com.study.bigdata;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created on 2019/11/29
 */
public class FileInfo implements Comparable<FileInfo> {
    //每个小文件的文件名
    private String name;
    //当前待比较元素
    private int curNum;
    //当一轮比较完后，用于指向新元素的指针
    private BufferedReader reader;
    //当一轮比较完后，指针指向下一个元素
    public void readNext(){
        String data = null;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(data != null){
            curNum = Integer.valueOf(data);
        }else {
            curNum = -1;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurNum() {
        return curNum;
    }

    public void setCurNum(int curNum) {
        this.curNum = curNum;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public int compareTo(FileInfo o) {
        if(o.getCurNum() != curNum){
            return this.curNum -o.getCurNum();
        }else {
            return name.compareTo(o.getName());
        }
    }
}
