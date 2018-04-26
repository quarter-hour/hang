package com.bwie.wangkui.quarter_hour.utils;

import java.util.List;

/**
 * Created by dell on 2018/4/24.
 */

public class Bean {
    /**
     * msg :
     * code : 0
     * data : [{"aid":1,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad1.png","productId":null,"title":"第十三界瑞丽模特大赛","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":2,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad2.png","productId":null,"title":"文化艺术节","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":3,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad3.png","productId":null,"title":"直播封面标准","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":4,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad4.png","productId":"1","title":"人气谁最高，金主谁最豪气","type":1,"url":""}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * aid : 1
         * createtime : 2017-12-26T21:49:44
         * icon : https://www.zhaoapi.cn/images/quarter/ad1.png
         * productId : null
         * title : 第十三界瑞丽模特大赛
         * type : 0
         * url : http://m.mv14449315.icoc.bz/index.jsp
         */

        private int aid;
        private String createtime;
        private String icon;
        private Object productId;
        private String title;
        private int type;
        private String url;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"58823c52bede86fe","appsecret":"9460B698362F8607E01839A48D647179","createtime":"2018-04-24T20:36:02","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1523418069882aa.jpg","latitude":null,"longitude":null,"mobile":"15141002577","money":null,"nickname":"大航","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"4A964A2C16823555D737AC1252E795C3","uid":12574,"userId":null,"username":"15141002577"}
     */


}
