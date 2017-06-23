/**
 * Projet CHOUETTE
 *
 * ce projet est sous license libre
 * voir LICENSE.txt pour plus de details
 *
 */
package fr.certu.chouette.model.neptune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import fr.certu.chouette.core.CoreExceptionCode;
import fr.certu.chouette.core.CoreRuntimeException;
import fr.certu.chouette.filter.Filter;
import fr.certu.chouette.model.neptune.type.ChouetteAreaEnum;
import fr.certu.chouette.model.neptune.type.ImportedItems;
import fr.certu.chouette.model.neptune.type.TransportModeNameEnum;
import fr.certu.chouette.model.neptune.type.UserNeedEnum;

/**
 * Neptune Line
 * <p/>
 * Note for fields comment : <br/>
 * when readable is added to comment, a implicit getter is available <br/>
 * when writable is added to comment, a implicit setter is available
 */
@NoArgsConstructor
public class Line extends NeptuneIdentifiedObject
{
	private static final long     serialVersionUID           = -8086291270595894778L;
	// constant for persistence fields
	/**
	 * name of comment attribute for {@link Filter} attributeName construction
	 */
	public static final String    COMMENT                    = "comment";
	/**
	 * name of number attribute for {@link Filter} attributeName construction
	 */
	public static final String    NUMBER                     = "number";
	/**
	 * name of publishedName attribute for {@link Filter} attributeName
	 * construction
	 */
	public static final String    PUBLISHEDNAME              = "publishedName";
	/**
	 * name of registrationNumber attribute for {@link Filter} attributeName
	 * construction
	 */
	public static final String    REGISTRATIONNUMBER         = "registrationNumber";
	/**
	 * name of transportModeName attribute for {@link Filter} attributeName
	 * construction
	 */
	public static final String    TRANSPORTMODENAME          = "transportModeName";
	/**
	 * name of mobilityRestrictedSuitable attribute for {@link Filter}
	 * attributeName construction
	 */
	public static final String    MOBILITYRESTRICTEDSUITABLE = "mobilityRestrictedSuitable";
	/**
	 * name of userNeedsAsLong attribute for {@link Filter} attributeName
	 * construction
	 * <p>
	 * needs bitwise comparison
	 */
	public static final String    USERNEEDS                  = "userNeedsAsLong";
	/**
	 * name of ptNetwork attribute for {@link Filter} attributeName construction
	 */
	public static final String    PTNETWORK                  = "ptNetwork";
	/**
	 * name of company attribute for {@link Filter} attributeName construction
	 */
	public static final String    COMPANY                    = "company";
	/**
	 * name of routes attribute for {@link Filter} attributeName construction
	 */
	public static final String    ROUTES                     = "routes";
	/**
	 * name of groupOfLine attribute for {@link Filter} attributeName
	 * construction
	 */
	public static final String    GROUPOFLINE                = "groupOfLines";
	/**
	 * Number of the line (characters) <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private String                number;
	/**
	 * Public name for travellers <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private String                publishedName;
	/**
	 * Transport Mode (Bus, Train, ...) <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private TransportModeNameEnum transportModeName;
	/**
	 * Registration number <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private String                registrationNumber;
	/**
	 * Comment <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private String                comment;
	/**
	 * Neptune identification referring to the line's network <br/>
	 * <i>readable/writable</i>
	 * 
	 */
	@Getter
	@Setter
	private String                ptNetworkIdShortcut;
	/**
	 * Neptune identification referring to the line's routes <br/>
	 * for import/export purpose <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<String>          routeIds;
	/**
	 * Neptune identification referring to the departures/arrivals stoppoints of
	 * the line's JourneyPatterns<br/>
	 * Meaningless after database read <br/>
	 * for import/export purpose <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<String>          lineEnds;
	/**
	 * The line's network object <br/>
	 * for import/export purpose <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private PTNetwork             ptNetwork;
	/**
	 * The line's company object <br/>
	 * <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private Company               company;
	/**
	 * The line's companies objects <br/>
	 * <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<Company>         companies;
	/**
	 * The line's route objects <br/>
	 * <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<Route>           routes;
	/**
	 * Indicate whenever the line is suitable for mobility restricted persons <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private Boolean               mobilityRestrictedSuitable;
	/**
	 * List of the specific user needs available <br/>
	 * <i>readable/writable</i>
	 */
	private List<UserNeedEnum>    userNeeds;

	/**
	 * encoded form of userNeeds for database purpose
	 */
	@Getter
	@Setter
	private Integer                intUserNeeds;                           // BD

	/**
	 * The optional GroupOfLine of the line <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<GroupOfLine>           groupOfLines;

	/**
	 * The GroupOfLinesId of the line <br/>
	 * for import/export purpose <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<String>            groupOfLineIds;

	/**
	 * The optional RoutingConstraints of the line
	 * <p>
	 * RoutingConstraints are {@link StopArea} of {@link ChouetteAreaEnum}.ITL
	 * areaType <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<StopArea>        routingConstraints;

	/**
	 * The optional RoutingConstraint objectIds of the line
	 * <p>
	 * RoutingConstraints are {@link StopArea} of {@link ChouetteAreaEnum}.ITL
	 * areaType <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<String>          routingConstraintIds;

	/**
	 * ImportedItems for import neptune process
	 */
	@Getter
	@Setter
	private ImportedItems         importedItems;

	/**
	 * list of facilities <br/>
	 * <i>readable/writable</i>
	 */
	@Getter
	@Setter
	private List<Facility>        facilities;

	/**
	 * List of journeyPatterns 
	 * filled only after complete() call
	 */
	@Getter private List<JourneyPattern> journeyPatterns; 

	/**
	 * List of vehicleJourneys
	 * filled only after complete() call
	 */
	@Getter private List<VehicleJourney> vehicleJourneys; 

	/**
	 * List of timetables
	 * filled only after complete() call
	 */
	@Getter private List<Timetable> timetables; 

	/**
	 * List of stopPoints
	 * filled only after complete() call
	 */
	@Getter private List<StopPoint> stopPoints; 

	/**
	 * List of stopAreas (excluded RoutingConstraints)
	 * filled only after complete() call
	 */
	@Getter private List<StopArea> stopAreas;

	/**
	 * List of boardingPositions
	 * filled only after complete() call
	 */
	@Getter private List<StopArea> boardingPositions;

	/**
	 * List of quays
	 * filled only after complete() call
	 */
	@Getter private List<StopArea> quays;

	/**
	 * List of commercialStopPoints
	 * filled only after complete() call
	 */
	@Getter private List<StopArea> commercialStopPoints;

	/**
	 * List of stopPlaces
	 * filled only after complete() call
	 */
	@Getter private List<StopArea> stopPlaces;

	/**
	 * List of accessLinks
	 * filled only after complete() call
	 */
	@Getter private List<AccessLink> accessLinks;

	/**
	 * List of accessPoints
	 * filled only after complete() call
	 */
	@Getter private List<AccessPoint> accessPoints;

	/**
	 * List of connectionLinks
	 * filled only after complete() call
	 */
	@Getter private List<ConnectionLink> connectionLinks;


	/**
	 * @param groupOfLine
	 */
	public void addGroupOfLine(GroupOfLine groupOfLine)
	{
		if (groupOfLines == null)
			groupOfLines = new ArrayList<GroupOfLine>();
		if (!groupOfLines.contains(groupOfLine))
			groupOfLines.add(groupOfLine);
	}

	/**
	 * @param groupOfLine
	 */
	public void removeGroupOfLine(GroupOfLine groupOfLine)
	{
		if (groupOfLines == null)
			groupOfLines = new ArrayList<GroupOfLine>();
		if (groupOfLines.contains(groupOfLine))
			groupOfLines.remove(groupOfLine);
	}
	/**
	 * @param facility
	 */
	public void addGroupOfLineId(String groupOfLineId)
	{
		if (groupOfLineIds == null)
			groupOfLineIds = new ArrayList<String>();
		if (!groupOfLineIds.contains(groupOfLineId))
			groupOfLineIds.add(groupOfLineId);
	}

	/**
	 * @param facility
	 */
	public void addFacility(Facility facility)
	{
		if (facilities == null)
			facilities = new ArrayList<Facility>();
		if (!facilities.contains(facility))
			facilities.add(facility);
	}

	/**
	 * @param facility
	 */
	public void removeFacility(Facility facility)
	{
		if (facilities == null)
			facilities = new ArrayList<Facility>();
		if (facilities.contains(facility))
			facilities.remove(facility);
	}

	/**
	 * add a userNeed value in userNeeds collection if not already present <br/>
	 * intUserNeeds will be automatically synchronized <br/>
	 * <i>readable/writable</i>
	 * 
	 * @param userNeed
	 *           the userNeed to add
	 */
	public void addUserNeed(UserNeedEnum userNeed)
	{
		if (userNeeds == null)
			userNeeds = new ArrayList<UserNeedEnum>();
		if (!userNeeds.contains(userNeed))
		{
			userNeeds.add(userNeed);
			synchronizeUserNeeds();
		}
	}

	/**
	 * add a collection of userNeed values in userNeeds collection if not already
	 * present <br/>
	 * intUserNeeds will be automatically synchronized
	 * 
	 * @param userNeedCollection
	 *           the userNeeds to add
	 */
	public void addAllUserNeed(Collection<UserNeedEnum> userNeedCollection)
	{
		if (userNeeds == null)
			userNeeds = new ArrayList<UserNeedEnum>();
		boolean added = false;
		for (UserNeedEnum userNeed : userNeedCollection)
		{
			if (!userNeeds.contains(userNeed))
			{
				userNeeds.add(userNeed);
				added = true;
			}
		}
		if (added)
		{
			synchronizeUserNeeds();
		}
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.certu.chouette.model.neptune.NeptuneIdentifiedObject#toString(java.
	 * lang.String, int)
	 */
	@Override
	public String toString(String indent, int level)
	{
		StringBuilder sb = new StringBuilder(super.toString(indent, level));
		sb.append("\n").append(indent).append("  ptNetworkIdShortcut = ").append(ptNetworkIdShortcut);
		sb.append("\n").append(indent).append("  number = ").append(number);
		sb.append("\n").append(indent).append("  publishedName = ").append(publishedName);
		sb.append("\n").append(indent).append("  transportModeName = ").append(transportModeName);
		sb.append("\n").append(indent).append("  registrationNumber = ").append(registrationNumber);
		sb.append("\n").append(indent).append("  comment = ").append(comment);
		sb.append("\n").append(indent).append("  mobilityRestrictedSuitable = ").append(mobilityRestrictedSuitable);
		sb.append("\n").append(indent).append("  routes count = ").append(routes == null?0:routes.size());
		sb.append("\n").append(indent).append("  routingConstraints count= ").append(routingConstraints == null?0:routingConstraints.size());
		if (lineEnds != null)
		{
			sb.append("\n").append(indent).append(CHILD_ARROW).append("lineEnds");
			for (String lineEnd : getLineEnds())
			{
				sb.append("\n").append(indent).append(CHILD_LIST_ARROW).append(lineEnd);
			}
		}
		if (routeIds != null)
		{
			sb.append("\n").append(indent).append(CHILD_ARROW).append("routeIds");
			for (String routeid : getRouteIds())
			{
				sb.append("\n").append(indent).append(CHILD_LIST_ARROW).append(routeid);
			}
		}
		if (userNeeds != null)
		{
			sb.append("\n").append(indent).append(CHILD_ARROW).append("userNeeds");
			for (UserNeedEnum userNeed : getUserNeeds())
			{
				sb.append("\n").append(indent).append(CHILD_LIST_ARROW).append(userNeed);
			}
		}

		if (routingConstraintIds != null)
		{
			sb.append("\n").append(indent).append(CHILD_ARROW).append("routingConstraintIds");
			for (String routingConstraintId : getRoutingConstraintIds())
			{
				sb.append("\n").append(indent).append(CHILD_LIST_ARROW).append(routingConstraintId);
			}
		}

		if (level > 0)
		{
			int childLevel = level - 1;
			String childIndent = indent + CHILD_INDENT;
			if (getPtNetwork() != null)
			{
				sb.append("\n").append(indent).append(CHILD_ARROW).append(ptNetwork.toString(childIndent, 0));
			}
			if (getCompany() != null)
			{
				sb.append("\n").append(indent).append(CHILD_ARROW).append(company.toString(childIndent, 0));
			}
			childIndent = indent + CHILD_LIST_INDENT;
			if (getRoutes() != null)
			{
				sb.append("\n").append(indent).append(CHILD_ARROW).append("routes");
				for (Route route : getRoutes())
				{
					sb.append("\n").append(indent).append(CHILD_LIST_ARROW).append(route.toString(childIndent, childLevel));
				}
			}
			if (routingConstraints != null)
			{
				sb.append("\n").append(indent).append(CHILD_ARROW).append("routingConstraints");
				for (StopArea routing : getRoutingConstraints())
				{
					sb.append("\n").append(indent).append(CHILD_LIST_ARROW).append(routing.toString(childIndent, childLevel));
				}
			}

		}

		return sb.toString();
	}

	/**
	 * add a route to the line
	 * 
	 * @param route
	 *           the route to be added
	 */
	public void addRoute(Route route)
	{
		if (routes == null)
			routes = new ArrayList<Route>();
		if (routes.contains(route)) return;
		if (route != null)
		{
			routes.add(route);
			route.setLine(this);
		}
	}

	/**
	 * remove a route from the line
	 * 
	 * @param index
	 *           of the route to be removed
	 */
	public void removeRoute(int index)
	{
		if (routes == null)
			routes = new ArrayList<Route>();
		if (index < routes.size())
		{
			Route deleted = routes.remove(index);
			if (deleted != null)
				removeRouteId(deleted.getObjectId());
		}
	}

	/**
	 * remove a route from the line
	 * 
	 * @param route
	 *           the route to be removed
	 */
	public void removeRoute(Route route)
	{
		if (routes == null)
			routes = new ArrayList<Route>();
		if (routes.remove(route))
		{
			removeRouteId(route.getObjectId());
		}
	}

	/**
	 * remove a route from the line
	 * 
	 * @param routeId
	 *           the route objectId to be removed
	 */
	public void removeRoute(String routeId)
	{
		if (routes == null)
			routes = new ArrayList<Route>();
		for (Iterator<Route> iterator = routes.iterator(); iterator.hasNext();)
		{
			Route route = iterator.next();
			if (routeId.equals(route.getObjectId()))
			{
				removeRouteId(routeId);
				iterator.remove();
				break;
			}
		}
	}

	/**
	 * add a routeid to the line
	 * 
	 * @param routeId
	 *           the routeId to add
	 */
	public void addRouteId(String routeId)
	{
		if (routeIds == null)
			routeIds = new ArrayList<String>();
		routeIds.add(routeId);
	}

	/**
	 * remove a routeid to the line
	 * 
	 * @param routeId
	 *           the routeId to add
	 */
	public void removeRouteId(String routeId)
	{
		if (routeIds == null)
			routeIds = new ArrayList<String>();
		routeIds.remove(routeId);
	}

	/**
	 * add a lienEndid to the line
	 * 
	 * @param lineEndId
	 */
	public void addLineEnd(String lineEndId)
	{
		if (lineEnds == null)
			lineEnds = new ArrayList<String>();
		lineEnds.add(lineEndId);
	}

	/**
	 * add a routing constraint
	 * 
	 * @param routingConstraint
	 */
	public void addRoutingConstraint(StopArea routingConstraint)
	{
		if (routingConstraints == null)
			routingConstraints = new ArrayList<StopArea>();
		if (!routingConstraint.getAreaType().equals(ChouetteAreaEnum.ITL))
		{
			// routingConstraint must be of ITL type
			throw new CoreRuntimeException(CoreExceptionCode.UNVALID_TYPE, routingConstraint.getAreaType().toString(),
					STOPAREA_KEY, "routingConstraints");
		}
		if (routingConstraint != null && !routingConstraints.contains(routingConstraint))
			routingConstraints.add(routingConstraint);

	}

	/**
	 * remove a routing constraint
	 * 
	 * @param routingConstraint
	 */
	public void removeRoutingConstraint(StopArea routingConstraint)
	{
		if (routingConstraints == null)
			routingConstraints = new ArrayList<StopArea>();
		if (routingConstraint != null && routingConstraints.contains(routingConstraint))
			routingConstraints.remove(routingConstraint);

	}

	/**
	 * add a routing constraint id
	 * 
	 * @param routingConstraintId
	 */
	public void addRoutingConstraintId(String routingConstraintid)
	{
		if (routingConstraintIds == null)
			routingConstraintIds = new ArrayList<String>();
		if (routingConstraintid != null && !routingConstraintIds.contains(routingConstraintid))
			routingConstraintIds.add(routingConstraintid);

	}

	/**
	 * remove a routing constraint id
	 * 
	 * @param routingConstraintId
	 */
	public void removeRoutingConstraintId(String routingConstraintId)
	{
		if (routingConstraintIds == null)
			routingConstraintIds = new ArrayList<String>();
		if (routingConstraintId != null && routingConstraintIds.contains(routingConstraintId))
			routingConstraintIds.remove(routingConstraintId);

	}

	/**
	 * return lineEndList built with PTLink relationship
	 * <p/>
	 * line must be loaded form database with DetailLevel of
	 * STRUCTURAL_DEPENDENCIES minimun for this method to operate
	 * <p/>
	 * This method does not refresh lineEnds
	 */
	public List<StopPoint> getLineEndList()
	{
		List<StopPoint> stopPoints = new ArrayList<StopPoint>();
		if (routes != null)
		{
			for (Route route : routes)
			{
				if (route.getPtLinks() != null)
				{
					Set<String> startStopPoints = new HashSet<String>();
					Set<String> endStopPoints = new HashSet<String>();
					for (PTLink link : route.getPtLinks())
					{
						if (link.getStartOfLink() != null)
							startStopPoints.add(link.getStartOfLink().getObjectId());
						if (link.getEndOfLink() != null)
							endStopPoints.add(link.getEndOfLink().getObjectId());
					}
					for (PTLink link : route.getPtLinks())
					{
						StopPoint start = link.getStartOfLink();
						if (start != null)
						{
							if (!endStopPoints.contains(start.getObjectId()))
							{
								stopPoints.add(start);
							}
						}
						StopPoint end = link.getStartOfLink();
						if (end != null)
						{
							if (!startStopPoints.contains(end.getObjectId()))
							{
								stopPoints.add(end);
							}
						}
					}
				}
			}
		}
		return stopPoints;
	}

	/**
	 * return stopPointList built with JourneyPattern relationship
	 * <p/>
	 * line must be loaded form database with DetailLevel of
	 * STRUCTURAL_DEPENDENCIES minimun for this method to operate
	 * <p/>
	 * This method does not refresh anything
	 */
	public List<StopPoint> getStopPointList()
	{
		Set<StopPoint> stopPoints = new HashSet<StopPoint>();
		if (routes != null)
		{
			for (Route route : routes)
			{
				if (route.getJourneyPatterns() != null)
				{
					for (JourneyPattern jp : route.getJourneyPatterns())
					{
						if (jp.getStopPoints() != null)
						{
							stopPoints.addAll(jp.getStopPoints());
						}
					}
				}
			}
		}
		return Arrays.asList(stopPoints.toArray(new StopPoint[0]));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.certu.chouette.model.neptune.NeptuneIdentifiedObject#clean()
	 */
	@Override
	public boolean clean()
	{
		if (routes == null)
		{
			return false;
		}
		for (Iterator<Route> iterator = routes.iterator(); iterator.hasNext();)
		{
			Route route = iterator.next();
			if (route == null || !route.clean())
			{
				iterator.remove();
			}
		}
		if (routes.isEmpty())
		{
			return false;
		}
		return true;
	}

	/**
	 * get UserNeeds list
	 * 
	 * @return userNeeds
	 */
	public List<UserNeedEnum> getUserNeeds()
	{
		if (intUserNeeds == null)
			return userNeeds;

		UserNeedEnum[] userNeedEnums = UserNeedEnum.values();
		for (UserNeedEnum userNeedEnum : userNeedEnums)
		{
			int filtre = (int) Math.pow(2, userNeedEnum.ordinal());
			if (filtre == (intUserNeeds.intValue() & filtre))
			{
				addUserNeed(userNeedEnum);
			}
		}
		return userNeeds;
	}

	/**
	 * set the userNeeds list <br/>
	 * intUserNeeds will be automatically synchronized
	 * 
	 * @param userNeedEnums
	 *           list of UserNeeds to set
	 */
	public void setUserNeeds(List<UserNeedEnum> userNeedEnums)
	{
		userNeeds = userNeedEnums;

		synchronizeUserNeeds();
	}

	/**
	 * synchronize intUserNeeds with userNeeds List content
	 */
	private void synchronizeUserNeeds()
	{
		intUserNeeds = 0;
		if (userNeeds == null)
			return;

		for (UserNeedEnum userNeedEnum : userNeeds)
		{
			intUserNeeds += (int) Math.pow(2, userNeedEnum.ordinal());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.certu.chouette.model.neptune.NeptuneIdentifiedObject#complete()
	 */
	@Override
	public synchronized void complete()
	{
		if (isCompleted())
			return;
		super.complete();

		journeyPatterns = new ArrayList<JourneyPattern>(); 
		vehicleJourneys = new ArrayList<VehicleJourney>(); 
		timetables = new ArrayList<Timetable>(); 
		stopPoints = new ArrayList<StopPoint>(); 
		stopAreas = new ArrayList<StopArea>();
		boardingPositions = new ArrayList<StopArea>();
		quays = new ArrayList<StopArea>();
		commercialStopPoints = new ArrayList<StopArea>();
		stopPlaces = new ArrayList<StopArea>();
		accessLinks = new ArrayList<AccessLink>();
		accessPoints = new ArrayList<AccessPoint>();
		connectionLinks = new ArrayList<ConnectionLink>();

		Set<Timetable> timetableSet = new HashSet<Timetable>(); 
		Set<StopArea> stopAreaSet = new HashSet<StopArea>();
		Set<AccessPoint> accessPointSet = new HashSet<AccessPoint>();
		Set<ConnectionLink> connectionLinkSet = new HashSet<ConnectionLink>();

		// ptNetworkShortcut
		PTNetwork ptNetwork = getPtNetwork();
		if (ptNetwork != null)
		{
			setPtNetworkIdShortcut(ptNetwork.getObjectId());
		}

		// groupOfLine
		if (getGroupOfLines() != null)
		{
			for (GroupOfLine groupOfLine : getGroupOfLines())
			{
				addGroupOfLineId(groupOfLine.getObjectId());
				groupOfLine.addLineId(getObjectId());
			}

		}

		// lineEndIds, journeys and stopPoints
		List<Route> routes = getRoutes();
		if (routes != null)
		{
			for (Route route : routes)
			{
				route.complete();
				if (route.getPtLinks() != null)
				{
					Set<String> startStopPoints = new HashSet<String>();
					Set<String> endStopPoints = new HashSet<String>();
					for (PTLink link : route.getPtLinks())
					{
						if (link.getStartOfLink() != null)
							startStopPoints.add(link.getStartOfLink().getObjectId());
						if (link.getEndOfLink() != null)
							endStopPoints.add(link.getEndOfLink().getObjectId());
					}
					for (PTLink link : route.getPtLinks())
					{
						StopPoint start = link.getStartOfLink();
						if (start != null)
						{
							if (!endStopPoints.contains(start.getObjectId()))
							{
								addLineEnd(start.getObjectId());
							}
						}
						StopPoint end = link.getEndOfLink();
						if (end != null)
						{
							if (!startStopPoints.contains(end.getObjectId()))
							{
								addLineEnd(end.getObjectId());
							}
						}
					}
				}
				if (route.getJourneyPatterns() != null)
					journeyPatterns.addAll(route.getJourneyPatterns());
				if (route.getStopPoints() != null)
					stopPoints.addAll(route.getStopPoints());
			}
		}
		// collect vehiclejourneys
		for (JourneyPattern jp : journeyPatterns) 
		{
			if (jp.getVehicleJourneys() != null)
			{
				vehicleJourneys.addAll(jp.getVehicleJourneys());
			}
		}
		// collect timetables
		for (VehicleJourney vj : vehicleJourneys) 
		{
			if (vj.getTimetables() != null)
			{
				timetableSet.addAll(vj.getTimetables());
			}
		}
		timetables.addAll(timetableSet);
		// collect stopareas
		for (StopPoint sp : stopPoints) 
		{
			stopAreaSet.addAll(extractStopAreaHierarchy(sp.getContainedInStopArea()));
		}

		// add routing constraints
		if (routingConstraints != null)
		{
			stopAreaSet.addAll(routingConstraints);
		}

		stopAreas.addAll(stopAreaSet);
		// sort stopArea and collect connectionLinks and accessLinks+points.
		for (StopArea area : stopAreaSet)
		{
			switch (area.getAreaType())
			{
			case BOARDINGPOSITION : 
				boardingPositions.add(area);
				break;
			case QUAY : 
				quays.add(area);
				break;
			case COMMERCIALSTOPPOINT : 
				commercialStopPoints.add(area);
				break;
			case STOPPLACE : 
				stopPlaces.add(area);
				break;
			default:
				break;
			}
			if (area.getAccessLinks() != null)
				accessLinks.addAll(area.getAccessLinks());
			if (area.getConnectionLinks() != null)
				connectionLinkSet.addAll(area.getConnectionLinks());
		}
		connectionLinks.addAll(connectionLinkSet);
		// collect accessPoints
		for (AccessLink al : accessLinks) 
		{
			accessPointSet.add(al.getAccessPoint());
		}
		accessPoints.addAll(accessPointSet);
	}

	/**
	 * extract parent tree for physical Stop
	 * 
	 * @param stopArea physical stop to check
	 * @param line line for routingConstraint relationship
	 * @return stopareas
	 */
	private List<StopArea> extractStopAreaHierarchy(StopArea stopArea)
	{
		List<StopArea> stopAreas = new ArrayList<StopArea>();
		if (stopArea != null)
		{
			if (!stopArea.getAreaType().equals(ChouetteAreaEnum.ITL))
			{
				stopAreas.add(stopArea);
				if (stopArea.getParent() != null)
				{
					stopAreas.addAll(extractStopAreaHierarchy(stopArea.getParent()));      
				}
			}
		}
		return stopAreas;
	}

}
