package com.elijah.apps.mypharmacy;

public class Item {
    String mPhone,mEmail,mPassword,mId;

    public Item(String mPhone, String mEmail, String mPassword, String mId) {
        this.mPhone = mPhone;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mId = mId;
    }

    public Item() {
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
}

