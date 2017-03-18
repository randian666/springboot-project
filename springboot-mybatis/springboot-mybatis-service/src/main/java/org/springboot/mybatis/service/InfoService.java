package org.springboot.mybatis.service;

import org.springboot.mybatis.domain.Info;

import java.util.List;

/**
 * Created by LiuXun on 2017/3/18.
 */
public interface InfoService {
    List<Info> getAll();
}
