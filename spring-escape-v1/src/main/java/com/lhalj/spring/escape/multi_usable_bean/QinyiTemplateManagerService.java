package com.lhalj.spring.escape.multi_usable_bean;

import org.springframework.stereotype.Service;

/**
 * 描述:
 */
@Service
public class QinyiTemplateManagerService implements ITemplateManagerService{
    @Override
    public void print() {
        System.out.println("QinyiTemplateManagerService");
    }
}
