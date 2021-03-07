package cn.teach.common.mvc;

/**
 * @ClassName ResultEntity
 * @Author MaZhuli
 * @Date 2019/3/4 14:05
 * @Description 返回结果类
 * @Version 1.0
 **/
public class ResponseEntity<T> {
    private String errorCode;   //错误码
    private String errorMsg;    //错误信息
    private T data;        //数据信息

    public ResponseEntity() {
        super();
    }
    public ResponseEntity(ResultErrorCode errorCode, String errorMsg) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMsg = errorMsg;
    }
    public ResponseEntity(ResultErrorCode errorCode, String errorMsg, T data) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMsg = errorMsg;
        this.data = data;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
