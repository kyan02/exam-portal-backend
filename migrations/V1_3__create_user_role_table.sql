CREATE TABLE IF NOT EXISTS user_role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8;

ALTER TABLE user_role ADD CONSTRAINT fk_user_userRole_user_id FOREIGN KEY (user_id) REFERENCES `user` (id);
ALTER TABLE user_role ADD CONSTRAINT fk_role_user_role_id FOREIGN KEY (role_id) REFERENCES `role` (id);