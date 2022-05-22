package cn.ch.qa_school.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionStruct {
    private String title;
    private String answer;
    private List<String> options;

    public String getTitle() {
        return trim(title);
    }

    public void setTitle(String title) {
        this.title = trim(title);
    }

    public String getAnswer() {
        return trim(answer);
    }

    public void setAnswer(String answer) {
        this.answer = trim(answer);
    }

    public List<String> getOptions() {
        if (options == null) {
            return new ArrayList<>();
        }
        List<String> newOptions = new ArrayList<>();
        for (String option : options
        ) {
            newOptions.add(trim(option));
        }
        return newOptions;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Map<String, String> getNewOptions() {
        Map<String, String> os = new HashMap<>();
        List<String> list = getOptions();
        for (String option : list
        ) {
            String key = option.substring(0, 2);
            String value = option.substring(2);
            os.put(key.substring(0, 1).toUpperCase(), trim(value));
        }
        return os;
    }


    private String trim(String str) {
        str = str.trim();
        while (str.indexOf("  ") != -1) {
            str = str.replaceAll("  ", " ");
        }
        return str;
    }
}
