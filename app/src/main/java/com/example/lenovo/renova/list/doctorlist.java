package com.example.lenovo.renova.list;

public class doctorlist {
    String name,fees,location,speclist;
    Integer profileImage;
    Boolean isFav=false;

    public doctorlist(Boolean isFav) {
        this.isFav = isFav;
    }

    public doctorlist(String name, String fees, String location, String speclist, Integer profileImage) {
        this.name = name;
        this.fees = fees;
        this.location = location;
        this.speclist = speclist;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpeclist() {
        return speclist;
    }

    public void setSpeclist(String speclist) {
        this.speclist = speclist;
    }

    public Integer getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Integer profileImage) {
        this.profileImage = profileImage;
    }

    public Boolean getFav() {
        return isFav;
    }

    public void setFav(Boolean fav) {
        isFav = fav;
    }
}
