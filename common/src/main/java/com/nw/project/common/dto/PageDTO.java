package com.nw.project.common.dto;

import lombok.Data;

@Data
public class PageDTO {
    private PageDTO() {}

    private Integer start;
    private Integer size;
    private Long total;
}
