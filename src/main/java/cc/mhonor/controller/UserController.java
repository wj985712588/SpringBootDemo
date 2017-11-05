package cc.mhonor.controller;

import cc.mhonor.enums.ResultCodeEnum;
import cc.mhonor.result.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController extends BaseController {

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @ResponseBody
    public Object userList() {
        return JsonResult.success(ResultCodeEnum.SUCCESS, userService.userList());
    }

}
