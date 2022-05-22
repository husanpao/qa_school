package cn.ch.qa_school.bean;

import com.github.drinkjava2.jdialects.annotation.jpa.Column;
import com.github.drinkjava2.jdialects.annotation.jpa.Id;
import com.github.drinkjava2.jsqlbox.ActiveRecord;

import java.sql.Timestamp;

public class Questions extends ActiveRecord<Questions> {
    public static final String ID = "id";

    public static final String QTITLE = "qtitle";

    public static final String PLATFORM = "platform";

    public static final String MD5 = "md5";

    public static final String CREATETIME = "createtime";

    public static final String SOURCE = "source";

    public static final String STATUS = "status";

    @Id
    private Integer id;

    /**
     * 问题
     */
    private String qtitle;
    /**
     * 平台
     */
    private Integer platform;
    /**
     * 问题md5
     */
    @Column(name = "md5", length = 200)
    private String md5;
    private Timestamp createtime;
    /**
     * 题目来源0 系统 1其他
     */
    private Integer source;
    /**
     * 审核状态:0待审核 1 通过 2不通过
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public Questions setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getQtitle() {
        return qtitle;
    }

    public Questions setQtitle(String qtitle) {
        this.qtitle = qtitle;
        return this;
    }

    public Integer getPlatform() {
        return platform;
    }

    public Questions setPlatform(Integer platform) {
        this.platform = platform;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public Questions setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public Questions setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
        return this;
    }

    public Integer getSource() {
        return source;
    }

    public Questions setSource(Integer source) {
        this.source = source;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Questions setStatus(Integer status) {
        this.status = status;
        return this;
    }

}
