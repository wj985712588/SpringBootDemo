package cc.mhonor.controller;

import cc.mhonor.dao.UserDao;
import cc.mhonor.service.impl.UserServiceImpl;
import cc.mhonor.utils.CodeGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有Controller的父类
 */
public class BaseController {

    public static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /*流水序列号生成组件注入===开始*/

    @Autowired
    protected CodeGenerator codeGenerator;

    /*流水序列号生成组件注入===结束*/

    /*service层对象注入===开始*/

    @Autowired
    protected UserServiceImpl userService;

    /*service层对象注入===结束*/

    /*redis操作对象注入===开始*/

    @Autowired
    protected HashOperations<String, String, Object> hashOperations;

    @Autowired
    protected ValueOperations<String, Object> valueOperations;

    @Autowired
    protected ListOperations<String, Object> listOperations;

    @Autowired
    protected SetOperations<String, Object> setOperations;

    @Autowired
    protected ZSetOperations<String, Object> zSetOperations;

    /*redis操作对象注入===结束*/

    /**
     * 获取请求的来源ip地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = (String) request.getParameter("loginIP"); // 兼容PC端请求IP记录
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (StringUtils.isBlank(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
