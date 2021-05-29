package org.example.ui.order;

public class Foods {
    private String fid;
    private String fname;
    private int fmoney;
    private String fclass;

    public String getFid() {
        return fid;
    }

    public String getFname() {
        return fname;
    }

    public int getFmoney() {
        return fmoney;
    }

    public String getFclass() {
        return fclass;
    }

    public void setFid(String fid){
        this.fid = fid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFmoney(int fmoney) {
        this.fmoney = fmoney;
    }

    public void setFclass(String fclass) {
        this.fclass = fclass;
    }
}
