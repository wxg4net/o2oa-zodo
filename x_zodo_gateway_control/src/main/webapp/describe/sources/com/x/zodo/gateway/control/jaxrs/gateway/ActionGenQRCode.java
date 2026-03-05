package com.x.zodo.gateway.control.jaxrs.gateway;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.base.core.project.config.Config;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.organization.core.entity.Bind;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import org.apache.commons.codec.binary.Base64;

/**
 * 根据id查询详细信息
 * @author sword
 */
public class ActionGenQRCode extends BaseAction {

    private Logger logger = LoggerFactory.getLogger( ActionGetPass.class );

    protected ActionResult<Wo> execute( HttpServletRequest request, EffectivePerson effectivePerson, Integer width, Integer height, String data ) throws Exception {
        logger.info("execute action 'ActionGenQRCode'......");
        ActionResult<Wo> result = new ActionResult<>();
        Wo wo = new Wo();

        if (data == null || data.isEmpty()) {
            // 二维码内容
            data = request.getParameter("data");
        }

        String format = "png";// 二维码的图片格式

        Map<EncodeHintType, String> hints = new HashMap<>();
        // 内容所使用字符集编码
        hints.put(EncodeHintType.MARGIN, "1");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q.toString());

        BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hints);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        Graphics2D graphics = image.createGraphics();

        Image logo = ImageIO.read(new ByteArrayInputStream(Config.bindLogo()));
        int offset = (width - logo.getWidth(null)) / 2;
        graphics.drawImage(logo, offset, offset, null);
        graphics.dispose();
        logo.flush();
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(image, format, out);
            wo.setImage(Base64.encodeBase64String(out.toByteArray()));
        }
        result.setData(wo);
        return result;
    }

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;


    public class Wo extends Bind {

        private static final long serialVersionUID = -3574645735233129236L;

        @FieldDescribe("Base64编码图像.")
        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }


}