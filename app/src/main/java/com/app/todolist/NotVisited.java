
package com.app.todolist;

import com.google.gson.annotations.SerializedName;

public class NotVisited {

    @SerializedName("companies")
    private Companies mCompanies;
    @SerializedName("company_id")
    private String mCompanyId;
    @SerializedName("date")
    private String mDate;
    @SerializedName("employee_id")
    private String mEmployeeId;
    @SerializedName("id")
    private Long mId;

    public Companies getCompanies() {
        return mCompanies;
    }

    public void setCompanies(Companies companies) {
        mCompanies = companies;
    }

    public String getCompanyId() {
        return mCompanyId;
    }

    public void setCompanyId(String companyId) {
        mCompanyId = companyId;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getEmployeeId() {
        return mEmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        mEmployeeId = employeeId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

}
