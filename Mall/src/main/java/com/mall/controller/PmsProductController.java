package com.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.controller.UmsAdminController.Response;
import com.mall.model.PmsProduct;
import com.mall.repository.PmsProductRepository;

@RequestMapping("/product")
@Controller
public class PmsProductController {

	@Autowired
	private PmsProductRepository pmsProductRepository;
	private static final Logger logger = LoggerFactory.getLogger(PmsProductController.class);

	@ResponseBody
	@PostMapping("/create") //
	public Response createProduct(@RequestBody PmsProduct param) {
		if (!param.getName().isEmpty() && param.getOriginalPrice() > 0) { // 价格类型为Number，判断条件">0"显示报错
			
			PmsProduct pmsProduct = PmsProduct.builder()//
					.albumPics(param.getAlbumPics())//
					.icon(param.getIcon())//
					.brandId(param.getBrandId()).brandName(param.getBrandName())//
					.deleteStatus(param.getDeleteStatus())//
					.description(param.getDescription())//
					.detailDesc(param.getDetailDesc())//
					.detailHtml(param.getDetailHtml())//
					.detailMobileHtml(param.getDetailMobileHtml())//
					.detailTitle(param.getDetailTitle())//
					.feightTemplateId(param.getFeightTemplateId())//
					.giftGrowth(param.getGiftGrowth())//
					.giftPoint(param.getGiftPoint())//
					.keyWords(param.getKeyWords())//
					.lowStock(param.getLowStock())//
					.name(param.getName())//
					.newStatus(param.getNewStatus())//
					.note(param.getNote())//
					.originalPrice(param.getOriginalPrice())//
					.pic(param.getPic())//
					.previewStatus(param.getPreviewStatus())//
					.productLadderList(param.getProductLadderList())//
					.build();
			pmsProductRepository.save(pmsProduct);
			logger.info("Product " + param.getName() + "添加成功");
			return new Response(200, null, "Succeed");
		} else {
			logger.warn("Produc" + param.getName() + " 添加失败");
			return new Response(404, null, "Fail");
		}
	}

}
