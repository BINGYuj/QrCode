package com.bingyucc.qrcode.entity.config;

import lombok.Data;

/**
 * 二维码配置项
 * 外框样式配置
 * @author BingYu
 * @date 2022/4/22
 */
@Data
public class OutBorder {

    /**
     * 是否启用外框
     * 默认不启用 false
     */
    private boolean enable = false;

    /**
     * 外框与二维码本体的间距， 默认为 0
     */
    private int margin = 0;

    /**
     * 二维码背景颜色
     * 支持
     *      16进制       #66ccff
     *      rgb         (r,g,b)
     *      颜色名称      BLACK
     * 默认白色
     */
    private String bgColor = "WHITE";

    /**
     * 二维码文字配置
     */
    private Text text;
}
