package com.longjiang.jiangxia.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.Person;
import com.longjiang.jiangxia.demo1.entity.common.IDListTO;
import com.longjiang.jiangxia.demo1.entity.common.PageWithAttach;
import com.longjiang.jiangxia.demo1.entity.common.Response;
import com.longjiang.jiangxia.demo1.service.impl.PersonServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private PersonServiceImpl personService;


    @Autowired
    public void Inject(
            PersonServiceImpl personService
    ){
        this.personService=personService;
    }

    @PostMapping(value = "/add")
    public Response<String> addPerson(@RequestBody Person person){
        if(personService.save(person)){
            return Response.success("添加人物成功");
        }else{
            return Response.fail("添加人物失败");
        }

    }

    @PostMapping(value = "/delete")
    public Response<String> deletePerson(@RequestBody IDListTO idListTO){
        if(personService.removeBatchByIds(idListTO.getId())){
            return Response.success("删除人物成功");
        }else{
            return Response.fail("删除人物失败");
        }
    }

    @PostMapping(value = "/modify")
    public Response<String> modifyPerson(@RequestBody Person person){
        UpdateWrapper<Person> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",person.getId());
        if(personService.update(person,updateWrapper)){
            return Response.success("更新人物成功");
        }else{
            return Response.fail("更新人物失败");
        }
    }


    @PostMapping(value = "/list/page")
    @ApiOperation(value = "分页获取,attachment参数须为整数，0为供应商,1为客户")
    public Response<Page<Person>> GetPersonList(@RequestBody PageWithAttach<Integer> pageWithAttach){
        Page<Person> page = new Page<>(pageWithAttach.getCurrent(),pageWithAttach.getSize());
        if(pageWithAttach.getAttachment()==null){
            personService.page(page);
            return Response.rspData(page);
        }
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        wrapper.eq("type",pageWithAttach.getAttachment());
        personService.page(page,wrapper);
        return Response.rspData(page);
    }


    @PostMapping(value = "/list/all")
    @ApiOperation(value = "attachment为任务类型:0->供应商,1->用户")
    public Response<List<Person>> GetAllPersonList(@RequestBody PageWithAttach<Integer> pageWithAttach){
        QueryWrapper<Person> wrapper = new QueryWrapper<>();

        wrapper.eq("type",pageWithAttach.getAttachment());
        List<Person> personList= personService.list(wrapper);
        return Response.rspData(personList);
    }



}
