package com.es.camp.web.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImoocJavaService {

    @Autowired
    private QinyiJavaService qinyiJavaService;

//    @Autowired
//    public ImoocJavaService(QinyiJavaService qinyiJavaService) {
//        this.qinyiJavaService = qinyiJavaService;
//    }

    public void imoocService() {
        System.out.println("ImoocJavaService");
    }
}
