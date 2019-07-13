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
 * 字典数据表 dict_data
 *
 * @author Yue
 * @create 2019/3/22
 * @since 1.0.0
 */
@Getter
@Setter
public class Data {
    private static final long serialVersionUID = 1L;

    /**
     * 字典标识
     */
    private Integer dictCode;
    /**
     * 字典标签
     */
    private String dictLabel;
    /**
     * 标签对应的数值
     */
    private Integer dictValue;
    /**
     * 字典类型
     */
    private Integer dictDataType;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dictCode", getDictCode())
                .append("dictLabel", getDictLabel())
                .append("dictValue", getDictValue())
                .append("dictDataType", getDictDataType())
                .toString();
    }
}
