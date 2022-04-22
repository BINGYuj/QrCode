package com.bingyucc.qrcode.controller;

import com.bingyucc.qrcode.common.web.JsonResult;
import com.bingyucc.qrcode.entity.config.QrCodeConfig;
import com.bingyucc.qrcode.service.QrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author BingYu
 */
@Api(value = "二维码接口", tags = {"二维码接口"})
@Controller
@RequestMapping("/qrCode")
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @ApiOperation(value = "获取二维码", tags = {"二维码接口"})
    @PostMapping()
    @ResponseBody
    public JsonResult a(@RequestBody QrCodeConfig qrCodeConfig){
        return JsonResult.ok().setData(qrCodeService.getQrBase64(qrCodeConfig));
    }
}
