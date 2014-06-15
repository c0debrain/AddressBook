var GMap = function(id, address) {	

	var mapOptions = {
      zoom: 15,
      center:  new google.maps.LatLng(-45, -45)
    };
	
	var self = this;	

	self.map = new google.maps.Map(document.getElementById(id), mapOptions);
	self.map.setCenter(new google.maps.LatLng(-45, -45));
	GMap.maps[id] = self;

};

GMap.maps = {};

GMap.prototype.setAddress = function(address) {
	var self = this;
	
	$.get("http://maps.googleapis.com/maps/api/geocode/json", {address: address}, function(data) { 
        var result = data.results[0];
        
        self.position = new google.maps.LatLng(result.geometry.location.lat, result.geometry.location.lng);

        if (self.marker) self.marker.setMap(null);
        
        self.map.setZoom(15);
        self.map.setCenter(self.position);
        
        self.marker = new google.maps.Marker({
        	position: self.position,
        	map: self.map,
        	title: result.formatted_address
    	});
	});
};

GMap.prototype.refresh = function() {
	google.maps.event.trigger(this.map, "resize");
    this.map.setCenter(this.position);
};

$(function() {
	
	$('body').on('click', '.address-map', function(event) {		
		event.preventDefault();
		var map = GMap.maps[$(this).data('map-id')];
		map.setAddress($(this).data('address'));
	});
});	