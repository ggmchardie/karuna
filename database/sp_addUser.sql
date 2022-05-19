DELIMITER $$

CREATE PROCEDURE sp_addUser
(
	IN _awsUserId			VARCHAR(255),
	IN _surname				VARCHAR(255),
	IN _firstName			VARCHAR(255),
	IN _emailAddress		VARCHAR(255),
	IN _accountType		VARCHAR(255),
	IN _accountStatus		VARCHAR(255)
)

BEGIN

DECLARE _accountType VARCHAR(255);
DECLARE _validEmail INT;


SELECT 1 INTO _validEmail FROM tblVerifiedOrganisations WHERE SUBSTR(_emailAddress, INSTR(_emailAddress, '@') + 1) = domainName;

SELECT 
	CASE 
		WHEN _validEmail = 1 THEN 'firstresponse'
		ELSE 'standard'
	END
	INTO _accountType;


INSERT INTO tblUsers SET
	awsUserId 			= _awsUserId,
	surname 			= _surname,
	firstName 			= _firstname,
	emailAddress	 	= _emailAddress,
	accountType 		= _accountType,
	accountStatus	 	= _accountStatus;

	
END$$

DELIMITER ;