package cn.teach.common.mvc;

/**
 * @ClassName ResponseHelper
 * @Author MaZhuli
 * @Date 2019/3/7 16:42
 * @Description 返回结果工具类
 * @Version 1.0
 **/
public class ResponseHelper {

    public static ResponseEntity returnResponse(boolean b) {
        if (b) {
            return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", null);
        } else {
            return new ResponseEntity<>(ResultErrorCode.FAIL, "操作失败", null);
        }
    }

    public static ResponseEntity returnResponse(boolean b, String msg) {
        return new ResponseEntity<>(b ? ResultErrorCode.SUCCESS : ResultErrorCode.FAIL, msg, null);
    }

    public static ResponseEntity returnResponse(boolean b, String msg, Object data) {
        return new ResponseEntity<>(b ? ResultErrorCode.SUCCESS : ResultErrorCode.FAIL, msg, data);
    }
}
