package org.guojing.demo.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created at: 2018-11-18 11:39
 *
 * @author guojing
 */
public class CustomBeanFactoryPost implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("============= CustomBeanFactoryPost.postProcessBeanFactory exec =============");
    }
}
