
package com.app.todolist;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Companies {

    @SerializedName("area_id")
    private String mAreaId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private Object mImage;
    @SerializedName("kind")
    private String mKind;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("trash")
    private String mTrash;

    public String getAreaId() {
        return mAreaId;
    }

    public void setAreaId(String areaId) {
        mAreaId = areaId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Object getImage() {
        return mImage;
    }

    public void setImage(Object image) {
        mImage = image;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getTrash() {
        return mTrash;
    }

    public void setTrash(String trash) {
        mTrash = trash;
    }

}
