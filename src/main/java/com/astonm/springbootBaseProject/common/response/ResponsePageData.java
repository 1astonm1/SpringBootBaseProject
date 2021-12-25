package com.astonm.springbootBaseProject.common.response;



@SuppressWarnings({"rawtypes"})
public class ResponsePageData<T> extends ResponseData<T> {


    private PageBean paging;

    public ResponsePageData() {
        super();
    }

    public ResponsePageData(int code, String msg, boolean success) {
        super(code, msg, success);
    }

    public PageBean getPaging() {
        return paging;
    }

    public ResponsePageData setPaging(PageBean paging) {
        this.paging = paging;
        return this;
    }

    @Override
    public ResponsePageData<T> setData(T data) {
        super.setData(data);
        return this;
    }


    public static ResponsePageData success() {
        return success("success");
    }

    public static ResponsePageData success(String msg) {
        return success(CODE_SUCCESS, msg);
    }

    public static ResponsePageData success(int code, String message) {
        return new ResponsePageData(code, message, true);
    }

    public static ResponsePageData failure() {
        return failure("failure");
    }

    public static ResponsePageData failure(String message) {
        return failure(CODE_FAILURE, message);
    }

    public static ResponsePageData failure(int code, String message) {
        return new ResponsePageData(code, message, false);
    }

}
