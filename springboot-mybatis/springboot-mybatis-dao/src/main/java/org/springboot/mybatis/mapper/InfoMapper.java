package org.springboot.mybatis.mapper;

import org.springboot.mybatis.domain.Info;

import java.util.List;

/**
 * Created by LiuXun on 2017/3/18.
 */
public interface InfoMapper {
    List<Info> get();
}
