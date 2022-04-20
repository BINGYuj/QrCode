package com.bingyucc.qrcode.service;

import com.bingyucc.qrcode.entity.QrCodeDO;

/**
 * @author BingYu
 */
public interface QrCodeService {

    /**
     * 获取base64的二维码
     * @param qrCodeDO
     * @return
     */
    String getQrBase64(QrCodeDO qrCodeDO);
}
