package com.st.srcreview.config;

import com.st.srcreview.bean.A;
import com.st.srcreview.bean.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomInitializer implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof A) {
            return new A(1);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof B) {
            return new B("1");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

//    @Override
//    public void initialize(BootstrapRegistry registry) {
//        System.out.println("[CustomInitializer] method: initialize");
//    }
}
