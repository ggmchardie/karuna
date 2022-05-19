#8172d383-01e0-4967-b4ac-247cdf45491a

CREATE TABLE tblUsers
(
	awsUserId			VARCHAR(255) PRIMARY KEY,
	surname				VARCHAR(255),
	firstName			VARCHAR(255),
	emailAddress		VARCHAR(255),
	accountType			ENUM('standard','firstresponse'),
	accountStatus		ENUM('active','inactive')
);


CREATE TABLE tblDisaster
(
	disasterId			INT AUTO_INCREMENT PRIMARY KEY,
	locationName		VARCHAR(255),
	latitude				DECIMAL(18,12),
	longitude			DECIMAL(18,12),
	affectedDistance	INT,
	startDate			DATETIME,
	endDate				DATETIME,
	activeDisaster		BIT
);	
	
	
CREATE TABLE tblLocatedPersons
(
	personId				INT AUTO_INCREMENT PRIMARY KEY,
	surname				VARCHAR(255),
	firstName			VARCHAR(255),
	dateEntered			DATETIME,
	location				VARCHAR(255),
	vitalStats			ENUM('alive','deceased'),
	uploadedByUser		VARCHAR(255),
	disasterId			INT,
	awsFaceId			VARCHAR(255),
	awsS3URL				VARCHAR(1023),
	CONSTRAINT `fk_awsUserId`
   FOREIGN KEY (uploadedByUser) REFERENCES tblUsers (awsUserId),
   CONSTRAINT `fk_disasterId`
   FOREIGN KEY (disasterId) REFERENCES tblDisaster (disasterId)
);


CREATE TABLE tblVerifiedOrganisations
(
	orgId					INT AUTO_INCREMENT PRIMARY KEY,
	organisationName	VARCHAR(255),
	domainName			VARCHAR(255),
	mainContactName	VARCHAR(255),
	mainContactEmail	VARCHAR(255),
	mainContactPhone	VARCHAR(255),
	address				VARCHAR(1023)
);

