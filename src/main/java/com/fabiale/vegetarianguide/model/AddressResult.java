package com.fabiale.vegetarianguide.model;

import java.util.List;

public class AddressResult {
	private String status;
	private List<Address> results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Address> getResults() {
		return results;
	}

	public void setResults(List<Address> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressResult [status=");
		builder.append(status);
		builder.append(", results=");
		builder.append(results);
		builder.append("]");
		return builder.toString();
	}
	
	public void populate(Restaurant restaurant) {
		if(this.getStatus().equals("OK")) {
			List<Address> results = this.getResults();
			if(results != null & !results.isEmpty()) {
				Address address2 = results.get(0);
				for(Component c : address2.getAddress_components()) {
					for(String type : c.getTypes()) {
						if(type != null) {
							if(type.equals("political"))
								continue;
							else if(type.equals("street_number"))
								restaurant.setNumber(Integer.valueOf(c.getLong_name()));
							else if(type.equals("route"))
								restaurant.setStreet(c.getLong_name());
							else if(type.equals("locality"))
								restaurant.setCity(c.getLong_name());
							else if(type.equals("administrative_area_level_1"))
								restaurant.setState(c.getLong_name());
							else if(type.equals("country")) {
								Country country = new Country();
								country.setName(c.getShort_name());
								restaurant.setCountry(country);
							} else if(type.equals("postal_code"))
								restaurant.setPostalCode(c.getLong_name());
						}
					}
				}
				if(address2.getGeometry() != null) {
					Geometry g = address2.getGeometry();
					if(g.getLocation() != null) {
						restaurant.setLatitude(Double.valueOf(g.getLocation().getLat()));
						restaurant.setLongitude(Double.valueOf(g.getLocation().getLng()));
					}
				}
			}
		}
		System.out.println("Populate: " + restaurant);
	}
}

class Address {

	private List<Component> address_components;
	private Geometry geometry;

	public List<Component> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(List<Component> address_components) {
		this.address_components = address_components;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [address_components=");
		builder.append(address_components);
		builder.append(", geometry=");
		builder.append(geometry);
		builder.append("]");
		return builder.toString();
	}
}

class Component {
	private String long_name;
	private String short_name;
	private List<String> types;

	public String getLong_name() {
		return long_name;
	}

	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Components [long_name=");
		builder.append(long_name);
		builder.append(", short_name=");
		builder.append(short_name);
		builder.append(", types=");
		builder.append(types);
		builder.append("]");
		return builder.toString();
	}
}

class Geometry {
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Geometry [location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}
}

class Location {
	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Location [lat=");
		builder.append(lat);
		builder.append(", lng=");
		builder.append(lng);
		builder.append("]");
		return builder.toString();
	}

}