package com.es.camp.web.default_singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE) // 原型模式， 会创建多个实例
//@Scope(BeanDefinition.SCOPE_SINGLETON)  // 默认为单例模式 容器中只存在一个实例
public class DefaultCourseManagerService {

    private List<String> courses = null;

    @PostConstruct
    public void init() {
        log.info("=========Coming in DefaultCourseManagerService init");
        this.courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    public int courseCount() {
        return this.courses.size();
    }

    public List<String> getCourses() {
        return this.courses;
    }
}
