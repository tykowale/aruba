CREATE TABLE user (
    id         BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    password_hash   VARCHAR(255),
    created_at TIMESTAMP  NOT NULL,
    updated_at TIMESTAMP  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE authority (
    id         BIGINT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255),
    created_at TIMESTAMP  NOT NULL,
    updated_at TIMESTAMP  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_authority (
    user_id BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,
    CONSTRAINT user_authority_pk PRIMARY KEY (user_id, authority_id),
    CONSTRAINT user_authority_fk_1 FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT user_authority_fk_2 FOREIGN KEY (authority_id) REFERENCES authority (id)
);