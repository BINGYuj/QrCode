package com.bingyucc.qrcode.entity;

import lombok.Data;

/**
 * @author BingYu
 */
@Data
public class QrCodeDO {

    /**
     * 二维码对应的地址
     */
    private String url;

    /**
     * 下方的文字
     */
    private String belowText;

    /**
     * 宽
     */
    private Integer width;

    /**
     * 长
     */
    private Integer height;

    /**
     * 边距
     */
    private Integer margin;

    /**
     * 最终图片类型
     */
    private String imageType;
}
