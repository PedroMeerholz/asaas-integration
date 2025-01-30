package integration.asaas.request.response.findCustomer;


import java.util.List;

public class FindAllCustomersResponse {
    private String object;
    private boolean hasMore;
    private int totalCount;
    private int limit;
    private int offset;
    private List<RetrievedCustomer> data;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<RetrievedCustomer> getData() {
        return data;
    }

    public void setData(List<RetrievedCustomer> data) {
        this.data = data;
    }
}
