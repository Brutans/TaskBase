package org.example.task6.Undo61;


public class Ex61 {
    public static void main(String[] args){
        String str = "Aboba";
        String str2 ="NetNet ";
        int a = 2;
        char[] c = new char[]{1,2,3};

        UndoStringBuilder builder = new UndoStringBuilder();

        builder.append(str).append(str2).append(str).reverse();
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.append(a);
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.delete(8,11);
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.deleteCharAt(4);
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
//        String strBuilder = builder.toString();
//        strBuilder.replace(3,6);
//        StringBuffer buffer = new StringBuffer(builder.toString());
//        System.out.println(buffer);
//        buffer.replace(3,6,str);
//        System.out.println(buffer);
        builder.replace(0,5,"Baobab");
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.insert(0,"Я Фруктовый сад ");
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.insert(0,true);
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.append(c);
        System.out.println(String.valueOf(c));
        System.out.println(builder);

    }
}
