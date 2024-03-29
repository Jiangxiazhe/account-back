package com.longjiang.jiangxia.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longjiang.jiangxia.demo1.daoentity.Person;
import com.longjiang.jiangxia.demo1.service.PersonService;
import com.longjiang.jiangxia.demo1.mapper.PersonMapper;
import org.springframework.stereotype.Service;

/**
* @author 78498
* @description 针对表【person】的数据库操作Service实现
* @createDate 2022-07-30 16:27:09
*/
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person>
    implements PersonService{

}




