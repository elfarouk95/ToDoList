
package com.app.todolist;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class RoadMapModel {

    @SerializedName("data")
    private Data mData;
    @SerializedName("error")
    private Object mError;
    @SerializedName("status")
    private String mStatus;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public Object getError() {
        return mError;
    }

    public void setError(Object error) {
        mError = error;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
