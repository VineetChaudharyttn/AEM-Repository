var updateTotalPrice = function () {
    console.log("updatecall");
    var coffee = $('#coffee').val();
    var quantity = $('#quantity').val();
    const obj = JSON.parse(coffee);
    if( coffee != "Please Select" && quantity !== "" ) {
        $('.modal-box').text("Bill Amount: "+(quantity*obj.price));
    } else {
        $('.modal-box').text("Bill Amount: "+0);
    }

}

var onSubmit = function () {
    var coffee = $('#coffee').val();
    var quantity = $('#quantity').val();
    const coffeeJson = JSON.parse(coffee);

    $.ajax
    ({
        url: '/content/ttnBootcamp/fr/en/api/submitOrder',
        data: JSON.stringify({"item": coffeeJson.name, "price": coffeeJson.price, "quantity": quantity, "state": "Pending"}),
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        type: 'post',
        success: function (result) {
            console.log(result)
            window.location.replace("/content/ttnBootcamp/fr/orderhistory.html");
        }
    });
}


var updateOrder = function (item,price,quantity,state) {
    if(state=="Pending") {
        state = "Complete";
    }
    $.ajax
    ({
        url: '/content/ttnBootcamp/fr/en/api/submitOrder',
        data: JSON.stringify({"item": item, "price": price, "quantity": quantity, "state": state}),
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        type: 'post',
        success: function (result) {
            console.log(result)
            window.location.replace("/content/ttnBootcamp/fr/orderdetails.html");
        }
    });
}
