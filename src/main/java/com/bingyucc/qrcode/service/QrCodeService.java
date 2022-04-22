package com.bingyucc.qrcode.service;

import com.bingyucc.qrcode.entity.config.QrCodeConfig;

/**
 * @author BingYu
 */
public interface QrCodeService {

    /**
     * 获取base64的二维码
     * @param qrCodeConfig
     * @return
     */
    String getQrBase64(QrCodeConfig qrCodeConfig);
}
