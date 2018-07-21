package ua.aiplines;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.aiplines.entity.AirCompany;
import ua.aiplines.entity.Country;
import ua.aiplines.entity.Destination;
import ua.aiplines.entity.Flight;
import ua.aiplines.entity.Passenger;
import ua.aiplines.entity.Plane;
import ua.aiplines.entity.enums.PlaneType;


public class App {
    public static void main( String[] args ){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
//        
//        addCountryAndCity(em);
//        addAirCompanyAndPlane(em);
//        addFlight(em);
//        addPassenger(em);
        
        
        em.getTransaction().commit();
        
        em.close();
        factory.close();
    }
    
    private static void addCountryAndCity(EntityManager em) {
    	Country country = new Country();
    	country.setName("Ukraine");
    	em.persist(country);
    	
    	Destination destination = new Destination();
    	destination.setCity("Lviv");
    	destination.setCountry(country);
    	em.persist(destination);
    	
    	destination = new Destination();
    	destination.setCity("Kyiv");
    	destination.setCountry(country);
    	em.persist(destination);
    	
    }
    
    private static void addAirCompanyAndPlane(EntityManager em) {
    	AirCompany airCompany = new AirCompany();
    	airCompany.setCompanyName("WizzAir");
    	airCompany.setCompanyAddress("128, Zamarstinivaska str");
    	em.persist(airCompany);
    	
    	Plane plane = new Plane();
    	plane.setAirCompany(airCompany);
    	plane.setPlaneType(PlaneType.BOEING_777_180);
    	em.persist(plane);
    	
    	plane = new Plane();
    	plane.setAirCompany(airCompany);
    	plane.setPlaneType(PlaneType.BOEING_737_200);
    	em.persist(plane);
    }
    
    private static void addFlight (EntityManager em) {
    	Plane plane = em.createQuery("select p from Plane p where p.id = :planeId", Plane.class)
    			.setParameter("planeId", 2L)
    			.getSingleResult();
    	
    	Destination destination = em.createQuery("select d from Destination d where d.id = :dId", Destination.class)
    			.setParameter("dId", 1L).getSingleResult();
    	
    	Flight flight = new Flight();
    	flight.setDestination(destination);
    	flight.setPlane(plane);
    	flight.setDepartureTime("2018-08-04 12:00");
    	flight.setArrivalTime("2018-08-04 19:15");
    	flight.setTravelTime("07:15");
    	em.persist(flight);
    			
    }
    
    private static void addPassenger(EntityManager em) {
    	Passenger passenger = new Passenger();
    	passenger.setFirstName("Nazar");
    	passenger.setLastName("Bilyi");
    	passenger.setPassportNumber("AA005235");
    	passenger.setPassportGivenDate("2008-12-01");
    	em.persist(passenger);
    }
    
    private static void addTicket(EntityManager em) {
    	
    }
}
