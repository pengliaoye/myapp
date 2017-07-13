CREATE TABLE tb_users (
	id bigint primary key,
	name varchar(255),
	description varchar(255)
);

CREATE TABLE `tb_tickets` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(1) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
);

INSERT INTO `tb_tickets` (`stub`) VALUES ('a');

DELIMITER $$
CREATE FUNCTION `gen_ticket64`() RETURNS BIGINT(20)
BEGIN
	DECLARE epoch BIGINT(20);
    DECLARE current_ms BIGINT(20);
    DECLARE node INTEGER;
    DECLARE incr BIGINT(20);
    
    SET node = 1;
    SET current_ms = round(UNIX_TIMESTAMP(CURTIME(4)) * 1000);
    SET epoch = 1499875200000; #//change your epoch
    
    REPLACE INTO tb_tickets (stub) VALUES ('a');
	SELECT LAST_INSERT_ID() INTO incr;
    
RETURN (current_ms - epoch) << 22 | (node << 12) | (incr % 4096);
END$$
DELIMITER ;