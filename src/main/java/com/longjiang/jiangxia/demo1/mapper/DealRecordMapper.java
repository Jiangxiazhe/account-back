package com.longjiang.jiangxia.demo1.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.DealRecord;
import com.longjiang.jiangxia.demo1.entity.DealRecordTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hang
 * @since 2022-07-30
 */
public interface DealRecordMapper extends BaseMapper<DealRecord> {

    @Select("select deal.id,date,good_id,deal.type,price,quantity,person_id,person.name as person_name,goods.name as good_name,goods.unit_desc as good_unit_desc from deal_record deal " +
            "left join person on person.id=person_id " +
            "left join goods on goods.id=good_id " +
            "${ew.customSqlSegment}")
    Page<DealRecordTO> getDealRecordTOPage(Page<DealRecordTO> page, @Param(Constants.WRAPPER) Wrapper queryWrapper);
}
