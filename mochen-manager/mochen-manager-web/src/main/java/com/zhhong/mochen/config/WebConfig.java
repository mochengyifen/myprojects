package com.zhhong.mochen.config;

import com.zhhong.mochen.YamlConfigurerUtil;
import com.zhhong.mochen.converter.StringToDateConverter;
import com.zhhong.mochen.filter.LoginFilter;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

/**
 * @author 董仁亮
 * @date 2020-01-13 15:19
 * @Description: 配置类
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {//注册日期类型转换器
        registry.addConverter(new StringToDateConverter());
    }


    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new LoginFilter());//注册登录过滤器
        registration.addUrlPatterns("/*");
        registration.setName("loginFilter");
        return registration;
    }

    @Bean
    public YamlConfigurerUtil ymlConfigurerUtil() {
        //1:加载配置文件
        Resource app = new ClassPathResource("application-common.yml");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
        yamlPropertiesFactoryBean.setResources(app);
        // 3：将yml转换成 key：val
        Properties properties = yamlPropertiesFactoryBean.getObject();
        // 4: 将Properties 通过构造方法交给我们写的工具类
        YamlConfigurerUtil ymlConfigurerUtil = new YamlConfigurerUtil(properties);
        return ymlConfigurerUtil;
    }
}
