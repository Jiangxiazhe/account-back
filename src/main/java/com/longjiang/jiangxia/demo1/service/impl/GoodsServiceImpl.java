package com.longjiang.jiangxia.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longjiang.jiangxia.demo1.daoentity.Goods;
import com.longjiang.jiangxia.demo1.entity.common.Response;
import com.longjiang.jiangxia.demo1.enumset.GoodUnit;
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

    public boolean addGood(Goods good){

        switch (GoodUnit.getEnum(good.getType())){
            case JIN:
                good.setUnitDesc(GoodUnit.JIN.getDesc());
                break;
            case KG:
                good.setUnitDesc(GoodUnit.KG.getDesc());
                break;
            case JIAN:
                good.setUnitDesc(GoodUnit.JIAN.getDesc());
                break;
            default:
                throw  new RuntimeException("无此商品单位");

        }
        return save(good);
    }
}




