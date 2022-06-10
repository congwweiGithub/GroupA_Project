
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
INSERT INTO pms_product_category_with_children_item (id,description,icon,keywords,level,name,nav_status,product_count,product_unit,show_status,sort,parent_id) 
VALUES ('20','手机数码','icon','国产','1','name','1','1','1','1','1','1');

TRUNCATE TABLE pms_product_category;
INSERT INTO pms_product_category (id,description,icon,keywords,level,name,nav_status,product_count,product_unit,show_status,sort,parent_id,product_category_id) 
VALUES ('20','手机','icon','国产','1','name','1','1','1','1','1','1','20');

