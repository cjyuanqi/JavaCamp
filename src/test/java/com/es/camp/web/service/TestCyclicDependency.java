package com.es.camp.web.service;

import com.es.camp.web.cyclic_dependency.ImoocJavaService;
import com.es.camp.web.cyclic_dependency.QinyiJavaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCyclicDependency {

    @Autowired
    private QinyiJavaService qinyiJavaService;

    @Autowired
    private ImoocJavaService imoocJavaService;

    @Test
    public void testCyclicDependency() {
        qinyiJavaService.qinyiService();
        imoocJavaService.imoocService();
    }
}
