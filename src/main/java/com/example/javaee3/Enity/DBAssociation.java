package com.example.javaee3.Enity;

public class DBAssociation {
    /**
     * aid 运动员号码（即id）
     * cid 得分编号
     * sid 比赛编号
     */
    private int aid;
    private int cid;
    private int sid;

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
