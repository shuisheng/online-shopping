package org.ssliao.onlineshopping.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUploadUtility {
    private static final String ABS_PATH = "/Users/liaoshuisheng/projects/webapp/online-shopping/onlineshopping/src/main/webapp/assets/images/";
    private static String REAL_PATH = "";

    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

        logger.info(REAL_PATH);

        if (!new File(ABS_PATH).exists()) {
            new File(ABS_PATH).mkdirs();
        }

        if (!new File(REAL_PATH).exists()) {
            new File(REAL_PATH).mkdirs();
        }

        try {
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        }
        catch (IOException ex) {

        }
    }
}
