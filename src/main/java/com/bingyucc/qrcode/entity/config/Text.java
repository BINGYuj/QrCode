package com.bingyucc.qrcode.entity.config;

import lombok.Data;
import java.util.List;

/**
 * 二维码配置项
 * 文字配置
 * @author BingYu
 */
@Data
public class Text {

    /**
     * 是否添加文字，默认不启用 false
     */
    private boolean enable = false;

    /**
     * 文字
     * 支持多行
     */
    private List<String> text;

    /**
     * 文字对齐方式
     * 0：居中；1：左；2：右
     * 默认居中
     */
    private int textAlign = 0;

    /**
     * 文字与边框距离 默认 2
     */
    private int margin = 2;

    /**
     * 文字字体大小
     * 默认38
     */
    private int fontSize = 38;

    /**
     * 字体，暂不使用
     */
    private String fontFamily = "";

    /**
     * 文字颜色
     * 支持
     *      16进制       #66ccff
     *      rgb         (r,g,b)
     *      颜色名称      BLACK
     * 默认为黑色
     */
    private String color = "BLACK";

    public static Text create(){
        return new Text();
    }
}
