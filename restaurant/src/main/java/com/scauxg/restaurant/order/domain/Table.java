package com.scauxg.restaurant.order.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Setter
@Getter
public class Table {
    private static final long serialVersionUID = 1L;

    /**
     * 桌子id
     */
    private Integer dinnerId;
    /**
     * 桌子类别
     */
    private Integer dinnerNumber;
    /**
     * 备注
     */
    private String dinnerType;
    /**
     * 备注
     */
    private Integer tableState;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dinnerId",getDinnerId())
                .append("dinnerNumber", getDinnerNumber())
                .append("dinnerType", getDinnerType())
                .append("tableState",getTableState())
                .toString();
    }
}
