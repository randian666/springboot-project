package org.springboot.mybatis.service.impl;

import org.springboot.mybatis.domain.Info;
import org.springboot.mybatis.mapper.InfoMapper;
import org.springboot.mybatis.service.InfoService;

import java.util.List;

/**
 * Created by LiuXun on 2017/3/18.
 */

public class InfoServiceImpl implements InfoService {

    private InfoMapper infoMapper;
    public List<Info> getAll() {
        return infoMapper.get();
    }
}
