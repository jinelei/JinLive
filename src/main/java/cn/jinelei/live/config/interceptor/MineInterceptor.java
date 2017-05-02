package cn.jinelei.live.config.interceptor;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by jinelei on 17-5-2.
 */
public class MineInterceptor extends LocaleChangeInterceptor{

    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException {

        String newLocale = request.getParameter(getParamName());

        if (StringUtils.isEmpty(newLocale)) {
            newLocale = (String)request.getSession().getAttribute("language");

            //-- 设置默认语言为中文
            if (StringUtils.isEmpty(newLocale)) {
                newLocale = "zh_CN";
            }
        }


        //-- 如果没有改变语言返回true，否则要重置session中的值
        if (newLocale.equals((String)request.getSession().getAttribute("language"))) return true;

        reSetSessionLocale(request, response, newLocale);

        return true;
    }

    private void reSetSessionLocale(HttpServletRequest request, HttpServletResponse response, String newLocale) {

        request.getSession().setAttribute("language", newLocale);

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }

        LocaleEditor localeEditor = new LocaleEditor();
        localeEditor.setAsText(newLocale);
        localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());

    }
}
