package org.softsys.weldplay;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Audited
public class AuditInterceptor {
    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception {
        System.out.println(context.getMethod() + " " + context.getParameters());
        return context.proceed();
    }
}
