/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/22 15:45
 * History:
 */
package com.scauxg.restaurant.dictionary.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 字典类型表 dict_type
 *
 * @author Yue
 * @create 2019/3/22
 * @since 1.0.0
 */
@Getter
@Setter
public class Type {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer dictId;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典类型（供表的字段使用）
     */
    private String dictType;
    /**
     * 描述说明
     */
    private String dictRemark;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dictId", getDictId())
                .append("dictName", getDictName())
                .append("dictType", getDictType())
                .append("dictRemark", getDictRemark())
                .toString();
    }
}
