package com.mysummary.myproject.base.entity;

/**
 * Created by xingzhi on 2017/11/27.
 */

public class RiskTestEntity {


    /**
     * riskTest : 62
     * riskLevel : 4
     * modifyDatetime : 2017-11-27T14:04:41+08:00
     */

    private int riskTest;
    private int riskLevel;
    private String modifyDatetime;

    public int getRiskTest() {
        return riskTest;
    }

    public void setRiskTest(int riskTest) {
        this.riskTest = riskTest;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(String modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }
}
