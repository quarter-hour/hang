package com.bwie.wangkui.quarter_hour.jokes.model.bean;

import java.util.List;

/**
 * Created by DELL on 2018/5/1.
 */

public class DuanZi {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"\"sadfghghjghgfsdas\"","createTime":"2018-04-30T14:42:36","imgUrls":null,"jid":2465,"praiseNum":null,"shareNum":null,"uid":11251,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524963413309b79186b2a2b4456d3dc0ed7ea4dd883a.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"阿斯顿发表八行书","createTime":"2018-04-30T14:41:15","imgUrls":null,"jid":2464,"praiseNum":null,"shareNum":null,"uid":11251,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524963413309b79186b2a2b4456d3dc0ed7ea4dd883a.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"158556255","createTime":"2018-04-29T17:17:01","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524993421293B612Kaji_20180429_125207_697.jpg|https://www.zhaoapi.cn/images/quarter/1524993421293B612Kaji_20180429_090325_290.jpg","jid":2463,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"158556255","createTime":"2018-04-29T17:16:42","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524993402497B612Kaji_20180429_125207_697.jpg|https://www.zhaoapi.cn/images/quarter/1524993402512B612Kaji_20180429_090325_290.jpg","jid":2462,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"好好补补","createTime":"2018-04-29T12:08:10","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524974890741Screenshot_2018-04-24-17-45-52-92.png|https://www.zhaoapi.cn/images/quarter/1524974890741Screenshot_2018-04-24-17-45-43-09.png","jid":2461,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"小闲猫","praiseNum":"null"}},{"commentNum":null,"content":"给哦里咯人做","createTime":"2018-04-29T12:07:15","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524974835787IMG_20180428_193111.jpg","jid":2460,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524894090431head_icon.jpg","nickname":"孑然","praiseNum":"null"}},{"commentNum":null,"content":"给哦里咯人做","createTime":"2018-04-29T12:07:15","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524974835506IMG_20180428_193111.jpg","jid":2459,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524894090431head_icon.jpg","nickname":"孑然","praiseNum":"null"}},{"commentNum":null,"content":"给哦里咯人做","createTime":"2018-04-29T12:07:15","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524974835037IMG_20180428_193111.jpg","jid":2458,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524894090431head_icon.jpg","nickname":"孑然","praiseNum":"null"}},{"commentNum":null,"content":"给哦里咯人做","createTime":"2018-04-29T12:07:06","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524974826975IMG_20180428_193111.jpg","jid":2457,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524894090431head_icon.jpg","nickname":"孑然","praiseNum":"null"}},{"commentNum":null,"content":"给哦里咯人做","createTime":"2018-04-29T12:06:59","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524974819365IMG_20180428_193111.jpg","jid":2456,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524894090431head_icon.jpg","nickname":"孑然","praiseNum":"null"}}]
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
         * commentNum : null
         * content : "sadfghghjghgfsdas"
         * createTime : 2018-04-30T14:42:36
         * imgUrls : null
         * jid : 2465
         * praiseNum : null
         * shareNum : null
         * uid : 11251
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524963413309b79186b2a2b4456d3dc0ed7ea4dd883a.jpg","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524963413309b79186b2a2b4456d3dc0ed7ea4dd883a.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
