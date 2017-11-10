/**
 * Apply our data table design to all selectors matching. We disable sorting of the first column for this design.
 */
$(document).ready(function() {
    $('.datatable-design').DataTable( {
        "info":     false,
        "order": [],
        columnDefs: [
            { targets: 'no-sort', orderable: false }
        ]
    } );

    $('.datatable-design tbody tr').click(function() {
        var control = $(this).find('td input:radio');
        if (control !== undefined) {
            control.prop('checked', true);
            control.click();
        }
    })
} );

/**
 * Confirm dialog.
 *
 * @param that The current 'this'.
 * @param action The action to be executed.
 * @param form The used form.
 * @returns {boolean} confirm-result
 */
function confirmAction(that, action, form) {
    var buttonYes = that.form.elements['buttonYes'].value;
    var buttonNo = that.form.elements['buttonNo'].value;
    var title = that.form.elements['modalTitle'].value;

    if (form === undefined) {
        form = "#dialog-confirm";
    }

    $(form).dialog({
        resizable: false,
        height: "auto",
        width: 400,
        modal: true,
        title: title,
        buttons: [
            {
                text: buttonYes,
                click: function() {
                    $(this).dialog('close');
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

/**
 * Enable all controls passed.
 *
 * @param that The current 'this'.
 * @param controls The controls to be activated.
 */
function enableControls(that, controls) {
    $.each( controls, function(key, controlName) {
        var control = $(controlName);
        if (control !== undefined) {
            control.prop('disabled', false);
        }
    });
}