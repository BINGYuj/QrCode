package com.bingyucc.qrcode;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bingyucc.qrcode.common.QrCodeTool;
import com.bingyucc.qrcode.entity.config.QrCodeConfig;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

public class SimpleTest {

    @Test
    public void a(){
//        QrCodeConfig qrCodeConfig = new QrCodeConfig();
//        qrCodeConfig.setUrl("www.baidu.com");
//        qrCodeConfig.setMargin(1);
//        String url = "D:\\temp\\1.png";
//        try {
//            QrCodeTool.createQrImgToFile(url, qrCodeConfig);
//            System.out.println(QrCodeTool.generateAsBase64(qrCodeConfig));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void b(){
//        QrCodeConfig qrCodeConfig = new QrCodeConfig();
//        qrCodeConfig.setMargin(1);
//        qrCodeConfig.setUrl("http://localhost:8088/rgis/share_preview.html?sensingId=62207db4bcbbf53d2380bdc5&id=db968ee5-cbca-4b20-948a-46ac6e03f7a7");
//        String filePath = "D:\\temp\\1.png";
//        QrCodeTool.createQrImgWithTextToFile(filePath, qrCodeConfig);

        String filePath = "D:\\temp\\1.png";
        String paramJsonFilePath = "D:\\code\\qrcode\\src\\main\\resources\\static\\param.json";
        JSONObject jsonObject = JSONUtil.readJSONObject(new File(paramJsonFilePath), Charset.defaultCharset());
        QrCodeConfig qrCodeConfig = JSONUtil.toBean(jsonObject, QrCodeConfig.class);
        QrCodeTool.createQrImgWithTextToFile(filePath, qrCodeConfig);
    }


}
