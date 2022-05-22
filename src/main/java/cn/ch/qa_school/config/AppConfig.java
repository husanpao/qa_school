package cn.ch.qa_school.config;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ITesseract ocr() {
        ITesseract instance = new Tesseract();
        //如果未将tessdata放在根目录下需要指定绝对路径
        instance.setDatapath("D:\\Projects\\IdeaProjects\\QA_SCHOOL\\src\\main\\resources\\tessdata");
        // 我们需要指定识别语种
        instance.setLanguage("chi_sim");
        instance.setVariable("tessedit_char_whitelist", "ABCDabcd");
        return instance;
    }
}
