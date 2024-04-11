ALTER TABLE product
    ADD qty_available INT NULL;

ALTER TABLE product
    ADD qty_sold INT NULL;

UPDATE product
SET qty_available = '0'
WHERE qty_available IS NULL;
ALTER TABLE product
    MODIFY qty_available INT NOT NULL;

UPDATE product
SET qty_sold = '0'
WHERE qty_sold IS NULL;
ALTER TABLE product
    MODIFY qty_sold INT NOT NULL;