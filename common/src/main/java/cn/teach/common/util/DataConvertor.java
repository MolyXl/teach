package cn.teach.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * 数据转化
 */
public class DataConvertor {

	private final static char[] cHex={ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	
	/**
	 * ToString
	 * 
	 * @param obj
	 * @return null 返回空
	 */
	public static String ToString(Object obj) {
		return ToString(obj, "");
	}

	/**
	 * ToString
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String ToString(Object obj, String defaultValue) {
		try {
			return obj == null ? defaultValue : obj.toString();
		}catch(Exception e){
			return defaultValue;
		}
	}

	/**
	 * ToInteger
	 * 
	 * @param obj
	 * @return Integer
	 */
	public static Integer ToInteger(Object obj) {
		return ToInteger(obj, 0);
	}

	/**
	 * To Integer
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return Integer
	 */
	public static Integer ToInteger(Object obj, Integer defaultValue) {
		try {
			return obj == null ? defaultValue : Integer.parseInt(ToString(obj,
					"0"));
		} catch (Exception e) {
		}
		return defaultValue;
	}

	/**
	 * ToLong 默认 0l
	 * 
	 * @param obj
	 * @return
	 */
	public static Long ToLong(Object obj) {
		return ToLong(obj, 0l);
	}

	/**
	 * ToLong
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Long ToLong(Object obj, Long defaultValue) {
		try {
			return obj == null ? defaultValue : Long.parseLong(ToString(obj,
					"0"));
		} catch (Exception e) {
		}
		return defaultValue;
	}
	/**
	 * ToFloat 默认 0f
	 * 
	 * @param obj
	 * @return
	 */
	public static Float ToFloat(Object obj) {
		return ToFloat(obj, 0f);
	}

	/**
	 * ToFloat
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Float ToFloat(Object obj, Float defaultValue) {
		try {
			return obj == null ? defaultValue : Float.parseFloat(ToString(obj,
					"0"));
		} catch (Exception e) {
		}
		return defaultValue;

	}

	/**
	 * ToDouble 默认 0d
	 * 
	 * @param obj
	 * @return
	 */
	public static Double ToDouble(Object obj) {
		return ToDouble(obj, 0d);
	}

	/**
	 * ToDouble
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Double ToDouble(Object obj, Double defaultValue) {
		try {
			return obj == null ? defaultValue : Double.parseDouble(ToString(
					obj, "0"));
		} catch (Exception e) {
		}
		return defaultValue;
	}

	/**
	 * ToBoolean 默认false
	 * 
	 * @param obj
	 * @return boolean
	 */
	public static boolean ToBoolean(Object obj) {
		return ToBoolean(obj, false);
	}

	/**
	 * ToBoolean
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return boolean
	 */
	public static boolean ToBoolean(Object obj, boolean defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		List<String> trueList = new ArrayList<String>();
		trueList.add("true");
		trueList.add("1");
		trueList.add("yes");
		return trueList.contains(ToString(obj).toLowerCase());
	}
	
	/**
	 * 将字节数组转换为十六进制字符串	 
	 * @param by
	 * @return
	 */
	public static String byteToStr(byte[] by){
		
		String strDesign="";
		for(int i=0;i<by.length;i++){
			strDesign+=byteToHexStr(by[i]);
		}
		return strDesign;
	}
	/**
	 * 将字节转换为十六进制字符串 
	 * @param mByte
	 * @return
	 */
	public static String byteToHexStr(byte mByte){
		char[] mChr=new char[2];
		mChr[0]=cHex[(mByte >>> 4) & 0X0f];
		mChr[1]=cHex[ mByte & 0X0f];
		String s=new String(mChr);
		return s;
	} 
	
	/**
	 *  将字节数组转换为十六进制字符串	
	 * @param hash
	 * @return
	 */
	public static String byteToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
	
	/**
	 * 对象转json字符串
	 * @param obj
	 * @return
	 */
	public static String objectToJsonStr(Object obj){
		return JsonUtils.toJSon(obj);
	}

	/**
	 * json字符串转对象
	 * @param c
	 * @param jsonStr
	 * @return T
	 */
	public  static <T extends Object> T jsonStrToObject(String jsonStr,Class<T>c) {
		T object=null;
		try {
			try {
				object=c.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				return object;
			}
			if(StringHelper.IsNullOrEmpty(jsonStr)) {
				return object;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				object = objectMapper.readValue(jsonStr, c);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 
	 * 将map排序后转成字符串	 
	 * @param map
	 * @return
	 */
	public static String mapToString(Map<String,Object> map){
		StringBuilder param=new StringBuilder();
		map=new TreeMap<String, Object>();
		Set<String> keyMap=map.keySet();
		for(String key:keyMap){
			if(key.equals("key")){
				continue;
			}
			Object obj=map.get(key);
			if(obj!=null){
				String value=obj.toString().trim();
				if(value!=""){
					param.append(key).append("=").append(obj.toString().trim()).append("&");
				}
			}
		}
		String par=param.toString();
		String strPar=par.substring(0,par.length()-1);
		return strPar;
	}
}
