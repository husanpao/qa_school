package cn.ch.qa_school;

import cn.hutool.core.codec.Base64;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.Test;

import java.io.File;

public class OcrTest {

    @Test
    public void test() {
        try {
            ITesseract instance = new Tesseract();
            //如果未将tessdata放在根目录下需要指定绝对路径
            instance.setDatapath("D:\\Projects\\IdeaProjects\\QA_SCHOOL\\src\\main\\resources\\tessdata");
            // 我们需要指定识别语种
            instance.setLanguage("eng");
            // 指定识别图片
            File imgDir = new File("C:\\Users\\Administrator\\Desktop\\test.png");
            long startTime = System.currentTimeMillis();
            String ocrResult = instance.doOCR(imgDir);
            // 输出识别结果
            System.out.println("OCR Result: \n" + ocrResult + "\n 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
//            Base64.decodeToFile("","");

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

}
