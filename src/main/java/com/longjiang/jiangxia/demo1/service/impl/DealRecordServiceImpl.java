package com.longjiang.jiangxia.demo1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.DealRecord;
import com.longjiang.jiangxia.demo1.entity.DealRecordTO;
import com.longjiang.jiangxia.demo1.entity.StatisticCondition;
import com.longjiang.jiangxia.demo1.entity.StatisticInfo;
import com.longjiang.jiangxia.demo1.entity.common.PageWithAttach;
import com.longjiang.jiangxia.demo1.mapper.DealRecordMapper;
import com.longjiang.jiangxia.demo1.service.IDealRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hang
 * @since 2022-07-30
 */
@Service
public class DealRecordServiceImpl extends ServiceImpl<DealRecordMapper, DealRecord> implements IDealRecordService {

    public StatisticInfo getStatistic(PageWithAttach<StatisticCondition> pageWithAttach){
        Page<DealRecordTO> dealPage = new Page<>(pageWithAttach.getCurrent(),pageWithAttach.getSize());
        if(pageWithAttach.getAttachment()==null){
            baseMapper.getDealRecordTOPage(dealPage,  new QueryWrapper<DealRecordTO>());
        }else{
            QueryWrapper<DealRecordTO> wrapper = new QueryWrapper<>();
            StatisticCondition condition= pageWithAttach.getAttachment();
            if(condition.getDateRange()!=null){
                wrapper.between("date",condition.getDateRange().get(0),condition.getDateRange().get(1));
            }
            if (condition.getPersonId()!=null){
                wrapper.eq("person_id",condition.getPersonId());
            }
            if (condition.getGoodId()!=null){
                wrapper.eq("good_id",condition.getGoodId());
            }
            baseMapper.getDealRecordTOPage(dealPage,  wrapper);
        }

        List<DealRecordTO> dealRecordTOList=dealPage.getRecords();
        BigDecimal totalAmount=BigDecimal.valueOf(0.0);
        for (var item:dealRecordTOList
             ) {
            totalAmount=totalAmount.add(item.getQuantity().multiply(item.getPrice()));
        }

        StatisticInfo statisticInfo=new StatisticInfo();
        statisticInfo.setPageData(dealPage);
        statisticInfo.setTotalAmount(totalAmount);

        return statisticInfo;
    }
}
