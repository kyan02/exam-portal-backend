CREATE TABLE attempt (
  id BIGINT AUTO_INCREMENT NOT NULL,
   user_id BIGINT NULL,
   attempted_on DATE NULL,
   score VARCHAR(255) NULL,
   total_correct_answer VARCHAR(255) NULL,
   total_attempted VARCHAR(255) NULL,
   result BIT(1) NOT NULL DEFAULT b'0',
   quiz_id BIGINT NULL,
   CONSTRAINT pk_attempt PRIMARY KEY (id)
);

ALTER TABLE attempt ADD CONSTRAINT FK_ATTEMPT_ON_QUIZ FOREIGN KEY (quiz_id) REFERENCES quiz (id);