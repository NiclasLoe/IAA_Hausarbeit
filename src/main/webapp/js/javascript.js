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