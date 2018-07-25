package util.com.jsgc;

public class RequestPage {
    private int limit; //每页多少条
    private int start;//第几条开始

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public RequestPage(int limit, int start) {
        this.limit = limit;
        this.start = start;
    }

}
