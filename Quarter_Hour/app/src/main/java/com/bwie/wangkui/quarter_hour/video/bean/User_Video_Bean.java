package com.bwie.wangkui.quarter_hour.video.bean;

import java.util.List;

/**
 * Created by dell on 2018/4/27.
 */

public class User_Video_Bean {
    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : {"user":null,"worksEntities":[{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151246557866220171205171834.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":44,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512465578662video_20171205_171828.mp4","wid":52,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151248086952120171205213419.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":6,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512480869521video_20171205_213345.mp4","wid":56,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151252157428720171206085247.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":2,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512521574287video_20171206_085203.mp4","wid":61,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151255002044320171206164618.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":1,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512550020443video_20171206_164500.mp4","wid":105,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151261880914620171207115305.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":3,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512618809146video_20171207_115248.mp4","wid":175,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151323769211520171214154759.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":0,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513237692115video_20171214_154742.mp4","wid":215,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151365357411620171219111915.jpg","createTime":"2017-12-19T11:19:34","favoriteNum":null,"latitude":"100","localUri":null,"longitude":"100","playNum":20,"praiseNum":null,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513653574116video_20171219_111845.mp4","wid":226,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151425878606620171226112617.jpg","createTime":"2017-12-26T11:26:26","favoriteNum":null,"latitude":"100","localUri":null,"longitude":"100","playNum":10,"praiseNum":null,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514258786066video_20171226_112556.mp4","wid":241,"workDesc":""}]}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user : null
         * worksEntities : [{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151246557866220171205171834.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":44,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512465578662video_20171205_171828.mp4","wid":52,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151248086952120171205213419.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":6,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512480869521video_20171205_213345.mp4","wid":56,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151252157428720171206085247.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":2,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512521574287video_20171206_085203.mp4","wid":61,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151255002044320171206164618.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":1,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512550020443video_20171206_164500.mp4","wid":105,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151261880914620171207115305.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":3,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512618809146video_20171207_115248.mp4","wid":175,"workDesc":""},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151323769211520171214154759.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":0,"praiseNum":0,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513237692115video_20171214_154742.mp4","wid":215,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151365357411620171219111915.jpg","createTime":"2017-12-19T11:19:34","favoriteNum":null,"latitude":"100","localUri":null,"longitude":"100","playNum":20,"praiseNum":null,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513653574116video_20171219_111845.mp4","wid":226,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151425878606620171226112617.jpg","createTime":"2017-12-26T11:26:26","favoriteNum":null,"latitude":"100","localUri":null,"longitude":"100","playNum":10,"praiseNum":null,"uid":195,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514258786066video_20171226_112556.mp4","wid":241,"workDesc":""}]
         */

        private Object user;
        private List<WorksEntitiesBean> worksEntities;

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }

        public List<WorksEntitiesBean> getWorksEntities() {
            return worksEntities;
        }

        public void setWorksEntities(List<WorksEntitiesBean> worksEntities) {
            this.worksEntities = worksEntities;
        }

        public static class WorksEntitiesBean {
            /**
             * commentNum : 0
             * cover : https://www.zhaoapi.cn/images/quarter/151246557866220171205171834.jpg
             * createTime : 2017-12-17T19:20:44
             * favoriteNum : 0
             * latitude : 100
             * localUri : null
             * longitude : 100
             * playNum : 44
             * praiseNum : 0
             * uid : 195
             * videoUrl : https://www.zhaoapi.cn/images/quarter/1512465578662video_20171205_171828.mp4
             * wid : 52
             * workDesc :
             */

            private int commentNum;
            private String cover;
            private String createTime;
            private int favoriteNum;
            private String latitude;
            private Object localUri;
            private String longitude;
            private int playNum;
            private int praiseNum;
            private int uid;
            private String videoUrl;
            private int wid;
            private String workDesc;

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getFavoriteNum() {
                return favoriteNum;
            }

            public void setFavoriteNum(int favoriteNum) {
                this.favoriteNum = favoriteNum;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public Object getLocalUri() {
                return localUri;
            }

            public void setLocalUri(Object localUri) {
                this.localUri = localUri;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public int getPlayNum() {
                return playNum;
            }

            public void setPlayNum(int playNum) {
                this.playNum = playNum;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }

            public String getWorkDesc() {
                return workDesc;
            }

            public void setWorkDesc(String workDesc) {
                this.workDesc = workDesc;
            }
        }
    }
}
