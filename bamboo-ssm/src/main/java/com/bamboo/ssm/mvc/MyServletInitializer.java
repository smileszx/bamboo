package com.bamboo.ssm.mvc;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 16:34
 **/
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.addMapping("/custom/**");

        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        myFilter.addMappingForUrlPatterns(null, false, "/custom/*");
    }
}
