package com.blame.li.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Create by li
 * 2019/5/10 20:42
 */
@Data
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue//自增
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
