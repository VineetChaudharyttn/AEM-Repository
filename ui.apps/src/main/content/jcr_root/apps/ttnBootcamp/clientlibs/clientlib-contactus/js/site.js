var contactUs = function () {
    var firstname = $('#fname').val();
    var lastname = $('#lname').val();
    var country = $('#country').val();
    var subject = $('#subject').val();

    $.ajax
    ({
        url: '/content/ttnBootcamp/fr/en/api/contactUs',
        data: JSON.stringify({"FirstName": firstname, "LastName": lastname, "country": country, "subject": subject}),
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        type: 'post',
        success: function (result) {
            $('.modal-box').text(result.get("status"));
        }
    });
}
