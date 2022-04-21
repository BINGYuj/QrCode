package com.bingyucc.qrcode.entity.config;

/**
 * 二维码配置项
 * 整体颜色配置
 * @author BingYu
 */
public class Color {

    /**
     * 二维码颜色
     * 支持
     *      16进制       #66ccff
     *      rgb         (r,g,b)
     *      颜色名称      BLACK
     *  默认黑色
     */
    private String codeColor = "BLACK";

    /**
     * 二维码背景颜色
     * 支持
     *      16进制       #66ccff
     *      rgb         (r,g,b)
     *      颜色名称      BLACK
     * 默认白色
     */
    private String bgColor = "WHITE";
}
