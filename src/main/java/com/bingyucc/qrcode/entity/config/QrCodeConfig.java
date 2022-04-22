package com.bingyucc.qrcode.entity.config;

import cn.hutool.extra.qrcode.QrConfig;
import lombok.Data;

/**
 * 配置总类
 * @author BingYu
 */
@Data
public class QrCodeConfig {

    /**
     * 二维码对应的地址
     */
    private String url;

    /**
     * 二维码本体配置
     */
    private Code code;

    /**
     * 二维码外框配置
     */
    private OutBorder outBorder;

    /**
     * 最终图片类型，默认 png
     */
    private String imageType = "png";

    /**
     * 宽
     */
    private int width;

    /**
     * 长
     */
    private int height;

    /**
     * 底层config配置
     * 由后台程序生成
     */
    private QrConfig qrConfig;
}
