package org.example.task6.Undo61;



import java.util.Stack;

public class UndoStringBuilder {
    private interface Action{
        void undo();
    }
    private class DeleteAction implements Action{
        private int size;

        public DeleteAction(int size){
            this.size = size;
        }


        public void undo() {
            stringBuilder.delete(stringBuilder.length() - size, stringBuilder.length());
        }

    }
    private StringBuilder stringBuilder;

    private Stack<Action> actions = new Stack<>();

    public UndoStringBuilder() {
        stringBuilder = new StringBuilder();
    }


    public UndoStringBuilder reverse(){
        stringBuilder.reverse();

        Action action = new Action() {

            public void undo() {
                stringBuilder.reverse();
            }
        };
        actions.add(action);
        return this;
    }
    public UndoStringBuilder append(String str) {
        stringBuilder.append(str);

        Action action = new Action(){
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length(),
                        stringBuilder.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append(CharSequence s){
        if (s != null){
            stringBuilder.append(s);
        } else {
            stringBuilder.append("null", 0, 4);
        }

        Action action = new Action(){
            public void undo(){
                if (s != null) {
                    stringBuilder.delete(
                            stringBuilder.length() - s.length(),
                            stringBuilder.length());
                } else {
                    stringBuilder.delete(
                            stringBuilder.length() - 4,
                            stringBuilder.length());
                }
            }

        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append(char[] str){
        String s = String.valueOf(str);
        stringBuilder.append(s);

        Action action = new Action(){
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - s.length(),
                        //stringBuilder.length() - str.length -1,
                        stringBuilder.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append (boolean b){
        String s = String.valueOf(b);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append (int i){
        String s = String.valueOf(i);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append (long l){
        String s = String.valueOf(l);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder append (float l){
        String s = String.valueOf(l);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append (double d){
        String s = String.valueOf(d);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder append (Object obj){
        String s = String.valueOf(obj);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;

    }
    //Возможно добавить Throws
    public UndoStringBuilder append (char[] str, int offset, int len){
        String s = String.valueOf(str,offset,len);
        stringBuilder.append(s);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length()-s.length(),
                        stringBuilder.length());

            }
        };

        actions.add(action);
        return this;
    }
    //Возможно добавить Throws
    public UndoStringBuilder append (CharSequence s, int start, int end){
        if (s == null) {
            stringBuilder.append("null", 0, 4);
        }else {
            stringBuilder.append(s.subSequence(start, end));
        }
        Action action = new Action() {

            public void undo(){
                if (s != null) {
                    stringBuilder.delete(
                            stringBuilder.length() - s.subSequence(start, end).length(),
                            stringBuilder.length());
                } else {
                    stringBuilder.delete(
                            stringBuilder.length() - 4,
                            stringBuilder.length());
                }
            }
        };

        actions.add(action);
        return this;

    }

    public UndoStringBuilder append(StringBuffer sb){

        if (sb == null){
            stringBuilder.append("null", 0, 4);
        } else{
            String str = sb.toString();
            stringBuilder.append(str);
        }
        Action action = new Action() {

            public void undo() {
                if (sb != null) {
                    stringBuilder.delete(
                            stringBuilder.length() - sb.length(),
                            stringBuilder.length());
                } else {
                    stringBuilder.delete(
                            stringBuilder.length() - 4,
                            stringBuilder.length());
                }
            }
        };
        actions.add(action);
        return this;
    }


    public UndoStringBuilder appendCodePoint(int codePoint){
        char[] str = Character.toChars(codePoint);
        String s = String.valueOf(str);
        stringBuilder.append(s);

        Action action = new Action(){
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - s.length(),
                        //stringBuilder.length() - str.length -1,
                        stringBuilder.length());
            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder delete(int start, int end){
        String str = stringBuilder.substring(start,end);
        stringBuilder.delete(start, end);
        Action action = new Action() {

            public void undo() {
                stringBuilder.insert(start,str);
            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder deleteCharAt(int index){
        String str = stringBuilder.substring(index,index+1);
        stringBuilder.deleteCharAt(index);

        Action action = new Action() {

            public void undo() {
                stringBuilder.insert(index,str);
            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder replace(int start, int end, String str){
        String s = stringBuilder.substring(start,end);
        stringBuilder.replace(start,end,str);
        Action action = new Action() {

            public void undo() {
                //stringBuilder.delete(start,str.length());
                stringBuilder.replace(start,str.length(), s);
            }
        };

        actions.add(action);
        return this;
    }

    public  UndoStringBuilder insert(int offset, String str){
        stringBuilder.insert(offset,str);

        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset,str.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int offset, boolean b){
        String s = String.valueOf(b);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int offset, char c){
        String s = String.valueOf(c);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int offset, char[] str){
        String s = String.valueOf(str);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int index, char[] str, int offset, int len){
        String s = String.valueOf(str,offset,len);
        stringBuilder.insert(index,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int offset, double d){
        String s = String.valueOf(d);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder insert(int offset, float f){
        String s = String.valueOf(f);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder insert(int offset, int i){
        String s = String.valueOf(i);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int offset, long l){
        String s = String.valueOf(l);
        stringBuilder.insert(offset,s);
        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset, s.length());
            }
        };

        actions.add(action);
        return this;
    }
    public UndoStringBuilder insert(int dstOffset, CharSequence s){
        if (s == null) {
            stringBuilder.insert(dstOffset,"null");
        }else {
            stringBuilder.insert(dstOffset,s);
        }
        Action action = new Action() {

            public void undo(){
                if (s != null) {
                    stringBuilder.delete(
                            dstOffset, s.length());
                } else {
                    stringBuilder.delete(
                            dstOffset,
                            4);
                }
            }
        };

        actions.add(action);
        return this;
    }

    public UndoStringBuilder insert(int dstOffset, CharSequence s, int start, int end){
        if (s == null) {
            stringBuilder.insert(dstOffset,"null");
        }else {
            stringBuilder.insert(dstOffset,s,start,end);
        }

        Action action = new Action() {
            public void undo(){
                if (s != null) {
                    stringBuilder.delete(
                            dstOffset - s.length(),
                            s.subSequence(start, end).length());
                } else {
                    stringBuilder.delete(
                            dstOffset,
                            4);
                }
            }
        };

        actions.add(action);
        return this;

    }

    public UndoStringBuilder insert(int offset, Object obj){
        String s = String.valueOf(obj);
        stringBuilder.insert(offset,s);

        Action action = new Action() {

            public void undo() {
                stringBuilder.delete(offset,s.length());

            }
        };
        actions.add(action);
        return this;

    }

    public void undo(){
        if(!actions.isEmpty()){
            actions.pop().undo();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }

}