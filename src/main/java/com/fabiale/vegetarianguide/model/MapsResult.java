package com.fabiale.vegetarianguide.model;

import java.util.List;

public class MapsResult {

	private String status;
	private List<Row> rows;
	private List<String> destination_addresses;
	private List<String> origin_addresses;
	
	public List<String> getDestination_addresses() {
		return destination_addresses;
	}

	public void setDestination_addresses(List<String> destination_addresses) {
		this.destination_addresses = destination_addresses;
	}

	public List<String> getOrigin_addresses() {
		return origin_addresses;
	}

	public void setOrigin_addresses(List<String> origin_addresses) {
		this.origin_addresses = origin_addresses;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	public Double getDistance() {
		Double distance = null;
		if(rows != null && !rows.isEmpty()) {
			Row row = rows.get(0);
			if(row.getElements() != null && !row.getElements().isEmpty()) {
				Element element = row.getElements().get(0);
				Distance dist = element.getDistance();
				if(dist != null)
					distance = Double.valueOf(dist.getValue());
			}
		}
		return distance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MapsResult [status=");
		builder.append(status);
		builder.append(", rows=");
		builder.append(rows);
		builder.append("]");
		return builder.toString();
	}

}

class Row {
	private List<Element> elements;

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Row [elements=");
		builder.append(elements);
		builder.append("]");
		return builder.toString();
	}

}

class Element {
	private Distance distance;
	private Distance duration;
	private String status;

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public void setDuration(Distance duration) {
		this.duration = duration;
	}

	public Distance getDuration() {
		return duration;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Element [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}

class Distance {
	private String text;
	private String value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Distance [text=");
		builder.append(text);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
