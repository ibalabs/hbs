CREATE TABLE hbs_unit_of_measure(
id 					VARCHAR(100) 	NOT NULL  PRIMARY KEY
,uom_id 			VARCHAR(200) 	UNIQUE NOT NULL
,uom_name			VARCHAR(200) 	UNIQUE NOT NULL
,uom_desc	 		VARCHAR(500) 	NULL
,created_by 		VARCHAR(255) 	NOT NULL
,created 			BIGINT 			NOT NULL
,updated_by 		VARCHAR(255) 	NULL          
,updated 			BIGINT 			NOT NULL DEFAULT 0
);

CREATE TABLE hbs_product_master(
id 					VARCHAR(100) 	NOT NULL PRIMARY KEY 
,product_name 		VARCHAR(500) 	NOT NULL UNIQUE
,uom_id 			VARCHAR(100) 	NOT NULL
,desrciption 		VARCHAR(500) 	NULL
,cost_price 		INTEGER 		NOT NULL
,whole_price 		INTEGER 		NULL
,retail_price 		INTEGER 		NULL
,created_by 		VARCHAR(255) 	NOT NULL
,created 			BIGINT NOT 		NULL
,updated_by 		VARCHAR(255) 	NULL          
,updated 			BIGINT 			NOT NULL DEFAULT 0
);
ALTER TABLE hbs_product_master ADD FOREIGN KEY (uom_id) REFERENCES hbs_unit_of_measure(id); 

CREATE TABLE hbs_customer_master(
id 					VARCHAR(100) 	NOT NULL PRIMARY KEY 
,customer_name		VARCHAR(100) 	NOT NULL
,alias 				VARCHAR(100) 	NULL
,address 			VARCHAR(100) 	NULL
,city 				VARCHAR(100) 	NULL
,mobile 			VARCHAR(100) 	NULL
,balance_amount 	VARCHAR(100) 	NULL
,desrciption 		VARCHAR(100)	NULL
,created_by 		VARCHAR(255)	NOT NULL
,created 			BIGINT 			NOT NULL
,updated_by			VARCHAR(255) 	NULL          
,updated 			BIGINT 			NOT NULL DEFAULT 0 
);

CREATE TABLE hbs_sales_invoice(
id 					 VARCHAR(100) 	NOT NULL PRIMARY KEY 
,cust_id			 VARCHAR(100) 	NOT NULL
,product_id 		 VARCHAR(100) 	NOT NULL
,refered_by			 VARCHAR(100) 	NOT NULL
,existing_blc_amt 	 VARCHAR(10) 	NULL
,uom_id 			 VARCHAR(100)	NOT NULL
,quantity 			 VARCHAR(20) 	NULL
,price 				 VARCHAR(20) 	NULL
,amount 			 VARCHAR(20) 	NULL
,amount_paid 		 VARCHAR(10) 	NULL
,new_bal_amt 		 VARCHAR(20) 	NULL
,notes 				 VARCHAR(500) 	NULL
,created_by 		 VARCHAR(255) 	NOT NULL
,created 			 BIGINT 		NOT NULL
,updated_by			 VARCHAR(255) 	NULL          
,updated 			 BIGINT 		NOT NULL DEFAULT 0 
);
ALTER TABLE hbs_sales_invoice ADD FOREIGN KEY (cust_id) REFERENCES hbs_customer_master(id);
ALTER TABLE hbs_sales_invoice ADD FOREIGN KEY (product_id) REFERENCES hbs_product_master(id);
ALTER TABLE hbs_sales_invoice ADD FOREIGN KEY (uom_id) REFERENCES hbs_unit_of_measure(id);

CREATE TABLE hbs_reciepts(
id 					 VARCHAR(100) 	NOT NULL UNIQUE PRIMARY KEY 
,reciept_id 		 VARCHAR(100) 	NOT NULL 
,cust_name 			 VARCHAR(100)	NOT NULL
,existing_blc_amt 	 VARCHAR(10) 	NULL
,amount_paid 		 VARCHAR(10) 	NULL
,round_off 			 VARCHAR(10) 	NULL
,new_bal_amt 		 VARCHAR(20) 	NULL
,notes 				 VARCHAR(500) 	NULL
,created_by 		 VARCHAR(255) 	NOT NULL
,created 			 BIGINT 		NOT NULL
,updated_by 		 VARCHAR(255) 	NULL          
,updated 			 BIGINT 		NOT NULL DEFAULT 0
);

CREATE TABLE hbs_sales_return(
id 					 VARCHAR(100) 	NOT NULL PRIMARY KEY 
,cust_id 			 VARCHAR(100) 	NOT NULL
,product_id 		 VARCHAR(100) 	NOT NULL
,uom_id 			 VARCHAR(100)	NOT NULL
,existing_blnc_amnt  VARCHAR(100) 	NOT NULL
,quantity 			 VARCHAR(20) 	NULL
,price 				 VARCHAR(20) 	NULL
,amount 			 VARCHAR(20) 	NULL
,toatl_amount 		 VARCHAR(20) 	NULL
,new_bal_amt 		 VARCHAR(20) 	NULL
,notes 				 VARCHAR(500) 	NULL
,created_by 		 VARCHAR(255) 	NOT NULL
,created 			 BIGINT 		NOT NULL
,updated_by 		 VARCHAR(255) 	NULL          
,updated 			 BIGINT 		NOT NULL DEFAULT 0 
);
ALTER TABLE hbs_sales_return ADD FOREIGN KEY (cust_id) REFERENCES hbs_customer_master(id);
ALTER TABLE hbs_sales_return ADD FOREIGN KEY (product_id) REFERENCES hbs_product_master(id);
ALTER TABLE hbs_sales_return ADD FOREIGN KEY (uom_id) REFERENCES hbs_unit_of_measure(id);

CREATE TABLE hbs_company(
id 					VARCHAR(100) 	NOT NULL PRIMARY KEY 
,hbs_company_name 		VARCHAR(200) 	NOT NULL
,city		 		VARCHAR(100) 	NULL
,pincode 			VARCHAR(10) 	NULL
,created_by 		VARCHAR(255) 	NOT NULL
,created 			BIGINT 			NOT NULL
,updated_by			VARCHAR(255) 	NULL          
,updated 			BIGINT 			NOT NULL DEFAULT 0 
);

CREATE TABLE hbs_user_details(
id VARCHAR(100) NOT NULL PRIMARY KEY
,user_name VARCHAR(250) NOT NULL UNIQUE
,first_name VARCHAR(250) NULL
,last_name VARCHAR(250) NULL
,password VARCHAR(250) NULL
,created_by VARCHAR(255) NOT NULL
,created BIGINT NOT NULL
,updated_by VARCHAR(255) NULL          
,updated BIGINT NOT NULL DEFAULT 0
);
INSERT INTO hbs_user_details(id, user_name, first_name, last_name,password, created_by, created) VALUES ('1', 'hbsadmin','HBS','Admin','hbsadmin', 'ADMIN', '1520252992361');


