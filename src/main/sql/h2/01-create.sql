DROP ALL OBJECTS;

CREATE TABLE role (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	ROLE_NAME varchar(100) NOT NULL,
	PRIMARY KEY (id),
	constraint role_unique_1 unique (role_name)
);

CREATE TABLE roleMembre (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	role varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE membrePPAF (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(100) NOT NULL,
	prenom varchar(100) NOT NULL,
	numeroTelephone1 varchar(100)  NULL,
	numeroTelephone2 varchar(100)  NULL,
	email varchar(100) NULL,
	actif bool NOT NULL,
	note TEXT NULL,
	rue varchar(100)  NULL,
	ville varchar(100)  NULL,
	codePostal varchar(100)  NULL,
	infoSuppl TEXT  NULL,
	roleMembre_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_MEMBREPPAF_ROLEMEMBRE FOREIGN KEY (roleMembre_id) REFERENCES roleMembre (id)
);


CREATE TABLE utilisateur (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	login varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
	email varchar(100) NOT NULL, 
	rue varchar(100) NULL,
	ville varchar(100) NULL,
	codePostal varchar(100) NULL,
	infoSuppl TEXT  NULL,
	membrePPAF_id INTEGER(10) NULL,
	actif bool NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_UTILISATEUR_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
 );


 CREATE TABLE utilisateur_role (
    utilisateur_id INTEGER(10) not null,
    role_id INTEGER(10) not null,
    constraint utilisateur_role_fk_1 foreign key (utilisateur_id) references utilisateur,
    constraint utilisateur_role_fk_2 foreign key (role_id) references ROLE,
    primary key (utilisateur_id, role_id)
);


CREATE TABLE item (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE contact (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(100) NOT NULL,
	prenom varchar(100) NOT NULL,
	numeroTelephone1 varchar(100)  NULL,
	numeroTelephone2 varchar(100)  NULL,
	email varchar(100)  NULL,
	actif bool NOT NULL,
	note TEXT NULL,
	rue varchar(100)  NULL,
	ville varchar(100)  NULL,
	codePostal varchar(100)  NULL,
	infoSuppl TEXT  NULL,
	PRIMARY KEY (id)
);

CREATE TABLE suiviContact (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	dateProchainAppel DATE NULL,
	note TEXT NULL,
	contact_id INTEGER(10) NOT NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_SUIVICONTACT_CONTACT FOREIGN KEY (contact_id) REFERENCES contact (id),
	CONSTRAINT FK_SUIVICONTACT_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);

CREATE TABLE lieuDeDepot (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	numeroTelephone1 varchar(100)  NULL,
	numeroTelephone2 varchar(100)  NULL,
	rue varchar(100)  NULL,
	ville varchar(100)  NULL,
	codePostal varchar(100)  NULL,
	infoSuppl TEXT  NULL,
	type varchar(100)  NULL,
	PRIMARY KEY (id)
);

CREATE TABLE suiviDuLieuDeDepot (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	note TEXT NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	lieuDeDepot_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_SUIVIDULIEUDEDEPOT_LIEUDEDEPOT FOREIGN KEY (lieuDeDepot_id) REFERENCES lieuDeDepot (id),
	CONSTRAINT FK_SUIVIDULIEUDEDEPOT_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);                
                  
CREATE TABLE lieuDeStockage (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	membrePPAFResponsable_id INTEGER(10) NOT NULL,
	rue varchar(100)  NULL,
	ville varchar(100)  NULL,
	codePostal varchar(100)  NULL,
	infoSuppl TEXT  NULL,
	note TEXT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_LIEUDESTOCKAGE_MEMBREPPAF FOREIGN KEY (membrePPAFResponsable_id) REFERENCES membrePPAF (id)
);                
                  
CREATE TABLE itemLieuDeStockage (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	quantite INTEGER(10) NOT NULL,
	item_id INTEGER(10) NOT NULL,
	lieuDeStockage_id INTEGER(10) NOT NULL,
	note TEXT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_ITEMLIEUDESTOCKAGE_LIEUSTOCKAGE FOREIGN KEY (lieuDeStockage_id) REFERENCES lieuDeStockage (id),
	CONSTRAINT FK_ITEMLIEUDESTOCKAGE_ITEM FOREIGN KEY (item_id) REFERENCES item (id)
);                
                  
CREATE TABLE itemLieuDeDepot (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	quantite INTEGER(10) NOT NULL,
	prixUnitaire INTEGER(10) NOT NULL,
	item_id INTEGER(10) NOT NULL,
	contact_id INTEGER(10) NOT NULL,
	lieuDeDepot_id INTEGER(10) NOT NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	note TEXT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_ITEMLIEUDEDEPOT_ITEM FOREIGN KEY (item_id) REFERENCES item (id),
	CONSTRAINT FK_ITEMLIEUDEDEPOT_CONTACT FOREIGN KEY (contact_id) REFERENCES contact (id),
	CONSTRAINT FK_ITEMLIEUDEDEPOT_LIEUDEDEPOT FOREIGN KEY (lieuDeDepot_id) REFERENCES lieuDeDepot (id),
	CONSTRAINT FK_ITEMLIEUDEDEPOT_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);

INSERT INTO utilisateur (id, login, password, email, actif) VALUES (1, 'admin', 'admin', 'admin@example.com', true);

INSERT INTO role (id,role_name) VALUES (1,'ROLE_ADMIN');
INSERT INTO role (id,role_name) VALUES (2,'ROLE_USER');

INSERT INTO utilisateur_role (utilisateur_id, role_id) VALUES (1, 1);

