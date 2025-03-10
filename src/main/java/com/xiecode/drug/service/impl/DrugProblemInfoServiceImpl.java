package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.DrugProblemInfoMapper;
import com.xiecode.drug.pojo.DrugProblemInfo;
import com.xiecode.drug.service.DrugProblemInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 问题药品表 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Service
public class DrugProblemInfoServiceImpl extends ServiceImpl<DrugProblemInfoMapper, DrugProblemInfo> implements DrugProblemInfoService {

    @Resource
    private DrugProblemInfoMapper drugProblemInfoMapper;




    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询问题药品信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugProblemInfo>
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @Override
    public IPage<DrugProblemInfo> selectDrugProblemInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugProblemInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<DrugProblemInfo> page = new Page<>(pageNum,pageSize);
        return drugProblemInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param drugProblemInfo
     * @Description: 新增一条问题药品信息
     * @param: [drugProblemInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @Override
    public int addDrugProblemInfo(DrugProblemInfo drugProblemInfo) {
        return drugProblemInfoMapper.insert(drugProblemInfo);
    }

    /**
     * @param drugProblemInfo
     * @Description: 编辑修改一条问题药品信息
     * @param: [drugProblemInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @Override
    public int editDrugProblemInfo(DrugProblemInfo drugProblemInfo) {
        return drugProblemInfoMapper.updateById(drugProblemInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询问题药品的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.DrugProblemInfo
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @Override
    public DrugProblemInfo queryDrugProblemInfoById(int id) {
        return drugProblemInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除问题药品的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @Override
    public int deleteDrugProblemInfoByID(int id) {
        return drugProblemInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的问题药品信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugProblemInfo>
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @Override
    public List<DrugProblemInfo> queryDrugProblemInfoList() {
        return drugProblemInfoMapper.selectList(null);
    }

}
