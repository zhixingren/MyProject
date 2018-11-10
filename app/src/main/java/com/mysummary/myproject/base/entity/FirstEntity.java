package com.mysummary.myproject.base.entity;

import java.util.List;

/**
 * Created by xingzhi on 2017/11/25.
 */

public class FirstEntity {

    /**
     * spaceId : 1011
     * totalCount : 2
     * data : [{"targetGroupCode":null,"imageUrl":"https://www.qiandaojr.com/d/file/qiandaojr/2017-01-03/c321d2548d67963b4808bbffde79b716.jpg","fundMarkValue4":null,"fundMarkValue3":null,"fundMarkName4":null,"targetFundId":38914,"fundMarkName3":null,"fundMarkValue2":null,"advertId":23,"targetUrl":"https://www.qiandaojr.com/h5/banner1.html","fundMarkName2":null,"fundMarkName1":null,"fundMarkValue1":null,"spaceIndex":1,"addDateTime":"2017-01-03T11:07:07+08:00","targtFundCode":"000730","targetType":1,"tagline":"抓住定投好时机"},{"targetGroupCode":null,"imageUrl":"https://www.qiandaojr.com/d/file/qiandaojr/2017-04-01/8a20e593b3ba79d95dbc8493ab7402ec.jpg","fundMarkValue4":null,"fundMarkValue3":null,"fundMarkName4":null,"targetFundId":38914,"fundMarkName3":null,"fundMarkValue2":null,"advertId":24,"targetUrl":"https://www.qiandaojr.com/h5/rate/rate.html","fundMarkName2":null,"fundMarkName1":null,"fundMarkValue1":null,"spaceIndex":2,"addDateTime":"2017-04-05T15:47:45+08:00","targtFundCode":"000730","targetType":1,"tagline":"1折买基金 省钱没商量"}]
     */

    private int spaceId;
    private int totalCount;
    private List<DataBean> data;

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * targetGroupCode : null
         * imageUrl : https://www.qiandaojr.com/d/file/qiandaojr/2017-01-03/c321d2548d67963b4808bbffde79b716.jpg
         * fundMarkValue4 : null
         * fundMarkValue3 : null
         * fundMarkName4 : null
         * targetFundId : 38914
         * fundMarkName3 : null
         * fundMarkValue2 : null
         * advertId : 23
         * targetUrl : https://www.qiandaojr.com/h5/banner1.html
         * fundMarkName2 : null
         * fundMarkName1 : null
         * fundMarkValue1 : null
         * spaceIndex : 1
         * addDateTime : 2017-01-03T11:07:07+08:00
         * targtFundCode : 000730
         * targetType : 1
         * tagline : 抓住定投好时机
         */

        private Object targetGroupCode;
        private String imageUrl;
        private Object fundMarkValue4;
        private Object fundMarkValue3;
        private Object fundMarkName4;
        private int targetFundId;
        private Object fundMarkName3;
        private Object fundMarkValue2;
        private int advertId;
        private String targetUrl;
        private Object fundMarkName2;
        private Object fundMarkName1;
        private Object fundMarkValue1;
        private int spaceIndex;
        private String addDateTime;
        private String targtFundCode;
        private int targetType;
        private String tagline;

        public Object getTargetGroupCode() {
            return targetGroupCode;
        }

        public void setTargetGroupCode(Object targetGroupCode) {
            this.targetGroupCode = targetGroupCode;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getFundMarkValue4() {
            return fundMarkValue4;
        }

        public void setFundMarkValue4(Object fundMarkValue4) {
            this.fundMarkValue4 = fundMarkValue4;
        }

        public Object getFundMarkValue3() {
            return fundMarkValue3;
        }

        public void setFundMarkValue3(Object fundMarkValue3) {
            this.fundMarkValue3 = fundMarkValue3;
        }

        public Object getFundMarkName4() {
            return fundMarkName4;
        }

        public void setFundMarkName4(Object fundMarkName4) {
            this.fundMarkName4 = fundMarkName4;
        }

        public int getTargetFundId() {
            return targetFundId;
        }

        public void setTargetFundId(int targetFundId) {
            this.targetFundId = targetFundId;
        }

        public Object getFundMarkName3() {
            return fundMarkName3;
        }

        public void setFundMarkName3(Object fundMarkName3) {
            this.fundMarkName3 = fundMarkName3;
        }

        public Object getFundMarkValue2() {
            return fundMarkValue2;
        }

        public void setFundMarkValue2(Object fundMarkValue2) {
            this.fundMarkValue2 = fundMarkValue2;
        }

        public int getAdvertId() {
            return advertId;
        }

        public void setAdvertId(int advertId) {
            this.advertId = advertId;
        }

        public String getTargetUrl() {
            return targetUrl;
        }

        public void setTargetUrl(String targetUrl) {
            this.targetUrl = targetUrl;
        }

        public Object getFundMarkName2() {
            return fundMarkName2;
        }

        public void setFundMarkName2(Object fundMarkName2) {
            this.fundMarkName2 = fundMarkName2;
        }

        public Object getFundMarkName1() {
            return fundMarkName1;
        }

        public void setFundMarkName1(Object fundMarkName1) {
            this.fundMarkName1 = fundMarkName1;
        }

        public Object getFundMarkValue1() {
            return fundMarkValue1;
        }

        public void setFundMarkValue1(Object fundMarkValue1) {
            this.fundMarkValue1 = fundMarkValue1;
        }

        public int getSpaceIndex() {
            return spaceIndex;
        }

        public void setSpaceIndex(int spaceIndex) {
            this.spaceIndex = spaceIndex;
        }

        public String getAddDateTime() {
            return addDateTime;
        }

        public void setAddDateTime(String addDateTime) {
            this.addDateTime = addDateTime;
        }

        public String getTargtFundCode() {
            return targtFundCode;
        }

        public void setTargtFundCode(String targtFundCode) {
            this.targtFundCode = targtFundCode;
        }

        public int getTargetType() {
            return targetType;
        }

        public void setTargetType(int targetType) {
            this.targetType = targetType;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }
    }
}
