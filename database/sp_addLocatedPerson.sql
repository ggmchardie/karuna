DELIMITER //

CREATE PROCEDURE sp_addLocatedPerson
(
	IN _surname				VARCHAR(255),
	IN _firstName			VARCHAR(255),
	IN _location			VARCHAR(255),
	IN _vitalStats			VARCHAR(20),
	IN _uploadedByUser	VARCHAR(255),
	IN _faceId			VARCHAR(255),
	IN _imageId			VARCHAR(255),
	IN _imageFileType	VARCHAR(25)
)

BEGIN

DECLARE _disasterId 		INT;
DECLARE _dateEntered 	DATETIME;

SELECT disasterId INTO _disasterId FROM tblDisaster
WHERE activeDisaster = 1 AND endDate IS NULL 
LIMIT 1;

SELECT NOW() INTO _dateEntered;

INSERT INTO tblLocatedPersons SET
	surname				= _surname,
	firstName			= _firstName,
	dateEntered			= _dateEntered,
	location			= _location,
	vitalStats			= _vitalStats,
	uploadedByUser		= _uploadedByUser,
	disasterId			= _disasterId,
	faceId				= _faceId,
	imageId				= _imageId,
	imageFileType		= _imageFileType;

END//

DELIMITER ;
