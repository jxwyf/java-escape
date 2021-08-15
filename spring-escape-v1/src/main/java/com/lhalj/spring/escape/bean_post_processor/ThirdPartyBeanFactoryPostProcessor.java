package com.lhalj.spring.escape.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 描述:
 */
@Component
public class ThirdPartyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        //通过bean容器拿到bean的定义
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("thirdPartyClass");
        //设定当前bean的作用域 修改为原型模式
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
