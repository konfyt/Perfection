package com.konfyt.perfection.beans;

import java.util.List;

/**
 * Created by Konfyt on 2016/7/24.
 */
public class ClassifySale {


    /**
     * error : 0
     * message : 成功
     * data : {"category":{"content":{"770101":"保暖","770102":"抱枕·靠垫·坐垫","770103":"宠物用品","770104":"床上用品","770105":"打火机·点烟器·电子烟","770107":"儿童·母婴","770108":"购物车·购物袋","770109":"计量用具","770110":"加湿器","770111":"家具","770112":"乐器","770113":"礼品·礼盒·红包","770114":"门铃·门挡","770115":"纳凉","770116":"驱蚊","770117":"伞·雨衣·雨靴","770118":"生活电器","770119":"收纳整理","770120":"睡衣·午睡毯·披肩","770121":"拖鞋·家居鞋","770122":"桌垫","770123":"五金·工具"},"id_arr":[770116,770119,770102,770117,770110,770104,770118,770115,770105,770101,770120,770113,770121,770114,770103,770109,770107,770108,770122,770111,770123,770112]},"cat_goods":[{"goods_id":"57202","shop_price":"159.00","promote_price":"159.00","goods_name":"翻翻灯(白色)","original_img":"http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14635407743701-400.jpeg","app_original_img":"images/quwanapp/goods/APP-IMG-14635407743701.jpeg","promote_end_date":"0"},{"goods_id":"57198","shop_price":"49.00","promote_price":"49.00","goods_name":"稻草人小夜灯-直插黄光","original_img":"http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14624404493269-400.jpeg","app_original_img":"images/quwanapp/goods/APP-IMG-14624404493269.jpeg","promote_end_date":"1464681599"},{"goods_id":"57191","shop_price":"49.00","promote_price":"49.00","goods_name":"三折黑胶防晒太阳伞--柠檬伞","original_img":"http://i2.quwan.com/images/201604/1461810166408556675-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57175","shop_price":"89.00","promote_price":"89.00","goods_name":"喷雾迷你风扇(粉色)","original_img":"http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14629625463317-400.jpeg","app_original_img":"images/quwanapp/goods/APP-IMG-14629625463317.jpeg","promote_end_date":"0"},{"goods_id":"57172","shop_price":"89.00","promote_price":"89.00","goods_name":"魔术豆风扇(黑色)","original_img":"http://i2.quwan.com/images/201605/1462321851638437071-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57167","shop_price":"69.00","promote_price":"69.00","goods_name":"格先者情侣风扇(白色)","original_img":"http://i2.quwan.com/images/201604/1461026575179736227-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57164","shop_price":"159.00","promote_price":"159.00","goods_name":"3D画框纸雕灯017-Deer nature","original_img":"http://i2.quwan.com/images/201604/1461803416624601996-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57160","shop_price":"78.00","promote_price":"78.00","goods_name":"揽月3D打印月球灯-7cm","original_img":"http://i2.quwan.com/images/201604/1460071441529130010-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57154","shop_price":"39.00","promote_price":"39.00","goods_name":"玩具收纳桶-黑象","original_img":"http://i2.quwan.com/images/201604/1460674759470402559-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57149","shop_price":"39.00","promote_price":"39.00","goods_name":"三层收纳挂袋-奶牛","original_img":"http://i2.quwan.com/images/201604/1460674667187414029-400.jpg","app_original_img":"","promote_end_date":"0"}]}
     */

    private int error;
    private String message;
    /**
     * category : {"content":{"770101":"保暖","770102":"抱枕·靠垫·坐垫","770103":"宠物用品","770104":"床上用品","770105":"打火机·点烟器·电子烟","770107":"儿童·母婴","770108":"购物车·购物袋","770109":"计量用具","770110":"加湿器","770111":"家具","770112":"乐器","770113":"礼品·礼盒·红包","770114":"门铃·门挡","770115":"纳凉","770116":"驱蚊","770117":"伞·雨衣·雨靴","770118":"生活电器","770119":"收纳整理","770120":"睡衣·午睡毯·披肩","770121":"拖鞋·家居鞋","770122":"桌垫","770123":"五金·工具"},"id_arr":[770116,770119,770102,770117,770110,770104,770118,770115,770105,770101,770120,770113,770121,770114,770103,770109,770107,770108,770122,770111,770123,770112]}
     * cat_goods : [{"goods_id":"57202","shop_price":"159.00","promote_price":"159.00","goods_name":"翻翻灯(白色)","original_img":"http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14635407743701-400.jpeg","app_original_img":"images/quwanapp/goods/APP-IMG-14635407743701.jpeg","promote_end_date":"0"},{"goods_id":"57198","shop_price":"49.00","promote_price":"49.00","goods_name":"稻草人小夜灯-直插黄光","original_img":"http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14624404493269-400.jpeg","app_original_img":"images/quwanapp/goods/APP-IMG-14624404493269.jpeg","promote_end_date":"1464681599"},{"goods_id":"57191","shop_price":"49.00","promote_price":"49.00","goods_name":"三折黑胶防晒太阳伞--柠檬伞","original_img":"http://i2.quwan.com/images/201604/1461810166408556675-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57175","shop_price":"89.00","promote_price":"89.00","goods_name":"喷雾迷你风扇(粉色)","original_img":"http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14629625463317-400.jpeg","app_original_img":"images/quwanapp/goods/APP-IMG-14629625463317.jpeg","promote_end_date":"0"},{"goods_id":"57172","shop_price":"89.00","promote_price":"89.00","goods_name":"魔术豆风扇(黑色)","original_img":"http://i2.quwan.com/images/201605/1462321851638437071-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57167","shop_price":"69.00","promote_price":"69.00","goods_name":"格先者情侣风扇(白色)","original_img":"http://i2.quwan.com/images/201604/1461026575179736227-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57164","shop_price":"159.00","promote_price":"159.00","goods_name":"3D画框纸雕灯017-Deer nature","original_img":"http://i2.quwan.com/images/201604/1461803416624601996-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57160","shop_price":"78.00","promote_price":"78.00","goods_name":"揽月3D打印月球灯-7cm","original_img":"http://i2.quwan.com/images/201604/1460071441529130010-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57154","shop_price":"39.00","promote_price":"39.00","goods_name":"玩具收纳桶-黑象","original_img":"http://i2.quwan.com/images/201604/1460674759470402559-400.jpg","app_original_img":"","promote_end_date":"0"},{"goods_id":"57149","shop_price":"39.00","promote_price":"39.00","goods_name":"三层收纳挂袋-奶牛","original_img":"http://i2.quwan.com/images/201604/1460674667187414029-400.jpg","app_original_img":"","promote_end_date":"0"}]
     */

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
         * goods_id : 57202
         * shop_price : 159.00
         * promote_price : 159.00
         * goods_name : 翻翻灯(白色)
         * original_img : http://i2.quwan.com/images/quwanapp/goods/APP-IMG-14635407743701-400.jpeg
         * app_original_img : images/quwanapp/goods/APP-IMG-14635407743701.jpeg
         * promote_end_date : 0
         */

        private List<CatGoodsBean> cat_goods;

        public List<CatGoodsBean> getCat_goods() {
            return cat_goods;
        }

        public void setCat_goods(List<CatGoodsBean> cat_goods) {
            this.cat_goods = cat_goods;
        }

        public static class CatGoodsBean {
            private String goods_id;
            private String shop_price;
            private String promote_price;
            private String goods_name;
            private String original_img;
            private String app_original_img;
            private String promote_end_date;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public String getPromote_price() {
                return promote_price;
            }

            public void setPromote_price(String promote_price) {
                this.promote_price = promote_price;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public String getApp_original_img() {
                return app_original_img;
            }

            public void setApp_original_img(String app_original_img) {
                this.app_original_img = app_original_img;
            }

            public String getPromote_end_date() {
                return promote_end_date;
            }

            public void setPromote_end_date(String promote_end_date) {
                this.promote_end_date = promote_end_date;
            }
        }
    }
}

