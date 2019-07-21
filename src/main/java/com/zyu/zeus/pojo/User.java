package com.zyu.zeus.pojo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/5/25 16:38
 */
@Data
@Entity
@Table(name = "t_user", schema = "zeus", catalog = "")
public class User {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "use_id", nullable = false)
    private Integer useId;

    /**
     * 用户名称
     */
    @Column(name = "use_name", nullable = true, length = 100)
    private String useName;

    /**
     * 用户手机号
     */
    @Column(name = "use_phone", nullable = true, length = 20)
    private String usePhone;

    /**
     * 用户头像
     */
    @Column(name = "use_head_portrait", nullable = true, length = -1)
    private String useHeadPortrait;

    /**
     * openid
     */
    @Column(name = "use_openid", nullable = true, length = 50)
    private String useOpenid;

    /**
     * 备注
     */
    @Column(name = "use_memo", nullable = true, length = 255)
    private String useMemo;

    /**
     * 创建时间（注册时间）
     */
    @Column(name = "use_create_time", nullable = true)
    private Date useCreateTime;

    /**
     * 最后登录时间
     */
    @Column(name = "use_last_time", nullable = true)
    private Date useLastTime;

}
