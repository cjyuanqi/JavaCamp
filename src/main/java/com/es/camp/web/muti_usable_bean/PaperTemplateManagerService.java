package com.es.camp.web.muti_usable_bean;

import org.springframework.stereotype.Service;

@Service
public class PaperTemplateManagerService implements ITemplateManagerService {

    @Override
    public void print() {
        System.out.println("PaperTemplateManagerService");
    }
}
