package com.example.javaee3.Entity;

public class DBAssociation {
    /**
     * aid 运动员号码（即id）
     * cid 得分编号
     * sid 比赛编号
     */
    private int aid;
    private int cid;
    private int sid;

    public DBAssociation(int aid, int cid, int sid) {
        this.aid = aid;
        this.cid = cid;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "DBAssociation{" +
                "aid=" + aid +
                ", cid=" + cid +
                ", sid=" + sid +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
