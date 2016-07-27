package com.konfyt.perfection.beans;

import java.util.List;

/**
 * Created by XCQ on 16/7/27.
 */
public class Home_four {


    /**
     * error : 0
     * message : 成功
     * data : {"zhuanti_list":[{"config_type":"3","config_specname":"想飞上天和太阳肩并肩","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14677888602831.jpeg","sort":"647","id":"539","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"夏天，与冰有关的那些小物","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14649217426084.jpeg","sort":"646","id":"527","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"拒绝枯燥，水杯演绎糖果色美好","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14645911498565.jpeg","sort":"645","id":"460","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"少女系手表  做时间的恋人","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14643155589123.jpeg","sort":"644","id":"425","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"把摩登时代的美国梦带到厨房","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14641471099506.jpeg","sort":"643","id":"286","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"贴心夜灯，伴你度过失眠的长夜","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14640580922255.jpeg","sort":"642","id":"522","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"雷雨季节，带上伞愉快出行","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14639708486603.jpeg","sort":"641","id":"477","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"解放双手，从一个完美的支架开始","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14637102842385.jpeg","sort":"640","id":"519","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"品质耳机，让心灵跟随音乐跳舞","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14633634265224.jpeg","sort":"639","id":"305","address":"","zhuanti_type":"1"},{"config_type":"3","config_specname":"凉爽，自在\u201c掌\u201d控：迷你风扇出击！","picture_url":"http://qwapi.quwan.com/images/quwanapp/APP-IMG-14631029597423.jpeg","sort":"639","id":"514","address":"","zhuanti_type":"2"}]}
     */

    private int error;
    private String message;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * config_type : 3
         * config_specname : 想飞上天和太阳肩并肩
         * picture_url : http://qwapi.quwan.com/images/quwanapp/APP-IMG-14677888602831.jpeg
         * sort : 647
         * id : 539
         * address :
         * zhuanti_type : 1
         */

        private List<ZhuantiListBean> zhuanti_list;

        public List<ZhuantiListBean> getZhuanti_list() {
            return zhuanti_list;
        }

        public void setZhuanti_list(List<ZhuantiListBean> zhuanti_list) {
            this.zhuanti_list = zhuanti_list;
        }

        public static class ZhuantiListBean {
            private String config_type;
            private String config_specname;
            private String picture_url;
            private String sort;
            private String id;
            private String address;
            private String zhuanti_type;

            public String getConfig_type() {
                return config_type;
            }

            public void setConfig_type(String config_type) {
                this.config_type = config_type;
            }

            public String getConfig_specname() {
                return config_specname;
            }

            public void setConfig_specname(String config_specname) {
                this.config_specname = config_specname;
            }

            public String getPicture_url() {
                return picture_url;
            }

            public void setPicture_url(String picture_url) {
                this.picture_url = picture_url;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getZhuanti_type() {
                return zhuanti_type;
            }

            public void setZhuanti_type(String zhuanti_type) {
                this.zhuanti_type = zhuanti_type;
            }
        }
    }
}
