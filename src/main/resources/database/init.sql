CREATE TABLE IF NOT EXISTS files
(
    id    INT PRIMARY KEY ,
    title  VARCHAR(100) NOT NULL ,
    creation_date TIMESTAMP NOT NULL DEFAULT NOW(),
    description VARCHAR(250),
    filedata BYTEA NOT NULL
);