package cn.ch.qa_school.service;

import cn.ch.qa_school.bean.Answers;
import cn.ch.qa_school.bean.QuestionStruct;
import cn.ch.qa_school.bean.Questions;
import cn.ch.qa_school.sys.service.BaseService;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import com.github.drinkjava2.jdialects.id.UUID32Generator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService extends BaseService {


    @Autowired
    ITesseract iTesseract;

    public Object find(JSONObject body) {

        return null;
    }

    public Object auto(List<QuestionStruct> questionStructs) {
        LOG.info("共提交{}题", questionStructs.size());
        int i = 0;
        for (QuestionStruct questionStruct : questionStructs
        ) {
            LOG.info("正在录入第{}题...", ++i);
            if (questionStruct.getAnswer().startsWith("data:image")) {
                File f = FileUtil.touch(StrUtil.format("temp/{}.png", System.currentTimeMillis()));
                Base64.decodeToFile(questionStruct.getAnswer().replaceAll("data:image/png;base64,", ""), f);
                try {
                    String result = iTesseract.doOCR(f);
                    FileUtil.del(f);
                    questionStruct.setAnswer(result.toUpperCase());
                } catch (TesseractException e) {
                    LOG.error("ocr error:{}", e.getMessage());
                }
            }
            Questions question = new Questions();
            question.setQtitle(questionStruct.getTitle());
            question.setPlatform(0);
            question.setMd5(SecureUtil.md5(questionStruct.getTitle()));
            question.setSource(0);
            question.setStatus(1);
            question.setId(UUID32Generator.getUUID32());
            question.insert();
            Map<String, String> options = questionStruct.getNewOptions();
            options.forEach((k, v) -> {
                Answers answers = new Answers();
                answers.setQid(question.getId());
                answers.setQanswer(v);
                answers.setMd5(SecureUtil.md5(v));
                answers.setFlag(questionStruct.getAnswer().indexOf(k) != -1 ? 1 : 0);
                answers.insert();
            });
        }
        LOG.info("题目录入完成...");
        return null;
    }


}
