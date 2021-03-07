package cn.teach.common.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IRequestHandler{
    boolean preHandle(HttpServletRequest request,HttpServletResponse response,RequestDataMeta meta);
    boolean postHandle(HttpServletRequest request,HttpServletResponse response,RequestDataMeta meta);
}