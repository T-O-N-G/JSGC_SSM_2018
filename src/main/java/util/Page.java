package util;

//存储分页信息
public class Page {
    private int start = 0;
    private final int count = 5;
    private int last = 0;

    public int getStart() {
        if (start < 0) {
            start = 0;
        } else if (start >= last) {
            start = last;
        }
        return start;
    }
    public int getCount() {
        return count;
    }

    public int getLast() {
        return last;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public void setLast(int last) {
        this.last = last;
    }

    public void calculateLast(int total) {
        if (total % count == 0) {
            last = total - count;
        } else {
            last = total - total % count;
        }
    }

}
