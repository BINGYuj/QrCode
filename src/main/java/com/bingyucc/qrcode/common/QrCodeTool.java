package com.bingyucc.qrcode.common;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.bingyucc.qrcode.entity.config.Code;
import com.bingyucc.qrcode.entity.config.OutBorder;
import com.bingyucc.qrcode.entity.config.QrCodeConfig;
import com.bingyucc.qrcode.entity.config.Text;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author BingYu
 */
public class QrCodeTool {


    public static void createQrImgToFile(String filePath, QrCodeConfig qrCodeConfig) throws FileNotFoundException {
        buildQrCodeConfig(qrCodeConfig);
        File f = new File(filePath);
        QrCodeUtil.generate(qrCodeConfig.getUrl(), qrCodeConfig.getQrConfig(), qrCodeConfig.getImageType(), new FileOutputStream(f));
    }

    public static String generateAsBase64(QrCodeConfig qrCodeConfig){
        buildQrCodeConfig(qrCodeConfig);
        return QrCodeUtil.generateAsBase64(qrCodeConfig.getUrl(), qrCodeConfig.getQrConfig(), qrCodeConfig.getImageType());
    }

    public static void createQrImgWithTextToFile(String filePath, QrCodeConfig qrCodeConfig){

        //设置QrConfig
        buildQrCodeConfig(qrCodeConfig);

        QrConfig qrConfig = qrCodeConfig.getQrConfig();

        //根据QrConfig生成二维码图片
        BufferedImage qrImage = QrCodeUtil.generate(qrCodeConfig.getUrl(), qrConfig);

        //绘制全图
        BufferedImage outImage = new BufferedImage(qrCodeConfig.getWidth(), qrCodeConfig.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D outG = outImage.createGraphics();

        outG.setBackground(ImgUtil.getColor(qrCodeConfig.getOutBorder().getBgColor()));
        outG.clearRect(0, 0, qrCodeConfig.getWidth(), qrCodeConfig.getHeight());

        OutBorder outBorder = qrCodeConfig.getOutBorder();
        int outMargin = 0;
        Text text = null;
        if(outBorder != null && outBorder.isEnable()){
            outMargin = outBorder.getMargin();
            text = outBorder.getText();
        }

        //将二维码图片绘制到全图
        outG.drawImage(qrImage, outMargin, outMargin, qrConfig.getWidth(), qrConfig.getHeight(), null);

        if(text != null && text.isEnable() && CollectionUtil.isNotEmpty(text.getText())){
            outG.setColor(ImgUtil.getColor(text.getColor()));
            int fontHeight = outMargin * 2 + qrConfig.getHeight();
            for (String texts : text.getText()){
                outG.drawString(texts, outMargin, fontHeight);
                fontHeight = fontHeight + text.getFontSize();
            }
        }
        outG.dispose();
        outImage.flush();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ImageIO.write(outImage, qrCodeConfig.getImageType(), fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析参数
     * @param qrCodeConfig
     */
    public static void buildQrCodeConfig(QrCodeConfig qrCodeConfig){
        QrConfig qrConfig = new QrConfig();
        //1.通过code内部对象构造QrConfig配置信息
        Code code = qrCodeConfig.getCode();
        if(code != null) {
            if (StringUtils.isNotBlank(code.getColor())) {
                qrConfig.setForeColor(ImgUtil.getColor(code.getColor()));
            }
            if (StringUtils.isNotBlank(code.getBgColor())) {
                qrConfig.setBackColor(ImgUtil.getColor(code.getBgColor()));
            }
            if (code.getMargin() > 0) {
                qrConfig.setMargin(code.getMargin());
            }
            if (StringUtils.isNotBlank(code.getErrorLevel())) {
                qrConfig.setErrorCorrection(ErrorCorrectionLevel.valueOf(code.getErrorLevel()));
            }
            if (code.getWidth() > 0) {
                qrConfig.setWidth(code.getWidth());
            }
            if (code.getHeight() > 0) {
                qrConfig.setHeight(code.getHeight());
            }
        }
        //2.组装QrCodeConfig
        int width = qrConfig.getWidth() + qrConfig.getMargin() * 2;
        int height = qrConfig.getHeight() + qrConfig.getMargin() * 2;
        if(qrCodeConfig.getOutBorder() != null){
            OutBorder outBorder = qrCodeConfig.getOutBorder();
            if(outBorder.getMargin() > 0){
                width = width + outBorder.getMargin() * 2;
                height = height + outBorder.getMargin() * 2;
            }
            if(outBorder.getText() != null){
                Text text = outBorder.getText();
                if(CollectionUtil.isNotEmpty(text.getText())){
                    if(text.getFontSize() <= 0){
                        text.setFontSize(Text.create().getFontSize());
                    }
                }
                height = height + text.getFontSize() * text.getText().size();
            }
        }
        qrCodeConfig.setWidth(width);
        qrCodeConfig.setHeight(height);
        if(StringUtils.isNotBlank(qrCodeConfig.getImageType())){
            qrCodeConfig.setImageType(ImgUtil.IMAGE_TYPE_PNG);
        }
        qrCodeConfig.setQrConfig(qrConfig);
    }
}
