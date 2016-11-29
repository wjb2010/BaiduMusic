package com.example.dllo.baidumusic.Bean;

import java.util.List;

/**
 * Created by dllo on 16/11/24.
 */

public class RanPicBean {

    /**
     * pic : [{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479915559a660c2fa0e65c9a15481cde3d0a68834.jpg","randpic_ios5":"","randpic_desc":"回到过去，和齐秦一起翻唱齐秦","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14799156226f7f2b55174861eae3313cdc8858f6dc.jpg","randpic_qq":"","randpic_2":"bos_client_147991556618367beb80404223e53ef2510d355f13","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_147991556618367beb80404223e53ef2510d355f13.jpg","special_type":0,"ipad_desc":"回到过去，和齐秦一起翻唱齐秦","is_publish":"111100","mo_type":"4","type":6,"code":"http://music.baidu.com/cms/webview/ktv_activity/20161123/"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479886112c285be61b7d7eff2af276e183a065e40.jpg","randpic_ios5":"","randpic_desc":"音乐热56","randpic_ipad":"","randpic_qq":"","randpic_2":"bos_client_14798861365feb659e84d298ad697304c27fb6caaa","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14798861365feb659e84d298ad697304c27fb6caaa.jpg","special_type":0,"ipad_desc":"音乐热56","is_publish":"111101","mo_type":"4","type":6,"code":"http://music.baidu.com/cms/webview/topic_activity/mobile-tmp-v60/"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14799775198e6cd2d996c8129949326729d7ec3092.jpg","randpic_ios5":"","randpic_desc":"老狼演唱会","randpic_ipad":"","randpic_qq":"","randpic_2":"bos_client_1479977664876b6327fa01fcfcf13fe2b41da56751","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479977664876b6327fa01fcfcf13fe2b41da56751.jpg","special_type":0,"ipad_desc":"老狼演唱会","is_publish":"111101","mo_type":"4","type":6,"code":"http://music.baidu.com/cms/webview/laolangshenzhen/index.html"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479970337aad98630e7f83f748fc8a23ed23ca75b.jpg","randpic_ios5":"","randpic_desc":"开通会员送耳机","randpic_ipad":"","randpic_qq":"","randpic_2":"bos_client_1479970341ef68da6d142be6ecbbe88422b3752c67","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479970341ef68da6d142be6ecbbe88422b3752c67.jpg","special_type":0,"ipad_desc":"开通会员送耳机","is_publish":"111101","mo_type":"4","type":6,"code":"http://music.baidu.com/cms/webview/vip_activity/erji_vip/index.html"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14794609176ef489220327f3b52dcb24402cf6ccb1.jpg","randpic_ios5":"","randpic_desc":"总有一首拉你入坑 爱豆show防弹少年团特辑","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14794609273fdc6994017bec7c13bc03ba75f635c1.jpg","randpic_qq":"","randpic_2":"bos_client_1479460912fcd6f2b256e4afbef92dd7323668dcef","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479460912fcd6f2b256e4afbef92dd7323668dcef.jpg","special_type":0,"ipad_desc":"总有一首拉你入坑 爱豆show防弹少年团特辑","is_publish":"111100","mo_type":"4","type":6,"code":"http://music.baidu.com/cms/webview/topic_activity/idolshow10/"}]
     * error_code : 22000
     */

    private int error_code;
    private List<PicBean> pic;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<PicBean> getPic() {
        return pic;
    }

    public void setPic(List<PicBean> pic) {
        this.pic = pic;
    }

    public static class PicBean {
        /**
         * randpic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1479915559a660c2fa0e65c9a15481cde3d0a68834.jpg
         * randpic_ios5 :
         * randpic_desc : 回到过去，和齐秦一起翻唱齐秦
         * randpic_ipad : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14799156226f7f2b55174861eae3313cdc8858f6dc.jpg
         * randpic_qq :
         * randpic_2 : bos_client_147991556618367beb80404223e53ef2510d355f13
         * randpic_iphone6 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_147991556618367beb80404223e53ef2510d355f13.jpg
         * special_type : 0
         * ipad_desc : 回到过去，和齐秦一起翻唱齐秦
         * is_publish : 111100
         * mo_type : 4
         * type : 6
         * code : http://music.baidu.com/cms/webview/ktv_activity/20161123/
         */

        private String randpic;
        private String randpic_ios5;
        private String randpic_desc;
        private String randpic_ipad;
        private String randpic_qq;
        private String randpic_2;
        private String randpic_iphone6;
        private int special_type;
        private String ipad_desc;
        private String is_publish;
        private String mo_type;
        private int type;
        private String code;

        public String getRandpic() {
            return randpic;
        }

        public void setRandpic(String randpic) {
            this.randpic = randpic;
        }

        public String getRandpic_ios5() {
            return randpic_ios5;
        }

        public void setRandpic_ios5(String randpic_ios5) {
            this.randpic_ios5 = randpic_ios5;
        }

        public String getRandpic_desc() {
            return randpic_desc;
        }

        public void setRandpic_desc(String randpic_desc) {
            this.randpic_desc = randpic_desc;
        }

        public String getRandpic_ipad() {
            return randpic_ipad;
        }

        public void setRandpic_ipad(String randpic_ipad) {
            this.randpic_ipad = randpic_ipad;
        }

        public String getRandpic_qq() {
            return randpic_qq;
        }

        public void setRandpic_qq(String randpic_qq) {
            this.randpic_qq = randpic_qq;
        }

        public String getRandpic_2() {
            return randpic_2;
        }

        public void setRandpic_2(String randpic_2) {
            this.randpic_2 = randpic_2;
        }

        public String getRandpic_iphone6() {
            return randpic_iphone6;
        }

        public void setRandpic_iphone6(String randpic_iphone6) {
            this.randpic_iphone6 = randpic_iphone6;
        }

        public int getSpecial_type() {
            return special_type;
        }

        public void setSpecial_type(int special_type) {
            this.special_type = special_type;
        }

        public String getIpad_desc() {
            return ipad_desc;
        }

        public void setIpad_desc(String ipad_desc) {
            this.ipad_desc = ipad_desc;
        }

        public String getIs_publish() {
            return is_publish;
        }

        public void setIs_publish(String is_publish) {
            this.is_publish = is_publish;
        }

        public String getMo_type() {
            return mo_type;
        }

        public void setMo_type(String mo_type) {
            this.mo_type = mo_type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
