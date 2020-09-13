package com.turman.and_guide.kotlin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public  class ResponseBean<T> {
    /**
     * ResultNo : 0
     * Result : []
     * Total : 3587
     * PageCount : 0
     */

    private int ResultNo;
    private int Total;
    private int PageCount;
    private List<T> Result;

    public int getResultNo() {
        return ResultNo;
    }

    public void setResultNo(int ResultNo) {
        this.ResultNo = ResultNo;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int PageCount) {
        this.PageCount = PageCount;
    }

    public List<?> getResult() {
        return Result;
    }

    public void setResult(List<T> Result) {
        this.Result = Result;
    }

    public static ResponseBean<StaffBean> getrs(String sr) {
        return new Gson().fromJson(sr,new TypeToken<ResponseBean<StaffBean>>(){}.getType());
    }
}
