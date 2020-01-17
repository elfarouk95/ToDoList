
package com.app.todolist;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Data {

    @SerializedName("notVisited")
    private List<Visited> mNotVisited;
    @SerializedName("visited")
    private List<Visited> mVisited;

    public List<Visited> getNotVisited() {
        return mNotVisited;
    }

    public void setNotVisited(List<Visited> notVisited) {
        mNotVisited = notVisited;
    }

    public List<Visited> getVisited() {
        return mVisited;
    }

    public void setVisited(List<Visited> visited) {
        mVisited = visited;
    }

}
