DELIMITER $$

CREATE PROCEDURE sp_addVerifiedOrganisation
(
	IN _organisationName	VARCHAR(255),
	IN _domainName			VARCHAR(255),
	IN _mainContactName	VARCHAR(255),
	IN _mainContactEmail	VARCHAR(255),
	IN _mainContactPhone	VARCHAR(255),
	IN _address				VARCHAR(1023)
)

BEGIN

INSERT INTO tblVerifiedOrganisations SET
	organisationName			= _organisationName,
	domainName					= _domainName,
	mainContactName			= _mainContactName,
	mainContactEmail			= _mainContactEmail,
	mainContactPhone			= _mainContactPhone,
	address						= _address;

	
END$$

DELIMITER ;

