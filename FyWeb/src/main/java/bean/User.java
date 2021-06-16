package bean;

public class User {
    private String bid;
    private String sname;
    private String bname;
    private String bauthor;
    private String bhome;
    public User(){}
    public User(String bid, String sname, String bname, String bauthor, String bhome) {
        this.bid=bid;
        this.sname=sname;
        this.bname=bname;
        this.bauthor=bauthor;
        this.bhome=bhome;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBhome() {
        return bhome;
    }

    public void setBhome(String bhome) {
        this.bhome = bhome;
    }
}
