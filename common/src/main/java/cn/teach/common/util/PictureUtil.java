package cn.teach.common.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PictureUtil {

    public static String overlapImage(String bigPath, String smallPath, Integer userId, HttpServletRequest request) {
        try {
            String root = System.getProperty("user.dir");
            bigPath = root + bigPath.substring(bigPath.lastIndexOf("/upload/"));
            smallPath = root + smallPath.substring(smallPath.lastIndexOf("/qrcode/"));
            BufferedImage big = ImageIO.read(new File(bigPath));
            BufferedImage small = ImageIO.read(new File(smallPath));
            Graphics2D g = big.createGraphics();
            /*int x = (big.getWidth() - small.getWidth()) / 2;
            int y = 300;*/
            int x = 320;
            int y = 450;
            g.drawImage(small, x, y, 80, 80, null);
            g.dispose();
            String path = "/poster/";
            File localhost = new File(root + path);
            localhost.mkdirs();
            File file = new File(root + path + userId + ".png");
            ImageIO.write(big, "png", file);
            String basePath = request.getScheme() + "://" + request.getServerName();
            return basePath + path + userId + ".png";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedImage  small= ImageIO.read(new File("F:/20190930115337.png"));
            BufferedImage  big= ImageIO.read(new File("F:/20190930115345.png"));
            Graphics2D g = big.createGraphics();
            int x = 320;
            int y = 450;
            //g.drawImage(small, x, y, small.getWidth(), small.getHeight(), null);
            g.drawImage(small, x, y, 80, 80, null);
            g.dispose();
            File file = new File("F:/n.png");
            ImageIO.write(big, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
