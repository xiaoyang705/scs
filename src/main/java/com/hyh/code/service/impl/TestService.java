package com.hyh.code.service.impl;

import com.hyh.code.mapper.TestMapper;
import com.hyh.code.pojo.Test;
import com.hyh.code.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService implements ITestService {

    @Resource
    private TestMapper mapper;

    @Override
    public List<Test> findAllTest() {
        return mapper.selectAll();
    }
}
