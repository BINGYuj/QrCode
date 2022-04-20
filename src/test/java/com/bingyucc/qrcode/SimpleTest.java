package com.bingyucc.qrcode;

import com.bingyucc.qrcode.common.QrCodeTool;
import com.bingyucc.qrcode.entity.QrCodeDO;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class SimpleTest {

    @Test
    public void a(){
        QrCodeDO qrCodeDO = new QrCodeDO();
        qrCodeDO.setUrl("www.baidu.com");
        qrCodeDO.setMargin(1);
        String url = "D:\\temp\\1.png";
        try {
            QrCodeTool.createQrImgToFile(url, qrCodeDO);
            System.out.println(QrCodeTool.generateAsBase64(qrCodeDO));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void b(){
        QrCodeDO qrCodeDO = new QrCodeDO();
        qrCodeDO.setMargin(1);
        qrCodeDO.setUrl("http://localhost:8088/rgis/share_preview.html?sensingId=62207db4bcbbf53d2380bdc5&id=db968ee5-cbca-4b20-948a-46ac6e03f7a7");
        String filePath = "D:\\temp\\1.png";
        QrCodeTool.createQrImgWithTextToFile(filePath, qrCodeDO);
    }
}
