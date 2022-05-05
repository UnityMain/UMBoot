package com.unitymain.core.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 动漫
 */
@Component
@Data
public class Anime {
    /**
     * 资源标题
     */
    private String Title;
    /**
     * 资源类别ID
     */
    private Integer TypeId;
    /**
     * 资源类别名称
     */
    private String TypeName;
    /**
     * 字幕组ID
     */
    private Integer SubgroupId;
    /**
     * 字幕组名称
     */
    private String SubgroupName;
    /**
     * 	磁力链接
     */
    private String Magnet;
    /**
     * 资源发布页面
     */
    private String PageUrl;
    /**
     * 资源大小（为了兼容花园数据，请显示为 123.45MB、1.234GB 这种格式）
     */
    private String FileSize;
    /**
     * 发布时间（格式为 yyyy-MM-dd HH:mm:ss）
     */
    private String PublishDate;
}
