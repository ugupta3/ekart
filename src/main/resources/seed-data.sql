INSERT INTO `ek_address` (`address_id`, `address_line1`, `address_line2`, `city`, `email_address`, `name`, `is_active`, `is_default`, `is_mailing`, `postal_code`, `phone`, `country`, `state`)
VALUES
	(1, 'Beeramguda', 'Ameenpur', 'Medak', 'gani.chandu@gmail.com', 'Umesh', 1, 1, 1, '508221', '8886220718', 'INDIA', 'TS'),
	(3, 'Lingampally', 'Lingampally', 'Medak', 'gani.chandu@gmail.com', 'Santhosh', 1, 1, 1, '508221', '8886220718', 'INDIA', 'TS');


INSERT INTO `ek_user_account` (`id`, `address_id`, `phone`, `email`, `password_encrypted_value`, `password_salt`, `algorithm`, `password_updated_at`, `created_at`, `updated_at`)
VALUES
	(1, 1, '8886220718', 'gani.chandu@gmail.com', '1234', '123', 'SHA-1', NULL, NULL, NULL);


INSERT INTO `ek_category` (`category_id`, `category_name`, `active_end_date`, `active_start_date`)
VALUES
	(1, 'water', NULL, NULL);

INSERT INTO `ek_product` (`product_id`, `product_name`, `image_url`, `manufacturer`, `category_id`)
VALUES
	(1, 'tankwater 5000 ltr', '/tank 5000 ltr', NULL, 1),
	(2, 'tankwater 25000 ltr', '/tank 25000 ltr', NULL, 1),
	(3, 'tankwater 550000 ltr', '/tank 50000 ltr', NULL, 1),
	(4, 'mineralwater 20 ltr', '/mineral water 20 ltr', NULL, 1);


INSERT INTO `ek_pricing` (`product_id`, `merchant_id`, `merchant_price`, `ek_percentage`, `sell_price`)
VALUES
	(1, 1, 100, 20, 120),
	(2, 1, 1000, 20, 1200),
	(3, 1, 100, 20, 120);


INSERT INTO `ek_privilege` (`id`, `name`)
VALUES
	(1, 'READ');


INSERT INTO `ek_user_role` (`id`, `name`, `privilege_id`)
VALUES
	(1, 'ROLE_USER', 1);

INSERT INTO `ek_user` (`id`, `email`, `is_active`, `first_name`, `last_name`, `password`, `phone`, `created_at`, `updated_at`, `role_id`)
VALUES
	(2, 'admin@gmail.com', 00000001, 'Uma', 'k', '$2a$10$J5GvqJJuQTy2Gqa9wu9Ld.jBA3.VueE8C9C1UVlCAb04KD/Q0I2q2', NULL, '2015-12-16 19:49:29', '2015-12-16 19:49:29', 1);


