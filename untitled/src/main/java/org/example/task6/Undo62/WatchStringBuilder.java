package org.example.task6.Undo62;

public class WatchStringBuilder<T> {

    private interface Listener{
        void onChange(WatchStringBuilder stringBuilder);
    }
    private Listener listener;

    private StringBuilder stringBuilder;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public WatchStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    private void notifyOnStringBuilderChangeListener(){
        if(listener != null){
            listener.onChange(this);
        }
    }

    public WatchStringBuilder<?> reverse(){
        stringBuilder.reverse();
        notifyOnStringBuilderChangeListener();
        return this;
    }
    public WatchStringBuilder<?> append(T t){
        String s = String.valueOf(t);
        stringBuilder.append(s);
        notifyOnStringBuilderChangeListener();
        return this;
    }
    public WatchStringBuilder<?> insert(int offset,T t){
        String s = String.valueOf(t);
        stringBuilder.insert(offset,s);
        notifyOnStringBuilderChangeListener();
        return this;
    }
    public WatchStringBuilder<?> delete(int start, int end){
        stringBuilder.delete(start,end);
        notifyOnStringBuilderChangeListener();
        return this;
    }
    public WatchStringBuilder<?> deleteCharAt(int index){
        stringBuilder.deleteCharAt(index);
        notifyOnStringBuilderChangeListener();
        return this;
    }
    public WatchStringBuilder<?> replace(int start, int end, T t){
        String s = String.valueOf(t);
        stringBuilder.replace(start, end, s);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }

    static class MyListener implements Listener {
        public void onChange(WatchStringBuilder stringBuilder) {
            System.out.println("Произошло изменение: " + stringBuilder.toString());
        }
    }

}
