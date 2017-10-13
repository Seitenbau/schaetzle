package sb.hackathon.controller;

import lombok.extern.slf4j.Slf4j;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * schaetzle
 * <p>
 * Created by patrick on 13.10.17.
 * © skix.net 2017
 */
@Slf4j
@RestController
public class SessionController {

    @Value("${addon.base-url}")
    private String basePath;

    @GetMapping(value = "/session/{uuid}/qr", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getSessionQrCode(@PathVariable("uuid") String uuid) throws IOException {
        return QRCode.from(basePath + "/session/" + uuid).to(ImageType.PNG).withSize(500, 500).stream()
                .toByteArray();


    }
}
