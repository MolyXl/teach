package cn.teach.common.mvc;
/**
 * @ClassName Jwt
 * @Author MaZhuli
 * @Date 2018/8/25 15:55
 * @Description 返回结果错误码
 * @Version 1.0
 **/
public enum ResultErrorCode {
    SUCCESS("0000"),
    FAIL("0001"),
    NOAUTHORITY("0002"),
    EXCEPTION("0003"),
    NEEDLOGIN("0004");

    private String errorCode;

    ResultErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
