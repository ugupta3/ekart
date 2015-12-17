DROP SCHEMA IF EXISTS ekart;
create SCHEMA ekart;
USE ekart;

CREATE TABLE `ek_privilege` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `name` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
);
CREATE TABLE `ek_user_role` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `name` varchar(255) DEFAULT NULL,
     `privilege_id` bigint(20),
     PRIMARY KEY (`id`),
     CONSTRAINT  FOREIGN KEY (`privilege_id`) REFERENCES `ek_privilege` (`id`)
   );

 CREATE TABLE `ek_user` (
   `id` bigint(20) AUTO_INCREMENT,
   `email` varchar(100) NOT NULL,
   `is_active` bit(1) NOT NULL,
   `first_name` varchar(255) DEFAULT NULL,
   `last_name` varchar(255) DEFAULT NULL,
   `password` varchar(60) DEFAULT NULL,
   `phone` varchar(255) DEFAULT NULL,
   `created_at` datetime DEFAULT NULL,
   `updated_at` datetime DEFAULT NULL,
    role_id bigint(20) NOT NULL,
   CONSTRAINT  FOREIGN KEY (`role_id`) REFERENCES `ek_user_role` (`id`),
   PRIMARY KEY (`id`)
 );
 CREATE TABLE ek_address (
   id bigint(20)  AUTO_INCREMENT,
   address_line1 varchar(255) NOT NULL,
   address_line2 varchar(255),
   city varchar(255) NOT NULL,
   email_address varchar(255) ,
   name varchar(255) ,
   is_active BOOLEAN,
   is_default BOOLEAN,
   is_mailing BOOLEAN,
   postal_code varchar(255),
   phone VARCHAR(12),
   country varchar(255) DEFAULT 'INDIA',
   state varchar(25),
   customer_id bigint(20),
   PRIMARY KEY (id),
    CONSTRAINT  FOREIGN KEY (`customer_id`) REFERENCES `ek_user` (`id`)
   );
 CREATE TABLE `ek_verification_token` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `expiry_date` datetime DEFAULT NULL,
      `token` varchar(255) DEFAULT NULL,
      `user_id` bigint(20) NOT NULL,
      PRIMARY KEY (`id`),
      KEY  (`user_id`),
      CONSTRAINT  FOREIGN KEY (`user_id`) REFERENCES `ek_user` (`id`)
    );
CREATE TABLE `ek_password_rest_token` (
  `id` bigint(20) AUTO_INCREMENT,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY  (user_id),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `ek_user` (`id`)
);
CREATE TABLE ek_category (
  category_id BIGINT(20) AUTO_INCREMENT,
  category_name VARCHAR(255) NOT NULL,
  active_end_date DATETIME,
  active_start_date DATETIME,
  PRIMARY KEY (CATEGORY_ID)
 );
CREATE TABLE ek_product (
  product_id BIGINT(11) AUTO_INCREMENT,
  product_name VARCHAR(255) ,
  image_url VARCHAR(255),
  manufacturer VARCHAR(255),
  category_id BIGINT(20),
  PRIMARY KEY (product_id),
  CONSTRAINT  FOREIGN KEY (category_id) REFERENCES ek_category (category_id)
);
CREATE TABLE ek_inventory (
  inventory_id BIGINT(20) AUTO_INCREMENT,
  merchant_id BIGINT(20),
  product_id BIGINT(20),
  quantity_in_hand BIGINT(20) NOT NULL,
  PRIMARY KEY (inventory_id),
  CONSTRAINT  FOREIGN KEY (merchant_id) REFERENCES ek_user (id),
  CONSTRAINT  FOREIGN KEY (product_id) REFERENCES ek_product (product_id)
);
CREATE TABLE ek_pricing(
   product_id BIGINT(20),
   merchant_id BIGINT(255),
   merchant_price DOUBLE,
   ek_percentage DOUBLE,
   sell_price DOUBLE,
   PRIMARY KEY(product_id,merchant_id),
  CONSTRAINT  FOREIGN KEY (product_id) REFERENCES ek_product (product_id),
  CONSTRAINT  FOREIGN KEY (merchant_id) REFERENCES ek_user (id)
);
CREATE TABLE ek_order_item (
  order_item_id BIGINT(20) AUTO_INCREMENT,
  product_id BIGINT(20) NOT NULL,
  merchant_id BIGINT(255) NOT NULL,
  order_id  BIGINT(20) NOT NULL,
  vendor_price DOUBLE,
  ek_percentage DOUBLE,
  sell_price DOUBLE,
  total_price DOUBLE,
  quantity int,
  PRIMARY KEY (order_item_id)
 );
CREATE TABLE ek_order (
  order_id BIGINT(11)  AUTO_INCREMENT,
  customer_id BIGINT(11),
  session_id BIGINT(11),
  order_name VARCHAR(255),
  order_status VARCHAR(255),
  order_subtotal DECIMAL(19,5),
  order_total DECIMAL(19,5),
  shipping_cost DECIMAL(19,5),
  date_created DATETIME,
  date_updated DATETIME,
  PRIMARY KEY (order_id)
  -- CONSTRAINT FK8F5B64A87470F437 FOREIGN KEY (CUSTOMER_ID) REFERENCES BLC_CUSTOMER (CUSTOMER_ID)
  -- OFFER_ID BIGINT(20),

);
CREATE TABLE ek_order_payment (
  order_payment_id BIGINT(20) AUTO_INCREMENT,
  amount DECIMAL(19,5),
  archived BOOLEAN,
  gateway_type VARCHAR(255),
  reference_number VARCHAR(255),
  payment_type VARCHAR(255) NOT NULL,
  address_id BIGINT(20),
  order_id BIGINT(20),
  PRIMARY KEY (ORDER_PAYMENT_ID)
  -- CONSTRAINT FK9517A14F89FE8A02 FOREIGN KEY (ORDER_ID) REFERENCES ek_ORDER (ORDER_ID),
  -- CONSTRAINT FK9517A14FC13085DD FOREIGN KEY (ADDRESS_ID) REFERENCES ek_ADDRESS (ADDRESS_ID)
);
CREATE TABLE ek_order_payment_transaction (
  payment_transaction_id BIGINT(20) AUTO_INCREMENT,
  transaction_amount DECIMAL(19,2),
  archived BOOLEAN,
  customer_ip_address VARCHAR(255),
  date_recorded datetime,
  raw_response LONGTEXT,
  success tinyint(1),
  transaction_type VARCHAR(255),
  order_payment BIGINT(20) NOT NULL,
  parent_transaction BIGINT(20),
  PRIMARY KEY (payment_transaction_id),
  KEY  (order_payment),
  KEY  (parent_transaction)
  -- CONSTRAINT  FOREIGN KEY (order_payment) REFERENCES ek_order_payment (ORDER_PAYMENT_ID),
  -- CONSTRAINT  FOREIGN KEY (parent_transaction) REFERENCES ek_order_payment_transaction (payment_transaction_id)
);
