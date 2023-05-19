package com.pug.zixun.config;

import com.pug.zixun.domain.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties("alipay")
public class AlipayProperties implements java.io.Serializable{
    private String key;
    private String openkey;

    private User user;

    private Map<String,String> map;
    private List<String> list;
}
