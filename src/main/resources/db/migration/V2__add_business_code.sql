ALTER TABLE business
    ADD COLUMN code VARCHAR(100);

UPDATE business
SET code = 'bodega-fabrizio'
WHERE id = 1;

ALTER TABLE business
    ALTER COLUMN code SET NOT NULL;

ALTER TABLE business
    ADD CONSTRAINT uk_business_code UNIQUE (code);