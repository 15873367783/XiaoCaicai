package com.action;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.Dep;
import com.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dep.do")
public class DepAction {

    @Autowired
    private DepService depService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(params = "p=fenye")
    public String fenye (){
        IPage ipage = new Page<Dep>(1,2);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage page = depService.fenye(ipage , queryWrapper);
        request.setAttribute("page",page);
        return "show.jsp";
    }
}
