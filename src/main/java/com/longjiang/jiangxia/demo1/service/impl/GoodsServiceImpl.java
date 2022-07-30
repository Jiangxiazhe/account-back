package com.longjiang.jiangxia.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longjiang.jiangxia.demo1.Goods;
import com.longjiang.jiangxia.demo1.service.GoodsService;
import com.longjiang.jiangxia.demo1.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author 78498
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2022-07-30 16:27:09
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




