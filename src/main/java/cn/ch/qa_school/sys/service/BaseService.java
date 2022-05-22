package cn.ch.qa_school.sys.service;

import com.github.drinkjava2.jsqlbox.DbContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseService {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    public HttpServletRequest request;

    @Autowired
    public DbContext db;


}
