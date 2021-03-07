package cn.teach.common.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestData {
   

    private RequestData(){
        data=new HashMap<String,List<RequestDataMeta>>();
    }

    private static RequestData instance;
    public static RequestData getInstance(){
        if(instance==null){
            instance=new RequestData();
        }
        return instance;
    }

    
    private Map<String,List<RequestDataMeta>> data;

    public void addData(String url,List<RequestDataMeta> metas){
        data.put(url,metas);
    }

    public List<RequestDataMeta> getMetas(String url){
        return data.get(url);
    }
}