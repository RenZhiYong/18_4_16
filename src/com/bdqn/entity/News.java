package com.bdqn.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: ldw
 * @Date: created in 11:43 2018/3/28
 * @Description:
 */

@Data
public class News {
    private Integer nid;
    private String ncontent;
    private Date pdate;

    //描述当前新闻的主题信息
    private Topic topic;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
