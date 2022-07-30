package com.longjiang.jiangxia.demo1.service.impl;

import com.longjiang.jiangxia.demo1.daoentity.Person;
import com.longjiang.jiangxia.demo1.mapper.PersonMapper;
import com.longjiang.jiangxia.demo1.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2022-07-30
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
