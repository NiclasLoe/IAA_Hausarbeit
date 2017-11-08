function confirmDeleteAction(that) {
    var message = that.form.elements['deleteApplicant'].value;
    var value = confirm(message);
    if (value) {
        that.form.action = 'deleteApplicant';
        that.form.submit();
    }
}

function confirmReEnrollAction(that) {
    var message = that.form.elements['reEnrollStudent'].value;
    var value = confirm(message);
    if (value) {
        that.form.action = 'reEnrollDroppedOut';
        that.form.submit();
    }
}
function confirmEndActiveStudentsAction(that) {
    var message = that.form.elements['endActiveStudies'].value;
    var value = confirm(message);
    if (value) {
        that.form.action = 'endActiveStudies';
        that.form.submit();
    }
}
function confirmExmatriculateAction(that) {
    var message = that.form.elements['exmatriculateStudent'].value;
    var value = confirm(message);
    if (value) {
        that.form.action = 'exmatriculateStudent';
        that.form.submit();
    }
}



