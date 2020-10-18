package com.mapper;

import com.pojo.Dep;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface DepMapper {
    public List<Dep> findall();
}
