package com.example.androidreccomendme;

public class User {


    //type is an int value 1-5 that represents what type of Item an Item is
    private int type;
    // category is a String value that represents an Item's category
    private String category;
    //id is a String value that represents an Item's id
    private String id;
    //name is a String value that represents an Item's name
    private String user;
    //description is a String value that represents an Item's description
    private String Userid;
    //score is a String value that represents an Item's score
    private String reasons;
    //platform is a String value that represents an Item's platform(theater/hulu/...etc)
    private String password;
    //pic is a String value that contains a URL linking to an Item's corresponding picture
    private String pic;
    //time_length is a String value that represents an Item's runtime
    private String gender;
    //director is a String value that represents an Item's director
    private String banned;
    //release_date is a String value that represents an Item's release data
    private String isComment;
    //release_date is a String value that represents an Item's release data
    private String email;
    private String admin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
