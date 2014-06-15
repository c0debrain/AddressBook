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
	
	$("#address-modal").on("shown.bs.modal", function(e) {		
		GMap.maps["map-canvas"].refresh();
    });
	
	$('body').on('click', '.address-map', function(event) {
		$('#address-modal').modal('show');
	});
});	