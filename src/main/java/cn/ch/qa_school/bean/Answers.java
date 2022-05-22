package cn.ch.qa_school.bean;

import com.github.drinkjava2.jdialects.annotation.jpa.Column;
import com.github.drinkjava2.jdialects.annotation.jpa.Id;
import com.github.drinkjava2.jsqlbox.ActiveRecord;

import java.sql.Timestamp;

public class Answers extends ActiveRecord<Answers> {
    public static final String ID = "id";

    public static final String QID = "qid";

    public static final String QANSWER = "qanswer";

    public static final String FLAG = "flag";

    public static final String MD5 = "md5";

    public static final String CREATETIME = "createtime";

    @Id
    private Integer id;

    /**
     * 问题id
     */
    private Integer qid;
    /**
     * 答案
     */
    private String qanswer;
    /**
     * 是否正确答案 0 否 1 是
     */
    private Integer flag;
    /**
     * 答案的md5
     */
    @Column(name = "md5", length = 200)
    private String md5;
    private Timestamp createtime;

    public Integer getId() {
        return id;
    }

    public Answers setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQid() {
        return qid;
    }

    public Answers setQid(Integer qid) {
        this.qid = qid;
        return this;
    }

    public String getQanswer() {
        return qanswer;
    }

    public Answers setQanswer(String qanswer) {
        this.qanswer = qanswer;
        return this;
    }

    public Integer getFlag() {
        return flag;
    }

    public Answers setFlag(Integer flag) {
        this.flag = flag;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public Answers setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public Answers setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
        return this;
    }

}
