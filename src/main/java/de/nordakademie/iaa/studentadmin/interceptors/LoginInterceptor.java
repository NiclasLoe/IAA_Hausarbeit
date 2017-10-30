package de.nordakademie.iaa.studentadmin.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext().getSession();

        String loginId = (String) session.get("loginId");

        // Bypass login for now.
        return invocation.invoke();

        /*if (loginId == null)
        {
            return Action.LOGIN;
        }
        else
        {
            return invocation.invoke();
        }*/
    }
}