package com.ceh.algorithms.Chapter3.Excercise.Excersice2_5_14;

/**
 * Created by enHui.Chen on 2019/1/20.
 */
public class Domain {
    private String[] strs;
    private int length;

    public Domain(String str) {
        this.strs = str.split("\\.");
        this.length = this.strs.length;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {

            for (int i = 0; i < this.length; i++) {
                if (i == this.length - 1) {
                    stringBuffer.append(strs[i]);
                    break;
                }
                stringBuffer.append(this.strs[i] + ".");
            }
        } catch (Exception e) {
            int a = 5454;
        }

        return stringBuffer.toString();
    }
}