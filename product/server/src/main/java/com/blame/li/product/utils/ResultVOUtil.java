package com.blame.li.product.utils;

import com.blame.li.product.vo.ResultVO;

/**
 * Create by li
 * 2019/5/10 20:48
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
