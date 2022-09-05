package systems.tat.passgen.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class TrackTimeConfig {

    @Around("@annotation(systems.tat.passgen.annotation.TrackTime)")
    public Object logMethodExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object method = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("The method {} has took {} milliseconds", joinPoint, timeTaken);

        return method;
    }
}
