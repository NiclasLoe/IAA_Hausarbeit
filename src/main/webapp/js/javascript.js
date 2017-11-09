function confirmAction(that, action, form) {
    var buttonYes = that.form.elements['buttonYes'].value;
    var buttonNo = that.form.elements['buttonNo'].value;
    if (form === undefined) {
        form = "#dialog-confirm";
    }

    $( form ).dialog({
        resizable: false,
        height: "auto",
        width: 400,
        modal: true,
        buttons: [
            {
                text: buttonYes,
                click: function() {
                    $( this ).dialog( "close" );
                    that.form.action = action;
                    that.form.submit(); }
            },
            {
                text: buttonNo,
                click: function() { $(this).dialog('close'); }
            }
        ]
    });
    return false;
}

// https://stackoverflow.com/questions/9127498/how-to-perform-a-real-time-search-and-filter-on-a-html-table
function filterTable(that, table) {
    var $rows = $(table + ' tbody tr');
    var val = '^(?=.*\\b' + $.trim($(that).val()).split(/\s+/).join('\\b)(?=.*\\b') + ').*$',
        reg = RegExp(val, 'i'),
        text;
    $rows.show().filter(function() {
        text = $(this).text().replace(/\s+/g, ' ');
        return !reg.test(text);
    }).hide();
}