CREATE TABLE business
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(150) NOT NULL,
    start_date   DATE         NOT NULL
);

CREATE TABLE user_account
(
    id          BIGSERIAL PRIMARY KEY,
    email       VARCHAR(150) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    status      VARCHAR(20)  NOT NULL,
    role        VARCHAR(20)  NOT NULL,
    business_id BIGINT       NOT NULL REFERENCES business (id),
    UNIQUE (business_id, email)
);

CREATE TABLE category
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    business_id BIGINT       NOT NULL REFERENCES business (id),
    UNIQUE (business_id, name)
);

CREATE TABLE product
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(150)   NOT NULL,
    description    VARCHAR(500),
    sale_price     DECIMAL(12, 2) NOT NULL,
    stock          INTEGER        NOT NULL DEFAULT 0,
    minimum_stock  INTEGER        NOT NULL DEFAULT 0,
    category_id    BIGINT         NOT NULL REFERENCES category (id),
    business_id    BIGINT         NOT NULL REFERENCES business (id)
);

CREATE TABLE customer
(
    id          BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(100) NOT NULL,
    last_name   VARCHAR(100) NOT NULL,
    dni         VARCHAR(20)  NOT NULL,
    phone       VARCHAR(20),
    business_id BIGINT       NOT NULL REFERENCES business (id)
);

CREATE TABLE supplier
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(150) NOT NULL,
    phone       VARCHAR(20),
    tax_id      VARCHAR(20)  NOT NULL,
    business_id BIGINT       NOT NULL REFERENCES business (id),
    UNIQUE (business_id, tax_id)
);

CREATE TABLE purchase
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       BIGINT         NOT NULL REFERENCES user_account (id),
    supplier_id   BIGINT         NOT NULL REFERENCES supplier (id),
    business_id   BIGINT         NOT NULL REFERENCES business (id),
    date          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    purchase_total DECIMAL(12, 2) NOT NULL
);

CREATE TABLE purchase_detail
(
    id             BIGSERIAL PRIMARY KEY,
    purchase_id    BIGINT         NOT NULL REFERENCES purchase (id),
    product_id     BIGINT         NOT NULL REFERENCES product (id),
    quantity       INTEGER        NOT NULL,
    purchase_price DECIMAL(12, 2) NOT NULL
);

CREATE TABLE sale
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT         NOT NULL REFERENCES user_account (id),
    customer_id  BIGINT                  REFERENCES customer (id),
    business_id  BIGINT         NOT NULL REFERENCES business (id),
    date         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    sale_total   DECIMAL(12, 2) NOT NULL
);

CREATE TABLE sale_detail
(
    id           BIGSERIAL PRIMARY KEY,
    sale_id      BIGINT         NOT NULL REFERENCES sale (id),
    product_id   BIGINT         NOT NULL REFERENCES product (id),
    quantity     INTEGER        NOT NULL,
    sale_price   DECIMAL(12, 2) NOT NULL
);

CREATE TABLE inventory_movement
(
    id          BIGSERIAL PRIMARY KEY,
    product_id  BIGINT      NOT NULL REFERENCES product (id),
    type        VARCHAR(20) NOT NULL,
    quantity    INTEGER     NOT NULL,
    date        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id     BIGINT      NOT NULL REFERENCES user_account (id),
    business_id BIGINT      NOT NULL REFERENCES business (id)
);