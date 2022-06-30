DROP TABLE IF EXISTS ums_menu;
CREATE TABLE ums_menu (
	id			integer		PRIMARY KEY,
	parent_id	integer		NOT NULL,
	create_time timestamp	NOT NULL, 
	title		text		NOT NULL,
	level		integer		NOT NULL,
	sort		integer		NOT NULL,
	name		text		NOT NULL,
	icon		text		NOT NULL,
	hidden		integer		NOT NULL
);
TRUNCATE TABLE ums_menu;
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('1', '0', '2020-02-02 14:50:36', '商品', '0', '0', 'pms', 'product', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('2', '1', '2020-02-02 14:51:50', '商品列表', '1', '0', 'product', 'product-list', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('3', '1', '2020-02-02 14:52:44', '添加商品', '1', '0', 'addProduct', 'product-add', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('4', '1', '2020-02-02 14:53:51', '商品分类', '1', '0', 'productCate', 'product-cate', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('5', '1', '2020-02-02 14:54:51', '商品类型', '1', '0', 'productAttr', 'product-attr', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('6', '1', '2020-02-02 14:56:29', '品牌管理', '1', '0', 'brand', 'product-brand', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('7', '0', '2020-02-02 16:54:07', '订单', '0', '0', 'oms', 'order', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('8', '7', '2020-02-02 16:55:18', '订单列表', '1', '0', 'order', 'product-list', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('9', '7', '2020-02-02 16:56:46', '订单设置', '1', '0', 'orderSetting', 'order-setting', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('10', '7', '2020-02-02 16:57:39', '退货申请处理', '1', '0', 'returnApply', 'order-return', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('11', '7', '2020-02-02 16:59:40', '退货原因设置', '1', '0', 'returnReason', 'order-return-reason', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('12', '0', '2020-02-04 16:18:00', '营销', '0', '0', 'sms', 'sms', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('13', '12', '2020-02-04 16:19:22', '秒杀活动列表', '1', '0', 'flash', 'sms-flash', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('14', '12', '2020-02-04 16:20:16', '优惠券列表', '1', '0', 'coupon', 'sms-coupon', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('16', '12', '2020-02-07 16:22:38', '品牌推荐', '1', '0', 'homeBrand', 'product-brand', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('17', '12', '2020-02-07 16:23:14', '新品推荐', '1', '0', 'homeNew', 'sms-new', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('18', '12', '2020-02-07 16:26:38', '人气推荐', '1', '0', 'homeHot', 'sms-hot', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('19', '12', '2020-02-07 16:28:16', '专题推荐', '1', '0', 'homeSubject', 'sms-subject', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('20', '12', '2020-02-07 16:28:42', '广告列表', '1', '0', 'homeAdvertise', 'sms-ad', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('21', '0', '2020-02-07 16:29:13', '权限', '0', '0', 'ums', 'ums', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('22', '21', '2020-02-07 16:29:51', '用户列表', '1', '0', 'admin', 'ums-admin', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('23', '21', '2020-02-07 16:30:13', '角色列表', '1', '0', 'role', 'ums-role', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('24', '21', '2020-02-07 16:30:53', '菜单列表', '1', '0', 'menu', 'ums-menu', '0');
INSERT INTO ums_menu (id, parent_id, create_time, title, level, sort, name, icon, hidden) VALUES ('25', '21', '2020-02-07 16:31:13', '资源列表', '1', '0', 'resource', 'ums-resource', '0');

TRUNCATE TABLE pms_product_category_with_children_item CASCADE;
INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('20','description','icon','国产','0','手机数码','1','0','1','1','1','1');

INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('21','description','icon','国产','0','服装','1','0','1','1','1','1');

INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('22','description','icon','国产','0','家居','1','0','1','1','1','1');

INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('23','description','icon','国产','0','家具','1','0','1','1','1','1');

INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('24','description','icon','国产','0','家电','1','0','1','1','1','1');

INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('25','description','icon','国产','0','美妆','1','0','1','1','1','1');

TRUNCATE TABLE pms_product_category;
INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('10','description','icon','国产','1','手机','1','20','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('11','description','icon','国产','1','台式电脑','1','20','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('12','description','icon','国产','1','笔记本电脑','1','20','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('13','description','icon','国产','1','平板电脑','1','20','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('14','description','icon','国产','1','数码相机','1','20','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('15','description','icon','国产','1','手机配件','1','20','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('20','description','icon','国产','1','夹克衫','1','21','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('21','description','icon','国产','1','Polo衫','1','21','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('22','description','icon','国产','1','短袖T恤','1','21','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('23','description','icon','国产','1','长袖T恤','1','21','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('24','description','icon','国产','1','运动短裤','1','21','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('25','description','icon','国产','1','运动长裤','1','21','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('30','description','icon','国产','1','睡衣','1','22','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('31','description','icon','国产','1','毛毯','1','22','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('32','description','icon','国产','1','夏凉被','1','22','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('33','description','icon','国产','1','羽绒被','1','22','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('34','description','icon','国产','1','棉被','1','22','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('35','description','icon','国产','1','窗帘','1','22','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('40','description','icon','国产','1','沙发','1','23','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('41','description','icon','国产','1','落地桌','1','23','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('42','description','icon','国产','1','折叠桌','1','23','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('43','description','icon','国产','1','电竞椅','1','23','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('44','description','icon','国产','1','折叠椅','1','23','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('45','description','icon','国产','1','手办展柜','1','23','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('50','description','icon','国产','1','电视','1','24','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('51','description','icon','国产','1','冰箱','1','24','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('52','description','icon','国产','1','空调','1','24','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('53','description','icon','国产','1','电饭煲','1','24','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('54','description','icon','国产','1','压力锅','1','24','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('55','description','icon','国产','1','空气炸锅','1','24','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('60','description','icon','国产','1','乳液','1','25','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('61','description','icon','国产','1','口红','1','25','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('62','description','icon','国产','1','面霜','1','25','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('63','description','icon','国产','1','粉底液','1','25','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('64','description','icon','国产','1','卸妆水','1','25','1','1','1','1');

INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,parent_id,product_count,product_unit,show_status,sort) 
VALUES ('65','description','icon','国产','1','眼影','1','25','1','1','1','1');

TRUNCATE TABLE pms_brand;
INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('10','string','string','0','a','logoimg','华为','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('11','string','string','0','a','logoimg','OPPO','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('12','string','string','0','a','logoimg','小米','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('13','string','string','0','a','logoimg','中兴','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('14','string','string','0','a','logoimg','魅族','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('15','string','string','0','a','logoimg','黑莓','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('16','string','string','0','a','logoimg','苹果','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('17','string','string','0','a','logoimg','Vivo','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('18','string','string','0','a','logoimg','海尔','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('19','string','string','0','a','logoimg','美的','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('20','string','string','0','a','logoimg','荣事达','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('21','string','string','0','a','logoimg','康佳','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('22','string','string','0','a','logoimg','长虹','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('23','string','string','0','a','logoimg','创维','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('24','string','string','0','a','logoimg','海信','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('25','string','string','0','a','logoimg','TCL','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('26','string','string','0','a','logoimg','容声','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('27','string','string','0','a','logoimg','大力','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('28','string','string','0','a','logoimg','格力','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('29','string','string','0','a','logoimg','万事达','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('30','string','string','0','a','logoimg','小天鹅','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('31','string','string','0','a','logoimg','纽曼','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('32','string','string','0','a','logoimg','澳柯玛','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('33','string','string','0','a','logoimg','史密斯','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('34','string','string','0','a','logoimg','松下','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('35','string','string','0','a','logoimg','海飞丝','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('36','string','string','0','a','logoimg','海蓝之谜','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('37','string','string','0','a','logoimg','海伦凯勒','0','0','0','0');

INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
VALUES ('38','string','string','0','a','logoimg','海澜之家','0','0','0','0');

TRUNCATE TABLE pms_product CASCADE;
INSERT INTO pms_product(id,album_pics,icon,brand_id,brand_name,delete_status,description,detail_desc,detail_html,detail_mobile_html,detail_title,feight_template_id,gift_growth,gift_point,key_words,low_stock,name,new_status,note,original_price,pic,preview_status,price,product_attribute_category_id,product_category_id,product_category_name,product_sn,promotion_end_time,promotion_per_limit,promotion_price,promotion_start_time,promotion_type,publish_status,recommand_status,sale,service_ids,sort,stock,sub_title,unit,use_point_limit,verify_status,weight)
VALUES ('10','albumPics','icon','0','华为','0','description','detailDesc','detailHtml','detailMobileHtml','detailTitle','1','1','1','keyword','1','华为手机','1','note','5000.0','pic','1','4500.0','1','10','手机','productSn','2022/8/1',1,'5000','2022/7/1','1','1','1','1','serviceIds','1','1','subTitle','unit','1','1','200.0');

INSERT INTO pms_product(id,album_pics,icon,brand_id,brand_name,delete_status,description,detail_desc,detail_html,detail_mobile_html,detail_title,feight_template_id,gift_growth,gift_point,key_words,low_stock,name,new_status,note,original_price,pic,preview_status,price,product_attribute_category_id,product_category_id,product_category_name,product_sn,promotion_end_time,promotion_per_limit,promotion_price,promotion_start_time,promotion_type,publish_status,recommand_status,sale,service_ids,sort,stock,sub_title,unit,use_point_limit,verify_status,weight)
VALUES ('11','albumPics','icon','0','小米','0','description','detailDesc','detailHtml','detailMobileHtml','detailTitle','1','1','1','keyword','1','小米手机','1','note','5000.0','pic','1','4500.0','1','10','手机','productSn','2022/8/1',1,'5000','2022/7/1','1','1','1','1','serviceIds','1','1','subTitle','unit','1','1','200.0');

INSERT INTO pms_product(id,album_pics,icon,brand_id,brand_name,delete_status,description,detail_desc,detail_html,detail_mobile_html,detail_title,feight_template_id,gift_growth,gift_point,key_words,low_stock,name,new_status,note,original_price,pic,preview_status,price,product_attribute_category_id,product_category_id,product_category_name,product_sn,promotion_end_time,promotion_per_limit,promotion_price,promotion_start_time,promotion_type,publish_status,recommand_status,sale,service_ids,sort,stock,sub_title,unit,use_point_limit,verify_status,weight)
VALUES ('12','albumPics','icon','0','魅族','0','description','detailDesc','detailHtml','detailMobileHtml','detailTitle','1','1','1','keyword','1','魅族手机','1','note','5000.0','pic','1','4500.0','1','10','手机','productSn','2022/8/1',1,'5000','2022/7/1','1','1','1','1','serviceIds','1','1','subTitle','unit','1','1','200.0');

INSERT INTO pms_product(id,album_pics,icon,brand_id,brand_name,delete_status,description,detail_desc,detail_html,detail_mobile_html,detail_title,feight_template_id,gift_growth,gift_point,key_words,low_stock,name,new_status,note,original_price,pic,preview_status,price,product_attribute_category_id,product_category_id,product_category_name,product_sn,promotion_end_time,promotion_per_limit,promotion_price,promotion_start_time,promotion_type,publish_status,recommand_status,sale,service_ids,sort,stock,sub_title,unit,use_point_limit,verify_status,weight)
VALUES ('13','albumPics','icon','0','中兴','0','description','detailDesc','detailHtml','detailMobileHtml','detailTitle','1','1','1','keyword','1','中兴手机','1','note','5000.0','pic','1','4500.0','1','10','手机','productSn','2022/8/1',1,'5000','2022/7/1','1','1','1','1','serviceIds','1','1','subTitle','unit','1','1','200.0');

INSERT INTO pms_product(id,album_pics,icon,brand_id,brand_name,delete_status,description,detail_desc,detail_html,detail_mobile_html,detail_title,feight_template_id,gift_growth,gift_point,key_words,low_stock,name,new_status,note,original_price,pic,preview_status,price,product_attribute_category_id,product_category_id,product_category_name,product_sn,promotion_end_time,promotion_per_limit,promotion_price,promotion_start_time,promotion_type,publish_status,recommand_status,sale,service_ids,sort,stock,sub_title,unit,use_point_limit,verify_status,weight)
VALUES ('14','albumPics','icon','0','OPPO','0','description','detailDesc','detailHtml','detailMobileHtml','detailTitle','1','1','1','keyword','1','OPPO手机','1','note','5000.0','pic','1','4500.0','1','10','手机','productSn','2022/8/1',1,'5000','2022/7/1','1','1','1','1','serviceIds','1','1','subTitle','unit','1','1','200.0');

INSERT INTO pms_product(id,album_pics,icon,brand_id,brand_name,delete_status,description,detail_desc,detail_html,detail_mobile_html,detail_title,feight_template_id,gift_growth,gift_point,key_words,low_stock,name,new_status,note,original_price,pic,preview_status,price,product_attribute_category_id,product_category_id,product_category_name,product_sn,promotion_end_time,promotion_per_limit,promotion_price,promotion_start_time,promotion_type,publish_status,recommand_status,sale,service_ids,sort,stock,sub_title,unit,use_point_limit,verify_status,weight)
VALUES ('15','albumPics','icon','0','Vivo','0','description','detailDesc','detailHtml','detailMobileHtml','detailTitle','1','1','1','keyword','1','Vivo手机','1','note','5000.0','pic','1','4500.0','1','10','手机','productSn','2022/8/1',1,'5000','2022/7/1','1','1','1','1','serviceIds','1','1','subTitle','unit','1','1','200.0');

TRUNCATE TABLE oms_order;
INSERT INTO  oms_order(id,auto_confirm_day,bill_content,bill_header,bill_receiver_email,bill_receiver_phone,bill_type,comment_time,confirm_status,coupon_amount,coupon_id,create_time,delete_status,delivery_company,delivery_sn,delivery_time,discount_amount,freight_amount,growth,integration,member_id,member_username,modify_time,note,order_sn,order_type,pay_amount,pay_type,pay_time,promotion_amount,promotion_info,receive_time,receiver_city,receiver_detail_address,receiver_name,receiver_phone,receiver_post_code,receive_province,receiver_region,source_type,status,total_amount,use_integration)
VALUES ('10','1','billContent','billHeader','billReceiverEmail','billReceiverPhone','1','2022/6/18','1','1','1','2022/6/18','1','deliveryCompany','deliverySn','deliveryTime','1','1','1','1','1','赵一','modifyTime','note','1001','1','1','1','payTime','1','promotionInfo','receiveTime','receiverCity','receiverDetailAddress','receiverName','receiverPhone','receiverPostCode','receiveProvince','receiverRegion','1','1','1','1');

INSERT INTO  oms_order(id,auto_confirm_day,bill_content,bill_header,bill_receiver_email,bill_receiver_phone,bill_type,comment_time,confirm_status,coupon_amount,coupon_id,create_time,delete_status,delivery_company,delivery_sn,delivery_time,discount_amount,freight_amount,growth,integration,member_id,member_username,modify_time,note,order_sn,order_type,pay_amount,pay_type,pay_time,promotion_amount,promotion_info,receive_time,receiver_city,receiver_detail_address,receiver_name,receiver_phone,receiver_post_code,receive_province,receiver_region,source_type,status,total_amount,use_integration)
VALUES ('11','1','billContent','billHeader','billReceiverEmail','billReceiverPhone','1','2022/6/18','1','1','1','2022/6/18','1','deliveryCompany','deliverySn','deliveryTime','1','1','1','1','1','钱二','modifyTime','note','1002','1','1','1','payTime','1','promotionInfo','receiveTime','receiverCity','receiverDetailAddress','receiverName','receiverPhone','receiverPostCode','receiveProvince','receiverRegion','1','1','1','1');

INSERT INTO  oms_order(id,auto_confirm_day,bill_content,bill_header,bill_receiver_email,bill_receiver_phone,bill_type,comment_time,confirm_status,coupon_amount,coupon_id,create_time,delete_status,delivery_company,delivery_sn,delivery_time,discount_amount,freight_amount,growth,integration,member_id,member_username,modify_time,note,order_sn,order_type,pay_amount,pay_type,pay_time,promotion_amount,promotion_info,receive_time,receiver_city,receiver_detail_address,receiver_name,receiver_phone,receiver_post_code,receive_province,receiver_region,source_type,status,total_amount,use_integration)
VALUES ('12','1','billContent','billHeader','billReceiverEmail','billReceiverPhone','1','2022/6/18','1','1','1','2022/6/18','1','deliveryCompany','deliverySn','deliveryTime','1','1','1','1','1','孙三','modifyTime','note','1003','1','1','1','payTime','1','promotionInfo','receiveTime','receiverCity','receiverDetailAddress','receiverName','receiverPhone','receiverPostCode','receiveProvince','receiverRegion','1','1','1','1');

INSERT INTO  oms_order(id,auto_confirm_day,bill_content,bill_header,bill_receiver_email,bill_receiver_phone,bill_type,comment_time,confirm_status,coupon_amount,coupon_id,create_time,delete_status,delivery_company,delivery_sn,delivery_time,discount_amount,freight_amount,growth,integration,member_id,member_username,modify_time,note,order_sn,order_type,pay_amount,pay_type,pay_time,promotion_amount,promotion_info,receive_time,receiver_city,receiver_detail_address,receiver_name,receiver_phone,receiver_post_code,receive_province,receiver_region,source_type,status,total_amount,use_integration)
VALUES ('13','1','billContent','billHeader','billReceiverEmail','billReceiverPhone','1','2022/6/18','1','1','1','2022/6/18','1','deliveryCompany','deliverySn','deliveryTime','1','1','1','1','1','李四','modifyTime','note','1004','1','1','1','payTime','1','promotionInfo','receiveTime','receiverCity','receiverDetailAddress','receiverName','receiverPhone','receiverPostCode','receiveProvince','receiverRegion','1','1','1','1');

INSERT INTO  oms_order(id,auto_confirm_day,bill_content,bill_header,bill_receiver_email,bill_receiver_phone,bill_type,comment_time,confirm_status,coupon_amount,coupon_id,create_time,delete_status,delivery_company,delivery_sn,delivery_time,discount_amount,freight_amount,growth,integration,member_id,member_username,modify_time,note,order_sn,order_type,pay_amount,pay_type,pay_time,promotion_amount,promotion_info,receive_time,receiver_city,receiver_detail_address,receiver_name,receiver_phone,receiver_post_code,receive_province,receiver_region,source_type,status,total_amount,use_integration)
VALUES ('14','1','billContent','billHeader','billReceiverEmail','billReceiverPhone','1','2022/6/18','1','1','1','2022/6/18','1','deliveryCompany','deliverySn','deliveryTime','1','1','1','1','1','周五','modifyTime','note','1005','1','1','1','payTime','1','promotionInfo','receiveTime','receiverCity','receiverDetailAddress','receiverName','receiverPhone','receiverPostCode','receiveProvince','receiverRegion','1','1','1','1');

INSERT INTO  oms_order(id,auto_confirm_day,bill_content,bill_header,bill_receiver_email,bill_receiver_phone,bill_type,comment_time,confirm_status,coupon_amount,coupon_id,create_time,delete_status,delivery_company,delivery_sn,delivery_time,discount_amount,freight_amount,growth,integration,member_id,member_username,modify_time,note,order_sn,order_type,pay_amount,pay_type,pay_time,promotion_amount,promotion_info,receive_time,receiver_city,receiver_detail_address,receiver_name,receiver_phone,receiver_post_code,receive_province,receiver_region,source_type,status,total_amount,use_integration)
VALUES ('15','1','billContent','billHeader','billReceiverEmail','billReceiverPhone','1','2022/6/18','1','1','1','2022/6/18','1','deliveryCompany','deliverySn','deliveryTime','1','1','1','1','1','吴六','modifyTime','note','1006','1','1','1','payTime','1','promotionInfo','receiveTime','receiverCity','receiverDetailAddress','receiverName','receiverPhone','receiverPostCode','receiveProvince','receiverRegion','1','1','1','1');
