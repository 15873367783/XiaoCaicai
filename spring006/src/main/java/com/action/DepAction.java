package com.action;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pojo.Dep;
import com.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dep.do")
public class DepAction {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DepService depService;

    @RequestMapping(params = "p=findall")
    public String findall(){
        IPage<Dep> iPage = depService.findall();
        request.setAttribute("iPage",iPage);
        return "show.jsp";
    }


}
