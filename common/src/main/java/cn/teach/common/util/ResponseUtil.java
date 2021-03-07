package cn.teach.common.util;

import cn.teach.common.mvc.ResponseEntity;
import cn.teach.common.mvc.ResultErrorCode;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class ResponseUtil {
    public static void responseError(ResultErrorCode err, String errMsg, ServletResponse response) throws IOException {
        ResponseEntity result = new ResponseEntity(err, errMsg, null);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(JsonUtils.toJSon(result));
    }
}