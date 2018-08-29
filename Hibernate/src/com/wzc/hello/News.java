package com.wzc.hello;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;//������������ȷ��
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * Hibernate ��Ҫ��־û���̳��κθ����ʵ�ֽӿڣ�����Ա�֤���벻����Ⱦ��
 * �����Hibernate����Ϊ������ʽ��Ƶ�ԭ��
 * @author WZC
 *
 */
@Entity
public class News {
    private int id;
    private String title;
    private String author;
    private Date date;

    public News() {
    }

    public News(String title, String author, Date date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }



    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(title, news.title) &&
                Objects.equals(author, news.author) &&
                Objects.equals(date, news.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, date);
    }
}
