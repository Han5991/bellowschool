package com.bellowschool.vo;

import com.bellowschool.main.main.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Log4j2
public class UserVoTests {
    @Value("${property.test.name}") // depth가 존재하는 값은 .으로 구분해서 값을 매핑
    private String propertyTestName;

    @Value("${propertyTest}") // 단일 값을 매핑
    private String propertyTest;

    @Value("${noKey:default value}") // 키 값이 존재하지 않은 경우 default 값을 설정하여 매핑
    private String defaultValue;

    @Value("${property.propertyTestList}") // 배열형으로 매핑
    private String[] propertyTestArray;

    @Value("#{'${property.propertyTestList}' .split(',')}") // ,을 기준으로 리스트형으로 매핑
    private List<String> propertyTestList;

    @Test
    public void userTest() {
        assertThat(propertyTest, Matchers.is("test"));
        assertThat(defaultValue, Matchers.is("default value"));

        assertThat(propertyTestArray[0], Matchers.is("a"));
        assertThat(propertyTestList.get(1), Matchers.is("b"));

        assertThat(propertyTestName, Matchers.is("property depth test"));
    }
}
