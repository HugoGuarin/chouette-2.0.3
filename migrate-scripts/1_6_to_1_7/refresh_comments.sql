
COMMENT ON TABLE chouette.company IS 'company operating a public transport service';
COMMENT ON COLUMN chouette.company.id IS 'Internal identification';
COMMENT ON COLUMN chouette.company.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.company.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.company.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.company.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.company."name" IS 'Name';
COMMENT ON COLUMN chouette.company.shortname IS 'Short name';
COMMENT ON COLUMN chouette.company.organizationalunit IS 'Organizational Unit';
COMMENT ON COLUMN chouette.company.operatingdepartmentname IS 'Operating department';
COMMENT ON COLUMN chouette.company.code IS 'Zip code';
COMMENT ON COLUMN chouette.company.phone IS 'Phone number';
COMMENT ON COLUMN chouette.company.fax IS 'FAX number';
COMMENT ON COLUMN chouette.company.email IS 'Email';
COMMENT ON COLUMN chouette.company.registrationnumber IS 'Registration number';

COMMENT ON TABLE chouette.connectionlink IS 'Connection link between 2 stopareas';
COMMENT ON COLUMN chouette.connectionlink.id IS 'Internal identification';
COMMENT ON COLUMN chouette.connectionlink.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.connectionlink.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.connectionlink.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.connectionlink.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.connectionlink."name" IS 'Name';
COMMENT ON COLUMN chouette.connectionlink."comment" IS 'Comment';
COMMENT ON COLUMN chouette.connectionlink.linkdistance IS 'Distance between StopAreas';
COMMENT ON COLUMN chouette.connectionlink.departureid IS 'Start stoparea internal id';
COMMENT ON COLUMN chouette.connectionlink.arrivalid IS 'End stoparea internal id';
COMMENT ON COLUMN chouette.connectionlink.liftavailability IS 'Indicate if a lift is available';
COMMENT ON COLUMN chouette.connectionlink.mobilityrestrictedsuitability IS 'Indicate if the link is suitable for mobility restricted persons';
COMMENT ON COLUMN chouette.connectionlink.stairsavailability IS 'Indicate if stairs are available';
COMMENT ON COLUMN chouette.connectionlink.defaultduration IS 'average duration of travel';
COMMENT ON COLUMN chouette.connectionlink.frequenttravellerduration IS 'duration of travel for frequent traveller';
COMMENT ON COLUMN chouette.connectionlink.occasionaltravellerduration IS 'duration of travel for occasional traveler';
COMMENT ON COLUMN chouette.connectionlink.mobilityrestrictedtravellerduration IS 'duration of travel for mobiliy restricted traveller';
COMMENT ON COLUMN chouette.connectionlink.linktype IS 'Type (Underground,Overground or Mixed)';
COMMENT ON COLUMN chouette.connectionlink.intuserneeds IS 'binary mapping of userNeed list';

COMMENT ON TABLE chouette.groupofline IS 'group of lines';
COMMENT ON COLUMN chouette.groupofline.id IS 'Internal identification';
COMMENT ON COLUMN chouette.groupofline.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.groupofline.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.groupofline.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.groupofline.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.groupofline."name" IS 'Name';
COMMENT ON COLUMN chouette.groupofline."comment" IS 'Comment';

COMMENT ON TABLE chouette.journeypattern IS 'Journey pattern';
COMMENT ON COLUMN chouette.journeypattern.id IS 'Internal identification';
COMMENT ON COLUMN chouette.journeypattern.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.journeypattern.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.journeypattern.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.journeypattern.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.journeypattern."name" IS 'Name';
COMMENT ON COLUMN chouette.journeypattern."comment" IS 'Comment';
COMMENT ON COLUMN chouette.journeypattern.registrationnumber IS 'Registration number';
COMMENT ON COLUMN chouette.journeypattern.publishedname IS 'Public name for travelers';
COMMENT ON COLUMN chouette.journeypattern.routeid IS 'Route Reference';

COMMENT ON TABLE chouette.journeypattern_stoppoint IS 'StopPoint on JourneyPattern cross reference';
COMMENT ON COLUMN chouette.journeypattern_stoppoint.journeypatternid IS 'JourneyPattern Reference';
COMMENT ON COLUMN chouette.journeypattern_stoppoint.stoppointid IS 'StopPoint Reference';

COMMENT ON TABLE chouette.line IS 'Public Transport Line';
COMMENT ON COLUMN chouette.line.id IS 'Internal identification';
COMMENT ON COLUMN chouette.line.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.line.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.line.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.line.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.line."name" IS 'Name';
COMMENT ON COLUMN chouette.line."comment" IS 'Comment';
COMMENT ON COLUMN chouette.line."number" IS 'Number of the line (characters)';
COMMENT ON COLUMN chouette.line.publishedname IS 'Public name for travelers';
COMMENT ON COLUMN chouette.line.registrationnumber IS 'Registration number';
COMMENT ON COLUMN chouette.line.transportmodename IS 'Transport Mode (Bus, Train, ...)';
COMMENT ON COLUMN chouette.line.mobilityrestrictedsuitable IS 'Indicate whenever the line is suitable for mobility restricted persons';
COMMENT ON COLUMN chouette.line.userneeds IS 'bit encoded list of userneeds enum value';
COMMENT ON COLUMN chouette.line.ptnetworkid IS 'PTNetwork reference';
COMMENT ON COLUMN chouette.line.companyid IS 'Company reference';
COMMENT ON COLUMN chouette.line.groupoflineid IS 'GroupOfLine reference';

COMMENT ON TABLE chouette.ptnetwork IS 'Public Transport Network';
COMMENT ON COLUMN chouette.ptnetwork.id IS 'Internal identification';
COMMENT ON COLUMN chouette.ptnetwork.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.ptnetwork.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.ptnetwork.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.ptnetwork.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.ptnetwork."name" IS 'Name';
COMMENT ON COLUMN chouette.ptnetwork."comment" IS 'Comment';
COMMENT ON COLUMN chouette.ptnetwork.versiondate IS 'PTNetwork version date';
COMMENT ON COLUMN chouette.ptnetwork.description IS 'description';
COMMENT ON COLUMN chouette.ptnetwork.registrationnumber IS 'Registration unique number';
COMMENT ON COLUMN chouette.ptnetwork.sourcename IS 'data producer name';
COMMENT ON COLUMN chouette.ptnetwork.sourceidentifier IS 'data producer identifier';

COMMENT ON TABLE chouette.route IS 'Route';
COMMENT ON COLUMN chouette.route.id IS 'Internal identification';
COMMENT ON COLUMN chouette.route.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.route.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.route.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.route.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.route."name" IS 'Name';
COMMENT ON COLUMN chouette.route."comment" IS 'Comment';
COMMENT ON COLUMN chouette.route.oppositerouteid IS 'Opposite route reference';
COMMENT ON COLUMN chouette.route.publishedname IS 'Published name';
COMMENT ON COLUMN chouette.route."number" IS 'Number';
COMMENT ON COLUMN chouette.route.direction IS 'Direction : North, East, ...';
COMMENT ON COLUMN chouette.route.wayback IS 'Orientation : A or R';
COMMENT ON COLUMN chouette.route.lineid IS 'Line reference';

COMMENT ON TABLE chouette.routingconstraints_lines IS 'Routing constraint applicable on lines';
COMMENT ON COLUMN chouette.routingconstraints_lines.lineid IS 'Line reference';
COMMENT ON COLUMN chouette.routingconstraints_lines.stopareaid IS 'Routing constraint reference';

COMMENT ON TABLE chouette.stoparea IS 'StopArea';
COMMENT ON COLUMN chouette.stoparea.id IS 'Internal identification';
COMMENT ON COLUMN chouette.stoparea.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.stoparea.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.stoparea.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.stoparea.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.stoparea."name" IS 'Name';
COMMENT ON COLUMN chouette.stoparea."comment" IS 'Comment';
COMMENT ON COLUMN chouette.stoparea.areatype IS 'Type of Area : BoardingPosition, Quay, CommercialStopPoint, StopPlace or ITL)';
COMMENT ON COLUMN chouette.stoparea.registrationnumber IS 'Registration number';
COMMENT ON COLUMN chouette.stoparea.nearesttopicname IS 'Nearest topic name';
COMMENT ON COLUMN chouette.stoparea.farecode IS 'Fare code';
COMMENT ON COLUMN chouette.stoparea.parentid IS '(deprecated) Main parent StopArea internal id for v1.6 compatibility';
COMMENT ON COLUMN chouette.stoparea.longitude IS 'Longitude';
COMMENT ON COLUMN chouette.stoparea.latitude IS 'Latitude';
COMMENT ON COLUMN chouette.stoparea.longlattype IS 'Model used for Longitude and Latitude (Standard, WGS84 or WGS92)';
COMMENT ON COLUMN chouette.stoparea.x IS 'X coordinate';
COMMENT ON COLUMN chouette.stoparea.y IS 'Y coordinate';
COMMENT ON COLUMN chouette.stoparea.projectiontype IS 'Projection used for coordinates';
COMMENT ON COLUMN chouette.stoparea.countrycode IS 'Zip code';
COMMENT ON COLUMN chouette.stoparea.streetname IS 'Address';

COMMENT ON TABLE chouette.stopareastoparea IS 'StopArea hierarchical graph';
COMMENT ON COLUMN chouette.stopareastoparea.childid IS 'Child reference in hierarchy';
COMMENT ON COLUMN chouette.stopareastoparea.parentid IS 'Parent reference in hierarchy';

COMMENT ON TABLE chouette.stoppoint IS 'stop point on route';
COMMENT ON COLUMN chouette.stoppoint.id IS 'Internal identification';
COMMENT ON COLUMN chouette.stoppoint.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.stoppoint.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.stoppoint.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.stoppoint.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.stoppoint."position" IS 'Rank of stop point in route';
COMMENT ON COLUMN chouette.stoppoint.stopareaid IS 'StopArea reference';
COMMENT ON COLUMN chouette.stoppoint.routeid IS 'Route reference';

COMMENT ON TABLE chouette.timetable IS 'Timetables';
COMMENT ON COLUMN chouette.timetable.id IS 'Internal identification';
COMMENT ON COLUMN chouette.timetable.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.timetable.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.timetable.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.timetable.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.timetable."comment" IS 'Comment';
COMMENT ON COLUMN chouette.timetable."version" IS 'version';
COMMENT ON COLUMN chouette.timetable.intdaytypes IS 'coded DayTypeEnum list (Monday,Tuesday, ...)';

COMMENT ON TABLE chouette.timetable_date IS 'Applicable Calendar days for Timetable';
COMMENT ON COLUMN chouette.timetable_date.timetableid IS 'timetable foreign key';
COMMENT ON COLUMN chouette.timetable_date.date IS 'calendar date';
COMMENT ON COLUMN chouette.timetable_date."position" IS 'order of date';

COMMENT ON TABLE chouette.timetable_period IS 'Applicable Periods for Timetable';
COMMENT ON COLUMN chouette.timetable_period.timetableid IS 'timetable foreign key';
COMMENT ON COLUMN chouette.timetable_period.periodstart IS 'start date of period';
COMMENT ON COLUMN chouette.timetable_period.periodend IS 'end date of period';
COMMENT ON COLUMN chouette.timetable_period."position" IS 'order of date';

COMMENT ON TABLE chouette.timetablevehiclejourney IS 'Timetable on Vehicle journeys cross reference';
COMMENT ON COLUMN chouette.timetablevehiclejourney.timetableid IS 'Timetable foreign key';
COMMENT ON COLUMN chouette.timetablevehiclejourney.vehiclejourneyid IS 'VehicleJourney foreign key';

COMMENT ON TABLE chouette.vehiclejourney IS 'Vehicle journey';
COMMENT ON COLUMN chouette.vehiclejourney.id IS 'Internal identification';
COMMENT ON COLUMN chouette.vehiclejourney.objectid IS 'Neptune identification';
COMMENT ON COLUMN chouette.vehiclejourney.objectversion IS 'Version of this object';
COMMENT ON COLUMN chouette.vehiclejourney.creationtime IS 'Creation date and time';
COMMENT ON COLUMN chouette.vehiclejourney.creatorid IS 'Creator identification';
COMMENT ON COLUMN chouette.vehiclejourney."comment" IS 'Comment';
COMMENT ON COLUMN chouette.vehiclejourney.statusvalue IS 'Service Status';
COMMENT ON COLUMN chouette.vehiclejourney.transportmode IS 'Transport mode';
COMMENT ON COLUMN chouette.vehiclejourney.publishedjourneyname IS 'Name for travelers';
COMMENT ON COLUMN chouette.vehiclejourney.publishedjourneyidentifier IS 'Identifier for travelers';
COMMENT ON COLUMN chouette.vehiclejourney.facility IS 'facility';
COMMENT ON COLUMN chouette.vehiclejourney.vehicletypeidentifier IS 'Vehicle type';
COMMENT ON COLUMN chouette.vehiclejourney."number" IS 'Number of the vehicle journey';
COMMENT ON COLUMN chouette.vehiclejourney.routeid IS 'Route foreign key';
COMMENT ON COLUMN chouette.vehiclejourney.journeypatternid IS 'JourneyPattern foreign key';
COMMENT ON COLUMN chouette.vehiclejourney.timeslotid IS 'TimeSlot foreign key';
COMMENT ON COLUMN chouette.vehiclejourney.companyid IS 'Company foreign key';

COMMENT ON TABLE chouette.vehiclejourneyatstop IS 'Vehicle Journey at Stop';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.vehiclejourneyid IS 'VehicleJourney foreign key (1st part of primary key)';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.stoppointid IS 'StopPoint foreign key (2nd part of primary key)';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.connectingserviceid IS 'connectingServiceId';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.boardingalightingpossibility IS 'boardingAlightingPossibility';
COMMENT ON COLUMN chouette.vehiclejourneyatstop."position" IS 'order in JourneyPattern';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.arrivaltime IS 'Arrival time';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.departuretime IS 'Departure time';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.waitingtime IS 'Waiting time';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.elapseduration IS 'elapse duration';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.headwayfrequency IS 'headway frequency';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.isdeparture IS 'First stop of the vehicle journey';
COMMENT ON COLUMN chouette.vehiclejourneyatstop.isarrival IS 'Last stop of the vehicle journey';

