package org.smartframework.cloud.common.web.autoconfigure;

import org.smartframework.cloud.starter.configure.constants.OrderConstant;
import org.smartframework.cloud.starter.configure.properties.SmartProperties;
import org.smartframework.cloud.common.web.filter.ServletFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
@ConditionalOnClass(name = {"javax.servlet.Filter"})
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class ServletFilterAutoConfiguration {

    @Bean
    public ServletFilter servletFilter(final SmartProperties smartProperties) {
        boolean enableRpcProtostuff = smartProperties.getRpc().isProtostuff();
        return new ServletFilter(enableRpcProtostuff);
    }

    @Bean
    public FilterRegistrationBean<Filter> registServletFilter(final ServletFilter servletFilter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(servletFilter);
        registration.addUrlPatterns("/*");
        registration.setName(ServletFilter.class.getSimpleName());
        registration.setOrder(OrderConstant.HTTP_FITLER);
        return registration;
    }

}