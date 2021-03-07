package cn.teach.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @ClassName JsonUtils
 * @Author MaZhuli
 * @Date 2019/3/22 20:54
 * @Description jackson工具类
 * @Version 1.0
 **/
public class JsonUtils {
    private static ObjectMapper objectMapper;

    static {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
    }

    public static <T> T readValue(String content, Class<T> valueType) {

        if (StringUtils.isEmpty(content) || StringUtils.isEmpty(valueType)) {
            return null;
        }
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            return null;
        }
    }

    public static String toJSon(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }
}
