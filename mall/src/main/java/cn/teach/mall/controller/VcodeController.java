package cn.teach.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/code")
public class VcodeController {

    private Color getRanColor(Random ran) {
        return new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
    }
    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random ran = new Random();
        int width = 300, height = 70;
        BufferedImage img = new BufferedImage(300, 34, BufferedImage.TYPE_3BYTE_BGR);
        // 获取画笔对象
        Graphics graphics = img.getGraphics();
        // 设置画笔颜色，并且填充矩形区域
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        // 从字符数组中随机得到字符
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        // 设置字体，大小为18，设置字的颜色随机
        graphics.setFont(new Font(Font.DIALOG, Font.ITALIC, 22));
        // 将每个字符画到图片，位置：5+(i*40)+加一个随机数
        // 创建一个sb对象用于存储验证码字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = ran.nextInt(arr.length);
            sb.append(arr[index]);
            int ranx = ran.nextInt(3);
            int rany = ran.nextInt(3);
            int flag = ran.nextInt(2);
            graphics.setColor(getRanColor(ran));
            if (flag == 1) {
                if(i == 0) {
                    graphics.drawString(arr[index] + "", 80 + (i * 40) + ranx, 20 + rany);
                }else{
                    graphics.drawString(arr[index] + "", 80 + (i * 40) + ranx, 20 + rany);
                }
            } else {
                if(i == 0) {
                    graphics.drawString(arr[index] + "", 80 + (i * 40) + ranx, 20 - rany);
                }else{
                    graphics.drawString(arr[index] + "", 80 + (i * 40) + ranx, 20 - rany);
                }
            }
        }
        //将验证码字符串放在session域中
        HttpSession session = request.getSession();
        session.setAttribute("validate", sb.toString());
        // 画若干条干扰线，线的数量，颜色是随机的，线的位置是随机的，x范围在width之中，y的范围在height之中。
        int num = ran.nextInt(5) + 6;
        for (int i = 0; i < num; i++) {
            int xa = ran.nextInt(width);
            Integer.valueOf(xa);
            int xb = ran.nextInt(width);
            int ya = ran.nextInt(height);
            int yb = ran.nextInt(height);
            graphics.setColor(getRanColor(ran));
            graphics.drawLine(xa, ya, xb, yb);
        }
        // 将缓存的图片输出到响应输出流中
        ImageIO.write(img, "jpg", response.getOutputStream());
    }
}
