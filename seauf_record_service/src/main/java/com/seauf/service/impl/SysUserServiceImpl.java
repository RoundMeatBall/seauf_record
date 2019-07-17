package com.seauf.service.impl;

import com.seauf.controller.model.PageModel;
import com.seauf.controller.model.SysUserModel;
import com.seauf.dao.SysUserDao;
import com.seauf.entity.SysUserENT;
import com.seauf.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserDao sysUserDao;

    @Transactional(readOnly = true)
    @Override
    public PageModel<SysUserENT> listSysUser(SysUserModel sysUserModel) {
        PageModel<SysUserENT> pageModel = new PageModel<>();

        Integer page = sysUserModel.getPage();
        Integer limit = sysUserModel.getLimit();

        Sort.Direction sort = Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page - 1, limit, sort, "id");
        Specification specification = (Specification) (root, criteriaQuery, cb) -> {
            //增加筛选条件
            Predicate predicate = cb.conjunction();
            return predicate;
        };
        Page<SysUserENT> all = sysUserDao.findAll(specification, pageable);
        pageModel.setRecords(all.getContent());
        pageModel.setTotal(all.getTotalElements());
        return pageModel;
    }

    @Transactional
    @Override
    public void saveSysUser(SysUserENT sysUser) {
        sysUserDao.save(sysUser);
    }

    @Transactional
    @Override
    public void updateSysUser(SysUserENT sysUser) {
        sysUserDao.save(sysUser);
    }

    @Override
    public Integer existByPassword(String userName, String md5DigestPassword) {
        return sysUserDao.existByPassword(userName, md5DigestPassword);
    }
}
