CREATE TABLE attempt_detail (
  id BIGINT AUTO_INCREMENT NOT NULL,
   user_id BIGINT NULL,
   attempted_on datetime NULL,
   selected_ans VARCHAR(255) NULL,
   is_correct BIT(1) NULL,
   question_id BIGINT NULL,
   CONSTRAINT pk_attemptdetail PRIMARY KEY (id)
);

ALTER TABLE attempt_detail ADD CONSTRAINT FK_ATTEMPTDETAIL_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);