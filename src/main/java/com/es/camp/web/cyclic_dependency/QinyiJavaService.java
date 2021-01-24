package com.es.camp.web.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QinyiJavaService {

    @Autowired
    private ImoocJavaService imoocJavaService;

//    @Autowired
//    public QinyiJavaService(ImoocJavaService imoocJavaService) {
//        this.imoocJavaService = imoocJavaService;
//    }

    public void qinyiService() {
        System.out.println("QinyiJavaService");
    }
}
