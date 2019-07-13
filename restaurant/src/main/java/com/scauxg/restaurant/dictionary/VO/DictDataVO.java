/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/23 22:37
 * History:
 */
package com.scauxg.restaurant.dictionary.VO;

import com.scauxg.restaurant.dictionary.domain.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 字典数据展示包装类
 *
 * @author Yue
 * @create 2019/3/23
 * @since 1.0.0
 */
public class DictDataVO extends Data {
    private String dataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dictCode", getDictCode())
                .append("dictLabel", getDictLabel())
                .append("dictValue", getDictValue())
                .append("dictDataType", getDictDataType())
                .append("dataType", getDataType())
                .toString();
    }

}
