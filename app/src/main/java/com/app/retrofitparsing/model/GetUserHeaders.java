package com.app.retrofitparsing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUserHeaders {


    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("data")
    private List<Data> data;
    @Expose
    @SerializedName("status")
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Data {
        @Expose
        @SerializedName("designation")
        private Designation designation;
        @Expose
        @SerializedName("department")
        private Department department;
        @Expose
        @SerializedName("updated_at")
        private String updatedAt;
        @Expose
        @SerializedName("created_at")
        private String createdAt;
        @Expose
        @SerializedName("status")
        private boolean status;
        @Expose
        @SerializedName("management_profile")
        private boolean managementProfile;
        @Expose
        @SerializedName("created_by")
        private int createdBy;
        @Expose
        @SerializedName("gender")
        private String gender;
        @Expose
        @SerializedName("phone_no")
        private String phoneNo;
        @Expose
        @SerializedName("dob")
        private String dob;
        @Expose
        @SerializedName("department_id")
        private int departmentId;
        @Expose
        @SerializedName("role_id")
        private int roleId;
        @Expose
        @SerializedName("user_theme")
        private String userTheme;
        @Expose
        @SerializedName("profilepicture")
        private String profilepicture;
        @Expose
        @SerializedName("designation_id")
        private int designationId;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("password")
        private String password;
        @Expose
        @SerializedName("employee_id")
        private String employeeId;
        @Expose
        @SerializedName("email_id")
        private String emailId;
        @Expose
        @SerializedName("lastname")
        private String lastname;
        @Expose
        @SerializedName("firstname")
        private String firstname;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("thumb_profile_path")
        private String thumbProfilePath;
        @Expose
        @SerializedName("profile_path")
        private String profilePath;

        public Designation getDesignation() {
            return designation;
        }

        public void setDesignation(Designation designation) {
            this.designation = designation;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public boolean getManagementProfile() {
            return managementProfile;
        }

        public void setManagementProfile(boolean managementProfile) {
            this.managementProfile = managementProfile;
        }

        public int getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getUserTheme() {
            return userTheme;
        }

        public void setUserTheme(String userTheme) {
            this.userTheme = userTheme;
        }

        public String getProfilepicture() {
            return profilepicture;
        }

        public void setProfilepicture(String profilepicture) {
            this.profilepicture = profilepicture;
        }

        public int getDesignationId() {
            return designationId;
        }

        public void setDesignationId(int designationId) {
            this.designationId = designationId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getThumbProfilePath() {
            return thumbProfilePath;
        }

        public void setThumbProfilePath(String thumbProfilePath) {
            this.thumbProfilePath = thumbProfilePath;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }
    }

    public static class Designation {
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("id")
        private int id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Department {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
