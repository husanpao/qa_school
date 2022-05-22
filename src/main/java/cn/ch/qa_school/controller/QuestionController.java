package cn.ch.qa_school.controller;

import cn.ch.qa_school.service.QuestionService;
import cn.ch.qa_school.sys.controller.BaseController;
import cn.ch.qa_school.sys.exeception.QuestionException;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController extends BaseController {


    @Autowired
    public QuestionService service;

    @PostMapping("/find")
    public Result find(@RequestBody String body) {
        if (JSONUtil.isTypeJSONArray(body)) {
            return success();
        } else {
            throw new QuestionException("The body needs a jsonarray eg:[{q:'today is ?'}]");
        }
    }

    @PostMapping("/submit")
    public Result submit(@RequestBody String body) {
        if (JSONUtil.isTypeJSON(body)) {
            return success();
        } else {
            throw new QuestionException("The body needs a json eg:[{q:'today is ?',a:'Monday'}]");
        }
    }

}
