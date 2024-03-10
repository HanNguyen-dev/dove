DROP DATABASE IF EXISTS jobs;

CREATE DATABASE jobs;

USE jobs;

CREATE TABLE company (
   company_id   INT UNIQUE NOT NULL AUTO_INCREMENT,
   name         NVARCHAR(50) NOT NULL,
   headquarter  NVARCHAR(50),
   industry_id  INT
);

CREATE TABLE job (
   job_id       INT UNIQUE NOT NULL AUTO_INCREMENT,
   company_id   INT,
   title        NVARCHAR(50) NOT NULL,
   frontend     NVARCHAR(50),
   backend      NVARCHAR(50),
   store_db     NVARCHAR(50),
   cloud        NVARCHAR(50),
   languages    NVARCHAR(50),
   experience   NVARCHAR(50),
   url          NVARCHAR(500)
);

CREATE TABLE industry (
   industry_id  INT UNIQUE NOT NULL AUTO_INCREMENT,
   name         NVARCHAR(50)
);

ALTER TABLE company
    ADD CONSTRAINT pk_company_company_id PRIMARY KEY (company_id);

ALTER TABLE job
    ADD CONSTRAINT pk_job_company_id FOREIGN KEY (company_id) REFERENCES company(company_id);

ALTER TABLE job
    ADD CONSTRAINT pk_job_job_id PRIMARY KEY (job_id);

ALTER TABLE company
    ADD CONSTRAINT fk_company_industry_id FOREIGN KEY (industry_id) REFERENCES industry(industry_id);

INSERT INTO industry(name) VALUES
    ('Game');

INSERT INTO company(name, headquarter, industry_id) VALUES
    ('John', 'New York City, NY', 1);

INSERT INTO job(company_id, title, frontend, languages, experience, url) VALUES
    (1, 'Player Two', 'Controller', 'English', 15, '3rd Planet');
