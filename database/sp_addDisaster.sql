DELIMITER $$

CREATE PROCEDURE sp_addDisaster
(
	IN	_locationName 		VARCHAR(255),
	IN	_latitude			DECIMAL(18,12),
	IN _longitude			DECIMAL(18,12),
	IN _affectedDistance	INT
)

BEGIN

INSERT INTO tblDisaster SET
	locationName 		= _locationName,
	latitude 			= IFNULL(_latitude, 0),
	longitude			= IFNULL(_longitude, 0),
	affectedDistance 	= _affectedDistance,
	startDate			= _startDate,
	endDate				= _endDate,
	activeDisaster		= _activeDisaster;

END$$

DELIMITER ;
