package com.fabiale.vegetarianguide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabiale.vegetarianguide.service.CountryService;

@Controller
public class MyController {
	
	@Autowired CountryService countryService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
//	public static void main(String[] args) throws TransformException {
//		GeodeticCalculator geoCalc = new GeodeticCalculator();
//		
//		geoCalc.setStartingGeographicPoint(52.5305995, 13.335103600000025);
//		geoCalc.setDestinationGeographicPoint(52.5300883, 13.33756829999993);
//		System.out.println(geoCalc.getOrthodromicDistance());
//		
//		GeodeticCalculator calc = new GeodeticCalculator();
//		
//		calc.setStartingPosition(new GeneralDirectPosition(52.52983150000001, 13.340975800000024));
//		calc.setDestinationPosition(new GeneralDirectPosition(52.5300883, 13.33756829999993));;
//		System.out.println(calc.getOrthodromicDistance());
//		
//		System.out.println(distFrom(52.5305995f, 13.335103600000025f, 52.5300883f, 13.33756829999993f));
//	}
//	
	public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
	    double earthRadius = 3958.75;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    int meterConversion = 1609;

	    return new Float(dist * meterConversion).floatValue();
	    }
	
	
}
