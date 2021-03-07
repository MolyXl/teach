package cn.teach.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.pow;


/**
 * 字符串帮助类
 *
 */
public class StringHelper {
	public static String getMapValue(Map map,String key){
		if(map.containsKey(key) && map.get(key)!=null){
			return map.get(key).toString();
		}

		return null;
	}
	/**
	 * 判断是否是null或者“”
	 * @param string
	 * @return  boolean
	 */
	public static boolean  IsNullOrEmpty(String string){
		boolean flag=false;
		if(string==null||string.trim().isEmpty()){
			flag=true;
		}
		return flag;
	}

	/**
	 * 左侧补足
	 * @param src 目标字符串
	 * @param len 总长度
	 * @param ch  填充的字符
	 * @return
	 */
	public static String PadLeft(String src,int len,char ch){
		int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }
        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
	}
	/**
	 * 右侧补足
	 * @param src 目标字符串
	 * @param len 总长度
	 * @param ch  填充的字符
	 * @return
	 */
	public static String PadRight(String src,int len,char ch){
		int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }
        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
	}
	
	/**
	 * string  用 , 分割成 int list
	 * @param src 字符串
	 * @return
	 */
	public static List<Integer> ToIntegerList(String src) {
		return ToIntegerList(src,",");
	}
	
	/**
	 * string  分割 int list
	 * @param src 字符串
	 * @param splitWord 分隔符
	 * @return List
	 */
	public static List<Integer> ToIntegerList(String src,String splitWord) {
		
		List<Integer> list=new ArrayList<Integer>();
		
		if(IsNullOrEmpty(src)){
			return list;
		}
		String[] arr=src.split(splitWord);
		if(arr!=null&&arr.length>0){
			for (String item: arr) {
					list.add(DataConvertor.ToInteger(item));
			}
		}
		return list;
	}
	
	/**
	 * array 拼接 成 string 
	 * @param join 拼接字符
	 * @param array  数组
	 * @return string
	 */
	public  static  String  Join(String join, Object[] array){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<array.length;i++){
             if(i==(array.length-1)){
                 sb.append(array[i]);
             }else{
                 sb.append(array[i]).append(join);
             }
        }
        return new String(sb);
    }
	
	/**
	 * 按照字节来截取字符串
	 * @param str  源字符
	 * @param length 截取的字节数 
	 * @return
	 */
	public static String cutString(String str,int length) {
		return cutString(str,length,"...");
	}
	
	/**
	 * 按照字节来截取字符串
	 * @param str  源字符
	 * @param length 截取的字节数 
	 * @param dot 
	 * @return
	 */
	public static String cutString(String str,int length,String dot) {
		String result="";
		try {
			
			if(StringHelper.IsNullOrEmpty(str)) {
				return result;
			}
			byte[] bytes =str.getBytes("Unicode"); 
			
			if(length>bytes.length) {
				return str;
			}
			
	        int n = 0; // 表示当前的字节数  
	        int i = 2; // 要截取的字节数，从第3个字节开始  
	        for (; i < bytes.length && n < length; i++){  
	            // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节  
	            if (i % 2 == 1){  
	                n++; // 在UCS2第二个字节时n加1  
	            }  
	            else{  
	                // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节  
	                if (bytes[i] != 0){  
	                    n++;  
	                }  
	            }  
	        }  
	        // 如果i为奇数时，处理成偶数  
	        if (i % 2 == 1){  
	            // 该UCS2字符是汉字时，去掉这个截一半的汉字  
	            if (bytes[i - 1] != 0){  
	                i = i - 1;    
	            }  
	            // 该UCS2字符是字母或数字，则保留该字符  
	            else{  
	                i = i + 1;  
	            }  
	        }  
	  
	        result=new String(bytes, 0, i, "Unicode")+dot;
	        
		} catch (Exception e) {
			result=str;
		}
		
		return result;
	}

	public static String getFirstBySplit(String str){
		if(str==null||"".equals(str)||str.length()==0){
			return "";
		}

		String[] arr=str.split("\\|");
		return arr[0];
	}

	public static String[] getBySplit(String str){
        if(str==null||"".equals(str)||str.length()==0){
			return null;
		}

		String[] arr=str.split("\\|");
		return arr;
	}

	public static String getMD5(String text){
		//定义一个字节数组
        byte[] secretBytes = null;
        try {
              // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(text.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
	}

	public static boolean stringInArray(String find,String[] arr){
		for(String item:arr){
			if(item.equals(find)){
				return true;
			}
		}

		return false;
	}

    /**
     * 获取n位的随机数
     * @param n
     * @return
     */
	public static String generateRandom(int n){
	    double d = pow(10d,DataConvertor.ToDouble(n-1));
        long l = new Double(d).longValue();
        return DataConvertor.ToString((long)((Math.random()*9+1)*l));
    }
}
