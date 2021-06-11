package com.anshark.service.impl;

import com.anshark.dao.GyUserPermDao;
import com.anshark.model.GyUserPerm;
import com.anshark.service.GyUserPermService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
@Service
public class GyUserPermServiceImpl implements GyUserPermService {

    @Autowired
    private GyUserPermDao gyUserPermDao;

    @Override
    public List<Integer> getPerms(Integer userId) {

        GyUserPerm gyUserPerm = gyUserPermDao.findByUserId(userId);

        if (null == gyUserPerm || StringUtils.isEmpty(gyUserPerm.getUserPerm())) {
            return new ArrayList<>();
        }

        String userPerm = gyUserPerm.getUserPerm();

        String[] split = userPerm.split(",");

        List<String> listString = Arrays.asList(split);

        return listString.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    @Override
    public void del(Integer userId) {
        GyUserPerm gyUserPerm = gyUserPermDao.findByUserId(userId);
        if (null != gyUserPerm) {
            gyUserPerm.setIsDeleted(true);
            gyUserPermDao.update(gyUserPerm);
        }
    }


}
