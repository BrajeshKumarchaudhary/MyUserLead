package com.app.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

public class ReportTemplateEngine {

    private static TemplateEngine instance;

    private ReportTemplateEngine() {}

    public static TemplateEngine getInstance() {
        if(instance == null){
            synchronized (ReportTemplateEngine.class) {
                if(instance == null) {
                    instance = new TemplateEngine();
                    StringTemplateResolver templateResolver = new StringTemplateResolver();
                    templateResolver.setTemplateMode(TemplateMode.HTML);
                    instance.setTemplateResolver(templateResolver);
                }
            }
        }
        return instance;
    }
}
