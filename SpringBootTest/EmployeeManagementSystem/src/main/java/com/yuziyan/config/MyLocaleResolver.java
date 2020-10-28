package com.yuziyan.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义区域解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        //System.out.println("language = " + lang);
        if (!StringUtils.isEmpty(lang)) {
            //此时请求携带了国际化参数，解析：zh_CN
            String[] messages = lang.split("_");
            //根据请求的参数创建Locale对象  语言，国家
            return new Locale(messages[0],messages[1]);
        }
        //走到这一行，说明请求没有携带国际化参数信息，使用默认值
        return Locale.getDefault();
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
