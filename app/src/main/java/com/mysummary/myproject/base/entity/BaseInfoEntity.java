package com.mysummary.myproject.base.entity;

/**
 * Created by xingzhi on 2017/11/27.
 */

public class BaseInfoEntity {

    /**
     * accessToken : 04337887b569422c9ab82f5de649a9c8
     * testType : 1
     * realName : 张瑞
     * idCardNum : 220822********1614
     * age : 24
     * bankId : 102
     * bankName : 中国工商银行
     * bankCardNum : 6212********2296
     * mobileNum : 185****0554
     * riskLevel : 2
     * nickName : 行知
     * email : null
     * city : 北京市
     * province : 北京市
     * isInvestor : false
     * address : 西城区德胜门外大街辅路
     * job : 自由职业
     * custType : 1
     * isProfessional : false
     * publicCount : 5
     * publicBuying : 0
     * publicIncomeYesterday : -0.08
     * groupAsset : 397.3428
     * currentIncomeAll : 15.42
     * currentYesterday : 2017-11-24
     * currentBuying : 0
     * publicYesterday : 2017-11-24
     * currentAsset : 166.31
     * groupCount : 1
     * groupIncomeYesterday : -2.43
     * publicIncomeAll : 5.85
     * groupYesterday : 2017-11-24
     * publicAsset : 362.116186
     * currentIncomeYesterday : 0.03
     * groupIncomeAll : 37.75
     * groupBuying : 0
     * avatar : upload/2017-05-11/59d1464fff9d49d19f0077a81462c022150.jpg
     * qrCode : accounts/qrCodes/c62825d8-2067-4374-8b48-937d258f89f3
     * inviteCodeOwn : 10022686
     * qiandou : 300
     * inviteParent : 乾道金融
     * couponDatetime : 2017-11-25T17:02:18+08:00
     * groupConvertDatetime : 2017-10-25T09:08:19+08:00
     * inviteDatetime : 2016-10-24T12:16:56+08:00
     */

    private String accessToken;
    private int testType;
    private String realName;
    private String idCardNum;
    private int age;
    private int bankId;
    private String bankName;
    private String bankCardNum;
    private String mobileNum;
    private int riskLevel;
    private String nickName;
    private Object email;
    private String city;
    private String province;
    private boolean isInvestor;
    private String address;
    private String job;
    private String custType;
    private boolean isProfessional;
    private int publicCount;
    private int publicBuying;
    private double publicIncomeYesterday;
    private double groupAsset;
    private double currentIncomeAll;
    private String currentYesterday;
    private int currentBuying;
    private String publicYesterday;
    private double currentAsset;
    private int groupCount;
    private double groupIncomeYesterday;
    private double publicIncomeAll;
    private String groupYesterday;
    private double publicAsset;
    private double currentIncomeYesterday;
    private double groupIncomeAll;
    private int groupBuying;
    private String avatar;
    private String qrCode;
    private String inviteCodeOwn;
    private int qiandou;
    private String inviteParent;
    private String couponDatetime;
    private String groupConvertDatetime;
    private String inviteDatetime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getTestType() {
        return testType;
    }

    public void setTestType(int testType) {
        this.testType = testType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public boolean isIsInvestor() {
        return isInvestor;
    }

    public void setIsInvestor(boolean isInvestor) {
        this.isInvestor = isInvestor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public boolean isIsProfessional() {
        return isProfessional;
    }

    public void setIsProfessional(boolean isProfessional) {
        this.isProfessional = isProfessional;
    }

    public int getPublicCount() {
        return publicCount;
    }

    public void setPublicCount(int publicCount) {
        this.publicCount = publicCount;
    }

    public int getPublicBuying() {
        return publicBuying;
    }

    public void setPublicBuying(int publicBuying) {
        this.publicBuying = publicBuying;
    }

    public double getPublicIncomeYesterday() {
        return publicIncomeYesterday;
    }

    public void setPublicIncomeYesterday(double publicIncomeYesterday) {
        this.publicIncomeYesterday = publicIncomeYesterday;
    }

    public double getGroupAsset() {
        return groupAsset;
    }

    public void setGroupAsset(double groupAsset) {
        this.groupAsset = groupAsset;
    }

    public double getCurrentIncomeAll() {
        return currentIncomeAll;
    }

    public void setCurrentIncomeAll(double currentIncomeAll) {
        this.currentIncomeAll = currentIncomeAll;
    }

    public String getCurrentYesterday() {
        return currentYesterday;
    }

    public void setCurrentYesterday(String currentYesterday) {
        this.currentYesterday = currentYesterday;
    }

    public int getCurrentBuying() {
        return currentBuying;
    }

    public void setCurrentBuying(int currentBuying) {
        this.currentBuying = currentBuying;
    }

    public String getPublicYesterday() {
        return publicYesterday;
    }

    public void setPublicYesterday(String publicYesterday) {
        this.publicYesterday = publicYesterday;
    }

    public double getCurrentAsset() {
        return currentAsset;
    }

    public void setCurrentAsset(double currentAsset) {
        this.currentAsset = currentAsset;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public double getGroupIncomeYesterday() {
        return groupIncomeYesterday;
    }

    public void setGroupIncomeYesterday(double groupIncomeYesterday) {
        this.groupIncomeYesterday = groupIncomeYesterday;
    }

    public double getPublicIncomeAll() {
        return publicIncomeAll;
    }

    public void setPublicIncomeAll(double publicIncomeAll) {
        this.publicIncomeAll = publicIncomeAll;
    }

    public String getGroupYesterday() {
        return groupYesterday;
    }

    public void setGroupYesterday(String groupYesterday) {
        this.groupYesterday = groupYesterday;
    }

    public double getPublicAsset() {
        return publicAsset;
    }

    public void setPublicAsset(double publicAsset) {
        this.publicAsset = publicAsset;
    }

    public double getCurrentIncomeYesterday() {
        return currentIncomeYesterday;
    }

    public void setCurrentIncomeYesterday(double currentIncomeYesterday) {
        this.currentIncomeYesterday = currentIncomeYesterday;
    }

    public double getGroupIncomeAll() {
        return groupIncomeAll;
    }

    public void setGroupIncomeAll(double groupIncomeAll) {
        this.groupIncomeAll = groupIncomeAll;
    }

    public int getGroupBuying() {
        return groupBuying;
    }

    public void setGroupBuying(int groupBuying) {
        this.groupBuying = groupBuying;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getInviteCodeOwn() {
        return inviteCodeOwn;
    }

    public void setInviteCodeOwn(String inviteCodeOwn) {
        this.inviteCodeOwn = inviteCodeOwn;
    }

    public int getQiandou() {
        return qiandou;
    }

    public void setQiandou(int qiandou) {
        this.qiandou = qiandou;
    }

    public String getInviteParent() {
        return inviteParent;
    }

    public void setInviteParent(String inviteParent) {
        this.inviteParent = inviteParent;
    }

    public String getCouponDatetime() {
        return couponDatetime;
    }

    public void setCouponDatetime(String couponDatetime) {
        this.couponDatetime = couponDatetime;
    }

    public String getGroupConvertDatetime() {
        return groupConvertDatetime;
    }

    public void setGroupConvertDatetime(String groupConvertDatetime) {
        this.groupConvertDatetime = groupConvertDatetime;
    }

    public String getInviteDatetime() {
        return inviteDatetime;
    }

    public void setInviteDatetime(String inviteDatetime) {
        this.inviteDatetime = inviteDatetime;
    }
}
