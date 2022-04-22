package com.bingyucc.qrcode.service.impl;

import com.bingyucc.qrcode.common.QrCodeTool;
import com.bingyucc.qrcode.entity.config.QrCodeConfig;
import com.bingyucc.qrcode.service.QrCodeService;
import org.springframework.stereotype.Service;

/**
 * @author BingYu
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {

    @Override
    public String getQrBase64(QrCodeConfig qrCodeConfig) {
        return QrCodeTool.generateAsBase64(qrCodeConfig);
    }
}
