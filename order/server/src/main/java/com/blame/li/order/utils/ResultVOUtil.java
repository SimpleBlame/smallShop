package com.blame.li.order.utils;

import com.blame.li.order.vo.ResultVO;

/**
 * Create by li
 * 2019/5/10 20:17
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
