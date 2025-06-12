-- Created by Vertabelo (http://vertabelo.com)

-- tables
-- Table: customer
CREATE TABLE customer (
                          id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                          first_name varchar(50)  NOT NULL,
                          last_name varchar(50)  NOT NULL,
                          phone varchar(20)  NULL,
                          CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: pet
CREATE TABLE pet (
                     id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                     pet_type_id int  NOT NULL,
                     name varchar(100)  NOT NULL,
                     birth_date date  NULL,
                     price decimal(10,2)  NOT NULL,
                     CONSTRAINT pet_pk PRIMARY KEY (id)
);

-- Table: pet_type
CREATE TABLE pet_type (
                          id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                          type_name varchar(50)  NOT NULL,
                          CONSTRAINT pet_type_ak_1 UNIQUE (type_name),
                          CONSTRAINT pet_type_pk PRIMARY KEY (id)
);

-- Table: sale
CREATE TABLE sale (
                      id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                      pet_id int  NOT NULL,
                      customer_id int  NOT NULL,
                      sale_date date  NOT NULL,
                      sale_price decimal(10,2)  NOT NULL,
                      CONSTRAINT sale_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: pet_pet_type (table: pet)
ALTER TABLE pet ADD CONSTRAINT pet_pet_type
    FOREIGN KEY (pet_type_id)
        REFERENCES pet_type (id);

-- Reference: sale_customer (table: sale)
ALTER TABLE sale ADD CONSTRAINT sale_customer
    FOREIGN KEY (customer_id)
        REFERENCES customer (id);

-- Reference: sale_pet (table: sale)
ALTER TABLE sale ADD CONSTRAINT sale_pet
    FOREIGN KEY (pet_id)
        REFERENCES pet (id);

-- End of file.