use(function () {
     var dateToFormat = new Date();
    if (this.date != null) {
        dateToFormat = this.date;
    }
    var formattedDate = new java.text.SimpleDateFormat(this.mask).format(dateToFormat);
    return {
        formattedDate: formattedDate
    };
});
