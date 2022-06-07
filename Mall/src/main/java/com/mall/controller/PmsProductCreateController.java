package com.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.PmsProduct;
import com.mall.model.response.ProductResponse;
import com.mall.repository.PmsProductRepository;

@RequestMapping("/product")
@Controller
public class PmsProductCreateController {

	@Autowired
	private PmsProductRepository pmsProductRepository;
	private static final Logger logger = LoggerFactory.getLogger(PmsProductCreateController.class);

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ProductResponse createProduct(@RequestBody PmsProduct param) {
		
		System.out.println("222222222222222222222222");
	
		if (!param.getName().isEmpty() 
				&& !param.getProductCategoryName().isEmpty()//
				&&!param.getSubTitle().isEmpty()//
				&&!param.getBrandName().isEmpty()) { 
			
			
			BeanUtils.copyProperties(param, pmsProductRepository);
			
//			PmsProduct pmsProduct = PmsProduct.builder()//					
//					.albumPics(param.getAlbumPics())//
//					.icon(param.getIcon())//
//					.brandId(param.getBrandId())
//					.brandName(param.getBrandName())//下拉菜单
//					.deleteStatus(param.getDeleteStatus())//
//					.description(param.getDescription())//
//					.detailDesc(param.getDetailDesc())//
//					.detailHtml(param.getDetailHtml())//
//					.detailMobileHtml(param.getDetailMobileHtml())//
//					.detailTitle(param.getDetailTitle())//
//					.feightTemplateId(param.getFeightTemplateId())//
//					.giftGrowth(param.getGiftGrowth())//
//					.giftPoint(param.getGiftPoint())//
//					.keyWords(param.getKeyWords())//
//					.lowStock(param.getLowStock())//
//					.name(param.getName())//
//					.newStatus(param.getNewStatus())//
//					.note(param.getNote())//
//					.originalPrice(param.getOriginalPrice())//
//					.pic(param.getPic())//
//					.previewStatus(param.getPreviewStatus())//
//					.price(param.getPrice())//
//					.productAttributeCategoryId(param.getProductAttributeCategoryId())//
//					.productCategoryId(param.getProductCategoryId())//
//					.productCategoryName(param.getProductCategoryName())//下拉菜单
//					.productSn(param.getProductSn())//
//					.promotionEndTime(param.getPromotionEndTime())//
//					.promotionPerLimit(param.getPromotionPerLimit())//
//					.promotionPrice(param.getPromotionPrice())//
//					.promotionStartTime(param.getPromotionStartTime())//
//					.promotionType(param.getPromotionType())//
//					.publishStatus(param.getPublishStatus())//
//					.recommandStatus(param.getRecommandStatus())//
//					.sale(param.getSale())//
//					.serviceIds(param.getServiceIds())//
//					.sort(param.getSort())//
//					.stock(param.getStock())//
//					.subTitle(param.getSubTitle())//
//					.unit(param.getUnit())//
//					.usePointLimit(param.getUsePointLimit())//
//					.verifyStatus(param.getVerifyStatus())//
//					.weight(param.getWeight())//
//					.cmsPrefrenceAreaProductRelation(param.getCmsPrefrenceAreaProductRelation())//
//					.cmsSubjectProductRelation(param.getCmsSubjectProductRelation())//
//					.pmsMemberPrice(param.getPmsMemberPrice())//
//					.pmsProductAttributeValue(param.getPmsProductAttributeValue())//
//					.pmsProductFullReduction(param.getPmsProductFullReduction())//
//					.pmsProductLadder(param.getPmsProductLadder())//
//					.pmsSkuStock(param.getPmsSkuStock())//
//					.build();								
			
			pmsProductRepository.save(param);
			logger.info("Product " + param.getName() + "添加成功");
			return new ProductResponse(200, null, "Succeed");
		} else {
			logger.warn("Produc" + param.getName() + " 添加失败");
			return new ProductResponse(404, null, "Fail");
		}
	}

}
