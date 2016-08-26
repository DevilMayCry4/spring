package com.cake.project;


import javax.servlet.http.HttpServletRequest;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import com.cake.project.LoginRequired;


/**
 * @author tao.zhang
 * @create-time 2012-2-31
 */
public class LoginRequiredInterceptor1 implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
            
        Object[] ars = mi.getArguments();
          
        for(Object o :ars){
            if(o instanceof HttpServletRequest){
               System.out.println("------------this is a HttpServletRequest Parameter------------ ");
            }
        }
        // 判断该方法是否加了@LoginRequired 注解
        if(mi.getMethod().isAnnotationPresent(LoginRequired.class)){
             System.out.println("----------this method is added @LoginRequired-------------------------");
        }
       //执行被拦截的方法，切记，如果此方法不调用，则被拦截的方法不会被执行。
        return mi.proceed();
    }
}