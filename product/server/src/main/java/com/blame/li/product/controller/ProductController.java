package com.blame.li.product.controller;

import com.blame.li.product.common.DecreaseStockInput;
import com.blame.li.product.dataobject.ProductCategory;
import com.blame.li.product.dataobject.ProductInfo;
import com.blame.li.product.dto.CartDTO;
import com.blame.li.product.service.CategoryService;
import com.blame.li.product.service.ProductService;
import com.blame.li.product.utils.ResultVOUtil;
import com.blame.li.product.vo.ProductInfoVo;
import com.blame.li.product.vo.ProductVO;
import com.blame.li.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by li
 * 2019/5/10 20:55
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */

    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1. 查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3. 查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);
            productVOList.add(productVO);

        }
        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表(给订单服务用)
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){

        return productService.findList(productIdList);

    }

    /**
     * 减库存
     * @param decreaseStockInputList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }

}
