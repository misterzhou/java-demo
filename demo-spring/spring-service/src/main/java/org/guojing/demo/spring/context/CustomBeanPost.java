package org.guojing.demo.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created at: 2018-11-18 11:38
 *
 * @author guojing
 */
public class CustomBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("============= " + beanName + ": CustomBeanPost.postProcessBeforeInitialization exec =============");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("============= " + beanName + ": CustomBeanPost.postProcessAfterInitialization exec =============");
        return bean;
    }
}
