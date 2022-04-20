package com.bingyucc.qrcode.common;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.bingyucc.qrcode.entity.QrCodeDO;
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


    public static void createQrImgToFile(String filePath, QrCodeDO qrCodeDO) throws FileNotFoundException {
        File f = new File(filePath);
        QrCodeUtil.generate(qrCodeDO.getUrl(), initQrConfig(qrCodeDO), getImgType(qrCodeDO), new FileOutputStream(f));
    }

    public static String generateAsBase64(QrCodeDO qrCodeDO){
        return QrCodeUtil.generateAsBase64(qrCodeDO.getUrl(), initQrConfig(qrCodeDO), getImgType(qrCodeDO));
    }

    public static void createQrImgWithTextToFile(String filePath, QrCodeDO qrCodeDO){
        int defaultOutWidth = 500;
        int defaultOutHeight = 500;



        BufferedImage qrImage = QrCodeUtil.generate(qrCodeDO.getUrl(), initQrConfig(qrCodeDO));

        int defaultMargin = 5;
        int defaultFontHeight = 30;
        int qrCodeWidth = qrImage.getWidth();
        int qrCodeHeight = qrImage.getHeight();
        int qrTopMargin = defaultMargin, qrLeftMargin = defaultMargin, qrRightMargin = defaultMargin;
        int outImageWidth = qrCodeWidth + qrLeftMargin + qrRightMargin;
        int outImageHeight = 0;
        String l1 = "兰渝线-下-K532+763-K533+024-2022年02月28日";
        String l2 = "轩盘岭隧道出口至将军岭隧道进口";



        BufferedImage outImage = new BufferedImage(defaultOutWidth, defaultOutHeight, BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D outG = outImage.createGraphics();

        int l1Width = outG.getFontMetrics().stringWidth(l1);
        int l2Width = outG.getFontMetrics().stringWidth(l2);

        outImageHeight = qrTopMargin + qrCodeHeight + defaultFontHeight * 2;

        outG.setBackground(Color.BLACK);
        outG.clearRect(0, 0, outImageWidth, outImageHeight);
        outG.drawImage(qrImage, qrLeftMargin, qrTopMargin, qrCodeWidth, qrCodeHeight, null);

        outG.setColor(Color.WHITE);

        int fontHeight = qrTopMargin + qrCodeHeight;
        outG.drawString(l1, qrLeftMargin, fontHeight);
        fontHeight = fontHeight + defaultFontHeight;
        outG.drawString(l2, qrLeftMargin, fontHeight);
        outG.dispose();
        outImage.flush();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ImageIO.write(outImage, "png", fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化 QrConfig
     * @param qrCodeDO
     * @return
     */
    public static QrConfig initQrConfig(QrCodeDO qrCodeDO){
        QrConfig qrConfig = new QrConfig();
        if(qrCodeDO.getWidth() != null && qrCodeDO.getWidth() > 0){
            qrConfig.setWidth(qrCodeDO.getWidth());
        }
        if(qrCodeDO.getHeight() != null && qrCodeDO.getHeight() > 0){
            qrConfig.setHeight(qrCodeDO.getHeight());
        }
        if(qrCodeDO.getMargin() != null && qrCodeDO.getMargin() > 0){
            qrConfig.setMargin(qrCodeDO.getMargin());
        }
        //qrConfig.setBackColor(Color.RED);
        return qrConfig;
    }

    public static String getImgType(QrCodeDO qrCodeDO){
        if(StringUtils.isNotBlank(qrCodeDO.getImageType())){
            return qrCodeDO.getImageType();
        }
        return ImgUtil.IMAGE_TYPE_PNG;
    }

    //public static int
}
