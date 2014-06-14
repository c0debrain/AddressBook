var map;
var marker;
var position = new google.maps.LatLng(-45, -45);

function initialize() {
    var mapOptions = {
      zoom: 15          
    };
    map = new google.maps.Map(document.getElementById('map-canvas'),
        mapOptions);
    		        
    $("#address-modal").on("shown.bs.modal", function(e) {
        google.maps.event.trigger(map, "resize");
        map.setCenter(position);
    });
}

google.maps.event.addDomListener(window, 'load', initialize);

function openPersonModal(data) {
	if (data.status == "success") {
		$('#person-modal').modal('show');
	}
}

function closePersonModal(data) {
	if (data.status == "success") {
		if ($('[id="person-form:valid"]').val() == "true") {
			$('#person-modal').modal('hide');	
		}						
	}
}

$(function() {
	
	$('body').on('click', '.address-map', function(event) {						
		event.preventDefault();
		$('#address-modal').modal('show');						
		
        $.get("http://maps.googleapis.com/maps/api/geocode/json", {address: $(this).data('address')}, function(data) { 
            var result = data.results[0];
            position = new google.maps.LatLng(result.geometry.location.lat, result.geometry.location.lng);

            if (marker) marker.setMap(null);

            map.setZoom(15);
            
            marker = new google.maps.Marker({
            	position: position,
            	map: map,
            	title: result.formatted_address
        	});
    	});
	});
});	