package com.maystrovyy.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class ProfilingAspect {

    private final String SECONDS = "seconds";
    private final String MILLISECONDS = "milli" + SECONDS;

    @SneakyThrows
    @Around(value = "@annotation(com.maystrovyy.annotation.Profiling)")
    private Object around(ProceedingJoinPoint point) {
        String className = point.getTarget().getClass().toString();
        String methodName = MethodSignature.class.cast(point.getSignature()).getMethod().getName();
        log.info("Profiling in " + className + " method: " + methodName + " started...");
        long before = System.nanoTime();
        Object result = point.proceed();
        long after = System.nanoTime();
        long time = TimeUnit.SECONDS.convert(after - before, TimeUnit.NANOSECONDS);
        String timeWithFormat = time + " " + SECONDS;
        if (time <= 10) {
            time = TimeUnit.MILLISECONDS.convert(after - before, TimeUnit.NANOSECONDS);
            timeWithFormat = time + " " + MILLISECONDS;
        }
        log.info("Execution time in " + className + " method: " + methodName + " = " + timeWithFormat + ".");
        return result;
    }

}