$(document).ready(function() {
    // Hide all sections except the first one on page load
    $('main > section').not(':first').hide();

    // Handle form submissions (e.g., search flights, confirm booking)
    $('form').submit(function(event) {
        event.preventDefault();

        // Get the ID of the next section to show
        const nextSectionId = $(this).data('next-section');

        // Validate the form data (add your own validation logic here)
        const isValidForm = validateForm($(this));

        if (isValidForm) {
            // Hide the current section
            $(this).closest('section').hide();

            // Show the next section
            $('#' + nextSectionId).show();
        }
    });

    // Handle "Book Now" button clicks to show the booking screen
    $('.book-button').click(function() {
        const flightId = $(this).closest('.flight-item').attr('id');

        // Hide the current section
        $(this).closest('section').hide();

        // Show the booking screen with the selected flight details
        $('#bookingDetails').show();

        // Add code to populate the booking screen with flight details
        // based on the selected flight (flightId) from the flight list.
    });
});

// Add your form validation logic here
function validateForm(form) {
    // Example: Check if the required fields are filled
    let isValid = true;
    form.find('input[required]').each(function() {
        if ($(this).val().trim() === '') {
            isValid = false;
            $(this).addClass('error');
        } else {
            $(this).removeClass('error');
        }
    });
    return isValid;
}
