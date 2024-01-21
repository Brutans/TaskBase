package org.example.task6.Undo62;

import java.util.Arrays;
import java.util.List;

public class Ex62 {
    public static void main(String[] args){
        String str = "Aboba";
        String str2 ="NetNet ";
        Integer a = 2;
        boolean b = true;
        CharSequence s = null;
        char[] c = new char[]{1,2,3};
        WatchStringBuilder<Object> watchStringBuilder = new WatchStringBuilder<>();
        watchStringBuilder.setListener(new WatchStringBuilder.MyListener());
        watchStringBuilder.append(str);
        watchStringBuilder.append(str2);
        watchStringBuilder.append(a);
        watchStringBuilder.append(b);
        watchStringBuilder.append(s);
        watchStringBuilder.append(c[2]);
        watchStringBuilder.reverse();
        watchStringBuilder.replace(0,1,str2);
        watchStringBuilder.delete(0,3);
    }
}
