package com.maike.beauty.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maike.beauty.utils.Result;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fj
 * @since 2019-08-12
 */
@RestController
@RequestMapping("/test")
public class TestController extends  BaseController {
    @PostMapping("/test")
    public Result book(){
//        List<Book> books = iBookService.list(new QueryWrapper<Book>().eq("parent_catalog", 110));
//        for (Book book : books){
//            ProductInfo productInfo = new ProductInfo();
//            productInfo.setProductId(GetId .addLeftZero(GetId.getLocalTrmSeqNum(),15)+RandomUtils.generateString(5));
//            productInfo.setProductName(book.getCommoName());
//            productInfo.setPrice(book.getPrice());
//            productInfo.setDescript(book.getPress());
//            productInfo.setSupplierId("2");
//            productInfo.setOneCategoryId("2");
//            productInfo.setTwoCategoryId("10");
//            productInfo.setThreeCategoryId("20");
//            productInfo.setAuditStatus(1);
//            productInfo.setPublishStatus(1);
//            productInfo.setProductCore(RandomUtils.generateString(4));
//            productInfo.setBrandId("1");
//            productInfo.setBarCode(RandomUtils.generateString(3));
//            iProductInfoService.save(productInfo);
//            ProductPicInfo productPicInfo = new ProductPicInfo();
//            productPicInfo.setProductPicId(GetId .addLeftZero(GetId.getLocalTrmSeqNum(),15)+RandomUtils.generateString(5));
//            productPicInfo.setProductId(productInfo.getProductId());
//            String picUrl="http://192.168.101.5:8080/book-img/"+book.getPictureUrl();
//            productPicInfo.setPicDesc(book.getAuthor());
//            productPicInfo.setPicUrl(picUrl);
//            productPicInfo.setPicStatus(1);
//            productPicInfo.setIsMaster(1);
//            iProductPicInfoService.save(productPicInfo);
//
//
//        }


//        List<ProductAttrValue> colorList = iProductAttrValueService.list(new QueryWrapper<ProductAttrValue>()
//                .eq("product_attr_id", 1));
//        String colorStr="{\"颜色\":[";
//        String colorStr1="";
//        for (ProductAttrValue color:colorList){
//            if (color==colorList.get(colorList.size()-1)){
//                colorStr1=colorStr1+"\""+color.getAttrValue()+"\"]";
//            }else{
//                colorStr1=colorStr1+"\""+color.getAttrValue()+"\",";
//            }
//
//        }
//        colorStr=colorStr+colorStr1+",";
//        System.out.println(colorStr);
//
//        List<ProductAttrValue> sizeList = iProductAttrValueService.list(new QueryWrapper<ProductAttrValue>()
//                .eq("product_attr_id", 2));
//        String sizeStr="\"尺寸\":[";
//        String sizeStr1="";
//        for (ProductAttrValue size:sizeList){
//            if (size==sizeList.get(sizeList.size()-1)){
//                sizeStr1=sizeStr1+"\""+size.getAttrValue()+"\"]";
//            }else{
//                sizeStr1=sizeStr1+"\""+size.getAttrValue()+"\",";
//            }
//
//        }
//        sizeStr=sizeStr+sizeStr1+"}";
//        String str=colorStr+sizeStr;
//        System.out.println(sizeStr);
//        System.out.println(str);
//        List<ProductInfo> productInfoList = iProductInfoService.list();
//        for (ProductInfo productInfo :productInfoList){
//            productInfo.setAttributeList(str);
//            iProductInfoService.saveOrUpdate(productInfo);
//        }
//        //{"颜色":"白色","尺码":"M"}
//        //{"颜色":"白色","橙色","棕色","粉红色","黑色","蓝色","绿色","尺寸":"S","M","L","XL","XXL","XXS","XS"}


//        List<Book> bookList = iBookService.list(new QueryWrapper<Book>()
//                .eq("parent_catalog", 109).last("limit 0 ,390"));
//
//        List<ProductInfo> productInfoList = iProductInfoService.list();
//        for (ProductPicInfo productInfo:productInfoList)


//        List<ProductInfo> productInfoList = iProductInfoService.list();
//        for (ProductInfo productInfo :productInfoList){
//            int number = (int) (Math.random() * (productInfoList.size() ) );
//            productInfo.setSale(number);
//            int number1 = (int) (Math.random() * (productInfoList.size() ) );
//            productInfo.setBrowseVolume(number1);
//            int number2 = (int) (Math.random() * (productInfoList.size() ) );
//            productInfo.setTotalStock(number2);
//            iProductInfoService.saveOrUpdate(productInfo);
//            ProductPicInfo picInfo = iProductPicInfoService.getOne(new QueryWrapper<ProductPicInfo>()
//                    .eq("product_id", productInfo.getProductId()));
//            ProductSku productSku = new ProductSku();
//            productSku.setId(GetId .addLeftZero(GetId.getLocalTrmSeqNum(),15)+RandomUtils.generateString(5));
//            productSku.setProductId(productInfo.getProductId());
//            productSku.setProductPrice(BigDecimal.valueOf(100));
//            productSku.setSkuStock("112");
//            productSku.setLowStock("10");
//            List<ProductAttrValue> colorList = iProductAttrValueService.list(new QueryWrapper<ProductAttrValue>()
//                    .eq("product_attr_id", 1));
//            String colorStr="{\"颜色\":";
//            String colorStr1="";
//            int number = (int) (Math.random() * (colorList.size() ) );
//            colorStr1=colorList.get(number).getAttrValue()+"\"";
//
//
//
//            colorStr=colorStr+colorStr1+",";
//            System.out.println(colorStr);
//
//            List<ProductAttrValue> sizeList = iProductAttrValueService.list(new QueryWrapper<ProductAttrValue>()
//                    .eq("product_attr_id", 2));
//            String sizeStr="\"尺寸\":";
//            String sizeStr1="";
//            int number1 = (int) (Math.random() * (sizeList.size()  ) );
//            sizeStr1=sizeList.get(number1).getAttrValue()+"\"";
//            sizeStr=sizeStr+sizeStr1+"}";
//            System.out.println(sizeStr);
//
//            String str=colorStr+sizeStr;
//            productSku.setProductSpecs(str);
//            productSku.setSpecsSeq(1);
//            productSku.setPicUrl(picInfo.getPicUrl());
//            iProductSkuService.saveOrUpdate(productSku);
        return Result.success();
    }
}
