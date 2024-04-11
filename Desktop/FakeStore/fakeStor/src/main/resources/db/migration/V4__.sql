CREATE TABLE address
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    modified_at    datetime NULL,
    is_deleted     VARCHAR(255) NULL,
    geolocation_id BIGINT NULL,
    city           VARCHAR(255) NULL,
    street         VARCHAR(255) NULL,
    number         VARCHAR(255) NULL,
    zipcode        VARCHAR(255) NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE geolocation
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    is_deleted  VARCHAR(255) NULL,
    lat         VARCHAR(255) NULL,
    longi       VARCHAR(255) NULL,
    CONSTRAINT pk_geolocation PRIMARY KEY (id)
);

CREATE TABLE user
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    is_deleted  VARCHAR(255) NULL,
    address_id  BIGINT NULL,
    email       VARCHAR(255) NULL,
    user_name   VARCHAR(255) NULL,
    first_name  VARCHAR(255) NULL,
    last_name   VARCHAR(255) NULL,
    phone       VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE address
    ADD CONSTRAINT uc_address_geolocation UNIQUE (geolocation_id);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_GEOLOCATION FOREIGN KEY (geolocation_id) REFERENCES geolocation (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);