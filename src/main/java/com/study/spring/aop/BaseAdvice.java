package com.study.spring.aop;

import com.alibaba.fastjson.JSON;
import com.study.util.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2020/1/9 15:04
 **/
public abstract class BaseAdvice {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Object process(ProceedingJoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        printParam(args,className,methodName);
        Object result = null;
        try {
            result = joinPoint.proceed();
            logger.info("{} --> {} result: {}", className, methodName, JSON.toJSONString(result));
        } catch (Throwable e) {
            logger.error("{} --> {} {}！", className, methodName, e.getClass().getSimpleName(), e);
        }
        return result;
    }

    /**
     * 打印参数
     */
    protected void printParam(Object[] args, String className, String methodName) {
        String paramStr = "{";
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                if (arg == null || StringUtils.isBlank(arg.toString())) {
                    paramStr += "empty,";
                } else {
                    paramStr += JSON.toJSONString(arg) + ",";
                }
            }
            //删除最后一个逗号
            if (StringUtils.isNotBlank(paramStr)) {
                paramStr = paramStr.substring(0, paramStr.length() - 1);
            }
        }
        paramStr += "}";
        logger.info("{} --> {} request param: {}", className, methodName, paramStr);
    }

}
