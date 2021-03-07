package cn.teach.common.sms;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName SmsMessage
 * @Author MaZhuli
 * @Date 2019/4/2 14:06
 * @Description 短信发送实体类
 * @Version 1.0
 **/
@Component
public class SmsMessage {
    private String phoneNo;
    private String sign;
    private String templateCode;
    private Map params;
    public SmsMessage (){

    }
    public SmsMessage (String phoneNo,String sign,String templateCode,Map params){
        this.phoneNo = phoneNo;
        this.sign = sign;
        this.templateCode = templateCode;
        this.params = params;
    }
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
