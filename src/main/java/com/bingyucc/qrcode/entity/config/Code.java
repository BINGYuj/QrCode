package com.bingyucc.qrcode.entity.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 二维码配置项
 * 二维码本体配置
 * @author BingYu
 */
@Data
public class Code {

    /**
     * 二维码颜色
     * 支持
     *      16进制       #66ccff
     *      rgb         (r,g,b)
     *      颜色名称      BLACK
     *  默认黑色
     */
    private String color = "BLACK";

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
     * 边距，默认2
     */
    private int margin = 2;

    /**
     * 纠错级别，默认M
     * L级别,7%或更少的错误能修正
     * M级别,15%或更少的错误能修正
     * Q级别,25%或更少的错误能修正
     * H级别,30%或更少的错误能修正
     */
    private String errorLevel = "M";

    /**
     * 宽，默认300
     */
    private int width = 300;

    /**
     * 长，默认300
     */
    private int height = 300;
}
